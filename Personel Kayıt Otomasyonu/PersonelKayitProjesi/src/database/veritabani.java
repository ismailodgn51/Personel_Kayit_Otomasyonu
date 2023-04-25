package database;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;



import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class veritabani {
	static Connection conn=null;
	public static  Connection baglan() {
	try {
	//"jdbc:mysql://serveripadress/db_ismi","kuulaniciadi","sifre"
		conn=DriverManager.getConnection("jdbc:mysql://localhost/personel_kayit_otomasyonu", "root" ,"mysql");
		return conn;		
		
	} catch(Exception e) {
		System.out.println(e.getMessage().toString());
		return null;
		
	}

}
	
}