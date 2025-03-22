package com.ian.javatospring02.dto;

import com.ian.javatospring02.type.ConvenienceType;
import com.ian.javatospring02.type.PayMethodType;

// 요청 객체
public class PayRequest {
    private ConvenienceType convenienceType;
    private Integer payAmount;
    private PayMethodType payMethodType;

    public PayRequest(ConvenienceType convenienceType, Integer payAmount, PayMethodType payMethodType) {
        this.convenienceType = convenienceType;
        this.payAmount = payAmount;
        this.payMethodType = payMethodType;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public PayMethodType getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
    }
}
