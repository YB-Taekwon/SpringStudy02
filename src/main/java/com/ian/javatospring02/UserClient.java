package com.ian.javatospring02;

import com.ian.javatospring02.config.AppConfig;
import com.ian.javatospring02.dto.PayCancleRequest;
import com.ian.javatospring02.dto.PayCancleResponse;
import com.ian.javatospring02.dto.PayRequest;
import com.ian.javatospring02.dto.PayResponse;
import com.ian.javatospring02.service.PaymentService;
import com.ian.javatospring02.type.ConvenienceType;
import com.ian.javatospring02.type.PayMethodType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 사용자 역할의 클래스
public class UserClient {
    public static void main(String[] args) {
        // 사용자 -> 편결이 -> 어댑터

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // 컨테이너에 등록한 빈을 가져옴(결제 수단에 따른 할인 정책을 적용)
        PaymentService paymentService = context.getBean("payMethodDiscountPaymentService", PaymentService.class);

        // 결제
        PayRequest payRequest = new PayRequest(ConvenienceType.G25, 5000, PayMethodType.CASH);
        PayResponse payResponse = paymentService.pay(payRequest);

        System.out.println("payResponse = " + payResponse);


        // 결제 취소
        PayCancleRequest payCancleRequest = new PayCancleRequest(ConvenienceType.G25, 50, PayMethodType.CARD);
        PayCancleResponse payCancleResponse = paymentService.payCancle(payCancleRequest);

        System.out.println("payCancleResponse = " + payCancleResponse);
    }
}
