package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AdminPanelController extends MethodForWindow{

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
    void onClickAdd(ActionEvent event) {
        openNewScene("/fxml/AddBook.fxml", addButton);


    }

    @FXML
    void onClickDelete(ActionEvent event) {

    }

}
