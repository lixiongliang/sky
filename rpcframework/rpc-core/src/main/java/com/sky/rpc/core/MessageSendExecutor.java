package com.sky.rpc.core;

import com.google.common.reflect.Reflection;
import com.sky.serialize.RpcSerializeProtocol;

/**
 * Rpc客户端执行模块
 */
public class MessageSendExecutor {

    private RpcServerLoader loader = RpcServerLoader.getInstance();

    /**
     * 构造器
     */
    public MessageSendExecutor() {

    }
    /**
     * 构造器
     */
    /*public MessageSendExecutor(String serverAddress, RpcSerializeProtocol serializeProtocol) {
        loader.load(serverAddress, serializeProtocol);
    }*/


    public void setRpcServerLoader(String serverAddress, RpcSerializeProtocol serializeProtocol) {
        loader.load(serverAddress, serializeProtocol);
    }

    public void stop() {
        loader.unLoad();
    }

    /***
     * 动态代理,获得代理后的对象
     * @param rpcInterface
     * @param <T>
     * @return
     */
    public static <T> T execute(Class<T> rpcInterface) {
        return (T) Reflection.newProxy(rpcInterface, new MessageSendProxy<T>());
    }
}
