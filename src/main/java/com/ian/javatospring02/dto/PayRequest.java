package com.ian.javatospring02.dto;

import com.ian.javatospring02.type.ConvenienceType;

// 요청 객체
public class PayRequest {
    private ConvenienceType convenienceType;
    private Integer payAmount;

    public PayRequest(ConvenienceType convenienceType, int payAmount) {
        this.convenienceType = convenienceType;
        this.payAmount = payAmount;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }
}
