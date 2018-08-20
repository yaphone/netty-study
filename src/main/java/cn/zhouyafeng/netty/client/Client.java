package cn.zhouyafeng.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/8/20 23:08
 */
public class Client {

    public void connect(String host, int port) throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ClientHandler());

            ChannelFuture future = bootstrap.connect(host, port).sync();
            future.channel().closeFuture();
        } catch (Exception e) {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new Client().connect("127.0.0.1", 6666);
    }
}
