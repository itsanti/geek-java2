/*
 */
package hw4.exmpls.javafx4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Button button;
    
    @FXML
    private TextField TextF;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        button.setText("Change");
        
        String btn_name = ((Button)event.getSource()).getText();
        
        TextF.setText(btn_name);
                
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
