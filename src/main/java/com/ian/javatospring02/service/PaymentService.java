package com.ian.javatospring02.service;

import com.ian.javatospring02.adapter.CashAdatper;
import com.ian.javatospring02.dto.PayCancleRequest;
import com.ian.javatospring02.dto.PayCancleResponse;
import com.ian.javatospring02.type.CashCancleResult;
import com.ian.javatospring02.type.CashResult;
import com.ian.javatospring02.dto.PayRequest;
import com.ian.javatospring02.dto.PayResponse;
import com.ian.javatospring02.type.PayCancleResult;
import com.ian.javatospring02.type.PayResult;

// 편결이 애플리케이션
public class PaymentService {
    private final CashAdatper cashAdatper = new CashAdatper();

    // 결제
    public PayResponse pay(PayRequest payRequest) {
        CashResult cashResult = cashAdatper.use(payRequest.getPayAmount());

        // Fail Fast
        if (cashResult == CashResult.USE_FAILED)
            return new PayResponse(PayResult.PAY_FAILED, 0);

        // Success Case(Only One)
        return new PayResponse(PayResult.PAY_SUCCESS, payRequest.getPayAmount());
    }

    // 결제 취소
    public PayCancleResponse payCancle(PayCancleRequest payCancleRequest) {
        CashCancleResult cashCancleResult = cashAdatper.useCancle(payCancleRequest.getPayCancleAmount());

        if (cashCancleResult == CashCancleResult.USE_CANCLE_FAILED)
            return new PayCancleResponse(PayCancleResult.PAY_CANCLE_FAILED, 0);

        return new PayCancleResponse(PayCancleResult.PAY_CANCLE_SUCCESS, payCancleRequest.getPayCancleAmount());
    }
}
