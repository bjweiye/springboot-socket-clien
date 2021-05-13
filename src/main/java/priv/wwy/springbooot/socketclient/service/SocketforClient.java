package priv.wwy.springbooot.socketclient.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;

@Slf4j
public class SocketforClient {
    private Socket socket;
    SocketforClient(Socket socket){
        this.socket = socket;
    }
    void socketHandler(){
        try{
            //获取输出流，向服务器端发送信息
            OutputStream os = socket.getOutputStream();//字节输出流
            PrintWriter pw = new PrintWriter(os);//将输出流包装成打印流
            pw.write("用户名：admin；密码：admin");
            pw.flush();
            socket.shutdownOutput();
            //获取输入流，并读取服务器端的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info;
            while ((info = br.readLine())!= null) {
                String msg = String.format("Hello,我是客户端，服务器说：%s",info);
                log.info(msg);
            }
            //关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
