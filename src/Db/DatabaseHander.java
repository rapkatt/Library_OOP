package Db;

import  java.sql.Connection;
import  java.sql.DriverManager;
import java.sql.PreparedStatement;
import  java.sql.SQLException;

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

    public void signUpUser(String firstName, String lastName, String userName,
                           String password, String phoneNumber){
        String insert = "INSERT " + Const.USER_TABLE + "(" +
                Const.USER_FIRSTNAME + "," + Const.USER_LASTNAME + ","+
                Const.USER_USERNAME +","+ Const.USER_PASSWORD + ","
                + Const.USER_PHONENUMBER+")" +
                "VALUES(?,?,?,?,?)";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setString(1,firstName);
            prSt.setString(2,lastName);
            prSt.setString(3,userName);
            prSt.setString(4,password);
            prSt.setString(5,phoneNumber);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
