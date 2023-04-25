package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import database.veritabani;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class GirisimFikri_Controller {
	    Connection baglanti=null;
	    PreparedStatement sorguifadesi=null;
	    ResultSet getirilen=null;
	    String sql,sql1,sql2;
	   
		public GirisimFikri_Controller() {
			
			baglanti=veritabani.baglan();
		}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TextField adi;
    @FXML
    private TextField soyadi;
    @FXML
    private TextField iletisim;
    @FXML
    private TextArea fikriniz;
    
    @FXML
    private MenuItem CIK;
    @FXML
    private MenuItem Don;

    @FXML
    private MenuItem KAYDET;

    @FXML
    void CIK_Click(ActionEvent event) {
    	Platform.exit();
     
    }
   
    @FXML
    void Don_Click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("Ana_Sayfa.fxml");
    }
  
    @FXML
    void KAYDET_CLICK(ActionEvent event) {
    	sql="insert into girisimfikirleri(adi,soyadi,fikri,iletisim) values(?,?,?,?)";
    	
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		sorguifadesi.setString(1, adi.getText().trim());
    		sorguifadesi.setString(2, soyadi.getText().trim());
    		sorguifadesi.setString(3, fikriniz.getText().trim());
    		sorguifadesi.setString(4, iletisim.getText().trim());
    		if(adi.getText() != "" && soyadi.getText() != "") {
    			sorguifadesi.executeUpdate();
    			Alert alert = new Alert(AlertType.INFORMATION);
     	    	alert.setTitle("GIRSIMCILER");
     	    	alert.setHeaderText("MESAJINIZ KAYDEDILDI");
     	    	alert.setContentText("BIZE GUVENIP FIKIRLERINIZI PAYLASTIGINIZ ICIN TESEKUR EDERIZ");
     	    	alert.showAndWait();
    			
    		}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
    	
    	
    	

    }

    @FXML
    void initialize() {
        
    	

    }

}
