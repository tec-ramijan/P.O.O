import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**********************************************************************
 Instituto Tecnológico de Costa Rica
 Programación Orientada a Objetos IC-2101
 II Semestre 2020
 Profesora: Samanta Ramijan Carmiol
 Ejemplos Prácticos: Interfaz Grafica
 *********************************************************************/

public class Main extends Application {
    //Clase Application para cargar una aplicacion JavaFX independiente

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Metodo start usualmente ubica a los controles de interfaz en la escena.

        Parent root = FXMLLoader.load(getClass().getResource("canvas.fxml"));
        primaryStage.setTitle("Clase de P.O.O");

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        //La maquina virtual de Java (JVM) automaticamente invoca al metodo lauch para correr el programa
        //Para llamar al programa desde linea de comandos
    }


}