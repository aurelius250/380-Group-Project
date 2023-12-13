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
    
    /**
     * Reservation for review
     */
    public static Reservation reservation;
    
    /**
     * Label to display reservation id
     */
    public Label resIDText;

    /**
     * Label to display customer name
     */
    public Label nameText;

    /**
     * Label to display customer email
     */
    public Label emailText;

    /**
     * Label to display reservation checkIn date
     */
    public Label checkInText;

    /**
     * Label to display reservation checkOut date
     */
    public Label checkOutText;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        displayGreeting(primaryStage);
        Reservation currentRes = ReservationHandler.resHandler.currentRes;
        displayReservationDetails(currentRes);
    }    
    /**
     * Method for setting the stage
     * @param stage Stage to be set to
     */
    private void setPrimaryStage(Stage stage) { 
        this.primaryStage = stage; 
    }
  

        
    /**
     * Method for sending user to startMenu
     * @throws IOException
     */
    public void returnStart() throws IOException{
        Main.setRoot("StartMenu");
    }
    
    // Still working on this entire class 

    /**
     * Method for displaying reservation confirmation message
     * @param stage
     */
    public void displayGreeting(Stage stage) { 
        Text text = new Text();
        String greeting = "Reservation successfully confirmed.";
        text.setText(greeting);
        Group root = new Group(text); 
//        Scene scene = new Scene(root, 600, 300);
//        stage.setScene(scene);
//        stage.show();
    }
    /**
     * method for displaying reservation info to screen
     * @param reservation 
     */
    private void displayReservationDetails(Reservation reservation){
        resIDText.setText(reservation.getID());
        nameText.setText(reservation.getCustomerName());
        emailText.setText(reservation.getCustomerEmail());
        checkInText.setText(reservation.getCheckIn());
        checkOutText.setText(reservation.getCheckOut());
    }
}
