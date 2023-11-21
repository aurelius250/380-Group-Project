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
 * Class controlling the Create reservation GUI and its actions
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
    
    /**
     * Method for sending a user back to the RoomSearch scene
     * @param e Button press of "Back" button
     * @throws IOException 
     */
    public void back(ActionEvent e) throws IOException{
        Main.setRoot("RoomSearch");
    }
    
    /**
     * ActionEvent method for running the proper create Reservation method
     * and setting the scene to the ReviewPurchase Scene
     * @param e on button press of "Create Reservation" button
     * @throws IOException 
     */
    public void createReservation(ActionEvent e) throws IOException{
        
        //Create the reservation
        createReservation();
        
        // After pressing "create reservation" button, moves to review purchase scene
        Main.setRoot("ReviewPurchase");
    }
    
    /**
     * Initializes the CreateReservationController class
     * Runs necessary scene start methods
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayReservationDetails(reservation);
        disablePastDates(checkInDatePicker);
        disablePastDates(checkOutDatePicker);
    }    
    
    /**
     * Changes label text to display appropriate room and reservation object data to user
     * @param r The reservation object to pull data from
     */
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
    
    /**
     * Method for making dates in the past unavailable to user for
     * selection
     * @param dp 
     */
    public void disablePastDates(DatePicker dp){
        dp.setDayCellFactory(param -> new DateCell(){
        @Override
        public void updateItem(LocalDate date, boolean empty){
            super.updateItem(date, empty);
            setDisable(empty || date.compareTo(LocalDate.now())<0);
            }
        });
    }
    
    /**
     * Creates the actual reservation object based on user input and selection
     * @throws IOException 
     */
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
