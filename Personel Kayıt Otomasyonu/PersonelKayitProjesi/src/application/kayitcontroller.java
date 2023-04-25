package application;

import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import database.veritabani;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;

public class kayitcontroller {

	   Connection baglanti=null;
	    PreparedStatement sorguifadesi=null;
	    ResultSet getirilen=null;
	    String sql,sql1,sql2;
	   
		public kayitcontroller() {
			
			baglanti=veritabani.baglan();
			
			
		}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btngir;

    @FXML
    private TextField kuladi;

    @FXML
    private TextField kulsoyadi;
    @FXML
    private TextField tc;

    @FXML
    private TextField sifre;

    public static String MDSSifreleme(String icerik) {
		try {
			MessageDigest md=MessageDigest.getInstance("SHA");
			byte[] sifrelenmis=md.digest(icerik.getBytes());
			
			
			BigInteger no= new BigInteger(1,sifrelenmis);
			
			String hshIcerik=no.toString(16);
			while (hshIcerik.length()<32) {
				hshIcerik="0"+hshIcerik;
				
			}
			return hshIcerik;
			
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		
		

	}
    @FXML
    void btngir_Click(ActionEvent event) {
    	
    	sql="insert into  kayit(kuladi,sifre,tc)values(?,?,?)";
    	try {
    		
		
			
    		sorguifadesi=baglanti.prepareStatement(sql);
    		
    		sorguifadesi.setString(1, kuladi.getText().trim());
    	    sorguifadesi.setString(2, MDSSifreleme(sifre.getText().trim()));
    		sorguifadesi.setString(3, tc.getText().trim());
    		
    		
  		
		
    	if(kuladi.getText().contains("iste.com") )
        		
        	{
    			
  
        			TextInputDialog dialog=new TextInputDialog("");
                	dialog.setTitle("iste otomasyon");
                	dialog.setHeaderText("Textfield ile deðer yollama");
                	dialog.setContentText("telefonunuza gelen onay kodunu giriniz..");
                    
                	Optional<String> sonuc = dialog.showAndWait();
                	String a="5151";
                		if(sonuc.get().equals(a)) {
                			//txtarea.appendText("HOSGELDÝNÝZ " + "ismail" + " " + "özdogan"+sonuc.get()+"\n");
                		
                 			sorguifadesi.executeUpdate();
                		}
                		else {
                		//	txtarea.appendText("hatali giris ");
                			System.out.println("hatali giris");
                		}
                		
                	//txtarea.appendText("HOSGELDÝNÝZ " + txt1.getText() + " " + txt2.getText()+"\n");
                	//txtarea.setText("\n");
                //	txtarea.appendText("HOSGELDÝNÝZ " + "ismail" + " " + "özdogan"+sonuc.get()+"\n");
        		}
       

    		
    	 	else {
    		Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("iste otomasyon");
        	alert.setHeaderText("Hata Mesajý");
        	alert.setContentText("TC VEYA TELEFON NUMARANÝZÝ DUZGUN GÝRÝNÝZ ozel karakter icermemeli ve hiçbir deðeri boþ geçmeyiniz");
        	alert.showAndWait();
    	}   	}
	
	
catch (Exception e) {
	// TODO: handle exception
	System.out.println(e);
}

    }

    @FXML
    void initialize() {
     
    	
    }

}
