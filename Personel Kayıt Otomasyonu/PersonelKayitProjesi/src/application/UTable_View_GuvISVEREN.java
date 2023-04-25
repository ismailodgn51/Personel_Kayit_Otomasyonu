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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class UTable_View_GuvISVEREN {
	Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null;
    String sql,sql1,sql2;
   
	public UTable_View_GuvISVEREN() {
		
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
    private TableColumn<fGuvenlikCLASS, String> cinsiyet;

    @FXML
    private TextField adi;
   

    @FXML
    private ToggleButton geridon;

    @FXML
    private Button iseal;

    @FXML
    private TableColumn<fGuvenlikCLASS, String> ehliyet;

    @FXML
    private TableColumn<fGuvenlikCLASS, String> mail;

    @FXML
    private TableColumn<fGuvenlikCLASS, String> soru1;

    @FXML
    private TableColumn<fGuvenlikCLASS, String> soru2;

    @FXML
    private TableColumn<fGuvenlikCLASS, String> soru3;
    @FXML
    private TextField soyadi;

    @FXML
    private TextField telono;
    @FXML
    private TextField tmail;
    @FXML
    private TextArea txtarea;

    @FXML
    void geridon_click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("ISVEREN_ANA.fxml");
	      ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    int durum=0;
    @FXML
    void iseal_Click(ActionEvent event) {
    	
    	sql="insert into  isealinanlar(adi,soyadi,mail,SirketAdi,meslek)values(?,?,?,?,?)";
    	try {
			
    		sorguifadesi=baglanti.prepareStatement(sql);
    		
    		sorguifadesi.setString(1, adi.getText().trim());
    		sorguifadesi.setString(2, Soyadi.getText().trim());
    		sorguifadesi.setString(3, mail.getText().trim());
    		sorguifadesi.setString(4, Tc_Kimlik.getText().trim());
    		sorguifadesi.setString(5, "GUVENLIK");
    		
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
    	        		sorguifadesi.executeUpdate();
    	        		
    	        	ObservableList<fGuvenlikCLASS> secilenKayit, tumKayitlar;
    	            	tumKayitlar=Table_View_guv.getItems();
    	            	secilenKayit=Table_View_guv.getSelectionModel().getSelectedItems();
    	            	
    	            	
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
    	fGuvenlikCLASS Kayitlar=new fGuvenlikCLASS();
    	Kayitlar=(fGuvenlikCLASS) Table_View_guv.getItems().get(Table_View_guv.getSelectionModel().getSelectedIndex());
    	
    	
    	adi.setText(Kayitlar.getAdi());
    	soyadi.setText(Kayitlar.getSoyadi());
    	tmail.setText(Kayitlar.getMail());
    	telono.setText(Kayitlar.getTelefon_No());
    	
       	txtarea.setText("bransi oldugu alanlar veya yapabileceði iþler;\n "+Kayitlar.getAlan()
    	+"\n"+"Calisacak kisinin Ucret Beklentisi;\n"+Kayitlar.getMaas());
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
    @FXML
    void initialize() {
        sql="select * from guvenlik";
       	
       	degerlerigetir(Table_View_guv, sql);

    }

}
