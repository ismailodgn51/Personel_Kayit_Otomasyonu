package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import database.veritabani;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class GuvenlikController {
	   Connection baglanti=null;
	    PreparedStatement sorguifadesi=null;
	    ResultSet getirilen=null;
	    String sql,sql1,sql2;
	   
		public GuvenlikController() {
			
			baglanti=veritabani.baglan();
			
			
		}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private CheckBox checkba;

    @FXML
    private CheckBox checker;
    @FXML
    private AnchorPane Anchor_Sol;
    @FXML
    private ComboBox<String> comboehliyet;

    @FXML
    private Button Btn_Geri;
    @FXML
    private RadioButton radios1evet;

    @FXML
    private RadioButton radios1hayir;

    @FXML
    private RadioButton radios2evet;

    @FXML
    private RadioButton radios2hayir;

    @FXML
    private RadioButton radios3evet;

    @FXML
    private RadioButton radios3hayir;

    @FXML
    private Button Btn_Gizle;

    @FXML
    private Button Btn_Guncelle;

    @FXML
    private Button Btn_Kaydet;

    @FXML
    private Button Btn_Kayitlar;

    @FXML
    private AnchorPane anchor_gizle;

    @FXML
    private Label k1;

    @FXML
    private RadioButton radio_bekar;

    @FXML
    private RadioButton radio_evli;

    @FXML
    private TextField txt_Adi;

    @FXML
    private TextArea txt_Area_Adres;
    @FXML
    private TextField mail;

    @FXML
    private TextArea txt_Area_Egitim;

    @FXML
    private TextField txt_Dogum_Tarihi;

    @FXML
    private DatePicker txt_Dogum_Tarihii;

    @FXML
    private TextField txt_Id;

    @FXML
    private TextField txt_Kimlik_No;

    @FXML
    private TextField txt_Maas;

    @FXML
    private TextField txt_Soyadi;

    @FXML
    private TextField txt_Telefon_No;
    @FXML
    private Button GirisimFikirleri;
    @FXML
    private Button Bilgilendirme;
    @FXML
    private Button Cikis;
    @FXML
    void GirisimFikirleri_Click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("GirisimFikri.fxml");
    }
    @FXML
    void Bilgilendirme_Click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("Otomasyon_Bilgilendirme.fxml");
    }
    @FXML
    void Cikis_Click(ActionEvent event) {
    	Platform.exit();
    }
    @FXML
    void Btn_Geri_Click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("Ana_Sayfa.fxml");
	      ((Node)(event.getSource())).getScene().getWindow().hide();

    }
    int durum=0;
    public boolean a = true;
    @FXML
    void Btn_Gizle_Click(ActionEvent event) {
    	if(a) {
    		anchor_gizle.setVisible(false);
    		a=false;
    	} else {
    		anchor_gizle.setVisible(true);
    		a=true;
    		
    	}
    	
    	
    	if(durum==0) {
    		FadeTransition fd1= new FadeTransition(Duration.seconds(1), Anchor_Sol);
    		fd1.setFromValue(0);
    	fd1.setToValue(1);
    		fd1.play();
    		
    		TranslateTransition tt1 =new TranslateTransition(Duration.seconds(1.2),Anchor_Sol);
    		tt1.setByX(+244);
    		tt1.play();
    		durum=1;
    	}else {
    		FadeTransition fd1= new FadeTransition(Duration.seconds(0.4), Anchor_Sol);
    		fd1.setFromValue(0);
        	fd1.setToValue(1);
    		fd1.play();
    		
    		TranslateTransition tt1 =new TranslateTransition(Duration.seconds(0.3),Anchor_Sol);
    		tt1.setByX(-244);
    		tt1.play();
    		durum=0;}
    }

    @FXML
    void Btn_Guncelle_Click(ActionEvent event) {
    	
      	sql="update guvenlik set yadi=? where ykimlik=?";
     	sql1="update guvenlik set ysoyadi=? where ykimlik=?";
    	sql2="update guvenlik set ymedenihal=? where ykimlik=?";
     	
    	try {
    		if(txt_Adi.getText()!="") {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		sorguifadesi.setString(2, txt_Kimlik_No.getText().trim());
    		sorguifadesi.setString(1, txt_Adi.getText().trim());
    		sorguifadesi.executeUpdate();}
    		
    		if(txt_Soyadi.getText()!="") {
    		sorguifadesi=baglanti.prepareStatement(sql1);
    		sorguifadesi.setString(2, txt_Kimlik_No.getText().trim());
    		sorguifadesi.setString(1, txt_Soyadi.getText().trim());
    		sorguifadesi.executeUpdate();}
    		
    	
    		if(radio_evli.isSelected()){
    		sorguifadesi=baglanti.prepareStatement(sql2);
    		sorguifadesi.setString(2, txt_Kimlik_No.getText().trim());
    		sorguifadesi.setString(1, "Evli");
    	
    		sorguifadesi.executeUpdate();
    		}else if(radio_bekar.isSelected()) {
    			sorguifadesi=baglanti.prepareStatement(sql2);
        		sorguifadesi.setString(2, txt_Kimlik_No.getText().trim());
        		sorguifadesi.setString(1, "Bekar");
        		sorguifadesi.executeUpdate();
        		
    		}
    		
    		   		
    		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
    	
    	
    }

    @FXML
    void Btn_Kaydet_Click(ActionEvent event) {
    	sql="insert into  guvenlik(yadi,ysoyadi,ydogumtarihi,ykimlik,ytelefon,ymedenihal,ymaas,yadres,Egitim,Cinsiyet,Ehliyet,soru1,soru2,soru3,mail)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	try {
			
    		sorguifadesi=baglanti.prepareStatement(sql);
    		
    		sorguifadesi.setString(1, txt_Adi.getText().trim());
    		sorguifadesi.setString(2, txt_Soyadi.getText().trim());
    		sorguifadesi.setString(3, ((TextField)txt_Dogum_Tarihii.getEditor()).getText());
    		sorguifadesi.setString(4, txt_Kimlik_No.getText().trim());
    		sorguifadesi.setString(5, txt_Telefon_No.getText().trim());
    		if(radio_evli.isSelected()) {
    			sorguifadesi.setString(6, "evli" );
    			
    		}else if(radio_bekar.isSelected()) {
    			sorguifadesi.setString(6, "bekar" );
    		}else {
    			System.out.println("alert ekle");
    		}
    		sorguifadesi.setInt(7, Integer.parseInt( txt_Maas.getText().trim()));
    		sorguifadesi.setString(8, txt_Area_Adres.getText().trim());
    		sorguifadesi.setString(9, txt_Area_Egitim.getText().trim());
    		if(checker.isSelected()) {
    			sorguifadesi.setString(10, "Erkek" );
    			
    		}else if(checkba.isSelected()) {
    			sorguifadesi.setString(10, "Bayan" );
    		}else {
    			System.out.println("alert ekle");
    		}
    		sorguifadesi.setString(11, comboehliyet.getSelectionModel().getSelectedItem());
    		if(radios1evet.isSelected()) {
    			sorguifadesi.setString(12, "Evet" );
    			
    		}else if(radios1hayir.isSelected()) {
    			sorguifadesi.setString(12, "Hayýr" );
    		}else {
    			System.out.println("alert ekle");
    		}if(radios2evet.isSelected()) {
    			sorguifadesi.setString(13, "Evet" );
    			
    		}else if(radios2hayir.isSelected()) {
    			sorguifadesi.setString(13, "Hayýr" );
    		}else {
    			System.out.println("alert ekle");
    		
    		}if(radios3evet.isSelected()) {
    			sorguifadesi.setString(14, "Evet" );
    			
    		}else if(radios3hayir.isSelected()) {
    			sorguifadesi.setString(14, "Hayýr" );
    		}else {
    			System.out.println("alert ekle");
    		}
    		sorguifadesi.setString(15, mail.getText());
    	
      	
    		
        		if(txt_Adi.getText() != "" && txt_Soyadi.getText() != "" && txt_Kimlik_No.getText().length()==11 && txt_Telefon_No.getText().length()>=11)
            		
            	{
        			
      
            			TextInputDialog dialog=new TextInputDialog("");
                    	dialog.setTitle("iste otomasyon");
                    	dialog.setHeaderText("Textfield ile deðer yollama");
                    	dialog.setContentText("telefonunuza gelen onay kodunu giriniz..");
                        
                    	Optional<String> sonuc = dialog.showAndWait();
                    	String a="5151";
                    		if(sonuc.get().equals(a)) {
                    			//txtarea.appendText("HOSGELDÝNÝZ " + "ismail" + " " + "özdogan"+sonuc.get()+"\n");
                    			sorguifadesi.executeUpdate();
                    		}
                    		else {
                    		//	txtarea.appendText("hatali giris ");
                    			System.out.println("hatali giris");
                    		}
                    	
            		}

        	else {
        		Alert alert = new Alert(AlertType.ERROR);
            	alert.setTitle("iste otomasyon");
            	alert.setHeaderText("Hata Mesajý");
            	alert.setContentText("TC VEYA TELEFON NUMARANÝZÝ DUZGUN GÝRÝNÝZ ozel karakter icermemeli ve hiçbir deðeri boþ geçmeyiniz");
            	alert.showAndWait();
        	}
        
        	}   	
    	
    	
    catch (Exception e) {
		// TODO: handle exception
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("iste otomasyon");
    	alert.setHeaderText("Hata Mesajý");
    	alert.setContentText("TC VEYA TELEFON NUMARANÝZÝ DUZGUN GÝRÝNÝZ ozel karakter icermemeli ve hiçbir deðeri boþ geçmeyiniz");
    	alert.showAndWait();
	}
    	
    }

    @FXML
    void Btn_Kayitlar_Click(ActionEvent event) {
    	 FormGetir frm =new FormGetir();
	      frm.Gecis("Table_ViewGuv.fxml");

    }

    @FXML
    void radio_bekar_sec(ActionEvent event) {

    }

    @FXML
    void radio_evli_sec(ActionEvent event) {

    }

    @FXML
    void initialize() {
     	try {
    		AnchorPane panel=(AnchorPane)FXMLLoader.load(getClass().getResource("Hakkinda.fxml"));
    		anchor_gizle.getChildren().setAll(panel);
    	} catch (Exception e) {
    		// TODO: handle exception
    		e.printStackTrace();
    	}
    	
     	ObservableList<String> c = FXCollections.observableArrayList("a1","b2");
        comboehliyet.getItems().addAll(c);
    	

    }

}
