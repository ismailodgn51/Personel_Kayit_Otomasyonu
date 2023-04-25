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

public class Table_View_MuhController {
	
	  Connection baglanti=null;
	    PreparedStatement sorguifadesi=null;
	    ResultSet getirilen=null;
	    String sql,sql1,sql2;
	   
		public Table_View_MuhController() {
			
			baglanti=veritabani.baglan();
			
			
		}

    @FXML
    private ResourceBundle resources;
    @FXML
    private Label tckimlik;
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
    private Button btnSil;

    @FXML
    private Button btn_arama;
    @FXML
    private Button Btn_Geri;
    @FXML
    private DatePicker datepicker1;

    @FXML
    private TextField txt_arama;

    @FXML
    private TextField txtdeger1;
   
    @FXML
    private TextField txtdeger2;
    @FXML
    void Btn_Geri_Click(ActionEvent event) {
    	
    }
    
    @FXML
    void kayitlar_table_Click(MouseEvent event) {
    	fMUHENDISCLASS Kayitlar=new fMUHENDISCLASS();
    	Kayitlar=(fMUHENDISCLASS) Table_View_Muh.getItems().get(Table_View_Muh.getSelectionModel().getSelectedIndex());
    	
    	
    	tckimlik.setText(Kayitlar.getTc_Kimlik());
    }
int durum=0;
    @FXML
    void btnSil_Click(ActionEvent event) {
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
		  
		
		ObservableList<fMUHENDISCLASS> secilenKayit, tumKayitlar;
   	tumKayitlar=Table_View_Muh.getItems();
   	secilenKayit=Table_View_Muh.getSelectionModel().getSelectedItems();
   	
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
    	
    	 String sql0="select * from muhendislik where 	mOrtalama > {0} and 	mOrtalama < {1}";
         String sql1 = java.text.MessageFormat.format(sql0, txtdeger1.getText(), txtdeger2.getText());
         degerlerigetir(Table_View_Muh, sql1);

    }

 

    @FXML
    void txt_arama_keypressed(KeyEvent event) {

        if(txt_arama.getText().contains("")) {
    		
    		sql="select * from muhendislik where ykimlik like '%"+txt_arama.getText()+"%' or msoyadi like '%"+txt_arama.getText()+"%'" ; 
    		
    		
    		degerlerigetir(Table_View_Muh, sql);
    	}else {
 	
    		 
   		    }}
    	
    

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
