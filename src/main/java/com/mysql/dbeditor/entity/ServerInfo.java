package com.mysql.dbeditor.entity;

public class ServerInfo {
    private int id;
    private int userid;
    private String serverIp;
    private String portNumber;
    private String userName;
    private String password;

    public ServerInfo(){}

    public ServerInfo(int id, int userid, String serverIp, String portNumber, String userName, String password) {
        this.id = id;
        this.userid = userid;
        this.serverIp = serverIp;
        this.portNumber = portNumber;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
