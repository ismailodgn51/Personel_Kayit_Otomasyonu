
package application;

import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import database.veritabani;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;

public class sirketkayit {
	  Connection baglanti=null;
	    PreparedStatement sorguifadesi=null;
	    ResultSet getirilen=null;
	    String sql,sql1,sql2;
	   
		public sirketkayit() {
			
			baglanti=veritabani.baglan();
			
			
		}
		
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btngir;

    @FXML
    private TextField kuladi;

    @FXML
    private TextField sifre;



    @FXML
    void btngir_Click(ActionEvent event) {
    	sql="insert into  sirketlogin(Sirketadi,sifre)values(?,?)";
    	try {
    		
		
			
    		sorguifadesi=baglanti.prepareStatement(sql);
    		
    		sorguifadesi.setString(1, kuladi.getText().trim());
    	    sorguifadesi.setString(2,sifre.getText().trim());
    	    sorguifadesi.executeUpdate();
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("PERSONEL OTOMASYONU");
    		alert.setHeaderText("ONAY MESAJI");
    		alert.setContentText("KAYIT YAPILDI");
    		alert.showAndWait();
    		
    		
    	 	{
    		
    	}   	}
	
	
catch (Exception e) {
	// TODO: handle exception
	System.out.println(e);
	Alert alert = new Alert(AlertType.ERROR);
	alert.setTitle("iste otomasyon");
	alert.setHeaderText("Hata Mesajý");
	alert.setContentText("TC VEYA TELEFON NUMARANÝZÝ DUZGUN GÝRÝNÝZ ozel karakter icermemeli ve hiçbir deðeri boþ geçmeyiniz");
	alert.showAndWait();
}

    }


    @FXML
    void initialize() {
       

    }

}
