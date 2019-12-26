package Controllers;

import DataBase.BookDb;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.Books;

import static java.lang.Integer.parseInt;

public class AddBookController  extends MethodForWindow{

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
            if(!titleTxt.getText().equals("") && !authorTxt.getText().equals("")  &&
                    !editionText.getText().equals("")  && !numOfBookTxt.getText().equals("") &&
                    !subjectTxt.getText().equals("")
            )
                addBook();
        });
}

    public void addBook(){
        BookDb bookDb = new BookDb();
        String title = titleTxt.getText();
        String author = authorTxt.getText();
        String subject = subjectTxt.getText();
        String edition = editionText.getText();
        Integer numOfBook = parseInt(numOfBookTxt.getText());
        Books books  = new Books(title,author,subject,edition,numOfBook);
        bookDb.addBook(books);

    }

    public void onClickAddBook(MouseEvent mouseEvent) {
        openNewScene("/fxml/AdminPanel.fxml", buttonAddAdmin);
    }

    public void onClickBackAddBook(MouseEvent mouseEvent) {
        openNewScene("/fxml/MainPanes.fxml", buttonAddAdmin);

    }
}

