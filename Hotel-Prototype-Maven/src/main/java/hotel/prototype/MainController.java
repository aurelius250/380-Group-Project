 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hotel.prototype;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author keato
 */
public class MainController implements Initializable {

    @FXML
    private DatePicker checkInDatePicker, checkOutDatePicker;
    
    @FXML
    private ChoiceBox<String> roomChoiceBox;
    
    private String[] roomTypes = {"Best Room","Medium Room","Cheap Room"};
    private String roomType;
    
    public void bookReservation(ActionEvent e) throws IOException{
        
        Reservation reservation = new Reservation(
                "12345",
                checkInDatePicker.getValue(),
                checkOutDatePicker.getValue(),
                new Room()
        );
        
        //roomType = roomChoiceBox.getValue();
        
        reservation.listDetails();
        reservation.addReservation();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        roomChoiceBox.getItems().addAll(roomTypes);
    }    
}
