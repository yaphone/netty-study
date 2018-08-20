package cn.zhouyafeng.netty.client;

import cn.zhouyafeng.netty.server.ClientChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;


/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/8/20 23:31
 */
public class ServerChannelHandler extends ChannelInitializer<SocketChannel> {

    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline().addLast(new ClientChannelHandler());
    }
}
