package com.ian.javatospring02.discount;

import com.ian.javatospring02.dto.PayRequest;

public interface DiscountPolicy {
    // 할인이 적용된 금액 반환
    Integer discount(PayRequest payRequest);
}
