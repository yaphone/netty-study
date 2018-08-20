package cn.zhouyafeng.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/8/20 23:25
 */
public class ClientChannelHandler extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new ServerHandler());
    }
}
