package hotel.prototype;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static hotel.prototype.FileController.readFile;

/**
 * FXML Controller class
 *
 * @author Keaton
 */
public class RoomSearchController implements Initializable {

    /**
     * Table to select room from
     */
    @FXML
    public TableView<Room> tableView;
    
    /**
     *  Column displaying room numbers
     */
    public TableColumn<Room,Integer> colRoomNum;

    /**
     * Column displaying smoking status of rooms
     */
    public TableColumn<Room,Boolean> colSmoking;

    /**
     * Column displaying number of beds in the rooms
     */
    public TableColumn<Room,Integer> colNumBeds;

    /**
     * Column displaying max occupancy of the rooms
     */
    public TableColumn<Room,Integer> colNumPeople;

    /**
     * Column displaying size of the rooms
     */
    public TableColumn<Room,Integer> colSize;

    /**
     * Column displaying the bed type in the room
     */
    public TableColumn<Room,Character> colBedType;

    /**
     * Column displaying a description of the room
     */
    public TableColumn<Room,String> colDesc;
    
    ReservationHandler resHandler = new ReservationHandler();
    
    /**
     * creates a new reservation and assigns a room to it before
     * sending user to CreateReservation Scene
     * @param e Button press of "Reserve Selected Room"
     * @throws IOException 
     */
    public void reserveSelectedRoom(ActionEvent e) throws IOException{
        Reservation reservation = new Reservation();
        reservation.setRoom(tableView.getSelectionModel().getSelectedItem());
        CreateReservationController.reservation = reservation;
        Main.setRoot("CreateReservation");
    }
    
    /**
     * Sends user back to the StartMenu scene
     * @throws IOException 
     */
    public void Back() throws IOException{
        Main.setRoot("StartMenu");
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(resHandler.isReservationsEmpty() && resHandler.isRoomsEmpty()){
            //resHandler.fillReservationList(readFile("src/hotel/prototype/Reservations.csv"));
            resHandler.fillRoomList(readFile("src/hotel/prototype/Rooms.txt"));
        } else if (resHandler.isReservationsEmpty()){
            //resHandler.fillReservationList(readFile("src/hotel/prototype/Resrvations.csv"));
        } else if (resHandler.isRoomsEmpty()){
            resHandler.fillRoomList(readFile("src/hotel/prototype/Rooms.txt"));
        }
        resHandler.fillRoomList(readFile("src/hotel/prototype/Rooms.txt"));
        loadTableData();
    } 
    
    /**
     * Loads data into the room search table
     */
    private void loadTableData(){
        colRoomNum.setCellValueFactory(new PropertyValueFactory<>("roomNum"));
        colSmoking.setCellValueFactory(new PropertyValueFactory<>("smoking"));
        colNumBeds.setCellValueFactory(new PropertyValueFactory<>("numBeds"));
        colNumPeople.setCellValueFactory(new PropertyValueFactory<>("numPeople"));
        colSize.setCellValueFactory(new PropertyValueFactory<>("sqftSize"));
        colBedType.setCellValueFactory(new PropertyValueFactory<>("bedType"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        
        ObservableList<Room> observableList = FXCollections.observableArrayList(
                resHandler.roomList);
        
        tableView.setItems(observableList);
    }
    
}
