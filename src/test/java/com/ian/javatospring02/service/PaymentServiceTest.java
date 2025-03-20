package com.ian.javatospring02.service;

import com.ian.javatospring02.dto.PayCancleRequest;
import com.ian.javatospring02.dto.PayCancleResponse;
import com.ian.javatospring02.type.ConvenienceType;
import com.ian.javatospring02.dto.PayRequest;
import com.ian.javatospring02.dto.PayResponse;
import com.ian.javatospring02.type.PayCancleResult;
import com.ian.javatospring02.type.PayResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {
    PaymentService paymentService = new PaymentService();

    @Test
    void pay_success() {
        // given
        PayRequest payRequest = new PayRequest(ConvenienceType.G25, 5000);

        // when
        PayResponse payResponse = paymentService.pay(payRequest);

        // then
        assertEquals(PayResult.PAY_SUCCESS, payResponse.getPayResult());
        assertEquals(5000, payResponse.getPaidAmount());
    }

    @Test
    void pay_fail() {
        // given
        PayRequest payRequest = new PayRequest(ConvenienceType.G25, 100_0001);

        // when
        PayResponse payResponse = paymentService.pay(payRequest);

        // then
        assertEquals(PayResult.PAY_FAILED, payResponse.getPayResult());
        assertEquals(0, payResponse.getPaidAmount());
    }

    @Test
    void pay_cancle_success() {
        // given
        PayCancleRequest payCancleRequest = new PayCancleRequest(ConvenienceType.G25, 5000);

        // when
        PayCancleResponse payCancleResponse = paymentService.payCancle(payCancleRequest);

        // then
        assertEquals(PayCancleResult.PAY_CANCLE_SUCCESS, payCancleResponse.getPayCancleResult());
        assertEquals(5000, payCancleResponse.getPayCancleAmount());
    }

    @Test
    void pay_cancle_fail() {
        // given
        PayCancleRequest payCancleRequest = new PayCancleRequest(ConvenienceType.G25, 50);

        // when
        PayCancleResponse payCancleResponse = paymentService.payCancle(payCancleRequest);

        // then
        assertEquals(PayCancleResult.PAY_CANCLE_FAILED, payCancleResponse.getPayCancleResult());
        assertEquals(0, payCancleResponse.getPayCancleAmount());
    }

}