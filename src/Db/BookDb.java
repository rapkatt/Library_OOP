package Db;

import sample.Books;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class BookDb extends ConnectionDb {
    public void addBook(Books book){
        String insert = "INSERT " + Const.BOOK_TABLE + "(" +
                 Const.AUTHOR + ","+
                Const.NAME+","+ Const.SUBJECT + ","
                + Const.EDITION+","+parseInt(Const.PRICE) + ","+parseInt(Const.No_ofBooks)+")" +
                "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setString(1,book.getAuthor());
            prSt.setString(2,book.getName());
            prSt.setString(3,book.getSubject());
            prSt.setString(4,book.getEdition());
            prSt.setInt(5,book.getPrice());
            prSt.setInt(6,book.getNo_OfBooks());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
