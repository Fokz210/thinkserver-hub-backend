package server.think.hub.data;

import org.apache.catalina.Server;

public class ServerInfo {
    private String name;
    private String status;
    private String ip;

    public ServerInfo(String name, String status, String IP) {
        this.name = name;
        this.status = status;
        this.ip = IP;
    }

    public String getName() {
        return name;
    }

    public  String getStatus() {
        return status;
    }

    public String getIp() {
        return ip;
    }
}
