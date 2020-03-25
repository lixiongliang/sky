package com.hgshequ.springbootai.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author sky.li
 * @description
 * @since 2020/3/25 15:15
 */
@ConfigurationProperties(prefix = "hello") //获取属性值
public class HelloProperties {

    private static final String MSG = "world";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}