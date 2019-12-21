package Controllers;

import Db.DatabaseHander;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class SingUpController {

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField userName;

    @FXML
    private RadioButton male;

    @FXML
    private RadioButton female;

    @FXML
    private PasswordField password;

    @FXML
    private TextField phoneNumber;

    @FXML
    private Button btnSignUp;



    @FXML
    void initialize(){
        DatabaseHander dbHandler = new DatabaseHander();
        btnSignUp.setOnAction(event -> {
            dbHandler.signUpUser(firstName.getText(),lastName.getText(),userName.getText(), password.getText(),phoneNumber.getText());
                }
                );

    }

}
