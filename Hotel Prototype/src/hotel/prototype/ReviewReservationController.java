/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hotel.prototype;

import static hotel.prototype.FileController.readFile;
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
     * Initializes the controller class.
     */
    public TableView<Reservation> tableView;
    
    public Label reservationIDText;
    public Label roomNumText;
    public Label smokingText;
    public Label numBedsText;
    public Label numPeopleText;
    public Label sizeText;
    public Label bedTypeText;
    public Label descText;
    
    public TableColumn<Reservation,String> colRoom;
    public TableColumn<Reservation,LocalDate> colCheckIn;
    public TableColumn<Reservation,LocalDate> colCheckOut;
    
    ReservationHandler resHandler = new ReservationHandler();
    public static Reservation reservation;
    
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
     * @param r Th reservation that is to have associated room data pulled from
     */
    public void displayReservationDetails(Reservation r){
        roomNumText.setText(tableView.getSelectionModel().getSelectedItem().getRoom().getRoomNum().toString());
        smokingText.setText(tableView.getSelectionModel().getSelectedItem().getRoom().getSmoking().toString());
        numBedsText.setText(tableView.getSelectionModel().getSelectedItem().getRoom().getNumBeds().toString());
        numPeopleText.setText(tableView.getSelectionModel().getSelectedItem().getRoom().getNumPeople().toString());
        sizeText.setText(tableView.getSelectionModel().getSelectedItem().getRoom().getRoomNum().toString());
        bedTypeText.setText(String.valueOf(tableView.getSelectionModel().getSelectedItem().getRoom().getBedType()));
        descText.setText(tableView.getSelectionModel().getSelectedItem().getRoom().getDescription());
        reservationIDText.setText(tableView.getSelectionModel().getSelectedItem().getID());
    }
    
    /**
     * Displays customer reservations as lines on a table view to then be selected
     */
    private void loadTableData(){
        colRoom.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colCheckIn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        colCheckOut.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        
        ObservableList<Reservation> observableList = FXCollections.observableArrayList(
                resHandler.reservationList);
        
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
       if(resHandler.isReservationsEmpty() && resHandler.isRoomsEmpty()){
            resHandler.fillReservationList(readFile("src/hotel/prototype/Reservations.txt"));
            //resHandler.fillRoomList(readFile("src/hotel/prototype/Rooms.txt"));
        } else if (resHandler.isReservationsEmpty()){
            resHandler.fillReservationList(readFile("src/hotel/prototype/Reservations.txt"));
        } else if (resHandler.isRoomsEmpty()){
            //resHandler.fillRoomList(readFile("src/hotel/prototype/Rooms.txt"));
        }
        resHandler.fillRoomList(readFile("src/hotel/prototype/Rooms.txt"));
        resHandler.fillReservationList(readFile("src/hotel/prototype/Reservations.txt"));
        loadTableData();
    }    
    
}
