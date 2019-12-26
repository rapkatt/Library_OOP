package Controllers;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MethodForWindow {
    public void openNewScene(String window, Button btn){

        btn.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    protected void shaker(Node username, Node password) {
        Shake userLoginAnim = new Shake(username);
        Shake userPassAnim = new Shake(password);
        userLoginAnim.playAnim();
        userPassAnim.playAnim();
    }
}
