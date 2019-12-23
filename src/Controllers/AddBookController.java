package Controllers;

import Db.BookDb;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Books;

import static java.lang.Integer.parseInt;

public class AddBookController {

    @FXML
    private TextField titleTxt;

    @FXML
    private TextField authorTxt;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField subjectTxt;

    @FXML
    private TextField priceTxt;

    @FXML
    private TextField numOfBookTxt;

    @FXML
    private TextField editionText;

    @FXML
    private Button buttonAddAdmin;

    @FXML
    void initialize(){
        buttonAddAdmin.setOnAction(event -> {
            addBook();


        });
    }

    public void addBook(){
        BookDb bookDb = new BookDb();
        String title = titleTxt.getText();
        String author = authorTxt.getText();

        String subject = subjectTxt.getText();
        String edition = editionText.getText();
        int price = parseInt(priceTxt.getText());
        int No_OfBook = parseInt(numOfBookTxt.getText());
        Books books  = new Books(title,author,subject,edition,price,No_OfBook);
        bookDb.addBook(books);

    }

}

