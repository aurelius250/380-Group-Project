/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hotel.prototype;

import static hotel.prototype.FileController.readFile;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jon01
 */
public class LoginController implements Initializable {
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button button; 
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Label loginLabel;
    /**
     * sends user to start menu
     * @param e on click of "back" button sends user to start
     * @throws IOException
     */
    public void sendToStart(ActionEvent e) throws IOException{
        Main.setRoot("StartMenu");
    }
    
    /**
     * Will log a user into their account given correct email and password
     * @param e button click of "Login" button runs method
     * @throws IOException 
     */
    public void userLogin(ActionEvent e)throws IOException {
        if(checkLogin(email.getText(),password.getText())){
            System.out.println("login success");
            System.out.println(ReservationHandler.resHandler.user.customerName);
            ArrayList<String> temp = new ArrayList<String>();
            temp = ReservationHandler.resHandler.user.getReservationIDs();
            System.out.println(temp.get(0));
            if(ReservationHandler.resHandler.user.reservationIDs.isEmpty()){
                System.out.println("empty");
            }
        } else {
            System.out.println("login Failure");
        }
        
    }
    
    /**
     * checks to see if email and password entered in text fields matches a user profile
     * @throws IOException 
     * @return 
     */
    private Boolean checkLogin (String email,String pass) throws IOException {
        String[] lineData;
        Customer user;
        String temp;
        ArrayList<String> customerList = new ArrayList<String>();
        ArrayList<String> reservationIDs = new ArrayList<String>();
        customerList = readFile("src/hotel/prototype/Customers.txt");
        
        for(String s: customerList){
            lineData=s.split(",");
            
            if(lineData[1].equals(email)&& lineData[2].equals(pass)){
                for(int i = 3; i < lineData.length;i++){
                    temp = lineData[i];
                    reservationIDs.add(temp);
                    System.out.println(reservationIDs.get(0));
                }
                user = new Customer();
                
                user.setCustomerName(lineData[0]);
                user.setCustomerEmail(email);
                user.setCustomerPass(pass);
                user.reservationIDs = reservationIDs;
                
                ReservationHandler.resHandler.setUser(user);
                
                customerList.clear();
                reservationIDs.clear();
                lineData = null;
                
                return true;
            }
        }
        
        customerList.clear();
        reservationIDs.clear();
        lineData=null;
        
        return false;
    }
    
    /**
     * initial start up code for this scene. Does nothing
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
