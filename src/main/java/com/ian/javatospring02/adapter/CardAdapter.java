package com.ian.javatospring02.adapter;

import com.ian.javatospring02.type.UseCancleResult;
import com.ian.javatospring02.type.UseResult;

public class CardAdapter implements PaymentAdapter {

    // 인증
    public void authenticate() {
        System.out.println("Authentication was successful.");
    }

    // 승인
    public void approve() {
        System.out.println("Approval was successful.");
    }

    // 매입
    @Override
    public UseResult use(Integer amount) {
        // 결제 금액이 100만원 초과일 경우, 매입 실패
        if (amount > 100_0000)
            return UseResult.USE_FAILED;

        return UseResult.USE_SUCCESS;
    }

    // 매입 취소
    @Override
    public UseCancleResult useCancle(Integer amount) {
        // 결제 취소 금액이 100원 미만일 경우, 결제 취소 불가
        if (amount < 100)
            return UseCancleResult.USE_CANCLE_FAILED;

        return UseCancleResult.USE_CANCLE_SUCCESS;
    }
}
