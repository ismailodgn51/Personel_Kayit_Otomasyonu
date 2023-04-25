
package application;

public class fMUHENDISCLASS {

	private Integer ID;
	private String adi;
	private String Soyadi;
    private String D_Tarihi;
    private String Tc_Kimlik; 
    private String Telefon_No;  
    private String Medeni_Hal;  
    private Double Maas;
    private String Adres;
    private String Egitim;
    private String Tecrube;
    private String Alan;
    private String Brans;
    private Double ORTALAMA;
    private String sorgu;
    private String mail;
    private String fakulte;
    private String Staj;

	   
	    fMUHENDISCLASS() {
	    	
	    }
	    
	    //Muhendis için
	    fMUHENDISCLASS(Integer ID, String fakulte,String adi, String Soyadi,String D_Tarihi,String Tc_Kimlik,String Telefon_No,
	  			String Medeni_Hal,String Adres, String Egitim,String Staj,String Tecrube,  String Alan ,String Brans,Double ORTALAMA, String sorgu,String mail){
	    	  super(); 

	  		this.ID = ID;
	  		this.adi=adi;
	  	   	this.Soyadi = Soyadi;
	  	   	this.D_Tarihi = D_Tarihi;
	  	   	this.Tc_Kimlik = Tc_Kimlik;
	  	   	this.Telefon_No = Telefon_No;
	  	   	this.Medeni_Hal = Medeni_Hal;
	 		this.Adres = Adres;
	  		this.Egitim = Egitim;
	  		this.Staj=Staj;
	  		this.Tecrube = Tecrube;
	  		this.Alan = Alan;
	  		this.Brans=Brans;
	  		this.ORTALAMA=ORTALAMA;
	  		this.sorgu=sorgu;
	  		this.mail=mail;
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

		public String getD_Tarihi() {
			return D_Tarihi;
		}

		public void setD_Tarihi(String d_Tarihi) {
			D_Tarihi = d_Tarihi;
		}

		public String getTc_Kimlik() {
			return Tc_Kimlik;
		}

		public void setTc_Kimlik(String tc_Kimlik) {
			Tc_Kimlik = tc_Kimlik;
		}

		public String getTelefon_No() {
			return Telefon_No;
		}

		public void setTelefon_No(String telefon_No) {
			Telefon_No = telefon_No;
		}

		public String getMedeni_Hal() {
			return Medeni_Hal;
		}

		public String getStaj() {
			return Staj;
		}

		public void setStaj(String staj) {
			Staj = staj;
		}

		public void setMedeni_Hal(String medeni_Hal) {
			Medeni_Hal = medeni_Hal;
		}

		public Double getMaas() {
			return Maas;
		}

		public void setMaas(Double maas) {
			Maas = maas;
		}

		public String getAdres() {
			return Adres;
		}

		public void setAdres(String adres) {
			Adres = adres;
		}

		public String getEgitim() {
			return Egitim;
		}

		public void setEgitim(String egitim) {
			Egitim = egitim;
		}

		public String getTecrube() {
			return Tecrube;
		}

		public void setTecrube(String tecrube) {
			Tecrube = tecrube;
		}

		public String getAlan() {
			return Alan;
		}

		public void setAlan(String alan) {
			Alan = alan;
		}

		public String getBrans() {
			return Brans;
		}

		public void setBrans(String brans) {
			Brans = brans;
		}

		public Double getORTALAMA() {
			return ORTALAMA;
		}

		public void setORTALAMA(Double oRTALAMA) {
			ORTALAMA = oRTALAMA;
		}

		public String getSorgu() {
			return sorgu;
		}

		public void setSorgu(String sorgu) {
			this.sorgu = sorgu;
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
	    
	}
