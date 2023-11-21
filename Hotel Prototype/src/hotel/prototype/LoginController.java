/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hotel.prototype;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jon01
 */
public class LoginController implements Initializable {
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button button; 
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Label loginLabel;
    /**
     * sends user to start menu
     * @param e on click of "back" button sends user to start
     * @throws IOException
     */
    public void sendToStart(ActionEvent e) throws IOException{
        Main.setRoot("StartMenu");
    }
    
    /**
     * Will log a user into their account given correct email and password
     * @param e button click of "Login" button runs method
     * @throws IOException 
     */
    public void userLogin(ActionEvent e)throws IOException {
    
    }
    
    /**
     * checks to see if email and password entered in text fields matches a user profile
     * @throws IOException 
     */
    private void checkLogin () throws IOException {
       
    }
    
    /**
     * initial start up code for this scene. Does nothing
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
