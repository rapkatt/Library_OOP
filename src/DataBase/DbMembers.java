package DataBase;

import sample.Members;

import java.sql.PreparedStatement;
import  java.sql.SQLException;
import java.sql.ResultSet;

public class DbMembers extends ConnectionDb {

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
