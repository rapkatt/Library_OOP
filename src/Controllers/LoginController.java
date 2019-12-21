package Controllers;

import Db.DatabaseHander;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Members;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button buttonSignUp;

    @FXML
    private Button btnSignIn;

    @FXML
    void initialize(){
        buttonSignUp.setOnAction(event -> {
            buttonSignUp.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/SignUp.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        btnSignIn.setOnAction(event -> {
            btnSignIn.getScene().getWindow().hide();
            String loginText = txtUsername.getText().trim();
            String loginPassword = txtPassword.getText().trim();
            
            if(!loginText.equals("") && !loginPassword.equals("")){
                loginUser(loginText, loginPassword);
            }


        });
    }
    private void animation() {
        Shake userLoginAnim = new Shake(txtUsername);
        Shake userPassAnim = new Shake(txtPassword);
        userLoginAnim.playAnim();
        userPassAnim.playAnim();
    }


    private void loginUser(String loginText, String loginPassword) {
        DatabaseHander dbHandler = new DatabaseHander();
        Members members = new Members();
        members.setUserName(loginText);
        members.setPassword(loginPassword);
        dbHandler.getUser(members);
        ResultSet result = dbHandler.getUser(members);

        int counter = 0;

        while (true){
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }
        if (counter >=1){
            System.out.println("Success!");
        }else {
            animation();
            System.out.println("adasdsd");
        }


    }

}
