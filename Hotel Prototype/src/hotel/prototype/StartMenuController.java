/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hotel.prototype;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author Jonathan
 */
public class StartMenuController implements Initializable {
    @FXML
    /**
     * Initializes the controller class.
     */
    
    /** 
     * sends user to the room search screen
     * @param e button click on "find a room" button
     * @throws IOException
     */
    public void sendToRoomSearch (ActionEvent e) throws IOException{
        Main.setRoot("RoomSearch");
    }
    
    public void sendToReservationSearch(ActionEvent e) throws IOException{
        Main.setRoot("ReviewReservation");
    }
    
    /**
     * sends user to the login screen
     * @param e button click on "login" button
     * @throws IOException 
     */
    public void sendToLogin (ActionEvent e) throws IOException{
        Main.setRoot("login");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
