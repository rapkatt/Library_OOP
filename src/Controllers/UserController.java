package Controllers;

import DataBase.BookDb;
import DataBase.Const;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.Books;

import java.sql.SQLException;

import static DataBase.BookDb.bookList;

public class UserController extends MethodForWindow{

    @FXML
    private TextField authorBookUserSearch;

    @FXML
    private TextField titleBookUserSearch;

    @FXML
    private TextField categorySearchUser;

    @FXML
    private ImageView findUser;

    @FXML
    private ImageView backId5;

    @FXML
    private Button btn;

    @FXML
    private TableView<Books> tableIdUSer;

    @FXML
    private TableColumn<Books, String> titleColumUser;

    @FXML
    private TableColumn<Books, String> authorColumUser;

    @FXML
    private TableColumn<Books, String> editionColumUser;

    @FXML
    private TableColumn<Books, String> subjectColumUser;

    @FXML
    private TableColumn<Books, Integer> numOfBooksIdColumUser;

    @FXML
    void onClickBackBookSearch(MouseEvent event) {
        openNewScene("/fxml/Menu1.fxml",btn);

    }

    @FXML
    void onClickFindUser(MouseEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<Books> books;
        if(titleBookUserSearch.getText().isEmpty() && authorBookUserSearch.getText().isEmpty() && categorySearchUser.getText().isEmpty()){
            books= BookDb.getBooks();
        }
        else if(!titleBookUserSearch.getText().isEmpty() && authorBookUserSearch.getText().isEmpty() && categorySearchUser.getText().isEmpty()) {
            books = BookDb.finder(Const.TITLE, titleBookUserSearch.getText().trim());
        }
        else if(titleBookUserSearch.getText().isEmpty() && !authorBookUserSearch.getText().isEmpty() && categorySearchUser.getText().isEmpty()){
            books = BookDb.finder(Const.AUTHOR, authorBookUserSearch.getText().trim());
        }
        else if(titleBookUserSearch.getText().isEmpty() && authorBookUserSearch.getText().isEmpty() && !categorySearchUser.getText().isEmpty()){
            books = BookDb.finder(Const.SUBJECT, categorySearchUser.getText().trim());
        }
        else if(!titleBookUserSearch.getText().isEmpty() && authorBookUserSearch.getText().isEmpty() && !categorySearchUser.getText().isEmpty()){
            books= BookDb.finder2(Const.TITLE,titleBookUserSearch.getText().trim(),Const.SUBJECT,categorySearchUser.getText().trim());
        }
        else if(titleBookUserSearch.getText().isEmpty() && !authorBookUserSearch.getText().isEmpty() && !categorySearchUser.getText().isEmpty()){
            books = BookDb.finder2(Const.AUTHOR, authorBookUserSearch.getText().trim(),Const.SUBJECT,categorySearchUser.getText().trim());
        }
        else if(!titleBookUserSearch.getText().isEmpty() && !authorBookUserSearch.getText().isEmpty() && categorySearchUser.getText().isEmpty()){
            books = BookDb.finder2(Const.AUTHOR, authorBookUserSearch.getText().trim(), Const.TITLE, titleBookUserSearch.getText().trim());
        }
        else{
            books = BookDb.finder3(Const.TITLE, titleBookUserSearch.getText().trim(), Const.AUTHOR, authorBookUserSearch.getText().trim(),Const.SUBJECT,categorySearchUser.getText().trim());
        }
        showBooks(books);
    }
    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        bookList = BookDb.getBooks();
        showBooks(bookList);
    }
    protected  void showBooks(ObservableList<Books> books) {
        tableIdUSer.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        titleColumUser.setCellValueFactory(new PropertyValueFactory<Books, String>("title"));
        authorColumUser.setCellValueFactory(new PropertyValueFactory<Books,String>("author"));
        editionColumUser.setCellValueFactory(new PropertyValueFactory<Books,String>("edition"));
        subjectColumUser.setCellValueFactory(new PropertyValueFactory<Books, String>("subject"));
        numOfBooksIdColumUser.setCellValueFactory(new PropertyValueFactory<Books,Integer>("numOfBook"));

        tableIdUSer.setItems(books);
    }


}
