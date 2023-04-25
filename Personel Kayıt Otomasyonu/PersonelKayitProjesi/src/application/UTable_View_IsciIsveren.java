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

public class UTable_View_IsciIsveren {
	
	  Connection baglanti=null;
	    PreparedStatement sorguifadesi=null;
	    ResultSet getirilen=null;
	    String sql,sql1,sql2;
	   
		public UTable_View_IsciIsveren() {
			
			baglanti=veritabani.baglan();
			
			
		}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public TableColumn<fISCICLASS, Integer> ID;
      
    @FXML
    public TableColumn<fISCICLASS, String> Adi;
    
    @FXML
    public TableColumn<fISCICLASS, String> Adres;

    @FXML
    public TableColumn<fISCICLASS, String> Alan;

    @FXML
    public TableColumn<fISCICLASS, String> D_Tarihi;

    @FXML
    public TableColumn<fISCICLASS, String> Egitim;

    @FXML
    public TableColumn<fISCICLASS, Double> Maas;

    @FXML
    public TableColumn<fISCICLASS, String> Medeni_Hal;

    @FXML
    public TableColumn<fISCICLASS, String> Soyadi;

    @FXML
    public TableView<fISCICLASS> Table_View_Yonetici;

    @FXML
    public TableColumn<fISCICLASS, String> Tc_Kimlik;

    @FXML
    public TableColumn<fISCICLASS, String> Tecrube;

    @FXML
    public TableColumn<fISCICLASS, String> Telefon_No;

    @FXML
    private Button iseal;
    @FXML
    private ToggleButton geridon;
    @FXML
    private TextField adi;

    @FXML
    private TextField soyadi;

    @FXML
    private TextField telono;
    
    @FXML
    private TextArea ustalik;
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
    		sorguifadesi.setString(2, soyadi.getText().trim());
    		sorguifadesi.setString(3, null);
    		sorguifadesi.setString(4, Tc_Kimlik.getText().trim());
    		sorguifadesi.setString(5, "ISCI");
    		
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
        		fISCICLASS kayit=new fISCICLASS();
				
    	    	if(Table_View_Yonetici.getSelectionModel().getSelectedIndex()!=-1) {
    	    		kayit=(fISCICLASS) Table_View_Yonetici.getItems().get(Table_View_Yonetici.getSelectionModel().getSelectedIndex());
    	    	//	int a;
    	    		// a=kayit.getID();    
    	    		//System.out.println(a);
    	    		sql="delete from yonetici where yid=?";
    	    	
    	        	try {
    	        		
       	        		sorguifadesi=baglanti.prepareStatement(sql);
       	        		sorguifadesi.setInt(1, kayit.getID());
    	        		sorguifadesi.executeUpdate();
    	        		
    	        		        	        		ObservableList<fISCICLASS> secilenKayit, tumKayitlar;
    	            	tumKayitlar=Table_View_Yonetici.getItems();
    	            	secilenKayit=Table_View_Yonetici.getSelectionModel().getSelectedItems();
    	            	
    	            	
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
    	fISCICLASS Kayitlar=new fISCICLASS();
    	Kayitlar=(fISCICLASS) Table_View_Yonetici.getItems().get(Table_View_Yonetici.getSelectionModel().getSelectedIndex());
    	
    	
    	adi.setText(Kayitlar.getAdi());
    	soyadi.setText(Kayitlar.getSoyadi());
    	telono.setText(Kayitlar.getTelefon_No());
    	
    	
    	ustalik.setText("Usta oldugu alanlar veya yapabileceði iþler;\n "+Kayitlar.getAlan()
    	+"\n"+"Calisacak kisinin Ucret Beklentisi;\n"+Kayitlar.getMaas());
    }

    ObservableList<fISCICLASS> veriler;
    public void degerlerigetir(TableView tablo, String sql) {
    //	sql="select * from yonetici";
    	
    	
    	ObservableList<fISCICLASS> kayitlarliste = FXCollections.observableArrayList();
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		 ResultSet getirilen=sorguifadesi.executeQuery();
    		 while (getirilen.next()) {
    		//	 sql="insert into  yonetici(yadi,ysoyadi,ydogumtarihi,ykimlik,ytelefon,ymedenihal,ymaas,yadres,ygunler,ytecrube,yalan)values(?,?,?,?,?,?,?,?,?,?,?)";
			
    			 
    		 kayitlarliste.add(new fISCICLASS(getirilen.getInt("yid"),getirilen.getString("yadi"),getirilen.getString("ysoyadi"),getirilen.getString("ydogumtarihi"),
				getirilen.getString("ykimlik"),getirilen.getString("ytelefon"),getirilen.getString("ymedenihal"),getirilen.getDouble("ymaas"),getirilen.getString("yadres")
				,getirilen.getString("Egitim"),getirilen.getString("ytecrube"),getirilen.getString("yalan")));
				
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
        	 Alan.setCellValueFactory(new PropertyValueFactory<>("Alan"));
			 
    		 Table_View_Yonetici.setItems(kayitlarliste);
    		 
    		 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		
		}
    	
		}
    	
    	// veriler=FXCollections.observableArrayList();
    	// veriler.add(new Kayitlar_Constructor(1,"ismail","öz",2000,486,0537,"bekar",10000,"niðde","pazar","yok", "java"));
     	  	 
		
    @FXML
    void initialize() {
        sql="select * from yonetici";
    	
        degerlerigetir(Table_View_Yonetici, sql);
    	
    	

    }

}
