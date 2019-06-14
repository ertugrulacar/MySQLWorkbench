package com.mysql.dbeditor.dbconnection;

import java.sql.*;

public class DbConn {
    private static String serverIP;
    private static String portNumber;
    private static String serverId;
    private static String serverPassword;
    private static Connection con;
    private static DbConn dbConn;

    public static DbConn getInstance(String serverIP, String portNumber, String serverId, String serverPassword){
        if(dbConn == null)
            dbConn = new DbConn(serverIP, portNumber, serverId, serverPassword);
        return dbConn;
    }

    private DbConn(String serverIP, String portNumber, String serverId, String serverPassword){
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

    public Connection getConnection() {
        return con;
    }
}
