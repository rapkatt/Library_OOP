package Db;

import sample.Members;

import  java.sql.Connection;
import  java.sql.DriverManager;
import java.sql.PreparedStatement;
import  java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHander extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException,SQLException{
       // String url = "jdbc:mysql://localhost:3306/Peoples?autoReconnect=true&useSSL=false";
        String user = "root";
         String password = "0775580";

    String connectionString = "jdbc:mysql://"+ dbHost + ":"
              + dbPort + "/" + dbName;
     Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,user,password);
        System.out.println("Connected?");

       return dbConnection;
    }

    public void signUpUser(Members members){
        String insert = "INSERT " + Const.USER_TABLE + "(" +
                Const.USER_FIRSTNAME + "," + Const.USER_LASTNAME + ","+
                Const.USER_USERNAME +","+ Const.USER_PASSWORD + ","
                + Const.USER_PHONENUMBER+","+Const.USER_ADRESS+")" +
                "VALUES(?,?,?,?,?,?)";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setString(1,members.getFirstName());
            prSt.setString(2,members.getLastName());
            prSt.setString(3,members.getUserName());
            prSt.setString(4,members.getPassword());
            prSt.setString(5,members.getPh_no());
            prSt.setString(6,members.getLocation());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    public ResultSet getUser(Members members){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USER_USERNAME + "=? AND " + Const.USER_PASSWORD + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            prSt.setString(1,members.getUserName());
            prSt.setString(2,members.getPassword());
            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
}
