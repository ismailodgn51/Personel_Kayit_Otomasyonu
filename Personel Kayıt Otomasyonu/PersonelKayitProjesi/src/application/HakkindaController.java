package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class HakkindaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor_hakkinda;

    @FXML
    void initialize() {
        assert anchor_hakkinda != null : "fx:id=\"anchor_hakkinda\" was not injected: check your FXML file 'Hakkinda.fxml'.";

    }

}
