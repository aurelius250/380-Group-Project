/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hotel.prototype;

import static hotel.prototype.FileController.readFile;
import static hotel.prototype.ReservationHandler.resHandler;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 * Controller class for the Review Reservation screen.
 * @author jon01
 */
public class ReviewReservationController implements Initializable {

    /**
     * TableView variable for accessing table data
     */
    public TableView<Reservation> tableView;
    
    /**
     *  Label to display reservationID
     */
    public Label reservationIDText;

    /**
     *  Label to display the associated room number
     */
    public Label roomNumText;

    /**
     *  Label to display whether smoking is allowed in the associated room or not
     */
    public Label smokingText;

    /**
     *  Label to display number of beds in the room
     */
    public Label numBedsText;

    /**
     *  Label to display max occupancy of the room
     */
    public Label numPeopleText;

    /**
     *  Label to display the size of the room
     */
    public Label sizeText;

    /**
     *  Label to display the bed type(s) in the room
     */
    public Label bedTypeText;

    /**
     *  Label to display description of the room
     */
    public Label descText;
    
    /**
     *  column to display the room number associated with reservation
     */
    public TableColumn<Reservation,String> colRoom;

    /**
     * column to display checkIn dates of reservations
     */
    public TableColumn<Reservation,LocalDate> colCheckIn;

    /**
     * column to display checkOut dates of reservations
     */
    public TableColumn<Reservation,LocalDate> colCheckOut;


    /**
     * Method for sending users back to start menu
     * @param e runs on button press of "back" button
     * @throws IOException 
     */
    public void sendToStart(ActionEvent e)throws IOException{
        Main.setRoot("StartMenu");
    }
    
    /**
     * Displays all of the data pertaining to an associated reservations room.
     * @param r The reservation that is to have associated room data pulled from
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
    }
    
    /**
     * Displays customer reservations as lines on a table view to then be selected
     */
    private void loadTableData(){
        colRoom.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colCheckIn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        colCheckOut.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        
        ObservableList<Reservation> observableList = FXCollections.observableArrayList(
                ReservationHandler.resHandler.reservationList);
        
        tableView.setItems(observableList);
    }
    
    /**
     * Action code for running the displayReservationDetails method
     * @param e On receiving button press input from "select" button
     * @throws IOException 
     */
     public void reviewSelectedReservation(ActionEvent e) throws IOException{
        displayReservationDetails(tableView.getSelectionModel().getSelectedItem());
    }
     
     /**
      * Code to be ran on opening the ReviewReservation Scene
      * starts by making sure that the reservationHandler has been initialized
      * with filled object lists
      * @param url
      * @param rb 
      */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ReservationHandler.resHandler.roomList.clear();
       ReservationHandler.resHandler.reservationList.clear();
       if(ReservationHandler.resHandler.isRoomsEmpty()){
           ReservationHandler.resHandler.fillRoomList(readFile("src/hotel/prototype/Rooms.txt"));
       }
        
       if(ReservationHandler.resHandler.isReservationsEmpty()){
           ReservationHandler.resHandler.fillReservationList(readFile("src/hotel/prototype/Reservations.txt"));
       }
       if(resHandler.user != null)
       ReservationHandler.resHandler.SetToUserReservations();
       
        //ReservationHandler.resHandler.fillRoomList(readFile("src/hotel/prototype/Rooms.txt"));
        //ReservationHandler.resHandler.fillReservationList(readFile("src/hotel/prototype/Reservations.txt"));
        loadTableData();
    }    
    
}
