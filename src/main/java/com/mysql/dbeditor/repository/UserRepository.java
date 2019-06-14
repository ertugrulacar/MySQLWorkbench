package com.mysql.dbeditor.repository;

import com.mysql.dbeditor.dbconnection.DbConn;
import com.mysql.dbeditor.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private static PreparedStatement ps;
    private static ResultSet rs, rs2, rs3, rs4;
    private static DbConn dbConn;
    public UserRepository(){
        dbConn = DbConn.getInstance("159.89.23.224", "3306", "teambravo", "teambravo123");
    }
    public static User findByEmailAndPassword(String email, String password){
        try {
            ps = dbConn.getConnection().prepareStatement("select * from mysqleditor.user where email= ? and  password= ?;");
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            rs.next();
            return new User(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"), rs.getString("email"), rs.getString("password"));
        } catch (SQLException e) {
            System.out.println("Have a problem while getting User informations with email and password, error: " + e.getLocalizedMessage());
        }
        return null;
    }
    public static User findById(int id){
        try{
            ps = dbConn.getConnection().prepareStatement("select  * from mysqleditor.user where id= ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            return new User(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"), rs.getString("email"), rs.getString("password"));
        }catch(SQLException e){
            System.out.println("Have a problem while getting User informations with id, error: " + e.getLocalizedMessage());
        }
        return null;
    }

}
