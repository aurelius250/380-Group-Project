package hotel.prototype;

import static hotel.prototype.FileController.findAndAdd;
import static hotel.prototype.FileController.replaceLine;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

    /**
     *  Label to display reservationID
     */
    public Label reservationIDText;

    /**
     *Label to display the rooms number
     */
    public Label roomNumText;

    /**
     *Label to display whether smoking is allowed in the room
     */
    public Label smokingText;

    /**
     *Label to display number of beds in room
     */
    public Label numBedsText;

    /**
     *Label to display occupancy allowance of room
     */
    public Label numPeopleText;

    /**
     *Label to display room size
     */
    public Label sizeText;

    /**
     *Label to display room bed types
     */
    public Label bedTypeText;

    /**
     *Label to display room description
     */
    public Label descText;

    /**
     *  Field for entering customer name
     */
    
    public Label nameText;
    
    public Label emailText;
    
    public TextField nameField;

    /**
     * Field for entering customer email
     */
    public TextField emailField;
    
    /**
     * Reservation Object to be assigned data
     */
    public static Reservation reservation;
    
    @FXML
    private DatePicker checkInDatePicker, checkOutDatePicker;
    
    private LocalDate checkIn, checkOut;
    private String customerName, customerEmail;
    private ReservationHandler resHandler;
    
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
        //customerName = nameField.getText();
        //customerEmail = emailField.getText(); 
        checkIn = checkInDatePicker.getValue();
        checkOut = checkOutDatePicker.getValue();
        
        if(!checkDateRange(checkIn, checkOut)){
            String header = "Invalid Date Range";
            String content = "Please make sure the check in date is before"
                    + " the check out date.";
            displayAlert(header, content);
        }
        /*else if(checkEmptyFields()){
            String header = "Empty Fields";
            String content = "Please make sure data is entered for all fields.";
            displayAlert(header, content);
        }*/
        else{
            setReservationDates();
            resHandler.currentRes.addReservation();
            resHandler.addReservationToList(resHandler.currentRes);
            findAndAdd(
                    "src/hotel/prototype/Customers.txt",
                    "," + resHandler.currentRes.ID,
                    resHandler.user.toStringCsv()
            );
            resHandler.user.reservationIDs.add(resHandler.currentRes.getID());
            //ReviewPurchaseController.reservation = reservation;
            Main.setRoot("ReviewPurchase");
        }  
    }
    
    /**
     * Initializes the CreateReservationController class
     * Runs necessary scene start methods
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resHandler = ReservationHandler.resHandler;
        displayReservationDetails(resHandler.currentRes);
        disablePastDates(checkInDatePicker);
        disablePastDates(checkOutDatePicker);
    }    
    
    /**
     * Changes label text to display appropriate room and reservation object data to user
     * @param r The reservation object to pull data from
     */
    public void displayReservationDetails(Reservation r){
        roomNumText.setText(r.getRoomNum().toString());
        smokingText.setText(r.getSmoking().toString());
        numBedsText.setText(r.getNumBeds().toString());
        numPeopleText.setText(r.getNumPeople().toString());
        sizeText.setText(r.getRoomNum().toString());
        bedTypeText.setText(String.valueOf(r.getBedType()));
        descText.setText(r.getDescription());
        reservationIDText.setText(r.getID());
        nameText.setText(r.getCustomerName());
        emailText.setText(r.getCustomerEmail());
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
    private void setReservationData() throws IOException{
        Customer customer = new Customer();
        
        customer.setCustomerName(customerName);
        customer.setCustomerEmail(customerEmail);
        
        reservation.setCheckIn(checkIn);
        reservation.setCheckOut(checkOut);
        reservation.setCustomer(customer);

        reservation.addReservation();
        if(ReservationHandler.resHandler.user != null){
           findAndAdd("src/hotel/prototype/Customers.txt",","+reservation.ID,ReservationHandler.resHandler.user.toStringCsv());
           ReservationHandler.resHandler.user.reservationIDs.add(reservation.ID);
           customer.customerAddress = ReservationHandler.resHandler.user.customerAddress;
           customer.cardNum = ReservationHandler.resHandler.user.cardNum;
           customer.customerZip = ReservationHandler.resHandler.user.customerZip;
           customer.phoneNum = ReservationHandler.resHandler.user.phoneNum;
           customer.expiry = ReservationHandler.resHandler.user.expiry;
        }
        ReservationHandler.resHandler.addReservationToList(reservation);
    }
    
    private void setReservationDates(){
        resHandler.currentRes.setCheckIn(checkIn);
        resHandler.currentRes.setCheckOut(checkOut);
    }
    
    private boolean checkDateRange(LocalDate from, LocalDate to){
        if(from == null || to == null){
            return false;
        }
        else{
            return from.isBefore(to);
        }
    }
    
    private boolean checkEmptyFields(){
        TextField[] fields = {nameField,emailField};
        //LocalDate[] dates = {checkIn,checkOut};
        
        for(TextField field : fields){
            if(field.getText().isEmpty()){
                return true;
            }
        }
        
        //for(LocalDate date : dates){
            //if(date == null){
                //return true;
            //}
        //}
        
        return false;
    }
    
    private void displayAlert(String header, String content){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
}
