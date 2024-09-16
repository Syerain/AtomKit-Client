package top.syewiki.kop.cli96;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class kopcli96 {
    public static void main(String[] args) {
        String cliver = "0.95";
        String edition = "client-jdk21-common";
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
            while(true) {
                System.out.println("输入括号内数字以选择功能：\n\n【1】.唤醒服务端\n【2】.检查客户端更新");

                Scanner sc0 = new Scanner(System.in);
                int choi = sc0.nextByte();

                // 唤醒功能
                if (choi == 1) {

                    while (true) {
                        System.out.println("\n请选择所需唤醒的服务端：\n\n1.MC原版服请输入10700\n2.泰拉原版服请输入10500\n\n");
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

                        boolean iserrNTT = receivedMessage.equals("ERR:NO_THIS_TOKEN");
                        if (iserrNTT) {
                            System.out.println("错误：无效的解析码");
                            System.out.println("请重新发送报文");
                            break;
                        }

                        boolean isOK = receivedMessage.equals("OK");
                        if (isOK) {
                            System.out.println("");
                            System.out.println("___您现在可以关闭本程序，并等待所需服务端启动，若无法连接，请再次运行本程序。");
                            break;
                        }
                        break;
                    }
                }

                // 更新客户端
                if (choi == 2){
                    System.out.println("服务不可用");
                    break;
                }
            }
            // 关闭连接
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("【发生错误！请将以上报错代码截图发送给管理员：】");
        }
    }
}

