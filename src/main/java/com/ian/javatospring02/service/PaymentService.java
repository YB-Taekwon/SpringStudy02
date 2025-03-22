package com.ian.javatospring02.service;

import com.ian.javatospring02.adapter.PaymentAdapter;
import com.ian.javatospring02.discount.DiscountPolicy;
import com.ian.javatospring02.dto.PayCancleRequest;
import com.ian.javatospring02.dto.PayCancleResponse;
import com.ian.javatospring02.type.*;
import com.ian.javatospring02.dto.PayRequest;
import com.ian.javatospring02.dto.PayResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 편결이 애플리케이션
public class PaymentService {
    private final Map<PayMethodType, PaymentAdapter> paymentAdapterMap = new HashMap<>();
    private final DiscountPolicy discountPolicy;

    /** 생성자 의존성 주입
     * @param paymentAdapterSet
     *  애플리케이션 실행 시, AppConfig에 Bean으로 등록된 모든 구현체가 Set 타입으로 저장된다.
     * @param discountPolicy
     *  AppConfig에서 할인 정책이 결정된다.
     */
    public PaymentService(Set<PaymentAdapter> paymentAdapterSet, DiscountPolicy discountPolicy) {
        paymentAdapterSet.forEach(paymentAdapter ->
                paymentAdapterMap.put(paymentAdapter.getPayMethodType(), paymentAdapter));
        this.discountPolicy = discountPolicy;
    }


    // 결제
    public PayResponse pay(PayRequest payRequest) {
        PayMethodType payMethodType = payRequest.getPayMethodType();
        PaymentAdapter paymentAdapter = paymentAdapterMap.get(payMethodType);

        Integer discountAmount = discountPolicy.discount(payRequest);
        UseResult useResult = paymentAdapter.use(discountAmount);

        // Fail Fast
        if (useResult == UseResult.USE_FAILED)
            return new PayResponse(PayResult.PAY_FAILED, 0);

        // Success Case(Only One)
        return new PayResponse(PayResult.PAY_SUCCESS, discountAmount);
    }

    // 결제 취소
    public PayCancleResponse payCancle(PayCancleRequest payCancleRequest) {
        PayMethodType payMethodType = payCancleRequest.getPayMethodType();
        PaymentAdapter paymentAdapter = paymentAdapterMap.get(payMethodType);

        UseCancleResult useCancleResult = paymentAdapter.useCancle(payCancleRequest.getPayCancleAmount());

        if (useCancleResult == UseCancleResult.USE_CANCLE_FAILED)
            return new PayCancleResponse(PayCancleResult.PAY_CANCLE_FAILED, 0);

        return new PayCancleResponse(PayCancleResult.PAY_CANCLE_SUCCESS, payCancleRequest.getPayCancleAmount());
    }
}
