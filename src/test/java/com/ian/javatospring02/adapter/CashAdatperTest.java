package com.ian.javatospring02.adapter;

import com.ian.javatospring02.type.CashCancleResult;
import com.ian.javatospring02.type.CashResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashAdatperTest {
    CashAdatper cashAdatper = new CashAdatper();

    @Test
    void use_success() {
        // given
        Integer amount = 1000;

        // when
        CashResult cashResult = cashAdatper.use(amount);

        // then
        assertEquals(CashResult.USE_SUCCESS, cashResult);
    }

    @Test
    void use_fail() {
        // given
        Integer amount = 100_0001;

        // when
        CashResult cashResult = cashAdatper.use(amount);

        // then
        assertEquals(CashResult.USE_FAILED, cashResult);
    }

    @Test
    void use_cancle_success() {
        // given
        Integer amount = 1000;

        // when
        CashCancleResult cashCancleResult = cashAdatper.useCancle(amount);

        // then
        assertEquals(CashCancleResult.USE_CANCLE_SUCCESS, cashCancleResult);
    }

    @Test
    void use_cancle_fail() {
        // given
        Integer amount = 50;

        // when
        CashCancleResult cashCancleResult = cashAdatper.useCancle(amount);

        // then
        assertEquals(CashCancleResult.USE_CANCLE_FAILED, cashCancleResult);
    }

}