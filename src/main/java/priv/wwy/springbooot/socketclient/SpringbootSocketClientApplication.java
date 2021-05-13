package priv.wwy.springbooot.socketclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import priv.wwy.springbooot.socketclient.service.Client;

@SpringBootApplication
public class SpringbootSocketClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootSocketClientApplication.class, args);
        Client client = new Client(10086);
        client.setupSocket();
    }

}
