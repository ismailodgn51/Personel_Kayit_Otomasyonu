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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class OgretmenController {
	  Connection baglanti=null;
	    PreparedStatement sorguifadesi=null;
	    ResultSet getirilen=null;
	    String sql,sql1,sql2;
	   
		public OgretmenController() {
			
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
    private AnchorPane anchor_gizle;

    @FXML
    private ChoiceBox<String> choice1;

    @FXML
    private ChoiceBox<String> choice2;

    @FXML
    private ChoiceBox<String> choice3;

    @FXML
    private Label k1;

    @FXML
    private RadioButton radio_bekar;

    @FXML
    private RadioButton radio_evli;

    @FXML
    private ToggleButton togg1;

    @FXML
    private ToggleButton togg2;

    @FXML
    private ToggleButton togg3;

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
    private TextField txt_Mail;

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
    
   	 sql="update ogretmen set madi=?,msoyadi=? where ykimlik=?";
  	try {
  		if(txt_Adi.getText()!="") {
  		sorguifadesi=baglanti.prepareStatement(sql); 		
  		sorguifadesi.setString(1, txt_Adi.getText().trim());
  		sorguifadesi.setString(2, txt_Soyadi.getText().trim()); 
  		sorguifadesi.setString(3, txt_Kimlik_No.getText().trim());
        sorguifadesi.executeUpdate();}
       		
       		
       			
       	
       		Alert alert = new Alert(AlertType.INFORMATION);
    	    	alert.setTitle("KAYIT OTOMASYONU");
    	    	alert.setHeaderText("GUNCELLEME BASARILI");	    	
    	    	alert.showAndWait();
       		
    	    		
   		} catch (Exception e) {
   			System.out.println(e);
   			Alert alert = new Alert(AlertType.ERROR);
   	    	alert.setTitle("KAYIT OTOMASYONU");
   	    	alert.setHeaderText("HATALI KIMLIK GUNCELLEME BASARISIZ");	    	
   	    	alert.showAndWait();
   		}
       } {
       	
       }
       
    
    public Boolean wait=true;
    @FXML
    void togg1_C(ActionEvent event) {
    	
    	
    	if(wait) {
    		choice1.setVisible(true);
    		choice2.setVisible(false);
    		choice3.setVisible(false);
    		wait=false;
    	}
    	else {
    		choice1.setVisible(true);
    		choice2.setVisible(true);
    		choice3.setVisible(true);
    		wait=true;
    	}

    }

    @FXML
    void togg2_C(ActionEvent event) {
     	if(wait) {
     		choice2.setVisible(true);
    		choice1.setVisible(false);
    		choice3.setVisible(false);
    		wait=false;
    	}
    	else {
    		choice2.setVisible(true);
    		choice1.setVisible(true);
    		choice3.setVisible(true);
    		wait=true;
    	}
    }

    @FXML
    void togg3_C(ActionEvent event) {
    	
     	if(wait) {
     		choice3.setVisible(true);
    		choice1.setVisible(false);
    		choice2.setVisible(false);
    		wait=false;
    	}
    	else {
    		choice3.setVisible(true);
    		choice1.setVisible(true);
    		choice2.setVisible(true);
    		wait=true;
    	}

    }
    @FXML
    void Btn_Kaydet_Click(ActionEvent event) {
    	sql="insert into  ogretmen(madi,msoyadi,ydogumtarihi,ykimlik,ytelefon,ymedenihal,ymaas,yadres,mLisans,mOrtalama,Hangikesim,brans,mail)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
    		
    		if(togg1.isSelected()) {
    			sorguifadesi.setString(11, "ILKOKUL" );
			
    		}else if(togg2.isSelected()) {
    			sorguifadesi.setString(11, "ORTAOKUL" );
    			
    		}else if(togg3.isSelected()) {
    			sorguifadesi.setString(11, "LISE" );
    			
    		}else {
    			System.out.println("alert ekle");
    		}
     		if(togg1.isSelected()) {
     			sorguifadesi.setString(12, choice1.getSelectionModel().getSelectedItem());
     		}
    		sorguifadesi.setString(13, txt_Mail.getText().trim());

		
    	if(txt_Adi.getText() != "" && txt_Soyadi.getText() != "" && txt_Kimlik_No.getText().length()==11 && txt_Telefon_No.getText().length()>=11)
        		
        	{
        			TextInputDialog dialog=new TextInputDialog("");
                	dialog.setTitle("iste otomasyon");
                	dialog.setHeaderText("Textfield ile de�er yollama");
                	dialog.setContentText("telefonunuza gelen onay kodunu giriniz..");
                    
                	Optional<String> sonuc = dialog.showAndWait();
                	String a="5151";
                		if(sonuc.get().equals(a)) {
                			//txtarea.appendText("HOSGELD�N�Z " + "ismail" + " " + "�zdogan"+sonuc.get()+"\n");
                		
                 			sorguifadesi.executeUpdate();
                 			Alert alert = new Alert(AlertType.INFORMATION);
                 	    	alert.setTitle("KAYIT OTOMASYONU");
                 	    	alert.setHeaderText("ONAY MEsAJI");
                 	    	alert.setContentText("BASARILLI KAYIT TEBRIKLER EN KISA ZAMANDA UMARIM IS BULURSUNUZ");
                 	    	alert.showAndWait();
                		}
                		else {
                		//	txtarea.appendText("hatali giris ");
                			System.out.println("hatali giris");
                		}
        	}
                		
                		else {
                    		Alert alert = new Alert(AlertType.ERROR);
                        	alert.setTitle("iste otomasyon");
                        	alert.setHeaderText("Hata Mesaj�");
                        	alert.setContentText("TC VEYA TELEFON NUMARAN�Z� DUZGUN G�R�N�Z ozel karakter icermemeli ve hi�bir de�eri bo� ge�meyiniz");
                        	alert.showAndWait();
                    	}   	
    }
    	
    	   catch (Exception e) {
    			// TODO: handle exception
    		   System.out.println(e);
    		   Alert alert = new Alert(AlertType.ERROR);
    	    	alert.setTitle("iste otomasyon");
    	    	alert.setHeaderText("Hata Mesaj�");
    	    	alert.setContentText("TC VEYA TELEFON NUMARAN�Z� DUZGUN G�R�N�Z ozel karakter icermemeli ve hi�bir de�eri bo� ge�meyiniz");
    	    	alert.showAndWait();
    	   }
    }

    @FXML
    void Btn_Kayitlar_Click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("Table_ViewOgr.fxml");
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
    	ObservableList<String> a = FXCollections.observableArrayList("ilkokul","hayat");
        choice1.getItems().addAll(a);
      
       ObservableList<String> b = FXCollections.observableArrayList("ortaokul","sosyal");
       choice2.getItems().addAll(b);
      
       ObservableList<String> c = FXCollections.observableArrayList("lisedersleri","felsefe");
       choice3.getItems().addAll(c);

       ToggleGroup grup = new ToggleGroup();
       radio_bekar.setToggleGroup(grup);
     	radio_evli.setToggleGroup(grup);
    }

}
