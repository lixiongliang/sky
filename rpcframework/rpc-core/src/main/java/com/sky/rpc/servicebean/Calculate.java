package com.sky.rpc.servicebean;

/**
 * 计算器定义接口
 */
public interface Calculate {
    //两数相加
    int add(int a, int b);

    String sendSms(String sms);
}
