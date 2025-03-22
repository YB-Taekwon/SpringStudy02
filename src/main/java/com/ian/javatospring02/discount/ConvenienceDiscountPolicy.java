package com.ian.javatospring02.discount;

import com.ian.javatospring02.dto.PayRequest;

public class ConvenienceDiscountPolicy implements DiscountPolicy {
    @Override
    public Integer discount(PayRequest payRequest) {
        Integer discountAmount = switch (payRequest.getConvenienceType()) {
            case G25 -> payRequest.getPayAmount() * 8 / 10;
            case GU -> payRequest.getPayAmount() * 9 / 10;
            case SEVEN -> payRequest.getPayAmount();
        };
        return discountAmount;
    }
}
