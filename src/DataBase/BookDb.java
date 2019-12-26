package Db;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Books;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class BookDb extends ConnectionDb {
    public static ObservableList<Books> bookList = FXCollections.observableArrayList();

    public void addBook(Books book) {
        String insert = "INSERT " + Const.BOOK_TABLE + "(" +
                Const.AUTHOR + "," +
                Const.TITLE + "," + Const.SUBJECT + ","
                + Const.EDITION + "," + Const.NUMOFBOOK + ")" +
                "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setString(1, book.getAuthor());
            prSt.setString(2, book.getTitle());
            prSt.setString(3, book.getSubject());
            prSt.setString(4, book.getEdition());
            prSt.setInt(5, book.getNumOfBook());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Books> getBooks() throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM " + Const.BOOK_TABLE;
        PreparedStatement pop = getDbConnection().prepareStatement(select);
        ResultSet set = pop.executeQuery(select);

        ObservableList<Books> allBooks = FXCollections.observableArrayList();

        while (set.next()) {
            String title = set.getString(Const.TITLE);
            String author = set.getString(Const.AUTHOR);
            String edition = set.getString(Const.EDITION);
            String subject = set.getString(Const.SUBJECT);
            Integer numOfBook = set.getInt(Const.NUMOFBOOK);

            Books book = new Books(title, author, edition, subject, numOfBook);
            allBooks.add(book);
        }
        return allBooks;
    }

    public static void deleteBook(Books books) throws SQLException, ClassNotFoundException {
        String delete = "DELETE FROM " + Const.BOOK_TABLE + " WHERE " + Const.TITLE + "= '" + books.getTitle() + "'";
        PreparedStatement select = getDbConnection().prepareStatement(delete);
        select.executeUpdate(delete);

    }

    public static ObservableList<Books> finder(String n, String m) throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM " + Const.BOOK_TABLE + " WHERE " + n + " LIKE  '%" + m + "%'";
        PreparedStatement pop = getDbConnection().prepareStatement(select);
        ResultSet set = pop.executeQuery(select);

        ObservableList<Books> Books = FXCollections.observableArrayList();
        while (set.next()) {
            String title = set.getString(Const.TITLE);
            String author = set.getString(Const.AUTHOR);
            String edition = set.getString(Const.EDITION);
            String subject = set.getString(Const.SUBJECT);
            int numOfBooks = set.getInt(Const.NUMOFBOOK);

            Books book = new Books(title, author, edition, subject, numOfBooks);
            Books.add(book);

        }
        return Books;
    }
}
