package Controllers;

import Db.BookDb;
import static Db.BookDb.bookList;
import static java.lang.Integer.parseInt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Books;

import javax.swing.*;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.*;

public class AdminPanelController extends MethodForWindow {

    @FXML
    private TextField authorBookAdmin;

    @FXML
    private TextField titleBookAdmin;

    @FXML
    private TextField categorySearchAdmin;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private TableView<Books> tableId;

    @FXML
    private TableColumn<Books, String> titleColum;

    @FXML
    private TableColumn<Books, String> authorId;

    @FXML
    private TableColumn<Books, String> editionId;

    @FXML
    private TableColumn<Books, String> subjectId;

    @FXML
    private TableColumn<Books, Integer> numOfBooksId;

    @FXML
    void onClickAdd(ActionEvent event) {
        openNewScene("/fxml/AddBook.fxml", addButton);

    }

    @FXML
    void onClickDelete(ActionEvent event) throws SQLException, ClassNotFoundException {
        String a = tableId.getSelectionModel().getSelectedItem().getTitle();
        String b = tableId.getSelectionModel().getSelectedItem().getAuthor();
        String c = tableId.getSelectionModel().getSelectedItem().getSubject();
        String d = tableId.getSelectionModel().getSelectedItem().getEdition();
        Integer e = tableId.getSelectionModel().getSelectedItem().getNumOfBook();
        tableId.getItems().removeAll(tableId.getSelectionModel().getSelectedItem());

        Books books = new Books(a,b,c,d,e);
        BookDb.deleteBook(books);
        bookList.removeAll(books);
    }

    @FXML
    void onClickEdit(ActionEvent event) {
        openNewScene("/fxml/EditBook.fxml", editButton);

    }

    @FXML
    void initialize(){
        showBooks();
    }

    private void showBooks() {
        tableId.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        BookDb bookDB = new BookDb();
        try {
            bookList = bookDB.getBooks();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        titleColum.setCellValueFactory(new PropertyValueFactory<Books, String>("title"));
        authorId.setCellValueFactory(new PropertyValueFactory<Books,String>("author"));
        editionId.setCellValueFactory(new PropertyValueFactory<Books,String>("edition"));
        subjectId.setCellValueFactory(new PropertyValueFactory<Books, String>("subject"));
        numOfBooksId.setCellValueFactory(new PropertyValueFactory<Books,Integer>("numOfBook"));

        tableId.setItems(bookList);
    }



}
