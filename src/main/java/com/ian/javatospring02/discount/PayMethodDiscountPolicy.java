package com.ian.javatospring02.discount;

import com.ian.javatospring02.dto.PayRequest;

public class PayMethodDiscountPolicy implements DiscountPolicy {
    @Override
    public Integer discount(PayRequest payRequest) {
        Integer discountAmount = switch (payRequest.getPayMethodType()) {
            case CASH -> payRequest.getPayAmount() * 7 / 10;
            case CARD -> payRequest.getPayAmount();
        };
        return discountAmount;
    }
}
