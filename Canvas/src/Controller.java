import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;


/**********************************************************************
Instituto Tecnológico de Costa Rica
Programación Orientada a Objetos IC-2101
II Semestre 2020
Profesora: Samanta Ramijan Carmiol
Ejemplos Prácticos: Interfaz Grafica
*********************************************************************/
public class Controller {
	
	@FXML
	private ImageView barco;

    @FXML
    private Button arriba;
    @FXML
    private Button abajo;
    @FXML
    private Button derecha;
    @FXML
    private Button izquierda;
    
    public void moverArriba(ActionEvent event){

    	double posY = barco.getY();
    	barco.setY(posY-50);
    }
    
    public void moverAbajo(ActionEvent event){
    	double posY = barco.getY();
    	barco.setY(posY+50);
    }
    
    public void moverDerecha(ActionEvent event){
    	double posX = barco.getX();
    	barco.setX(posX+50); 
    }
    
    public void moverIzquierda(ActionEvent event){
    	double posX = barco.getX();
    	barco.setX(posX-50);
    }
}