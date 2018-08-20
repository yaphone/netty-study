package cn.zhouyafeng.bio.package1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/6/7 22:43
 */
public class TimeServer {
    public static void main(String[] args) throws IOException{
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e) {
                //TODO
            }
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port: " + port);
            Socket socket = null;
            while (true) {
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } finally {
            if (server != null) {
                System.out.println("The time server close");
                server.close();
                server = null;
            }
        }
    }
}
