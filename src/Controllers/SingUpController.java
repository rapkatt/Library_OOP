package Controllers;

import DataBase.DbMembers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.Members;

public class SingUpController extends MethodForWindow{

    @FXML
    private TextField firstNameText;

    @FXML
    private TextField lastNameText;

    @FXML
    private TextField userNameText;


    @FXML
    private PasswordField passwordText;

    @FXML
    private TextField phoneNumberText;

    @FXML
    private Button btnSignUp;

    @FXML
    private TextField adressText;


    @FXML
    void initialize() {


        btnSignUp.setOnAction(event -> {
            signUpNewUser();


        });

    }

    private void signUpNewUser() {
        DbMembers dbHandler = new DbMembers();

        String firstName = firstNameText.getText();
        String lastName = lastNameText.getText();
        String userName = userNameText.getText();
        String password = passwordText.getText();
        String phoneNumber = phoneNumberText.getText();
        String adress = adressText.getText();

        Members member = new Members(firstName, lastName, userName, password, phoneNumber, adress) {
        };
        dbHandler.signUpUser(member);

    }

    public void onClickBackSignUp(MouseEvent mouseEvent) {
        openNewScene("/fxml/WelcomePage.fxml",btnSignUp);
    }
}
