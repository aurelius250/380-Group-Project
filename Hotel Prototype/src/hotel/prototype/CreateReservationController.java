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
    
    public static Reservation reservation;
    
    @FXML
    private DatePicker checkInDatePicker, checkOutDatePicker;
    
    public void back(ActionEvent e) throws IOException{
        Main.setRoot("RoomSearch");
    }
    
    public void createReservation(ActionEvent e) throws IOException{
        
        //Create the reservation
        createReservation();
        
        // After pressing "create reservation" button, moves to review purchase scene
        Main.setRoot("ReviewPurchase");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayReservationDetails(reservation);
        disablePastDates(checkInDatePicker);
        disablePastDates(checkOutDatePicker);
    }    
    
    public void displayReservationDetails(Reservation r){
        roomNumText.setText(r.getRoom().getRoomNum().toString());
        smokingText.setText(r.getRoom().getSmoking().toString());
        numBedsText.setText(r.getRoom().getNumBeds().toString());
        numPeopleText.setText(r.getRoom().getNumPeople().toString());
        sizeText.setText(r.getRoom().getRoomNum().toString());
        bedTypeText.setText(String.valueOf(r.getRoom().getBedType()));
        descText.setText(r.getRoom().getDescription());
        reservationIDText.setText(r.getID());
        
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
    
    public void createReservation() throws IOException{
        Customer customer = new Customer();
        
        customer.setCustomerName(nameField.getText());
        customer.setCustomerEmail(emailField.getText());
        
        reservation.setCheckIn(checkInDatePicker.getValue());
        reservation.setCheckOut(checkOutDatePicker.getValue());
        reservation.setCustomer(customer);

        reservation.addReservation();
    }
    
}
