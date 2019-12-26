package Controllers;

import DataBase.DbMembers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.Members;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController extends MethodForWindow{

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
        buttonSignUp.setOnAction(event -> openNewScene("/fxml/SignUp.fxml",btnSignIn));
        btnSignIn.setOnAction(event -> {
            String loginText = txtUsername.getText().trim();
            String loginPassword = txtPassword.getText().trim();
            
            if(!loginText.equals("") && !loginPassword.equals("")){
                loginUser(loginText, loginPassword);
            }else{
                shaker(txtUsername,txtPassword);
            }


        });
    }


    private void loginUser(String loginText, String loginPassword) {
        DbMembers dbHandler = new DbMembers();
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
            if (txtUsername.getText().trim().equals("rapkatt")){
                openNewScene("/fxml/MainPanes.fxml",btnSignIn);
            }else {
           openNewScene("/fxml/Menu1.fxml",btnSignIn);}


        }else {
            shaker(txtUsername,txtPassword);
            System.out.println("adasdsd");
        }



    }


    public void onClickAdd(ActionEvent actionEvent) {

    }

    public void onClickDelete(ActionEvent actionEvent) {
    }

    public void onClickBackBookSearch(MouseEvent mouseEvent) {
        openNewScene("/fxml/Menu1.fxml",btnSignIn);
    }
}
