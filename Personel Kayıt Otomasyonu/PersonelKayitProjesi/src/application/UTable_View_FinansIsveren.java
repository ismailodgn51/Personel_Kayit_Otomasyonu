package application;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import database.veritabani;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class UTable_View_FinansIsveren {
	 Connection baglanti=null;
	    PreparedStatement sorguifadesi=null;
	    ResultSet getirilen=null;
	    String sql,sql1,sql2;
	   
		public UTable_View_FinansIsveren() {
			
			baglanti=veritabani.baglan();}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TextField Sirket;
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
    private TableColumn<finansClas, String> cinsiyet;


    @FXML
    private TableColumn<finansClas, String> mail;

    @FXML
    private TableColumn<finansClas, String> modul;

    @FXML
    private TextField txtadi;

    @FXML
    private TextField txtsoyadi;
    @FXML
    private TextField telefon;
    @FXML
    private TextField maila;
    @FXML
    private TextArea txtarea;
   // +"\n"

    @FXML
    private ToggleButton geridon;

    @FXML
    private Button iseal;
    @FXML

    private Button btn_arama;
    @FXML
    void btn_arama_Click(ActionEvent event) {

    	
    }
    @FXML
    void geridon_click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("ISVEREN_ANA.fxml");
	      ((Node)(event.getSource())).getScene().getWindow().hide();
  	
    }

    @FXML
    void iseal_Click(ActionEvent event) {
    	sql="insert into  isealinanlar(adi,soyadi,mail,SirketAdi,meslek)values(?,?,?,?,?)";
    	try {
			
    		sorguifadesi=baglanti.prepareStatement(sql);
    		
    		sorguifadesi.setString(1, txtadi.getText().trim());
    		sorguifadesi.setString(2, txtsoyadi.getText().trim());
    		sorguifadesi.setString(3, mail.getText().trim());
    		sorguifadesi.setString(4, Sirket.getText().trim());
    		sorguifadesi.setString(5, "FINANS");
    		
    		Alert alert=new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("ÝSTE Otomasyon");
        	alert.setHeaderText("Kendi butonlarýmýz");
        	alert.setContentText("Silmek istediðinize emin misiniz");
        	
        	ButtonType btn1=new ButtonType("Evet");
        	
        	ButtonType btn3=new ButtonType("Ýptal", ButtonData.CANCEL_CLOSE); //Iptal
        	alert.getButtonTypes().setAll(btn1, btn3);
        	
        	Optional<ButtonType> sonuc= alert.showAndWait();
        	
        	if(sonuc.get()==btn1) {
        		sorguifadesi.executeUpdate();
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
    	        		sorguifadesi.executeUpdate();
    	        		
    	        		ObservableList<finansClas> secilenKayit, tumKayitlar;
    	            	tumKayitlar=Table_View_finans.getItems();
    	            	secilenKayit=Table_View_finans.getSelectionModel().getSelectedItems();
    	            	
    	            	secilenKayit.forEach(tumKayitlar::remove);
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
        	
        	else if(sonuc.get()==btn3) {
        		
        	}
        	else {
        		System.out.println("Ýptal tuþu");
        	}
    		

    	}catch (Exception e) {
		System.out.println(e);
		}
    }

    @FXML
    void kayitlar_table_Click(MouseEvent event) {
    	
    	finansClas Kayitlar=new finansClas();
    	Kayitlar=(finansClas) Table_View_finans.getItems().get(Table_View_finans.getSelectionModel().getSelectedIndex());
    	
    	
    	txtadi.setText(Kayitlar.getAdi());
    	txtsoyadi.setText(Kayitlar.getSoyadi());
    	telefon.setText(Kayitlar.getTelefon_No());
    	maila.setText(Kayitlar.getMail());
    	
    	txtarea.setText(Kayitlar.getEgitim()+" Universitesinden "+Kayitlar.getORTALAMA()+" Ortalama ile mezun \nExeli "+Kayitlar.getExcel()+" derecede biliyor"+
    	" Modul kullanmayi "+Kayitlar.getModul()+"\n"+"Calisacak kisinin Ucret Beklentisi"+Kayitlar.getMaas());
    	

    }
    ObservableList<finansClas> veriler;
    public void degerlerigetir(TableView tablo, String sql) {
    //	sql="select * from yonetici";
    	
    	
    	ObservableList<finansClas> kayitlarliste = FXCollections.observableArrayList();
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		 ResultSet getirilen=sorguifadesi.executeQuery();
    		 while (getirilen.next()) {
    		//	 sql="insert into  muhendislik(yadi,ysoyadi,ydogumtarihi,ykimlik,ytelefon,ymedenihal,ymaas,yadres,ygunler,ytecrube,yalan,mOrtalama,brans,msorgu)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
    			 
    		 kayitlarliste.add(new finansClas(getirilen.getInt("fid"),getirilen.getString("madi"),getirilen.getString("msoyadi"),getirilen.getString("ydogumtarihi"),
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
			 
        	 Table_View_finans.setItems(kayitlarliste);
    		 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		
		}
    }
    @FXML
    void initialize() {
    	 sql="select * from finans";
     	 	
     	
     	
     	degerlerigetir(Table_View_finans, sql);
     	

    }

}
