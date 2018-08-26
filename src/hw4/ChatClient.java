package hw4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
// основной GUI класс
import javafx.stage.Stage;
// сцены
import javafx.scene.Scene;

public class ChatClient extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("chatclientform.fxml"));
        primaryStage.setTitle("Simple Chat Client");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
