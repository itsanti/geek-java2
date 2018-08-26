/*
 */
package hw4.exmpls.javafxcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Anikoton
 */
public class JavaFXControllerController {

    @FXML
    private Button btn;
     
    @FXML
    private void click(ActionEvent event) {
        btn.setText("You've clicked!");
    } 
    
}
