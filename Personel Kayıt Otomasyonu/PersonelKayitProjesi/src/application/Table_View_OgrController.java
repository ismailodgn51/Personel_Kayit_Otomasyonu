package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import database.veritabani;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class Table_View_OgrController {
	 Connection baglanti=null;
	    PreparedStatement sorguifadesi=null;
	    ResultSet getirilen=null;
	    String sql,sql1,sql2;
	   
		public Table_View_OgrController() {
			
			baglanti=veritabani.baglan();}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<OGRETMENCLASS, String> Adi;

    @FXML
    private TableColumn<OGRETMENCLASS, String> Adres;


    @FXML
    private TableColumn<OGRETMENCLASS, String> brans;

    @FXML
    private TableColumn<OGRETMENCLASS, String> D_Tarihi;

    @FXML
    private TableColumn<OGRETMENCLASS, String> Egitim;

    @FXML
    private TableColumn<OGRETMENCLASS, String> Hangikesim;

    @FXML
    private TableColumn<OGRETMENCLASS, Integer> ID;

    @FXML
    private TableColumn<OGRETMENCLASS, Double> Maas;

    @FXML
    private TableColumn<OGRETMENCLASS, String> Medeni_Hal;

    @FXML
    private TableColumn<OGRETMENCLASS, Integer> Ortalama;

    @FXML
    private TableColumn<OGRETMENCLASS, String> Soyadi;
    @FXML
    private TableView<OGRETMENCLASS> Table_View_ogr;
    @FXML
    private ImageView f;
    @FXML
    private TableColumn<OGRETMENCLASS, String> Tc_Kimlik;
    @FXML
    private TableColumn<OGRETMENCLASS, String> Telefon_No;

    @FXML
    private Button btnSil;

    @FXML
    private Button btn_arama;

    @FXML
    private DatePicker datepicker1;

    @FXML
    private TableColumn<Kayitlar_Constructor, String> mail;

    @FXML
    private TextField txt_arama;

    @FXML
    private TextField txtdeger1;
    @FXML
    private Label tckimlik;
    @FXML
    private TextField txtdeger2;
    @FXML
    private Button Btn_Geri;
    @FXML
    void Btn_Geri_Click(ActionEvent event) {
    	
    	
    }
    @FXML
    void kayitlar_table_Click(MouseEvent event) {
    	OGRETMENCLASS Kayitlar=new OGRETMENCLASS();
    	Kayitlar=(OGRETMENCLASS) Table_View_ogr.getItems().get(Table_View_ogr.getSelectionModel().getSelectedIndex());
    	
    	
    	tckimlik.setText(Kayitlar.getTc_Kimlik());
    }
int durum=0;
    @FXML
    void btnSil_Click(ActionEvent event) {
    	OGRETMENCLASS kayit=new OGRETMENCLASS();
    	 
   	 if(Table_View_ogr.getSelectionModel().getSelectedIndex()!=-1) {
	kayit=(OGRETMENCLASS) Table_View_ogr.getItems().get(Table_View_ogr.getSelectionModel().getSelectedIndex());
//	int a;
	// a=kayit.getID();    
	//System.out.println(a);
	sql="delete from ogretmen where mid=?";

	try {
		
   		sorguifadesi=baglanti.prepareStatement(sql);
   		sorguifadesi.setInt(1, kayit.getID());
		  
		
		ObservableList<OGRETMENCLASS> secilenKayit, tumKayitlar;
   	tumKayitlar=Table_View_ogr.getItems();
   	secilenKayit=Table_View_ogr.getSelectionModel().getSelectedItems();
   	
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
    	 String sql0="select * from ogretmen where 	mOrtalama > {0} and 	mOrtalama < {1}";
         String sql1 = java.text.MessageFormat.format(sql0, txtdeger1.getText(), txtdeger2.getText());
         degerlerigetir(Table_View_ogr, sql1);
      
    }  

    @FXML
    void txt_arama_keypressed(KeyEvent event) {
if(txt_arama.getText().contains("")) {
      		
      		sql="select * from ogretmen where ykimlik like '%"+txt_arama.getText()+"%' or msoyadi like '%"+txt_arama.getText()+"%'" ; 
      		
      		
      		degerlerigetir(Table_View_ogr, sql);
      	}else {
   	
      		 
     		    }

    }
    ObservableList<OGRETMENCLASS> veriler;
    public void degerlerigetir(TableView tablo, String sql) {
    //	sql="select * from yonetici";
    	
    	
    	ObservableList<OGRETMENCLASS> kayitlarliste = FXCollections.observableArrayList();
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		 ResultSet getirilen=sorguifadesi.executeQuery();
    		 while (getirilen.next()) {
    		//	 sql="insert into  muhendislik(yadi,ysoyadi,ydogumtarihi,ykimlik,ytelefon,ymedenihal,ymaas,yadres,ygunler,ytecrube,yalan,mOrtalama,brans,msorgu)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
    			 
    		 kayitlarliste.add(new OGRETMENCLASS(getirilen.getInt("mid"),getirilen.getString("madi"),getirilen.getString("msoyadi"),getirilen.getString("ydogumtarihi"),
				getirilen.getString("ykimlik"),getirilen.getString("ytelefon"),getirilen.getString("ymedenihal"),getirilen.getDouble("ymaas"),getirilen.getString("yadres")
				,getirilen.getString("mLisans"),getirilen.getDouble("mOrtalama"),getirilen.getString("Hangikesim"),getirilen.getString("brans"),getirilen.getString("mail")));
				
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
           	Ortalama.setCellValueFactory(new PropertyValueFactory<>("ORTALAMA"));
        	 Hangikesim.setCellValueFactory(new PropertyValueFactory<>("Hangikesim"));
        	 brans.setCellValueFactory(new PropertyValueFactory<>("Brans"));
        	 mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
			 
        	 Table_View_ogr.setItems(kayitlarliste);
    		 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		
		}
    	
    	 
    }
    @FXML
    void initialize() {
    	 sql="select * from ogretmen";
       	
       	degerlerigetir(Table_View_ogr, sql);
       
        	
    }

}
