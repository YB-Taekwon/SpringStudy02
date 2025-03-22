package com.ian.javatospring02.discount;

import com.ian.javatospring02.dto.PayRequest;
import com.ian.javatospring02.type.ConvenienceType;
import com.ian.javatospring02.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvenienceDiscountPolicyTest {
        ConvenienceDiscountPolicy discountPolicy = new ConvenienceDiscountPolicy();

        @Test
        void test() {
            // given
            PayRequest payRequest1 = new PayRequest(ConvenienceType.G25, 3000, PayMethodType.CASH);
            PayRequest payRequest2 = new PayRequest(ConvenienceType.GU, 3000, PayMethodType.CASH);
            PayRequest payRequest3 = new PayRequest(ConvenienceType.SEVEN, 3000, PayMethodType.CASH);

            // when
            Integer discountAmount1 = discountPolicy.discount(payRequest1);
            Integer discountAmount2 = discountPolicy.discount(payRequest2);
            Integer discountAmount3 = discountPolicy.discount(payRequest3);

            // then
            assertEquals(2400, discountAmount1);
            assertEquals(2700, discountAmount2);
            assertEquals(3000, discountAmount3);
        }
}