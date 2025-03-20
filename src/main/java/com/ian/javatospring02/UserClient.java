package com.ian.javatospring02;

import com.ian.javatospring02.dto.PayCancleRequest;
import com.ian.javatospring02.dto.PayCancleResponse;
import com.ian.javatospring02.dto.PayRequest;
import com.ian.javatospring02.dto.PayResponse;
import com.ian.javatospring02.service.PaymentService;
import com.ian.javatospring02.type.ConvenienceType;

// 사용자 역할의 클래스
public class UserClient {
    public static void main(String[] args) {
        // 사용자 -> 편결이 -> 어댑터

        // 결제
        PaymentService paymentService = new PaymentService();

        PayRequest payRequest = new PayRequest(ConvenienceType.G25, 5000);
        PayResponse payResponse = paymentService.pay(payRequest);

        System.out.println("payResponse = " + payResponse);


        // 결제 취소
        PayCancleRequest payCancleRequest = new PayCancleRequest(ConvenienceType.G25, 50);
        PayCancleResponse payCancleResponse = paymentService.payCancle(payCancleRequest);

        System.out.println("payCancleResponse = " + payCancleResponse);
    }
}
