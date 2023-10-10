/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hotel.prototype;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
    public TableView<Room> tableView;
    
    public TableColumn<Room,Integer> colRoomNum;
    public TableColumn<Room,Boolean> colSmoking;
    public TableColumn<Room,Integer> colNumBeds;
    public TableColumn<Room,Integer> colNumPeople;
    public TableColumn<Room,Integer> colSize;
    public TableColumn<Room,Character> colBedType;
    public TableColumn<Room,String> colDesc;
    
    public void reserveRoom(ActionEvent e) throws IOException{
        //TODO: Create reservation with data from selected row
        Main.setRoot("CreateReservation");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        colRoomNum.setCellValueFactory(new PropertyValueFactory<>("roomNum"));
        colSmoking.setCellValueFactory(new PropertyValueFactory<>("smoking"));
        colNumBeds.setCellValueFactory(new PropertyValueFactory<>("numBeds"));
        colNumPeople.setCellValueFactory(new PropertyValueFactory<>("numPeople"));
        colSize.setCellValueFactory(new PropertyValueFactory<>("sqftSize"));
        colBedType.setCellValueFactory(new PropertyValueFactory<>("bedType"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("description"));

        ObservableList<Room> observableList = FXCollections.observableArrayList(
                new Room(101,true,1,1,100,'K',"Cheap Room"),
                new Room(102,true,1,1,100,'K',"Cheap Room"),
                new Room(103,true,1,1,100,'K',"Cheap Room")
        );
        
        tableView.setItems(observableList);
    }    
    
}
