package com.ian.javatospring02.adapter;

import com.ian.javatospring02.type.PayMethodType;
import com.ian.javatospring02.type.UseCancleResult;
import com.ian.javatospring02.type.UseResult;

public class CashAdatper implements PaymentAdapter {
    @Override
    public PayMethodType getPayMethodType() {
        return PayMethodType.CASH;
    }

    // 사용
    public UseResult use(Integer amount) {
        // 결제 금액이 100만원 초과일 경우, 사용 불가
        if (amount > 100_0000)
            return UseResult.USE_FAILED;

        return UseResult.USE_SUCCESS;
    }

    // 사용 취소
    public UseCancleResult useCancle(Integer amount) {
        // 결제 취소 금액이 100원 미만일 경우, 사용 취소 불가
        if (amount < 100)
            return UseCancleResult.USE_CANCLE_FAILED;

        return UseCancleResult.USE_CANCLE_SUCCESS;
    }
}
