package com.ian.javatospring02.discount;

import com.ian.javatospring02.dto.PayRequest;
import com.ian.javatospring02.type.ConvenienceType;
import com.ian.javatospring02.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayMethodDiscountPolicyTest {
    PayMethodDiscountPolicy discountPolicy = new PayMethodDiscountPolicy();

    @Test
    void test() {
        // given
        PayRequest payRequest1 = new PayRequest(ConvenienceType.G25, 3000, PayMethodType.CASH);
        PayRequest payRequest2 = new PayRequest(ConvenienceType.G25, 3000, PayMethodType.CARD);

        // when
        Integer discountAmount1 = discountPolicy.discount(payRequest1);
        Integer discountAmount2 = discountPolicy.discount(payRequest2);

        // then
        assertEquals(2100, discountAmount1);
        assertEquals(3000, discountAmount2);
    }
}