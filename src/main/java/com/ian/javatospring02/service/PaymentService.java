package com.ian.javatospring02.service;

import com.ian.javatospring02.adapter.CardAdapter;
import com.ian.javatospring02.adapter.CashAdatper;
import com.ian.javatospring02.adapter.PaymentAdapter;
import com.ian.javatospring02.dto.PayCancleRequest;
import com.ian.javatospring02.dto.PayCancleResponse;
import com.ian.javatospring02.type.*;
import com.ian.javatospring02.dto.PayRequest;
import com.ian.javatospring02.dto.PayResponse;

// 편결이 애플리케이션
public class PaymentService {
    private static PaymentAdapter paymentAdapter;

    // 결제
    public PayResponse pay(PayRequest payRequest) {
        if (payRequest.getPayMethodType() == PayMethodType.CASH)
            paymentAdapter = new CashAdatper();
        else
            paymentAdapter = new CardAdapter();

        UseResult useResult = paymentAdapter.use(payRequest.getPayAmount());

        // Fail Fast
        if (useResult == UseResult.USE_FAILED)
            return new PayResponse(PayResult.PAY_FAILED, 0);

        // Success Case(Only One)
        return new PayResponse(PayResult.PAY_SUCCESS, payRequest.getPayAmount());
    }

    // 결제 취소
    public PayCancleResponse payCancle(PayCancleRequest payCancleRequest) {
        if (payCancleRequest.getPayMethodType() == PayMethodType.CASH)
            paymentAdapter = new CashAdatper();
        else
            paymentAdapter = new CardAdapter();

        UseCancleResult useCancleResult = paymentAdapter.useCancle(payCancleRequest.getPayCancleAmount());

        if (useCancleResult == UseCancleResult.USE_CANCLE_FAILED)
            return new PayCancleResponse(PayCancleResult.PAY_CANCLE_FAILED, 0);

        return new PayCancleResponse(PayCancleResult.PAY_CANCLE_SUCCESS, payCancleRequest.getPayCancleAmount());
    }
}
