package com.ian.javatospring02.dto;

import com.ian.javatospring02.type.ConvenienceType;
import com.ian.javatospring02.type.PayMethodType;

public class PayCancleRequest {
    private ConvenienceType convenienceType;
    private Integer payCancleAmount;
    private PayMethodType payMethodType;

    public PayCancleRequest(ConvenienceType convenienceType, Integer payCancleAmount, PayMethodType payMethodType) {
        this.convenienceType = convenienceType;
        this.payCancleAmount = payCancleAmount;
        this.payMethodType = payMethodType;
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

    public PayMethodType getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
    }
}
