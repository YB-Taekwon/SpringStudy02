package com.ian.javatospring02.config;

import com.ian.javatospring02.adapter.CardAdapter;
import com.ian.javatospring02.adapter.CashAdatper;
import com.ian.javatospring02.discount.ConvenienceDiscountPolicy;
import com.ian.javatospring02.discount.PayMethodDiscountPolicy;
import com.ian.javatospring02.service.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class AppConfig {
    @Bean
    public CashAdatper cashAdatper() {
        return new CashAdatper();
    }

    @Bean
    public CardAdapter cardAdapter() {
        return new CardAdapter();
    }

    @Bean
    public ConvenienceDiscountPolicy convenienceDiscountPolicy() {
        return new ConvenienceDiscountPolicy();
    }

    @Bean
    public PayMethodDiscountPolicy payMethodDiscountPolicy() {
        return new PayMethodDiscountPolicy();
    }

    @Bean
    // 결제 수단에 따른 할인 정책을 적용한 편결이
    public PaymentService payMethodDiscountPaymentService() {
        return new PaymentService(
                new HashSet<>(Arrays.asList(cashAdatper(), cardAdapter())),
                payMethodDiscountPolicy()
        );
    }

    @Bean
    // 편의점에 따른 할인 정책을 적용한 편결이
    public PaymentService convenienceDiscountPaymentService() {
        return new PaymentService(
                new HashSet<>(Arrays.asList(cashAdatper(), cardAdapter())),
                convenienceDiscountPolicy()
        );
    }

}
