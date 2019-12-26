package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController extends MethodForWindow {

    @FXML
    private ImageView imageid;

    @FXML
    private ImageView book;

    @FXML
    private ImageView info;

    @FXML
    private ImageView account;

    @FXML
    private Text bookTxt;

    @FXML
    private Text accountTxt;

    @FXML
    private Text infoTxt;

    @FXML
    private Button nothing;

    @FXML
    void AccountClick(MouseEvent event) {


    }

    @FXML
    void BookClick(MouseEvent event) {
        book.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/BooksSearch.fxml"));
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

    @FXML
    void InfoClick(MouseEvent event) {
        openNewScene("/fxml/Info.fxml",nothing);

    }

    public void onClickBackMenu1(MouseEvent mouseEvent) {
        openNewScene("/fxml/WelcomePage.fxml",nothing);

    }
}
