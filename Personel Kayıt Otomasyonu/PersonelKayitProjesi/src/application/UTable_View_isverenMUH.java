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

public class UTable_View_isverenMUH {
	  Connection baglanti=null;
	    PreparedStatement sorguifadesi=null;
	    ResultSet getirilen=null;
	    String sql,sql1,sql2;
	   
		public UTable_View_isverenMUH() {
			
			baglanti=veritabani.baglan();
		}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<fMUHENDISCLASS, String> Adi;
    @FXML
    private TableColumn<fMUHENDISCLASS, String> fakulte;
    @FXML
    private TableColumn<fMUHENDISCLASS, String> Adres;

    @FXML
    private TableColumn<fMUHENDISCLASS, String> Alan;

    @FXML
    private TableColumn<fMUHENDISCLASS, String> Brans;

    @FXML
    private TableColumn<fMUHENDISCLASS, String> D_Tarihi;

    @FXML
    private TableColumn<fMUHENDISCLASS, String> Egitim;

    @FXML
    private TableColumn<fMUHENDISCLASS, Integer> ID1;

    @FXML
    private TableColumn<fMUHENDISCLASS, String> Staj;

    @FXML
    private TableColumn<fMUHENDISCLASS, String> Medeni_Hal;

    @FXML
    private TableColumn<fMUHENDISCLASS, Integer> Ortalama;

    @FXML
    private TableColumn<fMUHENDISCLASS, String> Sorgu;

    @FXML
    private TableColumn<fMUHENDISCLASS, String> Soyadi;

    @FXML
    private TableView<fMUHENDISCLASS> Table_View_Muh;

    @FXML
    private TableColumn<fMUHENDISCLASS, String> Tc_Kimlik;

    @FXML
    private TableColumn<fMUHENDISCLASS, String> Tecrube;

    @FXML
    private TableColumn<fMUHENDISCLASS, String> Telefon_No;
    @FXML
    private TableColumn<fMUHENDISCLASS, String> mail;
    

    @FXML
    private ToggleButton geridon;

    @FXML
    private Button iseal;

    

    @FXML
    private TextField maila;

    @FXML
    private TextField telefon;

    @FXML
    private TextField txtadi;

    @FXML
    private TextArea txtarea;

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
    		sorguifadesi.setString(4, Tc_Kimlik.getText().trim());
    		sorguifadesi.setString(5, "MIMARLIK");
    		
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
        		fMUHENDISCLASS kayit=new fMUHENDISCLASS();
				
    	    	if(Table_View_Muh.getSelectionModel().getSelectedIndex()!=-1) {
    	    		kayit=(fMUHENDISCLASS) Table_View_Muh.getItems().get(Table_View_Muh.getSelectionModel().getSelectedIndex());
    	    	//	int a;
    	    		// a=kayit.getID();    
    	    		//System.out.println(a);
    	    		sql="delete from muhendislik where mid=?";
    	    	
    	        	try {
    	        		
       	        		sorguifadesi=baglanti.prepareStatement(sql);
       	        		sorguifadesi.setInt(1, kayit.getID());
    	        		sorguifadesi.executeUpdate();
    	        		
    	        		ObservableList<fMUHENDISCLASS> secilenKayit, tumKayitlar;
    	            	tumKayitlar=Table_View_Muh.getItems();
    	            	secilenKayit=Table_View_Muh.getSelectionModel().getSelectedItems();
    	            	
    	            	
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
			// TODO: handle exception
		}
    	
    }

