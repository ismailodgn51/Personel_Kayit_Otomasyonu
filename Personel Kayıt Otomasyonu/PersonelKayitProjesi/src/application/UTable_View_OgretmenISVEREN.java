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
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class UTable_View_OgretmenISVEREN {
	 Connection baglanti=null;
	    PreparedStatement sorguifadesi=null;
	    ResultSet getirilen=null;
	    String sql,sql1,sql2;
	   
		public UTable_View_OgretmenISVEREN() {
			
			baglanti=veritabani.baglan();
			
			
		}

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
    private TableColumn<OGRETMENCLASS, String> Tc_Kimlik;

  

    @FXML
    private TableColumn<OGRETMENCLASS, String> Telefon_No;


    @FXML
    private ToggleButton geridon;

    @FXML
    private Button iseal;

    @FXML
    private TableColumn<Kayitlar_Constructor, String> mail;

    @FXML
    private TextField maila;

    @FXML
    private TextField telefon;

    @FXML
    private TextField txtadi;

    @FXML
    private TextArea txtarea;
    @FXML
    private TextField Sirket;
    @FXML
    private TextField txtsoyadi;
   
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
    		sorguifadesi.setString(5, "OGRETMEN");
    		
    		Alert alert=new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("ÝSTE Otomasyon");
        	alert.setHeaderText("Kendi butonlarýmýz");
        	alert.setContentText("Silmek istediðinize emin misiniz");
        	
        	ButtonType btn1=new ButtonType("Evet");
        	
        	ButtonType btn3=new ButtonType("Ýptal", ButtonData.CANCEL_CLOSE); //Iptal
        	//ButtonType btn3=new ButtonType("Tamam", ButtonData.OK_DONE); //Tamam
        	//ButtonType btn3=new ButtonType("Evet", ButtonData.YES); //Evet
        	//ButtonType btn3=new ButtonType("Hayýr", ButtonData.NO); //Hayir
        	
        	alert.getButtonTypes().setAll(btn1, btn3);
        	
        	Optional<ButtonType> sonuc= alert.showAndWait();
        	
        	if(sonuc.get()==btn1) {
        		sorguifadesi.executeUpdate();
        		OGRETMENCLASS kayit=new OGRETMENCLASS();
	    	if(Table_View_ogr.getSelectionModel().getSelectedIndex()!=-1) {
    	    		kayit=(OGRETMENCLASS) Table_View_ogr.getItems().get(Table_View_ogr.getSelectionModel().getSelectedIndex());
    	    	
    	    		sql="delete from yonetici where mid=?";
 	        	try {
    	        		sorguifadesi=baglanti.prepareStatement(sql);
       	        		sorguifadesi.setInt(1, kayit.getID());
    	        		sorguifadesi.executeUpdate();
    	        		
    	        	ObservableList<OGRETMENCLASS> secilenKayit, tumKayitlar;
    	            	tumKayitlar=Table_View_ogr.getItems();
    	            	secilenKayit=Table_View_ogr.getSelectionModel().getSelectedItems();
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
    	OGRETMENCLASS Kayitlar=new OGRETMENCLASS();
    	Kayitlar=(OGRETMENCLASS) Table_View_ogr.getItems().get(Table_View_ogr.getSelectionModel().getSelectedIndex());
    	
    	
    	txtadi.setText(Kayitlar.getAdi());
    	txtsoyadi.setText(Kayitlar.getSoyadi());
    	telefon.setText(Kayitlar.getTelefon_No());
    	
       	txtarea.setText("bransi oldugu alanlar veya yapabileceði iþler;\n "+Kayitlar.getAlan()
    	+"\n"+"Calisacak kisinin Ucret Beklentisi;\n"+Kayitlar.getMaas());
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
