package com.ian.javatospring02.dto;

import com.ian.javatospring02.type.PayCancleResult;

public class PayCancleResponse {
    private PayCancleResult payCancleResult;
    private Integer payCancleAmount;

    public PayCancleResponse(PayCancleResult payCancleResult, Integer payCancleAmount) {
        this.payCancleResult = payCancleResult;
        this.payCancleAmount = payCancleAmount;
    }

    public PayCancleResult getPayCancleResult() {
        return payCancleResult;
    }

    public void setPayCancleResult(PayCancleResult payCancleResult) {
        this.payCancleResult = payCancleResult;
    }

    public Integer getPayCancleAmount() {
        return payCancleAmount;
    }

    public void setPayCancleAmount(Integer payCancleAmount) {
        this.payCancleAmount = payCancleAmount;
    }

    @Override
    public String toString() {
        return "PayCancleResponse{" +
                "payCancleResult=" + payCancleResult +
                ", payCancleAmount=" + payCancleAmount +
                '}';
    }
}
