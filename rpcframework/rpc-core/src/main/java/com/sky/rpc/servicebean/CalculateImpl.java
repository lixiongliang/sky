package com.sky.rpc.servicebean;

/**
 * 计算器定义接口实现
 */
public class CalculateImpl implements Calculate {
    //两数相加
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public String sendSms(String sms) {
        System.out.println(">>>>>>>>"+sms);
        return "Successed";
    }
}
