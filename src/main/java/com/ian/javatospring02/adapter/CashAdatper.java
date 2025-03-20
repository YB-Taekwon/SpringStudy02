package com.ian.javatospring02.adapter;

import com.ian.javatospring02.type.CashCancleResult;
import com.ian.javatospring02.type.CashResult;

public class CashAdatper {
    // 사용
    public CashResult use(Integer amount) {
        // 결제 금액이 100만원 초과일 경우, 사용 불가
        if (amount > 100_0000)
            return CashResult.USE_FAILED;

        return CashResult.USE_SUCCESS;
    }

    // 사용 취소
    public CashCancleResult useCancle(Integer amount) {
        // 결제 취소 금액이 100원 미만일 경우, 사용 취소 불가
        if (amount < 100)
            return CashCancleResult.USE_CANCLE_FAILED;

        return CashCancleResult.USE_CANCLE_SUCCESS;
    }
}
