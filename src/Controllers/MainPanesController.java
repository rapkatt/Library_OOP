package Controllers;

import Db.BookDb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import sample.Books;

import java.sql.SQLException;

import static Db.BookDb.bookList;
import static Db.BookDb.deleteBook;
import static java.lang.Integer.parseInt;

public class MainPanesController extends MethodForWindow {

    @FXML
    private Pane mainPane;

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
    protected TableView<Books> tableId;

    @FXML
    protected TableColumn<Books, String> titleColum;

    @FXML
    protected TableColumn<Books, String> authorId;

    @FXML
    protected TableColumn<Books, String> editionId;

    @FXML
    protected TableColumn<Books, String> subjectId;

    @FXML
    protected TableColumn<Books, Integer> numOfBooksId;

    @FXML
    private Pane editPane;

    @FXML
    private TextField titleTxtEdit;

    @FXML
    private TextField authorTxtEdit;

    @FXML
    private TextField numOfBookTxtEdit;

    @FXML
    private TextField editionTextEdit;

    @FXML
    private TextField subjectTxtEdit;

    @FXML
    private Button buttonEditAdmin;

    @FXML
    void initialize(){
        mainPane.toFront();
        showBooks();

    }

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
    void onClickEdit(ActionEvent event) throws SQLException, ClassNotFoundException {
        Books books = tableId.getSelectionModel().getSelectedItem();
        editPane.toFront();
        deleteBook(books);
        titleBookAdmin.setText(books.getTitle());
        authorBookAdmin.setText(books.getAuthor());
        editionId.setText(books.getEdition());
        subjectId.setText(books.getSubject());
        numOfBooksId.setText(String.valueOf(books.getNumOfBook()));
    }

    protected  void showBooks() {
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

    public void onClickUpdate(ActionEvent actionEvent) {
        BookDb bookDb = new BookDb();

        String a=titleTxtEdit.getText();
        String b=authorTxtEdit.getText();
        String c=editionTextEdit.getText();
        String d=subjectTxtEdit.getText();
        Integer e = parseInt(numOfBookTxtEdit.getText());
        Books book = new Books(a,b,c,d,e);
        bookDb.addBook(book);
    }
}
