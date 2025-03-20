package com.ian.javatospring02.dto;

import com.ian.javatospring02.type.ConvenienceType;

public class PayCancleRequest {
    private ConvenienceType convenienceType;
    private Integer payCancleAmount;

    public PayCancleRequest(ConvenienceType convenienceType, Integer payCancleAmount) {
        this.convenienceType = convenienceType;
        this.payCancleAmount = payCancleAmount;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayCancleAmount() {
        return payCancleAmount;
    }

    public void setPayCancleAmount(Integer payCancleAmount) {
        this.payCancleAmount = payCancleAmount;
    }
}
