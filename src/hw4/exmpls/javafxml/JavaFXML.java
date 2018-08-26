/*
 */
package hw4.exmpls.javafxml;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class JavaFXML extends Application {
    
   @Override
    public void start(Stage stage) throws Exception {
         
        Parent root = FXMLLoader.load(getClass().getResource("JavaFXML.fxml")); 
        Scene scene = new Scene(root);
         
        stage.setScene(scene);
         
        stage.setTitle("Hello JavaFX");
        stage.setWidth(250);
        stage.setHeight(200);
         
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
