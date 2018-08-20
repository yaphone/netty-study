package cn.zhouyafeng.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/8/20 23:32
 */
public class ClientHandler extends ChannelHandlerAdapter {

    private ByteBuf buf;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        byte[] msg2 = "Hello World".getBytes();
        buf = Unpooled.buffer(msg2.length);
        buf.writeBytes(msg2);
        ctx.writeAndFlush(buf);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel active");
        byte[] msg = "Hello World".getBytes();
        buf = Unpooled.buffer(msg.length);
        buf.writeBytes(msg);

        ctx.writeAndFlush(buf);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
