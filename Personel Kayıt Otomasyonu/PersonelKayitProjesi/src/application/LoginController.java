package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import database.veritabani;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
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
import javafx.util.Duration;

public class LoginController {
	   Connection baglanti=null;
	    PreparedStatement sorguifadesi=null;
	    ResultSet getirilen=null;
	    String sql,sql1,sql2;
	   
		public LoginController() {
			
			baglanti=veritabani.baglan();
		}
    @FXML
    private ResourceBundle resources;
    @FXML
    private MenuItem MenuYardim;
    @FXML
    private MenuItem isverenhakkinda;
    @FXML
    private Label F;

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
    private TextField txt_login_TC;

    @FXML
    private PasswordField txt_login_sifre;
    @FXML
    void isveren_click(ActionEvent event) {
    	
    	
    }
    @FXML
    void isverenmenu_click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("sirketlogin.fxml");
	     
	      
    }
    @FXML
    void btn_login_giris_click(ActionEvent event) {
    	
    	 String kontrol=kayitcontroller.MDSSifreleme(txt_login_sifre.getText().trim());                  
    	
    	
    	sql="select * from kayit where tc=? and sifre=? ";
    	try {
    		
    		sorguifadesi=baglanti.prepareStatement(sql);
    		sorguifadesi.setString(1, txt_login_TC.getText().trim());
			sorguifadesi.setString(2, kontrol);
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
			      frm.Gecis("Ana_Sayfa.fxml");
			      ((Node)(event.getSource())).getScene().getWindow().hide();
				
			}
			
				
				
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
	
    	
}
    }
    @FXML
    void kayitol_click(MouseEvent event) {
    	 FormGetir frm =new FormGetir();
	      frm.Gecis("Kayitol.fxml");
    }
       
    @FXML
    void initialize() {
    	
     	ScaleTransition scale = new ScaleTransition();
        scale.setNode(F);
        scale.setDuration(Duration.millis(1000));
        scale.setCycleCount(TranslateTransition.INDEFINITE);
        scale.setInterpolator(Interpolator.LINEAR);
        scale.setByX(0.6);
        scale.setByY(0.6);
        scale.setAutoReverse(true);
        scale.play();    
      
    }

}
