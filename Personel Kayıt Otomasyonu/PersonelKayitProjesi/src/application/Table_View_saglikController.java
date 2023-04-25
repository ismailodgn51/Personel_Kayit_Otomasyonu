package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import database.veritabani;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Table_View_saglikController {
	 Connection baglanti=null;
	    PreparedStatement sorguifadesi=null;
	    ResultSet getirilen=null;
	    String sql,sql1,sql2;
	   
		public Table_View_saglikController() {
			
			baglanti=veritabani.baglan();
			
			
		}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private TableColumn<fSAGLIKCICLASS, String> Adi;

    @FXML
    private TableColumn<fSAGLIKCICLASS, String> Adres;


    @FXML
    private TableColumn<fSAGLIKCICLASS, String> Brans;

    @FXML
    private TableColumn<fSAGLIKCICLASS, String> D_Tarihi;

    @FXML
    private TableColumn<fSAGLIKCICLASS, String> Egitim;

    @FXML
    private TableColumn<fSAGLIKCICLASS, Integer> ID;

    @FXML
    private TableColumn<fSAGLIKCICLASS, Double> Maas;

    @FXML
    private TableColumn<fSAGLIKCICLASS, String> Medeni_Hal;

    @FXML
    private TableColumn<fSAGLIKCICLASS, Integer> Ortalama;

    @FXML
    private TableColumn<fSAGLIKCICLASS, String> Soyadi;

    @FXML
    private TableView<fSAGLIKCICLASS> Table_View_saglik;

    @FXML
    private TableColumn<fSAGLIKCICLASS, String> Tc_Kimlik;

    @FXML
    private TableColumn<fSAGLIKCICLASS, String> Tecrube;

    @FXML
    private TableColumn<fSAGLIKCICLASS, String> Telefon_No;
    @FXML
    private Button btnSil;

    @FXML
    private Button btn_arama;

    @FXML
    private DatePicker datepicker1;
    @FXML
    private Label tckimlik;
    @FXML
    private TextField txt_arama;

    @FXML
    private TextField txtdeger1;
    
    @FXML
    private TextField txtdeger2;
    @FXML
    private Button Btn_Geri;
    @FXML
    void Btn_Geri_Click(ActionEvent event) {
    	
    	
    }
    
    @FXML
    void kayitlar_table_Click(MouseEvent event) {
    	fSAGLIKCICLASS Kayitlar=new fSAGLIKCICLASS();
    	Kayitlar=(fSAGLIKCICLASS) Table_View_saglik.getItems().get(Table_View_saglik.getSelectionModel().getSelectedIndex());
    	
    	
    	tckimlik.setText(Kayitlar.getTc_Kimlik());
    }
    
    
    int durum=0;
    @FXML
    void btnSil_Click(ActionEvent event)   {
    
    
    	fSAGLIKCICLASS kayit=new fSAGLIKCICLASS();
 
    	 if(Table_View_saglik.getSelectionModel().getSelectedIndex()!=-1) {
	kayit=(fSAGLIKCICLASS) Table_View_saglik.getItems().get(Table_View_saglik.getSelectionModel().getSelectedIndex());
//	int a;
	// a=kayit.getID();    
	//System.out.println(a);
	sql="delete from saglik where mid=?";

	try {
		
    		sorguifadesi=baglanti.prepareStatement(sql);
    		sorguifadesi.setInt(1, kayit.getID());
		  
		
		ObservableList<fSAGLIKCICLASS> secilenKayit, tumKayitlar;
    	tumKayitlar=Table_View_saglik.getItems();
    	secilenKayit=Table_View_saglik.getSelectionModel().getSelectedItems();
    	
    	if(durum==0)
    	{
    		
    			TextInputDialog dialog=new TextInputDialog("");
    			dialog.setTitle("DIKKAT ");
    	    	dialog.setHeaderText("Kaydinizi silmek icin lutfen KENDI Kimlik numaranizi giriniz");
    	    	dialog.setContentText("11 Haneli kimlik numaraniz");
    	        
    	    	Optional<String> sonuc = dialog.showAndWait();
    	    	
    	    		if(sonuc.get().equals(tckimlik.getText())) {
    	    			//txtarea.appendText("HOSGELDÝNÝZ " + "ismail" + " " + "özdogan"+sonuc.get()+"\n");
    	    			
    	    			sorguifadesi.executeUpdate();
    	    			secilenKayit.forEach(tumKayitlar::remove);
    	    		}
    	    		else {
    	    		//	txtarea.appendText("hatali giris ");
    	    			Alert alert=new Alert(AlertType.ERROR);
    	    	    	alert.setTitle("ÝSTE Otomasyon");
    	    	    	alert.setHeaderText("Hata Mesajý");
    	    	    	alert.setContentText("LUTFEN KIMLIK NUMARINIZI DOGRU GIRINIZ");
    	    	    	alert.showAndWait();
    	    		}
    	    		
    	  
    		}
    	    	
    	
	}
catch (Exception e) {
	// TODO: handle exception
	System.out.println(e);
}
}

else {
	System.out.println("Herhangi Bir deðer Girmediniz");
}

    	
    }

    @FXML
    void btn_arama_Click(ActionEvent event) {
    	 String sql0="select * from saglik where mOrtalama > {0} and mOrtalama < {1}";
         String sql1 = java.text.MessageFormat.format(sql0, txtdeger1.getText(), txtdeger2.getText());
         degerlerigetir(Table_View_saglik, sql1);
    }
 

    @FXML
    void txt_arama_keypressed(KeyEvent event) {
    	try {
    		if(txt_arama.getText().contains("")) {
          		
          		sql="select * from saglik where ykimlik like '%"+txt_arama.getText()+"%' or msoyadi like '%"+txt_arama.getText()+"%'" ; 
          		
          		
          		degerlerigetir(Table_View_saglik, sql);
          	}else {
       	
          		 
         		    }
		} catch (Exception e) {
			// TODO: handle exception
		}  
    	
    }
    ObservableList<fSAGLIKCICLASS> veriler;
    public void degerlerigetir(TableView tablo, String sql) {
    //	sql="select * from yonetici";
    	
    	
    	ObservableList<fSAGLIKCICLASS> kayitlarliste = FXCollections.observableArrayList();
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		 ResultSet getirilen=sorguifadesi.executeQuery();
    		 while (getirilen.next()) {	
    			
    			 kayitlarliste.add(new fSAGLIKCICLASS(getirilen.getInt("mid"),getirilen.getString("madi"),getirilen.getString("msoyadi"),getirilen.getString("ydogumtarihi"),
				getirilen.getString("ykimlik"),getirilen.getString("ytelefon"),getirilen.getString("ymedenihal"), getirilen.getDouble("ymaas"),getirilen.getString("yadres")
				,getirilen.getString("mLisans"),getirilen.getString("mtecrube"),getirilen.getString("Brans"), getirilen.getDouble("mOrtalama")));
				
			}
    		
    		 ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        	 Adi.setCellValueFactory(new PropertyValueFactory<>("Adi"));
        	 Soyadi.setCellValueFactory(new PropertyValueFactory<>("Soyadi"));
        	 D_Tarihi.setCellValueFactory(new PropertyValueFactory<>("D_Tarihi"));
        	 Tc_Kimlik.setCellValueFactory(new PropertyValueFactory<>("Tc_Kimlik"));
         	 Telefon_No.setCellValueFactory(new PropertyValueFactory<>("Telefon_No"));
         	 Medeni_Hal.setCellValueFactory(new PropertyValueFactory<>("Medeni_Hal"));
        	 Maas.setCellValueFactory(new PropertyValueFactory<>("Maas"));
        	 Adres.setCellValueFactory(new PropertyValueFactory<>("Adres"));
        	 Egitim.setCellValueFactory(new PropertyValueFactory<>("Egitim"));
        	 Tecrube.setCellValueFactory(new PropertyValueFactory<>("Tecrube"));
        	
        	 Ortalama.setCellValueFactory(new PropertyValueFactory<>("ORTALAMA"));
        	 Brans.setCellValueFactory(new PropertyValueFactory<>("Brans"));
        	 
			 
        	 Table_View_saglik.setItems(kayitlarliste);
    		 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		
		}
    	
    	
    	
    	// veriler=FXCollections.observableArrayList();
    	// veriler.add(new Kayitlar_Constructor(1,"ismail","öz",2000,486,0537,"bekar",10000,"niðde","pazar","yok", "java"));
     	  	 
		}
    	 
       	
    @FXML
    void initialize() {
    	  sql="select * from saglik";
      	
      	degerlerigetir(Table_View_saglik, sql);

    }

}
