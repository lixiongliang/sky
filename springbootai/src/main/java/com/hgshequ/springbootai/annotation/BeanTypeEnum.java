package com.hgshequ.springbootai.annotation;

public enum BeanTypeEnum {
    VALIDATE("validate", "还款验证"),
    PAY("pay", "还款支付"),
    FEE_SPLITTING("fee-splitting", "还款分润"),;

    private String value;
    private String description;

    BeanTypeEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    ;
}
