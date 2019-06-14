package com.mysql.dbeditor.repository;

import com.mysql.dbeditor.dbconnection.DbConn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableSampleRepo {
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static DbConn dbConn;

    public TableSampleRepo(){
        dbConn = DbConn.getInstance("159.89.23.224", "3306", "teambravo", "teambravo123");
    }
    public int getNumberOfColumnsOfATable(String database, String table){
        try{
            ps = dbConn.getConnection().prepareStatement("select count(*) as numberOfColumns from information_schema.columns where table_schema= ? and table_name= ?;");
            ps.setString(1, database);
            ps.setString(2, table);
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt("numberOfColumns");

        }catch(SQLException e){
            System.out.println("Have a problem while finding number of columns with database name and table name, error: " + e.getLocalizedMessage());
        }
        return 0;
    }
    public List<String> getColumnNamesOfATable(String database, String table){
        List<String> list = new ArrayList<>();
        try{
            String query = "show columns from " + database+ "."+ table+";";
            ps = dbConn.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(rs.getString("Field"));
            }
        }catch(SQLException e){
            System.out.println("Have a problem while finding the name of column fields in the database.table:"+database+":"+ table+ ", error: " + e.getLocalizedMessage());
        }
        return list;
    }
    public List<List<String>> getRowsOfATable(String database, String table){
        List<List<String>> list = new ArrayList<>();
        int numberOfColumns = this.getNumberOfColumnsOfATable(database, table);
        List<String> columnNames  = this.getColumnNamesOfATable(database, table);
        try{
            String query = "select * from " + database+ "." +table + ";";
            ps = dbConn.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            List<String> row;
            while(rs.next()){
                row = new ArrayList<>();
                for(int i=0;i<numberOfColumns;i++){
                    row.add(rs.getString(columnNames.get(i)));
                }
                list.add(row);
            }
        }catch(SQLException e){
            System.out.println("Have a problem while getting all the rows of database.table: " + database+ "." + table + ", error" + e.getLocalizedMessage());
        }
        return list;
    }

    public static void main(String[] args) {
        TableSampleRepo tableSampleRepo = new TableSampleRepo();

        List<String> eto = tableSampleRepo.getColumnNamesOfATable("iau", "Book");
        List<List<String>> list  = tableSampleRepo.getRowsOfATable("iau", "Book");
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(i).size();j++){
                System.out.print(list.get(i).get(j) + "  --  ");
            }
            System.out.println();
        }

    }


}
