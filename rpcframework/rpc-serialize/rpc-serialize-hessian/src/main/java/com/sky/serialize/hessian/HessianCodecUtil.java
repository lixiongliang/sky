/**
 * @filename:HessianCodecUtil.java
 *
 * Newland Co. Ltd. All rights reserved.
 *
 * @Description:Hessian编解码工具类
 * @author tangjie
 * @version 1.0
 *
 */
package com.sky.serialize.hessian;

import com.google.common.io.Closer;
import io.netty.buffer.ByteBuf;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import com.sky.serialize.MessageCodecUtil;

public class HessianCodecUtil implements MessageCodecUtil {

    HessianSerializePool pool = HessianSerializePool.getHessianPoolInstance();
    private static Closer closer = Closer.create();

    public HessianCodecUtil() {

    }

    public void encode(final ByteBuf out, final Object message) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            closer.register(byteArrayOutputStream);
            HessianSerialize hessianSerialization = pool.borrow();
            hessianSerialization.serialize(byteArrayOutputStream, message);
            byte[] body = byteArrayOutputStream.toByteArray();
            int dataLength = body.length;
            out.writeInt(dataLength);
            out.writeBytes(body);
            pool.restore(hessianSerialization);
        } finally {
            closer.close();
        }
    }

    public Object decode(byte[] body) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body);
            closer.register(byteArrayInputStream);
            HessianSerialize hessianSerialization = pool.borrow();
            Object object = hessianSerialization.deserialize(byteArrayInputStream);
            pool.restore(hessianSerialization);
            return object;
        } finally {
            closer.close();
        }
    }
}
