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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Jonathan
 */
public class ManagerViewController implements Initializable {

    /**
     * TableView to see all reservations in system
     */
    @FXML
    public TableView<Reservation> tableView;

    /**
     * TableColumn for reservation IDs
     */
    public TableColumn<Reservation, String> colID;

    /**
     * TableColumn for reservation cost
     */
    public TableColumn<Reservation, Integer> colCost;

    /**
     * TableColumn for reservation customer name
     */
    public TableColumn<Reservation, String> colName;

    /**
     * TableColumn for reservation customer phone
     */
    public TableColumn<Reservation, Integer[]> colPhone;

    /**
     * TableColumn for reservation checkIn date
     */
    public TableColumn<Reservation, LocalDate> colCheckIn;

    /**
     * TableColumn for reservation checkOut date
     */
    public TableColumn<Reservation, LocalDate> colCheckOut;

    /**
     * TableColumn for reservation room number
     */
    public TableColumn<Reservation, Integer> colRoom;
    
    /**
     * Label displaying current revenue
     */
    public Label revenueLabel;

    /**
     * Label displaying rooms purchased
     */
    public Label roomsLabel;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ReservationHandler.resHandler.roomList.clear();
        ReservationHandler.resHandler.reservationList.clear();
        if (ReservationHandler.resHandler.isRoomsEmpty()) {
            ReservationHandler.resHandler.fillRoomList(readFile("src/hotel/prototype/Rooms.txt"));
        }

        if (ReservationHandler.resHandler.isReservationsEmpty()) {
            ReservationHandler.resHandler.fillReservationList(readFile("src/hotel/prototype/Reservations.txt"));
        }
        loadTableData();
        setLabels();
    }
    
    /**
     * Sends user back to the start menu, also logs user out of admin account
     * @param e button press of "back" button
     * @throws IOException
     */
    public void back(ActionEvent e) throws IOException{
        ReservationHandler.resHandler.user = null;
        Main.setRoot("StartMenu");
    }
    /**
     * Loads data into the TableView
     */
    private void loadTableData() {
        colID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        colName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumString"));
        colCheckIn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        colCheckOut.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        colRoom.setCellValueFactory(new PropertyValueFactory<>("roomNum"));

        ObservableList<Reservation> observableList = FXCollections.observableArrayList(
                ReservationHandler.resHandler.reservationList);

        tableView.setItems(observableList);
    }
    /**
     * Sets revenue and rooms labels to appropriate values
     */
    private void setLabels(){
        int revenue = 0;
        int roomsRented = 0;
        String temp;
        for(Reservation r: ReservationHandler.resHandler.reservationList){
            revenue += r.getCost();
            roomsRented++;
        }
       
        temp = Integer.toString(revenue);
        revenueLabel.setText(temp);
        temp = Integer.toString(roomsRented);
        roomsLabel.setText(temp);
        
    }
}
