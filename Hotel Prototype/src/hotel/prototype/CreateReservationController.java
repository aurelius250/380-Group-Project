package hotel.prototype;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Keaton
 */
public class CreateReservationController implements Initializable {

    public Label reservationIDText;
    public Label roomNumText;
    public Label smokingText;
    public Label numBedsText;
    public Label numPeopleText;
    public Label sizeText;
    public Label bedTypeText;
    public Label descText;

    public TextField nameField;
    public TextField emailField;
    
    public static Room selectedRoom;
    
    @FXML
    private DatePicker checkInDatePicker, checkOutDatePicker;
    
    public void back(ActionEvent e) throws IOException{
        Main.setRoot("RoomSearch");
    }
    
    public void createReservation(ActionEvent e){
        Reservation reservation = new Reservation();
        Customer customer = new Customer();
        
        customer.setCustomerName(nameField.getText());
        customer.setCustomerEmail(emailField.getText());
        
        reservation.ID = reservationIDText.getText();
        reservation.checkIn = checkInDatePicker.getValue();
        reservation.checkOut = checkOutDatePicker.getValue();
        reservation.room = selectedRoom;
        reservation.customer = customer;

        reservation.listDetails();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayRoomDetails(selectedRoom);
        disablePastDates(checkInDatePicker);
        disablePastDates(checkOutDatePicker);
    }    
    
    public void displayRoomDetails(Room room){
        roomNumText.setText(room.getRoomNum().toString());
        smokingText.setText(room.getSmoking().toString());
        numBedsText.setText(room.getNumBeds().toString());
        numPeopleText.setText(room.getNumPeople().toString());
        sizeText.setText(room.getRoomNum().toString());
        bedTypeText.setText(String.valueOf(room.getBedType()));
        descText.setText(room.getDescription());
    }
    
    public void disablePastDates(DatePicker dp){
        dp.setDayCellFactory(param -> new DateCell(){
        @Override
        public void updateItem(LocalDate date, boolean empty){
            super.updateItem(date, empty);
            setDisable(empty || date.compareTo(LocalDate.now())<0);
            }
        });
    }
    
}
