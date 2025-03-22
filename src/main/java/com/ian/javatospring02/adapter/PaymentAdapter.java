package com.ian.javatospring02.adapter;

import com.ian.javatospring02.type.UseCancleResult;
import com.ian.javatospring02.type.UseResult;

public interface PaymentAdapter {
    UseResult use(Integer amount);
    UseCancleResult useCancle(Integer amount);
}
