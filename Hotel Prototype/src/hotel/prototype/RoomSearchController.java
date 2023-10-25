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

/**
 * FXML Controller class
 *
 * @author Keaton
 */
public class RoomSearchController implements Initializable {
    @FXML
    public TableView<Room> tableView;
    
    public TableColumn<Room,Integer> colRoomNum;
    public TableColumn<Room,Boolean> colSmoking;
    public TableColumn<Room,Integer> colNumBeds;
    public TableColumn<Room,Integer> colNumPeople;
    public TableColumn<Room,Integer> colSize;
    public TableColumn<Room,Character> colBedType;
    public TableColumn<Room,String> colDesc;
    
    public void reserveSelectedRoom(ActionEvent e) throws IOException{
        Room room = tableView.getSelectionModel().getSelectedItem();
        CreateReservationController.selectedRoom = room;
        Main.setRoot("CreateReservation");
    }
    
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
                new Room(101,true,1,1,100,'S',"Cheap Room"),
                new Room(201,false,2,2,200,'K',"Medium Room"),
                new Room(301,true,3,4,300,'Q',"Best Room")
        );
        
        tableView.setItems(observableList);
    }
    
}
