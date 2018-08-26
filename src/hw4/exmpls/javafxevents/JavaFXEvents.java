/*
 */
package hw4.exmpls.javafxevents;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class JavaFXEvents extends Application {
    
public static void main(String[] args) {
         
        Application.launch(args);
    }
     
    @Override
    public void start(Stage stage) {
         
        Button btn = new Button();
        btn.setText("Click!");
        /*
        //прикрепить событие к кнопке       
        btn.setOnAction(new EventHandler<ActionEvent>() {
             
            @Override
            public void handle(ActionEvent event) {
             
                btn.setText("You've clicked!");
            }
        });
         */        
        /*//использование лямбда-выражения (альтернативно)
            btn.setOnAction(e -> {
        
                           btn.setText("You've clicked!");
            });
        */

        EventHandler<ActionEvent> hnd = new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event) {
                   btn.setText("You've clicked!");
            }         
        };
        
        btn.setOnAction(hnd);

        Group root = new Group(btn);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Hello JavaFX");
        stage.setWidth(250);
        stage.setHeight(200);
        stage.show();
    }
}
