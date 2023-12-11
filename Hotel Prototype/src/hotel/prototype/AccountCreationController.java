/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package hotel.prototype;

import static hotel.prototype.FileController.appendFile;
import static hotel.prototype.FileController.integerParser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    @FXML
    public TextField fname;
    @FXML
    public TextField lname;
    @FXML
    public TextField email;
    @FXML
    public TextField phoneNum;
    @FXML
    public PasswordField password;
    @FXML
    public PasswordField repassword;
    @FXML
    public TextField address;
    @FXML
    public TextField zip;
    @FXML
    public TextField cardNum;
    @FXML
    public TextField expiry;
    @FXML
    public TextField cvv;
    @FXML
    public Button confirmation;
    @FXML
    public Button back;
    @FXML
    public Label fnameCheck;
    @FXML
    public Label lnameCheck;
    @FXML
    public Label emailCheck;
    @FXML
    public Label phoneNumCheck;
    @FXML
    public Label passwordCheck;
    @FXML
    public Label repasswordCheck;
    @FXML
    public Label addressCheck;
    @FXML
    public Label zipCheck;
    @FXML
    public Label cardNumCheck;
    @FXML
    public Label expiryCheck;
    @FXML
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
        setChecksBlank();
    }

    private void setChecksBlank() {
        fnameCheck.setText("");
        lnameCheck.setText("");
        emailCheck.setText("");
        phoneNumCheck.setText("");
        passwordCheck.setText("");
        repasswordCheck.setText("");
        addressCheck.setText("");
        zipCheck.setText("");
        cardNumCheck.setText("");
        expiryCheck.setText("");
        cvvCheck.setText("");
    }

    public void toStart(ActionEvent e) throws IOException {
        Main.setRoot("StartMenu");
    }

    public void confirmation(ActionEvent e) throws IOException {
        Customer customer = new Customer();
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

        setChecksBlank();

        //if empty
        if (fnameData.trim().equals("")) {
            fnameCheck.setText("Invalid: please enter a name");
            flag = false;
        }
        if (lnameData.trim().equals("")) {
            lnameCheck.setText("Invalid: please enter a name");
            flag = false;
        }
        if (emailData.trim().equals("")) {
            emailCheck.setText("Invalid: please enter a email");
            flag = false;
        }
        if (phoneNumData.trim().equals("")) {
            phoneNumCheck.setText("Invalid: please enter a phone number");
            flag = false;
        }
        if (passwordData.trim().equals("")) {
            passwordCheck.setText("Invalid: please enter a password");
            flag = false;
        }
        if (repasswordData.trim().equals("")) {
            repasswordCheck.setText("Invalid: please enter a password");
            flag = false;
        }
        if (addressData.trim().equals("")) {
            addressCheck.setText("Invalid: please enter an address");
            flag = false;
        }
        if (zipData.trim().equals("")) {
            zipCheck.setText("Invalid: please enter a zip code");
            flag = false;
        }
        if (cardNumData.trim().equals("")) {
            cardNumCheck.setText("Invalid: please enter a card number");
            flag = false;
        }
        if (expiryData.trim().equals("")) {
            expiryCheck.setText("Invalid: please enter a expiry date");
            flag = false;
        }
        if (cvvData.trim().equals("")) {
            cvvCheck.setText("Invalid: please enter a cvv");
            flag = false;
        }

        //if invalid for some reason
        if (fnameData.contains(",")) {
            fnameCheck.setText("Invalid: Contains \",\"");
            flag = false;
        }

        if (lnameData.contains(",")) {
            lnameCheck.setText("Invalid: Contains \",\"");
            flag = false;
        }

        if (emailData.contains(",")) {
            emailCheck.setText("Invalid: Contains \",\"");
            flag = false;
        }

        if (!emailData.contains("@email") && !emailData.contains("@gmail") && !emailData.contains("@hotmail")) {
            emailCheck.setText("Invalid email");
            flag = false;
        }
        if (phoneNumData.length() != 10 || !phoneNumData.matches("\\d+")) {
            phoneNumCheck.setText("Invalid Phone Number");
            flag = false;
        }
        if (passwordData.contains(",")) {
            passwordCheck.setText("Invalid: Contains \",\"");
            flag = false;
        }
        if (!passwordData.equals(repasswordData)) {
            repasswordCheck.setText("Invalid: please enter the same password");
            flag = false;
        }
        if (repasswordData.contains(",")) {
            repasswordCheck.setText("Invalid: Contains \",\"");
            flag = false;
        }
        if (addressData.contains(",")) {
            addressCheck.setText("Invalid: Contains \",\"");
            flag = false;
        }
        if (zipData.contains(",")) {
            zipCheck.setText("Invalid: Contains \",\"");
            flag = false;
        }
        if (zipData.length() != 5 || !zipData.matches("\\d+")) {
            zipCheck.setText("Invalid zip");
            flag = false;
        }
        if (cardNumData.contains(",")) {
            cardNumCheck.setText("Invalid: Contains \",\"");
            flag = false;
        }
        if (cardNumData.length() != 16 || !cardNumData.matches("\\d+")) {
            cardNumCheck.setText("Invalid Card Number");
            flag = false;
        }
        if (cvvData.contains(",")) {
            cvvCheck.setText("Invalid: Contains \",\"");
            flag = false;
        }
        if (cvvData.length() != 3 || !cvvData.matches("\\d+")) {
            cvvCheck.setText("Invalid cvv");
            flag = false;
        }

        if (flag) {
            fullNameData = fnameData.trim() + "-" + lnameData.trim();
            customer.customerName = fullNameData;
            customer.customerEmail = emailData;
            customer.customerAddress = addressData.replace(" ", "-");
            customer.customerPassword = passwordData;
            customer.customerZip = integerParser(zipData);
            customer.expiry = expiryData;
            customer.cvv = integerParser(cvvData);
            customer.isAdmin = false;
            for (int i = 0; i < phoneNumData.length(); i++) {
                customer.phoneNum[i] = integerParser(phoneNumData.charAt(i));
            }
            for (int i = 0; i < cardNumData.length(); i++) {
                customer.cardNum[i] = integerParser(cardNumData.charAt(i));
            }
            appendFile("src/hotel/prototype/Customers.txt", customer.toStringCsv());
            ReservationHandler.resHandler.user = customer;
            Main.setRoot("StartMenu");
        }
    }
}
