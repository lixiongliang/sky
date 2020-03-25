package com.hgshequ.springbootai.vo;

/**
 * @author sky.li
 * @description
 * @since 2020/3/25 15:14
 */
public class HelloVo {
    private String msg;

    public String sayHello() {
        return "hello " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
