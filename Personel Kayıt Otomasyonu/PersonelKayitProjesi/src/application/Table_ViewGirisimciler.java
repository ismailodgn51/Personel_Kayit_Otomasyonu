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
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Table_ViewGirisimciler {
	Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null;
    String sql,sql1,sql2;
   
	public Table_ViewGirisimciler() {
		
		baglanti=veritabani.baglan();
	}
    @FXML
    private ResourceBundle resources;
    @FXML
    private Button Btn_Geri;
    @FXML
    private URL location;
    @FXML
    private TableColumn<Kayitlar_Constructor, String> Adi;

    @FXML
    private TableColumn<Kayitlar_Constructor, String> Fikir;

    @FXML
    private TableColumn<Kayitlar_Constructor, Integer> ID;

    @FXML
    private TableColumn<Kayitlar_Constructor, String> Soyadi;
    @FXML
    private TableColumn<Kayitlar_Constructor, String> iletisim;
    @FXML
    private TableView<Kayitlar_Constructor> table_View;
    @FXML
    private TextArea area;
    @FXML
    void geridon_click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("ISVEREN_ANA.fxml");
	      ((Node)(event.getSource())).getScene().getWindow().hide();
    	}
    @FXML
    void table_click(MouseEvent event) {
    	Kayitlar_Constructor Kayitlar=new Kayitlar_Constructor();
    	Kayitlar=(Kayitlar_Constructor) table_View.getItems().get(table_View.getSelectionModel().getSelectedIndex());


    	area.setText(Kayitlar.getFikir());
    }
    ObservableList<Kayitlar_Constructor> veriler;
    public void degerlerigetir(TableView tablo, String sql) {
    //	sql="select * from yonetici";
    	
    	
    	ObservableList<Kayitlar_Constructor> kayitlarliste = FXCollections.observableArrayList();
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		 ResultSet getirilen=sorguifadesi.executeQuery();
    		 while (getirilen.next()) {
    		//	 sql="insert into  muhendislik(yadi,ysoyadi,ydogumtarihi,ykimlik,ytelefon,ymedenihal,ymaas,yadres,ygunler,ytecrube,yalan,mOrtalama,brans,msorgu)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
    			 
    		 kayitlarliste.add(new Kayitlar_Constructor(getirilen.getInt("id"),getirilen.getString("adi"),getirilen.getString("soyadi"),getirilen.getString("iletisim"),getirilen.getString("Fikri")));
    		 
				
    		 }
    		
    		 ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        	 Adi.setCellValueFactory(new PropertyValueFactory<>("Adi"));
        	 Soyadi.setCellValueFactory(new PropertyValueFactory<>("Soyadi"));
        	 iletisim.setCellValueFactory(new PropertyValueFactory<>("Telefon_No"));
        	 Fikir.setCellValueFactory(new PropertyValueFactory<>("fikir"));
         	 table_View.setItems(kayitlarliste);
    		 
        		} catch (Exception e) {
        			// TODO: handle exception
        			System.out.println(e);
        		}
    	}
    @FXML
    void initialize() {
    	 sql="select * from girisimfikirleri";
       	
       	degerlerigetir(table_View, sql);

    }

}
