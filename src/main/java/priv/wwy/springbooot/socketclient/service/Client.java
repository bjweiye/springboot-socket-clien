package priv.wwy.springbooot.socketclient.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.net.Socket;

//@Component
@Slf4j
public class Client {
    private int port;
    public Client(int port){
        this.port = port;
    }
    public void setupSocket() {
        try(Socket socket = new Socket("127.0.0.1",port)){
            SocketforClient socketforClient = new SocketforClient(socket);
            socketforClient.socketHandler();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
