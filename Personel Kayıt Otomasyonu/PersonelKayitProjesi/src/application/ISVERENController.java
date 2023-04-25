package application;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class ISVERENController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button finans;

    @FXML
    private Button guvenlik;

    @FXML
    private Button isci;
    @FXML
    private AnchorPane Anchor_Sol;

    @FXML
    private Button Bilgilendirme;

    @FXML
    private Button Btn_Gizle;
    @FXML
    private Button Cikis;
    @FXML
    private Button GirisimFikirleri;
    @FXML
    private Button mimar;
    @FXML
    private AnchorPane anchorb;
    @FXML
    private Button muhendis;
    @FXML
    private ImageView f1;
    @FXML
    private ImageView f2;
    @FXML
    private Button ogretmen;
    @FXML
    private Button MUHENDIS;
    @FXML
    private Button Btn_Kayitlar;
    @FXML
    private Button saglik;
   
    @FXML
    private Slider slider;
    @FXML
    private Button btnmulakat;
    @FXML
    private Slider sliderh;

    @FXML
    void btnmulakat_C(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("isealinanlar.fxml");
	      ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    @FXML
    void Bilgilendirme_Click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("Otomasyon_Bilgilendirme.fxml");
    }
    int durum=0;
    public boolean a = true;
    @FXML
    void Btn_Gizle_Click(ActionEvent event) {
    	if(a) {
    	//	anchor_gizle.setVisible(false);
    		a=false;
    	} else {
    	//	anchor_gizle.setVisible(true);
    		a=true;
    		
    	}
    	
    	
    	if(durum==0) {
    		FadeTransition fd1= new FadeTransition(Duration.seconds(1), Anchor_Sol);
    		fd1.setFromValue(0);
    	fd1.setToValue(1);
    		fd1.play();
    		
    		TranslateTransition tt1 =new TranslateTransition(Duration.seconds(1.2),Anchor_Sol);
    		tt1.setByX(+115);
    		tt1.play();
    		durum=1;
    	}else {
    		FadeTransition fd1= new FadeTransition(Duration.seconds(0.4), Anchor_Sol);
    		fd1.setFromValue(0);
        	fd1.setToValue(1);
    		fd1.play();
    		
    		TranslateTransition tt1 =new TranslateTransition(Duration.seconds(0.3),Anchor_Sol);
    		tt1.setByX(-115);
    		tt1.play();
    		durum=0;}
    }

    @FXML
    void Btn_Kayitlar_Click(ActionEvent event) {

    }

    @FXML
    void Cikis_Click(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void GirisimFikirleri_Click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("Table_View_Girisimciler.fxml");
	      ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    void finans_click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("UTable_View_FinansIsveren.fxml");
	      ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    @FXML
    void MUHENDIS_click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("UTable_View_MUHIsveren.fxml");
	      ((Node)(event.getSource())).getScene().getWindow().hide();
    	
    }
    @FXML
    void geridon(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("Login.fxml");
	      ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void guvenlik_click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("UTable_View_GuvenlikIsveren.fxml");
	      ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void isci_cliclk(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("UTable_View_IsciIsveren.fxml");
	      ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void mimar_click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("UTable_View_MIM.fxml");
	      ((Node)(event.getSource())).getScene().getWindow().hide();
    }



    @FXML
    void ogretmen_cliclk(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("UTable_View_OgretmenISVEREN.fxml");
	      ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void saglik_click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("UTable_View_SaglikIsveren.fxml");
	      ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void initialize() {
    	int secilen1 =346;
    	int secilen2=240;
     	
	     slider.setMax(200);   	
	     slider.setMin(10d);   	
   	     slider.setShowTickMarks(true);
      	 slider.setShowTickLabels(true);
   	     slider.setMajorTickUnit(25d);
         slider.setBlockIncrement(10);
   	     slider.setValue(secilen1);
	
     	sliderh.setMax(200);   	
	    sliderh.setMin(10d);   	
   	    sliderh.setShowTickMarks(true);
     	sliderh.setShowTickLabels(true);
   	    sliderh.setMajorTickUnit(25d);
   	    sliderh.setBlockIncrement(10);
   	    sliderh.setValue(secilen2);
	
   
		
   		 slider.valueProperty().addListener(
 	        		//lambda methodu ile yaptým
 	        		(obs, oldValue, newValue)->{
 	        		//	System.out.println("Spinner eski deger="+oldValue);
 	        			if((f1.getLayoutX()+oldValue.intValue())<anchorb.getWidth()) {
 	        	 			f1.setFitWidth(oldValue.intValue());
 	        	 			}
 	        			if((f2.getLayoutX()+oldValue.intValue())<anchorb.getWidth()) {
 	        	 			f2.setFitWidth(oldValue.intValue());
 	        	 			}
 	        		}
   				);
   		 sliderh.valueProperty().addListener(
	        		//lambda methodu ile yaptým
	        		(obs, oldValue, newValue)->{
	        		//	System.out.println("Spinner eski deger="+oldValue);
	        			if((f1.getLayoutY()+oldValue.intValue())<anchorb.getWidth()) {
	        	 			f1.setFitWidth(oldValue.intValue());
	        	 			}
	        			if((f2.getLayoutY()+oldValue.intValue())<anchorb.getWidth()) {
	        	 			f2.setFitWidth(oldValue.intValue());
	        	 			}
	        		}
				);
    }

}
