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

    @FXML
    public TableView<Reservation> tableView;

    public TableColumn<Reservation, String> colID;
    public TableColumn<Reservation, Integer> colCost;
    public TableColumn<Reservation, String> colName;
    public TableColumn<Reservation, Integer[]> colPhone;
    public TableColumn<Reservation, LocalDate> colCheckIn;
    public TableColumn<Reservation, LocalDate> colCheckOut;
    public TableColumn<Reservation, Integer> colRoom;
    
    public Label revenueLabel;
    public Label roomsLabel;

    /**
     * Initializes the controller class.
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
    
    public void back(ActionEvent e) throws IOException{
        ReservationHandler.resHandler.user = null;
        Main.setRoot("StartMenu");
    }

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
