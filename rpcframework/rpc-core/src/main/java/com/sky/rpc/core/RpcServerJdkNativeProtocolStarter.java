package com.sky.rpc.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:rpc服务器启动模块
 */
public class RpcServerJdkNativeProtocolStarter {

    public static void main(String[] args) {
        /**
         * 加载Spring容器,启动服务器
         */
        new ClassPathXmlApplicationContext("config/rpc-jdknative.xml");
    }
}

