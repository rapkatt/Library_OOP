package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class UserController {

    @FXML
    private TextField authorBookUser;

    @FXML
    private TextField titleBookUser;

    @FXML
    private TextField categorySearchUSer;

    @FXML
    private ImageView findUser;

    @FXML
    private ImageView backId5;

    @FXML
    private Button butBookUser;

    @FXML
    private TableView<?> tableIdUSer;

    @FXML
    private TableColumn<?, ?> titleColumUser;

    @FXML
    private TableColumn<?, ?> authorId;

    @FXML
    private TableColumn<?, ?> editionId;

    @FXML
    private TableColumn<?, ?> subjectIdUser;

    @FXML
    private TableColumn<?, ?> numOfBooksIdUser;

    @FXML
    void onClickBackBookSearch(MouseEvent event) {

    }

    @FXML
    void onClickFindUser(MouseEvent event) {


    }

}