    @FXML
    void kayitlar_table_Click(MouseEvent event) {
    	
    	fMUHENDISCLASS Kayitlar=new fMUHENDISCLASS();
    	Kayitlar=(fMUHENDISCLASS) Table_View_Muh.getItems().get(Table_View_Muh.getSelectionModel().getSelectedIndex());
    	
    	
    	txtadi.setText(Kayitlar.getAdi());
    	txtsoyadi.setText(Kayitlar.getSoyadi());
    	telefon.setText(Kayitlar.getTelefon_No());
    	maila.setText(Kayitlar.getMail());

    	txtarea.setText("bransi oldugu alanlar veya yapabileceði iþler;\n "+Kayitlar.getAlan()
    	+"\n"+"Calisacak kisinin Ucret Beklentisi;\n"+Kayitlar.getMaas());

    }
    ObservableList<fMUHENDISCLASS> veriler;
    public void degerlerigetir(TableView tablo, String sql) {
    //	sql="select * from yonetici";
    	
    	
    	ObservableList<fMUHENDISCLASS> kayitlarliste = FXCollections.observableArrayList();
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		 ResultSet getirilen=sorguifadesi.executeQuery();
    		 while (getirilen.next()) {
    		//	 sql="insert into  muhendislik(yadi,ysoyadi,ydogumtarihi,ykimlik,ytelefon,ymedenihal,ymaas,yadres,ygunler,ytecrube,yalan,mOrtalama,brans,msorgu)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
    			 
    			 kayitlarliste.add(new fMUHENDISCLASS(getirilen.getInt("mid"),getirilen.getString("fakulte"),getirilen.getString("madi"),getirilen.getString("msoyadi"),getirilen.getString("ydogumtarihi"),
    						getirilen.getString("ykimlik"),getirilen.getString("ytelefon"),getirilen.getString("ymedenihal"),getirilen.getString("yadres")
    						,getirilen.getString("mLisans"),getirilen.getString("Stajyeri"),getirilen.getString("mtecrube"),getirilen.getString("yalan"),getirilen.getString("Brans"),getirilen.getDouble("mOrtalama"),getirilen.getString("msorgu"),getirilen.getString("email")));
				
			}
    		 
    		 ID1.setCellValueFactory(new PropertyValueFactory<>("ID"));
    		 fakulte.setCellValueFactory(new PropertyValueFactory<>("fakulte"));
        	 Adi.setCellValueFactory(new PropertyValueFactory<>("Adi"));
        	 Soyadi.setCellValueFactory(new PropertyValueFactory<>("Soyadi"));
        	 D_Tarihi.setCellValueFactory(new PropertyValueFactory<>("D_Tarihi"));
        	 Tc_Kimlik.setCellValueFactory(new PropertyValueFactory<>("Tc_Kimlik"));
         	 Telefon_No.setCellValueFactory(new PropertyValueFactory<>("Telefon_No"));
         	 Medeni_Hal.setCellValueFactory(new PropertyValueFactory<>("Medeni_Hal"));
        	 Staj.setCellValueFactory(new PropertyValueFactory<>("Staj"));
        	 Adres.setCellValueFactory(new PropertyValueFactory<>("Adres"));
        	 Egitim.setCellValueFactory(new PropertyValueFactory<>("Egitim"));
        	 Tecrube.setCellValueFactory(new PropertyValueFactory<>("Tecrube"));
        	 Alan.setCellValueFactory(new PropertyValueFactory<>("Alan"));
        	 Ortalama.setCellValueFactory(new PropertyValueFactory<>("ORTALAMA"));
        	 Brans.setCellValueFactory(new PropertyValueFactory<>("Brans"));
        	 Sorgu.setCellValueFactory(new PropertyValueFactory<>("sorgu"));
			 mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
    		Table_View_Muh.setItems(kayitlarliste);
    		 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		
    	
    	
    	
    	
    	// veriler=FXCollections.observableArrayList();
    	// veriler.add(new Kayitlar_Constructor(1,"ismail","öz",2000,486,0537,"bekar",10000,"niðde","pazar","yok", "java"));
     	  	 
		}
    	 
       	
    	 
    	
    }
    @FXML
    void initialize() {
    	 sql="select * from muhendislik";
     	
     	degerlerigetir(Table_View_Muh, sql);
    }

}
