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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Saglikci_Controller {
	
	  Connection baglanti=null;
	    PreparedStatement sorguifadesi=null;
	    ResultSet getirilen=null;
	    String sql,sql1,sql2;
	   
		public Saglikci_Controller() {
			
			baglanti=veritabani.baglan();
			
			
		}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane Anchor_Sol;

    @FXML
    private Button Btn_Geri;

    @FXML
    private Button Btn_Gizle;

    @FXML
    private Button Btn_Guncelle;

    @FXML
    private Button Btn_Kaydet;

    @FXML
    private Button Btn_Kayitlar;

    @FXML
    private TextField Lisans;

    @FXML
    private TextField Ortalama;

    @FXML
    private TextArea Text_Area_Tecrube;

    @FXML
    private AnchorPane anchor_gizle;

    @FXML
    private Label k1;

    @FXML
    private ListView<String> listviewsaglik;

    @FXML
    private RadioButton radio_bekar;

    @FXML
    private RadioButton radio_evli;

    @FXML
    private TextField txt_Adi;

    @FXML
    private TextArea txt_Area_Adres;

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
    	sql="update saglik set madi=? where ykimlik=?";
     	sql1="update saglik set msoyadi=? where ykimlik=?";
    	
     	
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
    		
    
    		
    		   		
    		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
    	
    }

    @FXML
    void Btn_Kaydet_Click(ActionEvent event) {
    	sql="insert into  saglik(madi,msoyadi,ydogumtarihi,ykimlik,ytelefon,ymedenihal,ymaas,yadres,mLisans,mOrtalama,mtecrube,brans)values(?,?,?,?,?,?,?,?,?,?,?,?)";
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
    		sorguifadesi.setString(9, Lisans.getText().trim());
    		sorguifadesi.setDouble(10, Double.parseDouble( Ortalama.getText().trim()));
    		sorguifadesi.setString(11, Text_Area_Tecrube.getText().trim());
     		//sorguifadesi.setString(12, Text_Area_Alan.getText().trim());
     	//	sorguifadesi.setString(13, Lisans.getText().trim());
    		sorguifadesi.setString(12,  listviewsaglik.getSelectionModel().getSelectedItem());
         	
    		

  		
  		
  		
		
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
                 			Alert alert = new Alert(AlertType.INFORMATION);
                 	    	alert.setTitle("KAYIT OTOMASYONU");
                 	    	alert.setHeaderText("ONAY MEsAJI");
                 	    	alert.setContentText("BASARILLI KAYIT TEBRIKLER EN KISA ZAMANDA UMARIM IS BULURSUNUZ");
                 	    	alert.showAndWait();
                		}
                		else {
                			Alert alert = new Alert(AlertType.ERROR);
                        	alert.setTitle("TEKRAR DENEYINIZ");
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
    		   System.out.println("hatali giris");
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
	      frm.Gecis("Table_ViewSag.fxml");
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
       ObservableList<String> a = FXCollections.observableArrayList("hemþire","ebe");
       listviewsaglik.getItems().addAll(a);
    	
       ToggleGroup grup = new ToggleGroup();
       radio_bekar.setToggleGroup(grup);
     	radio_evli.setToggleGroup(grup);
        

    }

}
