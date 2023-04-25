package application;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import database.veritabani;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ÝSEALINANLAR {
	 Connection baglanti=null;
	    PreparedStatement sorguifadesi=null;
	    ResultSet getirilen=null;
	    String sql,sql1,sql2;
	   
		public ÝSEALINANLAR() {
			
			baglanti=veritabani.baglan();
			}
		  @FXML
		    private TableColumn<Kayitlar_Constructor, String> adi;

		    @FXML
		    private TableColumn<Kayitlar_Constructor, Integer> id;

		    @FXML
		    private TableColumn<Kayitlar_Constructor, String> mail;

		    @FXML
		    private TableColumn<Kayitlar_Constructor, String> meslke;

		    @FXML
		    private TableColumn<Kayitlar_Constructor, String> sirket;

		    @FXML
		    private TableColumn<Kayitlar_Constructor, String> soyadi;

		    @FXML
		    private TableView<Kayitlar_Constructor> tabloview;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Btn_Geri;

    @FXML
    void Btn_Geri_Click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("ISVEREN_ANA.fxml");
	      ((Node)(event.getSource())).getScene().getWindow().hide();
    }
     
    
   public void degerlerigetir() {
	   ObservableList<Kayitlar_Constructor> veriler;
   	ObservableList<Kayitlar_Constructor> kayitlarliste = FXCollections.observableArrayList();
   	try {
   		sorguifadesi=baglanti.prepareStatement(sql);
   		 ResultSet getirilen=sorguifadesi.executeQuery();
   		 while (getirilen.next()) {	
   			
   			 kayitlarliste.add(new Kayitlar_Constructor(getirilen.getInt("id"),getirilen.getString("adi"),getirilen.getString("soyadi"),getirilen.getString("mail")
				,getirilen.getString("SirketAdi"),getirilen.getString("meslek")));
				
			}
   		
   		 id.setCellValueFactory(new PropertyValueFactory<>("ID"));
       	 adi.setCellValueFactory(new PropertyValueFactory<>("adi"));
       	 soyadi.setCellValueFactory(new PropertyValueFactory<>("Soyadi"));
    	 mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
    	 sirket.setCellValueFactory(new PropertyValueFactory<>("sirket"));
    	 meslke.setCellValueFactory(new PropertyValueFactory<>("fakulte"));
			 
       	 tabloview.setItems(kayitlarliste);
   		 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		
		}
   	
		}
        
    @FXML
    void initialize() {
     sql="select * from isealinanlar";
     degerlerigetir();

    }

}
