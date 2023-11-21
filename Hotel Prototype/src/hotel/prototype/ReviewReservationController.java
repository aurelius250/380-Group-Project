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
 *
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
    
    public void sendToStart(ActionEvent e)throws IOException{
        Main.setRoot("StartMenu");
    }
    
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
    
    private void loadTableData(){
        colRoom.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colCheckIn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        colCheckOut.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        
        ObservableList<Reservation> observableList = FXCollections.observableArrayList(
                resHandler.reservationList);
        
        tableView.setItems(observableList);
    }
    
     public void reviewSelectedReservation(ActionEvent e) throws IOException{
        tableView.getSelectionModel().getSelectedItem();
    }
     
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
