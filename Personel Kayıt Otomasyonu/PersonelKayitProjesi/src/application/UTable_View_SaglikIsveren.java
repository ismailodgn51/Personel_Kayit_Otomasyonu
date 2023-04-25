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

public class UTable_View_SaglikIsveren {
	Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null;
    String sql,sql1,sql2;
   
	public UTable_View_SaglikIsveren() {
		
		baglanti=veritabani.baglan();
		}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<fSAGLIKCICLASS, String> Adi;
    @FXML
    private TextField Sirket;
  
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
    private TextField maila;
    @FXML
    private ToggleButton geridon;

    @FXML
    private Button iseal;
  
    @FXML
    private TextField telefon;

    @FXML
    private TextField txtadi;

    @FXML
    private TextArea txtarea;

    @FXML
    private TextField txtsoyadi;

    @FXML
    private Button btn_arama;

    @FXML
    private DatePicker datepicker2;
    @FXML
    private DatePicker datepicker1;
    @FXML
    void btn_arama_Click(ActionEvent event) {

    }
    @FXML
    void kayitlar_table_Click(MouseEvent event) {
    	fSAGLIKCICLASS Kayitlar=new fSAGLIKCICLASS();
    	Kayitlar=(fSAGLIKCICLASS) Table_View_saglik.getItems().get(Table_View_saglik.getSelectionModel().getSelectedIndex());
    	
    	
    	txtadi.setText(Kayitlar.getAdi());
    	txtsoyadi.setText(Kayitlar.getSoyadi());
    	telefon.setText(Kayitlar.getTelefon_No());
    	
    	
    	txtarea.setText("Usta oldugu alanlar veya yapabileceði iþler;\n "+Kayitlar.getAlan()
    	+"\n"+"Calisacak kisinin Ucret Beklentisi;\n"+Kayitlar.getMaas());
    }
    
    @FXML
    void geridon_click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("ISVEREN_ANA.fxml");
	      ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    int durum=0;
    @FXML
    void iseal_Click(ActionEvent event) {
    	sql="insert into  isealinanlar(adi,soyadi,SirketAdi,meslek)values(?,?,?,?)";
    	try {
			
    		sorguifadesi=baglanti.prepareStatement(sql);
    		
    		sorguifadesi.setString(1, txtadi.getText().trim());
    		sorguifadesi.setString(2, txtsoyadi.getText().trim());	
    		
    		sorguifadesi.setString(3, Sirket.getText().trim());
    		sorguifadesi.setString(4, "OGRETMEN");
    		
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
        		sorguifadesi.executeUpdate();	fSAGLIKCICLASS kayit=new fSAGLIKCICLASS();
				
    	    	if(Table_View_saglik.getSelectionModel().getSelectedIndex()!=-1) {
    	    		kayit=(fSAGLIKCICLASS) Table_View_saglik.getItems().get(Table_View_saglik.getSelectionModel().getSelectedIndex());
    	    	
    	    		sql="delete from saglik where mid=?";
 	        	try {
    	        		sorguifadesi=baglanti.prepareStatement(sql);
       	        		sorguifadesi.setInt(1, kayit.getID());
    	        		sorguifadesi.executeUpdate();
    	        		
    	        	ObservableList<fSAGLIKCICLASS> secilenKayit, tumKayitlar;
    	            	tumKayitlar=Table_View_saglik.getItems();
    	            	secilenKayit=Table_View_saglik.getSelectionModel().getSelectedItems();
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
    		//	 sql="insert into  muhendislik(yadi,ysoyadi,ydogumtarihi,ykimlik,ytelefon,ymedenihal,ymaas,yadres,ygunler,ytecrube,yalan,mOrtalama,brans,msorgu)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
    			 
    		 kayitlarliste.add(new fSAGLIKCICLASS(getirilen.getInt("mid"),getirilen.getString("madi"),getirilen.getString("msoyadi"),getirilen.getString("ydogumtarihi"),
				getirilen.getString("ykimlik"),getirilen.getString("ytelefon"),getirilen.getString("ymedenihal"),getirilen.getDouble("ymaas"),getirilen.getString("yadres")
				,getirilen.getString("mLisans"),getirilen.getString("mtecrube"),getirilen.getString("Brans"),getirilen.getDouble("mOrtalama")));
				
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
    	
     	  	 
		}
    @FXML
    void initialize() {
        sql="select * from saglik";
     	degerlerigetir(Table_View_saglik, sql);
    	
    	

    }

}
