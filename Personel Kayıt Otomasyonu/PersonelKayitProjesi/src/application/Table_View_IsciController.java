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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Table_View_IsciController {
	
	  Connection baglanti=null;
	    PreparedStatement sorguifadesi=null;
	    ResultSet getirilen=null;
	    String sql,sql1,sql2;
	   
		public Table_View_IsciController() {
			
			baglanti=veritabani.baglan();
			
			
		}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Label tckimlik;
    @FXML
    private TextField txt_arama;
    @FXML
    private TextField txtdeger1;
    @FXML
    private TextField txtdeger2;

    
    @FXML
    private Button btn_arama;
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
    private DatePicker datepicker1;
    @FXML
    private DatePicker datepicker2;
    @FXML
    private Button btnSil;
    @FXML
    private Button Btn_Geri;
    @FXML
    void Btn_Geri_Click(ActionEvent event) {
    	
    	
    }
    @FXML
    void fISCICLASS(MouseEvent event) {
    	fISCICLASS Kayitlar=new fISCICLASS();
    	Kayitlar=(fISCICLASS) Table_View_Yonetici.getItems().get(Table_View_Yonetici.getSelectionModel().getSelectedIndex());
    	
    	
    	tckimlik.setText(Kayitlar.getTc_Kimlik());
    }
int durum=0;
    @FXML
    void btnSil_Click(ActionEvent event) {
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
		  
		
		ObservableList<fISCICLASS> secilenKayit, tumKayitlar;
   	tumKayitlar=Table_View_Yonetici.getItems();
   	secilenKayit=Table_View_Yonetici.getSelectionModel().getSelectedItems();
   	
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
    void kayitlar_table_Click(MouseEvent event) {

    }
    @FXML
    void btn_arama_Click(ActionEvent event) {
   	 String sql0="select * from mimarlik where ykimlik > {0} and ykimlik < {1}";
     String sql1 = java.text.MessageFormat.format(sql0, txtdeger1.getText(), txtdeger2.getText());
     degerlerigetir(Table_View_Yonetici, sql1);

    }
    @FXML
    void txt_arama_keypressed(KeyEvent event) {
   
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
		   	
    	
      	// veriler=FXCollections.observableArrayList();
    	// veriler.add(new Kayitlar_Constructor(1,"ismail","öz",2000,486,0537,"bekar",10000,"niðde","pazar","yok", "java"));
     	  	 
		}
    	 
         	 
    	
    }
   
    
    @FXML
    void initialize() {
    	sql="select * from yonetici";
    	
    	degerlerigetir(Table_View_Yonetici, sql);
    	
      
          
    	
   

    }

}
