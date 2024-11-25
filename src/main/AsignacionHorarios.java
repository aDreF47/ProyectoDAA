package main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AsignacionHorarios extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/LoginView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root); //Scena fundamentl para FX
        scene.getStylesheets().add(getClass().getResource("/styles/styleLogin.css").toExternalForm());
        
        //scene.getStylesheets().add(getClass().getResource("/estilos/styleLogin.css").toExternalForm());
        
        // Establece el tamaño mínimo de la ventana
        primaryStage.setMinWidth(340.0);
        primaryStage.setMinHeight(633.0);
        
        // Establece el tamaño mínimo de la ventana
        primaryStage.setMaxWidth(1100.0);
        primaryStage.setMaxHeight(540.0);
       
        // Centrar la ventana
        primaryStage.centerOnScreen();
        
        primaryStage.setTitle("Login"); 
        primaryStage.setScene(scene); // muestra la escena internamente
        primaryStage.show();
        System.out.println("HOla mundo cruel");
            
    }

    public static void main(String[] args) {
        launch(args);
        
    }
    
}
