package top.syewiki.atk.cli.stdgui;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClassSimpleMsger {
    public String hostAddr;
    public int hostPort;

    public ClassSimpleMsger(String hostAddr, int hostPort){
        this.hostAddr = hostAddr;
        this.hostPort = hostPort;
    }

    public void connectionK(){
        try {

            // 创建TCP客户端并连接到服务器
            String inputsrvaddr = "syewiki.top";
            System.out.println("正在尝试连接到服务端 ...");
            String srvaddr = "syewiki.top";
            int serverPort = 6001;
            System.out.println("(目标主机:"+srvaddr+":"+serverPort+")");
            Socket clientSocket = new Socket(srvaddr, serverPort);

            //反馈
            System.out.println("");
            System.out.println("服务端连接成功.");

            // 创建输入流和输出流
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();
                        Scanner sc1 = new Scanner(System.in);
                        String token = sc1.nextLine();
                        System.out.println("确定发送内容:" + token);

                        String message = (token);
                        outputStream.write(message.getBytes());
                        System.out.println("\n正在发送唤醒报文 ...");

                        // 读取服务器响应的数据
                        byte[] buffer = new byte[1024];
                        int bytesRead = inputStream.read(buffer);
                        String receivedMessage = new String(buffer, 0, bytesRead);
                        System.out.println("");
                        System.out.println("收到服务器响应：" + receivedMessage);
                        //System.out.println("(客户端已更新到最新版本0.87)");

            // 关闭连接
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("【发生错误！请将以上报错代码截图发送给管理员：】");
        }
    }


}
