package cn.zhouyafeng.nio.package1;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/6/9 0:43
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {

            }
        }

        new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001").start();
    }
}
