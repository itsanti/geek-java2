/*
 */
package hw4.exmpls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.Group;

public class FirstFX1 extends Application {
    
    public static void main(String[] args) {
        Application.launch(args);
    }
        
    @Override
    public void start(Stage stage) {
         
        // установка надписи
        Text text = new Text("Hello from JavaFX!");
        text.setLayoutY(100);   // установка положения надписи по оси Y
        text.setLayoutX(100);   // установка положения надписи по оси X
         
        Group group = new Group(text);  // создание и установка группы элементов
         
        Scene scene = new Scene(group); // создание сцены
        stage.setScene(scene);          // установка сцены для объекта Stage
        stage.setTitle("First Application");
        stage.setWidth(300);
        stage.setHeight(300);
        stage.show();
    }
}
