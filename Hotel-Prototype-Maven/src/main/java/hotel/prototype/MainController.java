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
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author keato
 */
public class MainController implements Initializable {

    @FXML
    
    private DatePicker fromDatePicker,toDatePicker;
    private LocalDate fromDate, toDate;
    
    public void bookReservation(ActionEvent e){
        fromDate = fromDatePicker.getValue();
        toDate = toDatePicker.getValue();
        
        System.out.println("Reservation confirmed from " + fromDate + 
                " to " + toDate + ".");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
