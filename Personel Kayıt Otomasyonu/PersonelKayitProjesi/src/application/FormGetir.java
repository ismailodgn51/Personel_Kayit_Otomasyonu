package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FormGetir {
	public void Gecis(String string) {
		try {
    		Stage stage=new Stage();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource(string));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
           
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
