package Controllers;

import DataBase.BookDb;
import DataBase.Const;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import sample.Books;

import java.sql.SQLException;

import static DataBase.BookDb.bookList;
import static DataBase.BookDb.deleteBook;
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

        BookDb bookDB = new BookDb();
        try {
            bookList = bookDB.getBooks();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        showBooks(bookList);

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
        titleTxtEdit.setText(books.getTitle());
        authorTxtEdit.setText(books.getAuthor());
        editionTextEdit.setText(books.getEdition());
        subjectTxtEdit.setText(books.getSubject());
        numOfBookTxtEdit.setText(String.valueOf(books.getNumOfBook()));

    }

    protected  void showBooks(ObservableList<Books> books) {
        tableId.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        titleColum.setCellValueFactory(new PropertyValueFactory<Books, String>("title"));
        authorId.setCellValueFactory(new PropertyValueFactory<Books,String>("author"));
        editionId.setCellValueFactory(new PropertyValueFactory<Books,String>("edition"));
        subjectId.setCellValueFactory(new PropertyValueFactory<Books, String>("subject"));
        numOfBooksId.setCellValueFactory(new PropertyValueFactory<Books,Integer>("numOfBook"));

        tableId.setItems(books);
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

        titleTxtEdit.clear();
        authorTxtEdit.clear();
        editionTextEdit.clear();
        subjectTxtEdit.clear();
        numOfBookTxtEdit.clear();
    }

    public void onClickBackEditBook(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        mainPane.toFront();
        BookDb bookDb = new BookDb();
        bookList = bookDb.getBooks();
        showBooks(bookList);
    }

    public void onClickBackId1(MouseEvent mouseEvent) {
        openNewScene("/fxml/WelcomePage.fxml",buttonEditAdmin);
    }


    public void onClickSearchTitle(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        ObservableList<Books> books = FXCollections.observableArrayList();
        if(titleBookAdmin.getText().isEmpty() && authorBookAdmin.getText().isEmpty() && categorySearchAdmin.getText().isEmpty()){
            books = BookDb.getBooks();
        }else if(!titleBookAdmin.getText().isEmpty() && authorBookAdmin.getText().isEmpty() && categorySearchAdmin.getText().isEmpty()) {
            books = BookDb.finder(Const.TITLE, titleBookAdmin.getText().trim());
        }else if(titleBookAdmin.getText().isEmpty() && !authorBookAdmin.getText().isEmpty() && categorySearchAdmin.getText().isEmpty()){
            books = BookDb.finder(Const.AUTHOR, authorBookAdmin.getText().trim());
        }else if(titleBookAdmin.getText().isEmpty() && authorBookAdmin.getText().isEmpty() && !categorySearchAdmin.getText().isEmpty()){
            books = BookDb.finder(Const.SUBJECT, categorySearchAdmin.getText().trim());
        }else if(titleBookAdmin.getText().isEmpty() && authorBookAdmin.getText().isEmpty() && !categorySearchAdmin.getText().isEmpty()){

        }
        showBooks(books);
    }
}
