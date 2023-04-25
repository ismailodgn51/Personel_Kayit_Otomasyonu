package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Ana_Sayfa_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane Anaform_Anchor;

    @FXML
    private Button Btn_Finans1;

    @FXML
    private Button Btn_Guvenlik;

    @FXML
    private Button Btn_Hukuk;

    @FXML
    private Button Btn_Isci;
    @FXML
    private AnchorPane Anaform_Anchor1;

    @FXML
    private ImageView f1;

    @FXML
    private ImageView f2;

    @FXML
    private ImageView f3;

    @FXML
    private ImageView f4;

    @FXML
    private ImageView f5;

    @FXML
    private ImageView f6;

    @FXML
    private ImageView f7;
    @FXML
    private AnchorPane Anchor_Sol;
    @FXML
    private Button Btn_Mimar;
    @FXML
    private Button Cikis;


    @FXML
    private AnchorPane anchorb;
    @FXML
    private Button GirisimFikirleri;
    @FXML
    private Button Btn_Muhendislik;
    @FXML
    private Button Btn_Geri;
    @FXML
    private Button Btn_Ogretmen;
    @FXML
    private Button Btn_Gizle;
    @FXML
    private Button Saglik;
    @FXML
    private Slider slider;

    @FXML
    private Slider sliderh;
    @FXML
    void Cikis_Click(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void GirisimFikirleri_Click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("GirisimFikri.fxml");
    }
    int durum=0;
    @FXML
    void Btn_Gizle_Click(ActionEvent event) {
    	if(durum==0) {
    		FadeTransition fd1= new FadeTransition(Duration.seconds(1), Anchor_Sol);
    		fd1.setFromValue(0);
    	fd1.setToValue(1);
    		fd1.play();
    		
    		TranslateTransition tt1 =new TranslateTransition(Duration.seconds(1.2),Anchor_Sol);
    		tt1.setByX(+147);
    		tt1.play();
    		durum=1;
    	}else {
    		FadeTransition fd1= new FadeTransition(Duration.seconds(0.4), Anchor_Sol);
    		fd1.setFromValue(0);
        	fd1.setToValue(1);
    		fd1.play();
    		
    		TranslateTransition tt1 =new TranslateTransition(Duration.seconds(0.3),Anchor_Sol);
    		tt1.setByX(-147);
    		tt1.play();
    		durum=0;}
    }
    @FXML
    void Bilgilendirme_Click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("Otomasyon_Bilgilendirme.fxml");
    }
    @FXML
    void Btn_Geri_Click(ActionEvent event) {
    	FormGetir frm =new FormGetir();
	      frm.Gecis("Login.fxml");
	      ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    @FXML
    void Btn_Finans_Click(ActionEvent event) {
    	FormGetir frm = new FormGetir();
    	frm.Gecis("Finans.fxml");
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void Btn_Guvenlik_Click(ActionEvent event) {
    	FormGetir frm = new FormGetir();
    	frm.Gecis("Guvenlik.fxml");
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }



    @FXML
    void Btn_Isci_Click(ActionEvent event) {
    	
    	FormGetir frm = new FormGetir();
    	frm.Gecis("Isci.fxml");
    	((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void Btn_Mimar_Click(ActionEvent event) {
    	FormGetir frm = new FormGetir();
    	frm.Gecis("Mimarlik.fxml");
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void Btn_Muhendislik_Click(ActionEvent event) {
    	FormGetir frm = new FormGetir();
    	frm.Gecis("Muhendislik.fxml");
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void Btn_Ogretmen_Click(ActionEvent event) {
    	FormGetir frm = new FormGetir();
    	frm.Gecis("Ogretmenlik.fxml");
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void Saglik_Cliclk(ActionEvent event) {
    	FormGetir frm = new FormGetir();
    	frm.Gecis("Saglikci.fxml");
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void initialize() {
      
    	int secilen1 =346;
    
 	
 	     slider.setMax(200);   	
 	     slider.setMin(10d);   	
    	 slider.setShowTickMarks(true);
       	slider.setShowTickLabels(true);
    	slider.setMajorTickUnit(25d);
    	slider.setBlockIncrement(10);
    	slider.setValue(secilen1);
 	
    
 		
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
  	        			if((f3.getLayoutX()+oldValue.intValue())<anchorb.getWidth()) {
  	        	 			f3.setFitWidth(oldValue.intValue());
  	        	 			}
  	        			if((f4.getLayoutX()+oldValue.intValue())<anchorb.getWidth()) {
  	        	 			f4.setFitWidth(oldValue.intValue());
  	        	 		
  	        			if((f5.getLayoutX()+oldValue.intValue())<anchorb.getWidth()) {
  	        	 			f5.setFitWidth(oldValue.intValue());
  	        	 			}
  	        			if((f6.getLayoutX()+oldValue.intValue())<anchorb.getWidth()) {
  	        	 			f6.setFitWidth(oldValue.intValue());
  	        	 			}
  	        			if((f7.getLayoutX()+oldValue.intValue())<anchorb.getWidth()) {
  	        	 			f7.setFitWidth(oldValue.intValue());
  	        	 			}
  	        			
  	        			
  	            	//	System.out.println("Spinner yeni deger="+newValue);
  	        			}
  	        			
  	        		}
  	        		
       		);
         
 	 
 	    	
    }
}


