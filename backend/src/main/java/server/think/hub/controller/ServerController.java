package server.think.hub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.think.hub.data.ServerInfo;

import java.net.DatagramSocket;
import java.net.InetAddress;

@RestController
@RequestMapping("/api/server")
public class ServerController {
    @GetMapping
    public ServerInfo getInfo() {
        String ip;
        try(final DatagramSocket socket = new DatagramSocket()){
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            ip = socket.getLocalAddress().getHostAddress();
            return new ServerInfo("ThinkServer", "Online", ip);
        } catch (Exception e) {
            return new ServerInfo("ThinkServer", "ERROR", "ERROR");
        }
    }
}
