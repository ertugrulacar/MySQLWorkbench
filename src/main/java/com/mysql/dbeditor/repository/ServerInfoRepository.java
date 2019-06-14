package com.mysql.dbeditor.repository;

import com.mysql.dbeditor.dbconnection.DbConn;
import com.mysql.dbeditor.entity.ServerInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServerInfoRepository {
    private static PreparedStatement ps;
    private static ResultSet rs, rs2;
    private static DbConn dbConn;
    public ServerInfoRepository(){
        dbConn = DbConn.getInstance("159.89.23.224", "3306", "teambravo", "teambravo123");
    }
    public List<ServerInfo> findByUserId(int userId){
        List<ServerInfo> list = new ArrayList<>();
        try{
            ps = dbConn.getConnection().prepareStatement("select * from mysqleditor.serverinfo where userid= ?;");
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new ServerInfo(rs.getInt("id"), rs.getInt("userid"), rs.getString("serverip"), rs.getString("portnumber"), rs.getString("username"), rs.getString("password")));
            }
        }catch(SQLException e){
            System.out.println("Have a problem while getting ServerInfos with userid, error: " + e.getLocalizedMessage());
        }
        return list;
    }
    public List<ServerInfo> findById(int id){
        List<ServerInfo> list = new ArrayList<>();
        try{
            ps = dbConn.getConnection().prepareStatement("select * from mysqleditor.serverinfo where id= ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new ServerInfo(rs.getInt("id"), rs.getInt("userid"), rs.getString("serverip"), rs.getString("portnumber"), rs.getString("username"), rs.getString("password")));
            }
        }catch(SQLException e){
            System.out.println("Have a problem while getting ServerInfos with id, error: " + e.getLocalizedMessage());
        }
        return list;
    }

}
