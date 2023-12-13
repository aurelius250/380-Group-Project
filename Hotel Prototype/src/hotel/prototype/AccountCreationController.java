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

    /**
     *  TextField for getting customer's first name
     */
    @FXML
    public TextField fname;

    /**
     *  TextField for getting customer's last name
     */
    @FXML
    public TextField lname;

    /**
     * TextField for getting customer's email
     */
    @FXML
    public TextField email;

    /**
     *  TextField for getting customer's phone number
     */
    @FXML
    public TextField phoneNum;

    /**
     * PasswordField for getting customer's password
     */
    @FXML
    public PasswordField password;

    /**
     * PasswordField for getting customer's password
     */
    @FXML
    public PasswordField repassword;

    /**
     *  TextField for getting customer's address
     */
    @FXML
    public TextField address;

    /**
     * TextField for getting customer's zip code
     */
    @FXML
    public TextField zip;

    /**
     * TextField for getting customer's 16 digit card number
     */
    @FXML
    public TextField cardNum;

    /**
     * TextField for getting customer's card expiry date
     */
    @FXML
    public TextField expiry;

    /**
     * TextField for getting customer's cvv number from their card
     */
    @FXML
    public TextField cvv;

    /**
     * Button for confirmation ActionEvent
     */
    @FXML
    public Button confirmation;

    /**
     * Button for toStart ActionEvent
     */
    @FXML
    public Button back;

    /**
     * Label for informing user of invalid input for first name
     */
    @FXML
    public Label fnameCheck;

    /**
     * Label for informing user of invalid input for last name
     */
    @FXML
    public Label lnameCheck;

    /**
     * Label for informing user of invalid input for email
     */
    @FXML
    public Label emailCheck;

    /**
     * Label for informing user of invalid input for phone number
     */
    @FXML
    public Label phoneNumCheck;

    /**
     * Label for informing user of invalid input for password
     */
    @FXML
    public Label passwordCheck;

    /**
     * Label for informing user of invalid input for repassword
     */
    @FXML
    public Label repasswordCheck;

    /**
     * Label for informing user of invalid input for address
     */
    @FXML
    public Label addressCheck;

    /**
     * Label for informing user of invalid input for zip code
     */
    @FXML
    public Label zipCheck;

    /**
     * Label for informing user of invalid input for 16 digit card number
     */
    @FXML
    public Label cardNumCheck;

    /**
     * Label for informing user of invalid input for card expiry date
     */
    @FXML
    public Label expiryCheck;

    /**
     * Label for informing user of invalid input for cvv number from card
     */
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
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setChecksBlank();
    }
    /**
     * Sets labels on screen to blank
     */
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

    /**
     * Sends user to StartMenu screen
     * @param e Button press of "back" button
     * @throws IOException
     */
    public void toStart(ActionEvent e) throws IOException {
        Main.setRoot("StartMenu");
    }

    /**
     * Checks user inputs and if they are valid makes a new customer account
     * @param e Button press of "Confirm" button
     * @throws IOException
     */
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
