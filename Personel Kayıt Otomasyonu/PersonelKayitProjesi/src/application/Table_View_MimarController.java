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

public class Table_View_MimarController {
	  Connection baglanti=null;
	    PreparedStatement sorguifadesi=null;
	    ResultSet getirilen=null;
	    String sql,sql1,sql2;
	   
		public Table_View_MimarController() {
			
			baglanti=veritabani.baglan();
			
			
		}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Label tckimlik;
    @FXML
    private TableColumn<fMIMARCLASS, String> Adi;
    @FXML
    private TableColumn<fMIMARCLASS, String> fakulte;
    @FXML
    private TableColumn<fMIMARCLASS, String> Adres;

    @FXML
    private TableColumn<fMIMARCLASS, String> Alan;

    @FXML
    private TableColumn<fMIMARCLASS, String> Brans;

    @FXML
    private TableColumn<fMIMARCLASS, String> D_Tarihi;

    @FXML
    private TableColumn<fMIMARCLASS, String> Egitim;

    @FXML
    private TableColumn<fMIMARCLASS, Integer> ID;

    @FXML
    private TableColumn<fMIMARCLASS, Double> Maas;

    @FXML
    private TableColumn<fMIMARCLASS, String> Medeni_Hal;

    @FXML
    private TableColumn<fMIMARCLASS, Integer> Ortalama;

    @FXML
    private TableColumn<fMIMARCLASS, String> Sorgu;

    @FXML
    private TableColumn<fMIMARCLASS, String> Soyadi;

    @FXML
    private TableView<fMIMARCLASS> Table_View_Mim;

    @FXML
    private TableColumn<fMIMARCLASS, String> Tc_Kimlik;

    @FXML
    private TableColumn<fMIMARCLASS, String> Tecrube;

    @FXML
    private TableColumn<fMIMARCLASS, String> Telefon_No;
    @FXML
    private TableColumn<fMIMARCLASS, String> mail;


    @FXML
    private Button btnSil;

    @FXML
    private Button btn_arama;

    @FXML
    private DatePicker datepicker1;

  

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
    	FormGetir frm =new FormGetir();
	      frm.Gecis("Mimarlik.fxml");
	      ((Node)(event.getSource())).getScene().getWindow().hide();
    	
    }
    @FXML
    void kayitlar_table_Click(MouseEvent event) {
    	fMIMARCLASS Kayitlar=new fMIMARCLASS();
    	Kayitlar=(fMIMARCLASS) Table_View_Mim.getItems().get(Table_View_Mim.getSelectionModel().getSelectedIndex());
    	
    	
    	tckimlik.setText(Kayitlar.getTc_Kimlik());
    }
int durum=0;
    @FXML
    void btnSil_Click(ActionEvent event) {
    	fMIMARCLASS kayit=new fMIMARCLASS();
    	 
   	 if(Table_View_Mim.getSelectionModel().getSelectedIndex()!=-1) {
	kayit=(fMIMARCLASS) Table_View_Mim.getItems().get(Table_View_Mim.getSelectionModel().getSelectedIndex());
//	int a;
	// a=kayit.getID();    
	//System.out.println(a);
	sql="delete from mimarlik where mid=?";

	try {
		
   		sorguifadesi=baglanti.prepareStatement(sql);
   		sorguifadesi.setInt(1, kayit.getID());
		  
		
		ObservableList<fMIMARCLASS> secilenKayit, tumKayitlar;
   	tumKayitlar=Table_View_Mim.getItems();
   	secilenKayit=Table_View_Mim.getSelectionModel().getSelectedItems();
   	
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
		   Alert alert=new Alert(AlertType.ERROR);
	    	alert.setTitle("ÝSTE Otomasyon");
	    	alert.setHeaderText("Hata Mesajý");
	    	alert.setContentText("HERHANGI BIR DEGER GIRMEDINIZ");
	    	alert.showAndWait();
	}


	    }
   	
	
    @FXML
    void btn_arama_Click(ActionEvent event) {
   	 String sql0="select * from mimarlik where 	mOrtalama > {0} and 	mOrtalama < {1}";
     String sql1 = java.text.MessageFormat.format(sql0, txtdeger1.getText(), txtdeger2.getText());
     degerlerigetir(Table_View_Mim, sql1);

    }



    @FXML
    void txt_arama_keypressed(KeyEvent event) {
       if(txt_arama.getText().contains("")) {
    		
    		sql="select * from mimarlik where ykimlik like '%"+txt_arama.getText()+"%' or msoyadi like '%"+txt_arama.getText()+"%'" ; 
    		
    		
    		degerlerigetir(Table_View_Mim, sql);
    	}else {
 	
    		 
   		    }
    }
    ObservableList<fMIMARCLASS> veriler;
    public void degerlerigetir(TableView tablo, String sql) {
    //	sql="select * from yonetici";
    	
    	
    	ObservableList<fMIMARCLASS> kayitlarliste = FXCollections.observableArrayList();
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		 ResultSet getirilen=sorguifadesi.executeQuery();
    		 while (getirilen.next()) {
    		//	 sql="insert into  mimarlik(yadi,ysoyadi,ydogumtarihi,ykimlik,ytelefon,ymedenihal,ymaas,yadres,ygunler,ytecrube,yalan,mOrtalama,brans,msorgu,mail)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
    			 
    		 kayitlarliste.add(new fMIMARCLASS(getirilen.getInt("mid"),getirilen.getString("fakulte"),getirilen.getString("madi"),getirilen.getString("msoyadi"),getirilen.getString("ydogumtarihi"),
				getirilen.getString("ykimlik"),getirilen.getString("ytelefon"),getirilen.getString("ymedenihal"),getirilen.getDouble("ymaas"),getirilen.getString("yadres")
				,getirilen.getString("mLisans"),getirilen.getString("mtecrube"),getirilen.getString("yalan"),getirilen.getString("Brans"),getirilen.getDouble("mOrtalama"),getirilen.getString("msorgu"),getirilen.getString("email")));
				
			}
    		 
    		 ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    		 fakulte.setCellValueFactory(new PropertyValueFactory<>("fakulte"));
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
        	 Ortalama.setCellValueFactory(new PropertyValueFactory<>("ORTALAMA"));
        	 Brans.setCellValueFactory(new PropertyValueFactory<>("Brans"));
        	 Sorgu.setCellValueFactory(new PropertyValueFactory<>("sorgu"));
        	 mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
			 
        	 Table_View_Mim.setItems(kayitlarliste);
    		 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		
    	
    	
    	
    	
    	// veriler=FXCollections.observableArrayList();
    	// veriler.add(new Kayitlar_Constructor(1,"ismail","öz",2000,486,0537,"bekar",10000,"niðde","pazar","yok", "java"));
     	  	 
		}
    	 
       	
    	 
    	
    }
    @FXML
    void initialize() {
    	 sql="select * from mimarlik";
     	
     	degerlerigetir(Table_View_Mim, sql);

    }

}
