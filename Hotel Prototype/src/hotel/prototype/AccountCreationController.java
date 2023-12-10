/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hotel.prototype;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jonathan
 */
public class AccountCreationController implements Initializable {

    public TextField fname;
    public TextField lname;
    public TextField email;
    public TextField phoneNum;
    public PasswordField password;
    public PasswordField repassword;
    public TextField address;
    public TextField zip;
    public TextField cardNum;
    public TextField expiry;
    public TextField cvv;
    public Button confirmation;
    public Label fnameCheck;
    public Label lnameCheck;
    public Label emailCheck;
    public Label phoneNumCheck;
    public Label passwordCheck;
    public Label repasswordCheck;
    public Label addressCheck;
    public Label zipCheck;
    public Label cardNumCheck;
    public Label expiryCheck;
    public Label cvvCheck;

    private String fnameData;
    private String lnameData;
    private String fullNameData;
    private String emailData;
    private String phoneNumData;
    private String passwordData;
    private String repasswordData;
    private String addressData;
    private String zipData;
    private String cardNumData;
    private String expiryData;
    private String cvvData;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void confirmation(ActionEvent e) throws IOException {
        fnameData = fname.getText();
        lnameData = lname.getText();
        emailData = email.getText();
        phoneNumData = phoneNum.getText();
        passwordData = password.getText();
        repasswordData = repassword.getText();
        addressData = address.getText();
        zipData = zip.getText();
        cardNumData = cardNum.getText();
        expiryData = expiry.getText();
        cvvData = cvv.getText();
        boolean flag = true;
        
        if(fnameData.contains(",")){
            fnameCheck.setText("Invalid: Contains \",\"");
            flag = false;
        }
        if(lnameData.contains(",")){
            lnameCheck.setText("Invalid: Contains \",\"");
            flag = false;
        }
        if(emailData.contains(",")){
            emailCheck.setText("Invalid: Contains \",\"");
            flag = false;
        }
        if(!emailData.contains("@email") || !emailData.contains("@gmail") || !emailData.contains("@hotmail")){
            emailCheck.setText("Invalid email");
            flag = false;
        }
        if(phoneNumData.length() != 10 || !phoneNumData.matches("\\d+")){
            phoneNumCheck.setText("Invalid Phone Number");
            flag = false;
        }
        if(passwordData.contains(",")){
            passwordCheck.setText("Invalid: Contains \",\"");
            flag = false;
        }
        
    }
}
