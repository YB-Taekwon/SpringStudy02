package com.ian.javatospring02.adapter;

import com.ian.javatospring02.type.UseCancleResult;
import com.ian.javatospring02.type.UseResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardAdapterTest {
    CardAdapter cardAdapter = new CardAdapter();

    @Test
    void use_success() {
        // given
        Integer amount = 1000;
        // when
        UseResult useResult = cardAdapter.use(amount);
        // then
        assertEquals(UseResult.USE_SUCCESS, useResult);
    }

    @Test
    void use_fail() {
        // given
        Integer amount = 100_0001;

        // when
        UseResult useResult = cardAdapter.use(amount);

        // then
        assertEquals(UseResult.USE_FAILED, useResult);
    }

    @Test
    void use_cancle_success() {
        // given
        Integer amount = 1000;

        // when
        UseCancleResult useCancleResult = cardAdapter.useCancle(amount);

        // then
        assertEquals(UseCancleResult.USE_CANCLE_SUCCESS, useCancleResult);
    }

    @Test
    void use_cancle_fail() {
        // given
        Integer amount = 50;

        // when
        UseCancleResult useCancleResult = cardAdapter.useCancle(amount);

        // then
        assertEquals(UseCancleResult.USE_CANCLE_FAILED, useCancleResult);
    }

}