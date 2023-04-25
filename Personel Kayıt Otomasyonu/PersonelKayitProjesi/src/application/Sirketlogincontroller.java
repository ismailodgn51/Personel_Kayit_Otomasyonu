package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import database.veritabani;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Sirketlogincontroller {
	   Connection baglanti=null;
	    PreparedStatement sorguifadesi=null;
	    ResultSet getirilen=null;
	    String sql,sql1,sql2;
	   
		public Sirketlogincontroller() {
			
			baglanti=veritabani.baglan();
		}
    @FXML
    private ResourceBundle resources;
    @FXML
    private MenuItem MenuYardim;
    @FXML
    private MenuItem isverenhakkinda;

    @FXML
    private MenuItem isverenmenu;

    @FXML
    private MenuItem menusikayet;
    @FXML
    private URL location;

    @FXML
    private Button isveren;
    @FXML
    private Button btn_login_giris;
    @FXML
    private ImageView imagevievid;
    @FXML
    private Label kayit;
    @FXML
    private TextField txt_login_sirket;

    @FXML
    private PasswordField txt_login_sifre;
   
    @FXML
    void kayitC(MouseEvent event) {

   	 FormGetir frm =new FormGetir();
	      frm.Gecis("sirketkayit.fxml");
    }
    
    @FXML
    void btn_login_giris_click(ActionEvent event) {
    	
             	
    	sql="select * from sirketlogin where Sirketadi	=? and sifre=? ";
    	try {
    		
    		sorguifadesi=baglanti.prepareStatement(sql);
    		sorguifadesi.setString(1, txt_login_sirket.getText().trim());
			sorguifadesi.setInt(2, Integer.parseInt(txt_login_sifre.getText().trim()));
			ResultSet getirilen=sorguifadesi.executeQuery();
			
			if(!getirilen.next()) {
				Alert alert=new Alert(AlertType.ERROR);
	    	    	alert.setTitle("Kayit Otomasyonu");
	    	    	alert.setHeaderText("Hata Mesajý");
	    	    	alert.setContentText("LUTFEN BILGILERINIZI DOLDURUN VE DOGRU GIRINIZ");
	    	    	alert.showAndWait();
			}
			else {
				getirilen.getString(1); //tab 1 sutundaki deger
				 FormGetir frm =new FormGetir();
			      frm.Gecis("ISVEREN_ANA.fxml");
			      ((Node)(event.getSource())).getScene().getWindow().hide();
				
			}
			
				
				
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
	
    	
}
    }
  
       
    @FXML
    void initialize() {
    	
     
      
    }

}
