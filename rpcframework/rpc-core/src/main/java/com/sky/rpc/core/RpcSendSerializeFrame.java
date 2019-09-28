package com.sky.rpc.core;

import com.sky.serialize.MessageCodecUtil;
import com.sky.serialize.RpcSerializeFrame;
import com.sky.serialize.RpcSerializeProtocol;
import com.sky.serialize.hessian.HessianCodecUtil;
import com.sky.serialize.hessian.HessianDecoder;
import com.sky.serialize.hessian.HessianEncoder;
import com.sky.serialize.kryo.KryoCodecUtil;
import com.sky.serialize.kryo.KryoDecoder;
import com.sky.serialize.kryo.KryoEncoder;
import com.sky.serialize.kryo.KryoPoolFactory;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * RPC 客户端消息序列化协议框架
 */
public class RpcSendSerializeFrame implements RpcSerializeFrame {

    public void select(RpcSerializeProtocol protocol, ChannelPipeline pipeline) {
        switch (protocol) {
            case JDKSERIALIZE: {
                //解码器 inbound 入站数据
                pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, MessageCodecUtil.MESSAGE_LENGTH, 0, MessageCodecUtil.MESSAGE_LENGTH));
                //编码器 outbound 出站数据
                //利用LengthFieldPrepender回填补充ObjectDecoder消息报文头
                pipeline.addLast(new LengthFieldPrepender(MessageCodecUtil.MESSAGE_LENGTH));
                //编码器 outbound 出站数据
                pipeline.addLast(new ObjectEncoder());
                //解码器 inbound 入站数据
                pipeline.addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.weakCachingConcurrentResolver(this.getClass().getClassLoader())));
                //解码器 inbound 入站数据
                pipeline.addLast(new MessageSendHandler());
                break;

                /**
                 * 入站数据, 客户端接收服务端发来的数据
                 *      -->LengthFieldBasedFrameDecoder-->ObjectDecoder-->MessageSendHandler
                 *
                 * 出站数据, 即客户端向服务端发送字节数据--
                 *      -->LengthFieldPrepender-->ObjectEncoder
                 */
            }
            case KRYOSERIALIZE: {
                KryoCodecUtil util = new KryoCodecUtil(KryoPoolFactory.getKryoPoolInstance());
                pipeline.addLast(new KryoEncoder(util));
                pipeline.addLast(new KryoDecoder(util));
                pipeline.addLast(new MessageSendHandler());
                break;
            }
            case HESSIANSERIALIZE: {
                HessianCodecUtil util = new HessianCodecUtil();
                pipeline.addLast(new HessianEncoder(util));
                pipeline.addLast(new HessianDecoder(util));
                pipeline.addLast(new MessageSendHandler());
                break;
            }
        }
    }
}
