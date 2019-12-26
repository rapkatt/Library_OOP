package Controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class InfoController extends MethodForWindow{

    @FXML
    private Button btn;

    @FXML
    void onClickBackInfo(MouseEvent event)  {
        openNewScene("/fxml/Menu1.fxml",btn);

    }

}
