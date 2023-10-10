/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hotel.prototype;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author Keaton
 */
public class CreateReservationController implements Initializable {

    @FXML
    private DatePicker checkInDatePicker, checkOutDatePicker;
    
    @FXML
    private ChoiceBox<String> roomChoiceBox;
    
    private LocalDate checkInDate, checkOutDate;
    private String[] roomTypes = {"Best Room","Medium Room","Cheap Room"};
    private String roomType;
    
    public void bookReservation(ActionEvent e){
        checkInDate = checkInDatePicker.getValue();
        checkOutDate = checkOutDatePicker.getValue();
        roomType = roomChoiceBox.getValue();
        
        System.out.println("Reservation confirmed from " + checkInDate + 
                " to " + checkOutDate + " in the " + roomType + ".");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        roomChoiceBox.getItems().addAll(roomTypes);
    }    
    
}
