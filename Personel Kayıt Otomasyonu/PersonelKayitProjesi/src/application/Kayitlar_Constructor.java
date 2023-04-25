package application;

import java.sql.Date;

public class Kayitlar_Constructor {

	private Integer ID;
	private String adi;
	private String Soyadi;
    private String Telefon_No;  
    private String mail;
    private String fakulte;  
    private String Fikir;
    private String sirket;
     Kayitlar_Constructor() {
    	
    }
     //iþealýnanlar
     Kayitlar_Constructor(Integer ID, String adi, String Soyadi,String mail,String sirket, String fakulte) {
        this.ID = ID;
   		this.adi=adi;
   	   	this.Soyadi = Soyadi;
   	    this.mail=mail;
   	    this.fakulte=fakulte;
   	    this.sirket=sirket;
   	    
   	   
     }
     //giriþimciler
     Kayitlar_Constructor(Integer ID, String adi, String Soyadi,String Telefon_No,String Fikir) {
        this.ID = ID;
  		this.adi=adi;
  	   	this.Soyadi = Soyadi;
  	    this.Telefon_No = Telefon_No;  
  	    this.Fikir=Fikir;
     }



	public String getSirket() {
		return sirket;
	}
	public void setSirket(String sirket) {
		this.sirket = sirket;
	}


	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getFakulte() {
		return fakulte;
	}

	public void setFakulte(String fakulte) {
		this.fakulte = fakulte;
	}



	public Integer getID() {
		return ID;
	}


	public void setID(Integer iD) {
		ID = iD;
	}


	public String getAdi() {
		return adi;
	}


	public void setAdi(String adi) {
		this.adi = adi;
	}


	public String getSoyadi() {
		return Soyadi;
	}


	public void setSoyadi(String soyadi) {
		Soyadi = soyadi;
	}

	public String getTelefon_No() {
		return Telefon_No;
	}


	public void setTelefon_No(String telefon_No) {
		Telefon_No = telefon_No;
	}

	public String getFikir() {
		return Fikir;
	}
	public void setFikir(String fikir) {
		Fikir = fikir;
	}
	public void setEgitim(String Egitim) {
		Egitim = Egitim;
	}



	



    
    
    
    
}
