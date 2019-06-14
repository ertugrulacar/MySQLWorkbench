package com.mysql.dbeditor.dbconnection.privateconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class PrivateDbConn {
    private static String serverIP;
    private static String portNumber;
    private static String serverId;
    private static String serverPassword;
    private static Connection con;
    private static PrivateDbConn privateDbConn;

    public static PrivateDbConn getInstance(String serverIP, String portNumber, String serverId, String serverPassword){
        if(privateDbConn == null)
            privateDbConn = new PrivateDbConn(serverIP, portNumber, serverId, serverPassword);
        return privateDbConn;
    }

    private PrivateDbConn(String serverIP, String portNumber, String serverId, String serverPassword){
        this.serverIP = serverIP;
        this.portNumber = portNumber;
        this.serverId = serverId;
        this.serverPassword = serverPassword;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + this.serverIP + ":" + this.portNumber + "/?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", this.serverId, this.serverPassword);
        }catch(Exception e){
            System.out.println("Have a problem with connection, error: " + e.getLocalizedMessage());
        }
    }

    public PrivateDbConn getPrivateDbConn() {
        return privateDbConn;
    }
}
