package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class Table_View_finansController {
	 Connection baglanti=null;
	    PreparedStatement sorguifadesi=null;
	    ResultSet getirilen=null;
	    String sql,sql1,sql2;
	   
		public Table_View_finansController() {
			
			baglanti=veritabani.baglan();}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<finansClas, String> Adi;

    @FXML
    private TableColumn<finansClas, String> Adres;

    @FXML
    private TableColumn<finansClas, String> C_saati;

    @FXML
    private TableColumn<finansClas, String> D_Tarihi;

    @FXML
    private TableColumn<finansClas, String> Egitim;

    @FXML
    private TableColumn<finansClas, String> Erp_Bilgisi;

    @FXML
    private TableColumn<finansClas, String> Exel_Bilgisi;

    @FXML
    private TableColumn<finansClas, Integer> ID;

    @FXML
    private TableColumn<finansClas, Integer> Maas;

    @FXML
    private TableColumn<finansClas, String> Medeni_Hal;

    @FXML
    private TableColumn<finansClas, Integer> Ortalama;

    @FXML
    private TableColumn<finansClas, String> Soyadi;

    @FXML
    private TableView<finansClas> Table_View_finans;

    @FXML
    private TableColumn<finansClas, String> Tc_Kimlik;

    @FXML
    private TableColumn<finansClas, String> Telefon_No;

    @FXML
    private Button btnSil;
    @FXML
    private Label tckimlik;
    @FXML
    private Button btn_arama;
   
    @FXML
    private TableColumn<Kayitlar_Constructor, String> cinsiyet;

    @FXML
    private DatePicker datepicker1;

    @FXML
    private TableColumn<Kayitlar_Constructor, String> mail;

    @FXML
    private TableColumn<Kayitlar_Constructor, String> modul;

    @FXML
    private TextField txt_arama;
    @FXML
    private Label tckimlik3;
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
    	finansClas Kayitlar=new finansClas();
    	Kayitlar=(finansClas) Table_View_finans.getItems().get(Table_View_finans.getSelectionModel().getSelectedIndex());
    	
    	
    	tckimlik3.setText(Kayitlar.getTc_Kimlik());
    }
int durum=0;
    @FXML
    void btnSil_Click(ActionEvent event) {
    	finansClas kayit=new finansClas();
    	 
   	 if(Table_View_finans.getSelectionModel().getSelectedIndex()!=-1) {
	kayit=(finansClas) Table_View_finans.getItems().get(Table_View_finans.getSelectionModel().getSelectedIndex());
//	int a;
	// a=kayit.getID();    
	//System.out.println(a);
	sql="delete from finans where fid=?";

	try {
		
   		sorguifadesi=baglanti.prepareStatement(sql);
   		sorguifadesi.setInt(1, kayit.getID());
		  
		
		ObservableList<finansClas> secilenKayit, tumKayitlar;
   	tumKayitlar=Table_View_finans.getItems();
   	secilenKayit=Table_View_finans.getSelectionModel().getSelectedItems();
   	
   	if(durum==0)
   	{
   		
   			TextInputDialog dialog=new TextInputDialog("");
   			dialog.setTitle("DIKKAT ");
   	    	dialog.setHeaderText("Kaydinizi silmek icin lutfen KENDI Kimlik numaranizi giriniz");
   	    	dialog.setContentText("11 Haneli kimlik numaraniz");
   	        
   	    	Optional<String> sonuc = dialog.showAndWait();
   	    	
   	    		if(sonuc.get().equals(tckimlik3.getText())) {
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
    	 String sql0="select * from finans where mOrtalama > {0} and mOrtalama < {1}";
         String sql1 = java.text.MessageFormat.format(sql0, txtdeger1.getText(), txtdeger2.getText());
         degerlerigetir(Table_View_finans, sql1);
    }

  

    @FXML
    void txt_arama_keypressed(KeyEvent event) {
     if(txt_arama.getText().contains("")) {
      		
      		sql="select * from finans where ykimlik like '%"+txt_arama.getText()+"%' or msoyadi like '%"+txt_arama.getText()+"%'" ; 
      		
      		
      		degerlerigetir(Table_View_finans, sql);
      	}else {
   	
      		 
     		    }

    }
    ObservableList<finansClas> veriler;
    public void degerlerigetir(TableView tablo, String sql) {
    //	sql="select * from yonetici";
    	
    	
    	ObservableList<finansClas> kayitlarlistea = FXCollections.observableArrayList();
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		 ResultSet getirilen=sorguifadesi.executeQuery();
    		 while (getirilen.next()) {
    		//	 sql="insert into  muhendislik(yadi,ysoyadi,ydogumtarihi,ykimlik,ytelefon,ymedenihal,ymaas,yadres,ygunler,ytecrube,yalan,mOrtalama,brans,msorgu)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
    			 //(getirilen.getInt("fid"),getirilen.getString("madi"),getirilen.getString("msoyadi"),getirilen.getString("ydogumtarihi"),
 				//getirilen.getString("ykimlik"),getirilen.getString("ytelefon"),getirilen.getString("ymedenihal"),getirilen.getDouble("ymaas"),getirilen.getString("yadres")
 			//	,getirilen.getString("mLisans"),getirilen.getDouble("mOrtalama"),getirilen.getString("mail"),getirilen.getString("cinsiyet"),getirilen.getString("Erp"),getirilen.getString("excel"),getirilen.getString("calismasaati"),getirilen.getString("modul"))
    		 kayitlarlistea.add(new finansClas(getirilen.getInt("fid"),getirilen.getString("madi"),getirilen.getString("msoyadi"),getirilen.getString("ydogumtarihi"),
				getirilen.getString("ykimlik"),getirilen.getString("ytelefon"),getirilen.getString("ymedenihal"),getirilen.getDouble("ymaas"),getirilen.getString("yadres")
				,getirilen.getString("mLisans"),getirilen.getDouble("mOrtalama"),getirilen.getString("mail"),getirilen.getString("cinsiyet"),getirilen.getString("Erp"),getirilen.getString("excel"),getirilen.getString("calismasaati"),getirilen.getString("modul")));
				
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
          	 mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
          	cinsiyet.setCellValueFactory(new PropertyValueFactory<>("Cinsiyet"));
          	Erp_Bilgisi.setCellValueFactory(new PropertyValueFactory<>("Erp"));
          	Exel_Bilgisi.setCellValueFactory(new PropertyValueFactory<>("Excel"));
          	C_saati.setCellValueFactory(new PropertyValueFactory<>("calismasaati"));
          	modul.setCellValueFactory(new PropertyValueFactory<>("modul"));
			 
        	 Table_View_finans.setItems(kayitlarlistea);
    		 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		
		}
    	
    	
    	
    	// veriler=FXCollections.observableArrayList();
    	// veriler.add(new Kayitlar_Constructor(1,"ismail","öz",2000,486,0537,"bekar",10000,"niðde","pazar","yok", "java"));
    }
    @FXML
    void initialize() {
     
     	 sql="select * from finans";
        	
        	degerlerigetir(Table_View_finans, sql);

    }

}
