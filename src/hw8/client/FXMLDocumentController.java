/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw8.client;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.net.*;
import java.io.*;

public class FXMLDocumentController implements Initializable {
    
    private boolean authorized;
    
    public void setAthorized(boolean authorized)
    {
        this.authorized = authorized;
        if(authorized)//если авторизованы
        {
          authPanel.setVisible(false);
          authPanel.setManaged(false);
          msgPanel.setVisible(true);
          msgPanel.setManaged(true);
        }
        else
        {
          authPanel.setVisible(true);
          authPanel.setManaged(true);
          msgPanel.setVisible(false);
          msgPanel.setManaged(false);
        }
    }
    
    private Socket socket;     //чтобы общаться с серваком
    
    private DataInputStream  in; //поток ввода, используется UTF-кодировка
    private DataOutputStream out;//поток вывода, используется UTF-кодировка
    
    @FXML
    private Button sendButton, connectBtn;
    
    @FXML
    private TextArea TextArea;
    
    @FXML
    private TextField TextField, loginField;
   
    @FXML
    private PasswordField passwordField;
    
    @FXML
    HBox authPanel, msgPanel;
    
    @FXML
    AnchorPane MainAnchorPane;
    
    
    
    public void sendMsg() {//послать сообщение на сервак
       
        try 
        {
            String str = TextField.getText();
            out.writeUTF(str);//сообщение пошло на сервер
            TextField.clear();
            TextField.requestFocus();//фокус ввода на поле ввода сообщения
        } 
        catch (IOException ex) 
        {
            ex.getStackTrace();
        }
       
    }
    
    public void sendMsg(String msg) {//послать сообщение на сервак
       
        try 
        {
            out.writeUTF(msg);//сообщение пошло на сервер
        } 
        catch (IOException ex) 
        {
            ex.getStackTrace();
        }
    }
    
    public void sendAuth() {//послать запрос на авторизацию в сторону сервера
      
        connect();
        sendMsg("/auth " + loginField.getText() + " " + passwordField.getText());
        loginField.clear();
        passwordField.clear();
    }
    
    public void connect()
    {
       if(socket==null || socket.isClosed())//можем подключиться, если сокет null или закрыт!
       {
        try
        {
          //Три кита при работе в сети:
          socket = new Socket("localhost", 12345);
          in  = new DataInputStream(socket.getInputStream());
          out = new DataOutputStream(socket.getOutputStream());
          
          new Thread(new Runnable(){
          
          @Override 
          public void run()
          {
                 try {
                        while(true)
                        {
                            System.out.println("В цикле авторизации");    
                         
                            String str = in.readUTF();
                                if(str.equals("/authok"))
                                {
                                    setAthorized(true);//авторизовались
                                    break;
                                }
                        }
                        while(true)
                        {
                                String str = in.readUTF();
                                TextArea.appendText(str);
                                TextArea.appendText("\n");
                        }
                 } catch (IOException ex) {
                     ex.printStackTrace();
                 }
                 finally//освобождаем ресурсы
                         {
                            try
                            {
                                in.close();
                                //out.close();   //в отдельный блок try - catch
                                //socket.close();//в отдельный блок try - catch
                            }
                            catch(IOException ex)
                            {
                                ex.printStackTrace();
                            }
                            try
                            {
                               out.close();
                            }
                            catch(IOException ex)
                            {
                                ex.printStackTrace();
                            }
                            try
                            {
                                socket.close();
                            }
                            catch(IOException ex)
                            {
                                ex.printStackTrace();
                            }
                            
                            setAthorized(false);//не авторизованы при разрыве соединения
                            
                         }//finally
          }
          }).start();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
       }//if
    }//public void connect()
    
    
    @Override//будет выполняться при запуске приложения
    public void initialize(URL url, ResourceBundle rb) {
        //URL              - доступ к удалённому *.fxml
        //ResourceBundle   - доступ к ресурсам, упакованным в jar, если они есть
        setAthorized(false);
        
            Platform.runLater(() -> {
                
                ((Stage)MainAnchorPane.getScene().getWindow()).setOnCloseRequest(new EventHandler<WindowEvent>(){
                    
                    @Override
                    public void handle(WindowEvent t)//здесь описываем то, что происходит при закрытии приложения
                    {
                        sendMsg("/end");
                        Platform.exit();
                        System.exit(0);
                    }
                });
        } //run
        );// Platform.runLater 
            
    }//public void initialize    
    
}//public class FXMLDocumentController
