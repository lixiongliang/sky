package com.sky.serialize;

import io.netty.channel.ChannelPipeline;

/**
 * RPC 消息序列化协议选择器接口
 */
public interface RpcSerializeFrame {

    public void select(RpcSerializeProtocol protocol, ChannelPipeline pipeline);
}
