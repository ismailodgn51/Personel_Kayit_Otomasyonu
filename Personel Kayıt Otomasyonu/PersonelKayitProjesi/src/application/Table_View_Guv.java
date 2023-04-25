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

public class Table_View_Guv {
	 Connection baglanti=null;
	    PreparedStatement sorguifadesi=null;
	    ResultSet getirilen=null;
	    String sql,sql1,sql2;
	   
		public Table_View_Guv() {
			
			baglanti=veritabani.baglan();}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<fGuvenlikCLASS, String> Adi;
    @FXML
    private Label tckimlik;
    @FXML
    private TableColumn<fGuvenlikCLASS, String> Adres;

    @FXML
    private TableColumn<fGuvenlikCLASS, String> D_Tarihi;

    @FXML
    private TableColumn<fGuvenlikCLASS, String> Egitim;

    @FXML
    private TableColumn<fGuvenlikCLASS, Integer> ID;

    @FXML
    private TableColumn<fGuvenlikCLASS, Integer> Maas;

    @FXML
    private TableColumn<fGuvenlikCLASS, String> Medeni_Hal;

    @FXML
    private TableColumn<fGuvenlikCLASS, String> Soyadi;

    @FXML
    private TableView<fGuvenlikCLASS> Table_View_guv;

    @FXML
    private TableColumn<fGuvenlikCLASS, String> Tc_Kimlik;

    @FXML
    private TableColumn<fGuvenlikCLASS, String> Telefon_No;

    @FXML
    private Button btnSil;

    @FXML
    private Button btn_arama;

    @FXML
    private TableColumn<Kayitlar_Constructor, String> cinsiyet;

    @FXML
    private DatePicker datepicker1;

    @FXML
    private TableColumn<Kayitlar_Constructor, String> ehliyet;

    @FXML
    private TableColumn<Kayitlar_Constructor, String> mail;

    @FXML
    private TableColumn<Kayitlar_Constructor, String> soru1;

    @FXML
    private TableColumn<Kayitlar_Constructor, String> soru2;

    @FXML
    private TableColumn<Kayitlar_Constructor, String> soru3;

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
    	fGuvenlikCLASS Kayitlar=new fGuvenlikCLASS();
    	Kayitlar=(fGuvenlikCLASS) Table_View_guv.getItems().get(Table_View_guv.getSelectionModel().getSelectedIndex());
    	
    	
    	tckimlik.setText(Kayitlar.getTc_Kimlik());
    }
int durum=0;
    @FXML
    void btnSil_Click(ActionEvent event) {
    	fGuvenlikCLASS kayit=new fGuvenlikCLASS();
    	 
   	 if(Table_View_guv.getSelectionModel().getSelectedIndex()!=-1) {
	kayit=(fGuvenlikCLASS) Table_View_guv.getItems().get(Table_View_guv.getSelectionModel().getSelectedIndex());
//	int a;
	// a=kayit.getID();    
	//System.out.println(a);
	sql="delete from guvenlik where yid=?";

	try {
		
   		sorguifadesi=baglanti.prepareStatement(sql);
   		sorguifadesi.setInt(1, kayit.getID());
		  
		
		ObservableList<fGuvenlikCLASS> secilenKayit, tumKayitlar;
   	tumKayitlar=Table_View_guv.getItems();
   	secilenKayit=Table_View_guv.getSelectionModel().getSelectedItems();
   	
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
    	 String sql0="select * from guvenlik where ykimlik > {0} and ykimlik < {1}";
         String sql1 = java.text.MessageFormat.format(sql0, txtdeger1.getText(), txtdeger2.getText());
         degerlerigetir(Table_View_guv, sql1);
    }

  
    @FXML
    void txt_arama_keypressed(KeyEvent event) {
if(txt_arama.getText().contains("")) {
      		
      		sql="select * from guvenlik where ykimlik like '%"+txt_arama.getText()+"%' or ysoyadi like '%"+txt_arama.getText()+"%'" ; 
      		
      		
      		degerlerigetir(Table_View_guv, sql);
      	}else {
   	
      		 
     		    }
    }
    ObservableList<fGuvenlikCLASS> veriler;
    public void degerlerigetir(TableView tablo, String sql) {
    //	sql="select * from yonetici";
    	
    	
    	ObservableList<fGuvenlikCLASS> kayitlarliste = FXCollections.observableArrayList();
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		 ResultSet getirilen=sorguifadesi.executeQuery();
    		 while (getirilen.next()) {
    		//	 sql="insert into  muhendislik(yadi,ysoyadi,ydogumtarihi,ykimlik,ytelefon,ymedenihal,ymaas,yadres,ygunler,ytecrube,yalan,mOrtalama,brans,msorgu)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
    			 
    		 kayitlarliste.add(new fGuvenlikCLASS(getirilen.getInt("yid"),getirilen.getString("yadi"),getirilen.getString("ysoyadi"),getirilen.getString("ydogumtarihi"),
				getirilen.getString("ykimlik"),getirilen.getString("ytelefon"),getirilen.getString("ymedenihal"),getirilen.getDouble("ymaas"),getirilen.getString("yadres")
				,getirilen.getString("Egitim"),getirilen.getString("Cinsiyet"),getirilen.getString("Ehliyet"),getirilen.getString("soru1"),getirilen.getString("soru2"),getirilen.getString("soru3"),getirilen.getString("mail")));
				
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
        	 cinsiyet.setCellValueFactory(new PropertyValueFactory<>("Cinsiyet"));
        	 ehliyet.setCellValueFactory(new PropertyValueFactory<>("Ehliyet"));
        	 soru1.setCellValueFactory(new PropertyValueFactory<>("soru1"));
        	 soru2.setCellValueFactory(new PropertyValueFactory<>("soru2"));
        	 soru3.setCellValueFactory(new PropertyValueFactory<>("soru3"));
        	 mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
			 
        	 Table_View_guv.setItems(kayitlarliste);
    		 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		
		}
    }
    	
    	
    	// veriler=FXCollections.observableArrayList();
    	// veriler.add(new Kayitlar_Constructor(1,"ismail","öz",2000,486,0537,"bekar",10000,"niðde","pazar","yok", "java"));
    @FXML
    void initialize() {

sql="select * from guvenlik";
       	
       	degerlerigetir(Table_View_guv, sql);
    }

}
