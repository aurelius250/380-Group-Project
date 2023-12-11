/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hotel.prototype;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.stage.Stage; 
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author tomc
 */
public class ReviewPurchaseController implements Initializable {

    private Stage primaryStage; 
    
    public static Reservation reservation;
    
    public Label resIDText;
    public Label nameText;
    public Label emailText;
    public Label checkInText;
    public Label checkOutText;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        displayGreeting(primaryStage);
        Reservation currentRes = ReservationHandler.resHandler.currentRes;
        displayReservationDetails(currentRes);
    }    
    
    private void setPrimaryStage(Stage stage) { 
        this.primaryStage = stage; 
    }
  
    public void start(Stage stage) { 
        
    }
        
    public void returnStart() throws IOException{
        Main.setRoot("StartMenu");
    }
    
    // Still working on this entire class 
    public void displayGreeting(Stage stage) { 
        Text text = new Text();
        String greeting = "Reservation successfully confirmed.";
        text.setText(greeting);
        Group root = new Group(text); 
//        Scene scene = new Scene(root, 600, 300);
//        stage.setScene(scene);
//        stage.show();
    }
    
    private void displayReservationDetails(Reservation reservation){
        resIDText.setText(reservation.getID());
        nameText.setText(reservation.getCustomerName());
        emailText.setText(reservation.getCustomerEmail());
        checkInText.setText(reservation.getCheckIn());
        checkOutText.setText(reservation.getCheckOut());
    }
}
