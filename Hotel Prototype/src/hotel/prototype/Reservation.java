package hotel.prototype;

import static hotel.prototype.FileController.readFile;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Reservation class object. Stores ID, Check in/out date, room associated, and
 * the customer associated.
 *
 * @author K.Maki
 */
public final class Reservation {

    /**
     * Unique ID designating the reservation
     */
    protected String ID;

    /**
     * The reservation checkIn date
     */
    protected LocalDate checkIn;

    /**
     * The reservation checkOut date
     */
    protected LocalDate checkOut;

    /**
     * Room object associated with the reservation
     */
    protected Room room;

    /**
     * The customer object associated with the reservation
     */
    protected Customer customer;

    /**
     * Default constructor.
     */
    public Reservation() {
        ID = this.generateID();
        checkIn = null;
        checkOut = null;
        room = null;
        customer = null;
    }

    /**
     * Parameterized constructor.
     *
     * @param ID
     * @param checkIn
     * @param checkOut
     * @param room
     * @param customer
     */
    public Reservation(String ID, LocalDate checkIn, LocalDate checkOut, Room room, Customer customer) {
        this.ID = ID;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.room = room;
        this.customer = customer;
    }

    /**
     * Setter for setting the checkIn variable
     *
     * @param checkIn the value to set the checkIn variable to
     */
    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * Setter for setting the checkOut variable
     *
     * @param checkOut the value to set the checkOut variable to
     */
    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    /**
     * Setter for setting the reservation's room object
     *
     * @param room the room to be assigned to the reservation
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Setter for setting the reservation's Customer object
     *
     * @param customer the customer to be assigned to the reservation
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Getter for getting the reservation ID variable
     *
     * @return ID variable as a string of the reservation
     */
    public String getID() {
        return this.ID;
    }

    /**
     * Getter for getting the reservation's associated room object
     *
     * @return a room object
     */
    public Room getRoom() {
        return this.room;
    }

    /**
     * Getter for getting the reservation's checkIn date variable
     *
     * @return the checkIn date as a string
     */
    public String getCheckIn() {
        return checkIn.toString();
    }

    /**
     * Getter for getting the reservation's checkOut date variable
     *
     * @return the checkOut date as a string
     */
    public String getCheckOut() {
        return checkOut.toString();
    }

    /**
     * Getter for getting the customer name associated with this reservation
     *
     * @return String of customer's name
     */
    public String getCustomerName() {
        return customer.getCustomerName().replace("-", " ");
    }

    /**
     * Getter for getting the customer email associated with this reservation
     *
     * @return String of the customer's email
     */
    public String getCustomerEmail() {
        return customer.getCustomerEmail();
    }

    /**
     * Getter for getting the room number associated with this reservation
     *
     * @return SimpleIntegerProperty of the room number
     */
    public Integer getRoomNum() {
        return room.getRoomNum();
    }

    /**
     * Getter for getting the smoking availability in the room associated with
     * this reservation
     *
     * @return Boolean value representing smoking availability
     */
    public Boolean getSmoking() {
        return room.getSmoking();
    }

    /**
     * Getter for getting the number of beds in the room associated with this
     * reservation
     *
     * @return SimpleIntegerProperty of the number of beds
     */
    public Integer getNumBeds() {
        return room.getNumBeds();
    }

    /**
     * Getter for getting the number of people allowed in the room associated
     * with this reservation
     *
     * @return SimpleIntegerProperty of the number of people
     */
    public Integer getNumPeople() {
        return room.getNumPeople();
    }

    /**
     * Getter for getting the size of the room associated with this reservation
     *
     * @return SimpleIntegerProperty of the room size
     */
    public Integer getSqftSize() {
        return room.getSqftSize();
    }

    /**
     * Getter for getting the type of bed in the room associated with this
     * reservation
     *
     * @return char representing bed type
     */
    public char getBedType() {
        return room.getBedType();
    }

    /**
     * Getter for getting the room description for this reservation
     *
     * @return String description of the room
     */
    public String getDescription() {
        return room.getDescription();
    }

    /**
     * Getter for getting the room cost for this reservation
     *
     * @return integer value of the room cost in dollars
     */
    public int getCost() {
        return room.getCost();
    }

    /**
     * Getter for getting the phone number of the customer associated with this
     * reservation
     *
     * @return integer array of the phone number
     */
    public int[] getPhoneNum() {
        return customer.phoneNum;
    }

    /**
     * Getter for getting the customer's phone number
     *
     * @return String of phone number
     */
    public String getPhoneNumString() {
        String s = "";
        for (int i : customer.getPhoneNum()) {
            s += i;
        }
        return s;
    }

    /**
     * Appends reservation data to the reservations file.
     *
     * @throws IOException
     */
    public void addReservation() throws IOException {
        FileController.appendFile("src/hotel/prototype/Reservations.txt",
                this.toStringCSV() + "\n");
    }

    /**
     * Method for converting reservation data into a string
     *
     * @return String of reservation data
     */
    public String toStringCSV() {

        String row
                = ID + ","
                + checkIn + ","
                + checkOut + ","
                + room.getRoomNum() + "," + customer.customerName + ","
                + customer.customerEmail + ","
                + customer.customerAddress + "," + customer.customerZip + ",";

        for (int i : customer.cardNum) {

            row += customer.cardNum[i];

        }

        row += "," + customer.expiry + ",";

        for (int i : customer.phoneNum) {

            row += customer.phoneNum[i];

        }
        row += "," + customer.cvv;
        return row;
    }

    /**
     * method for generating a reservation ID
     *
     * @return a string
     */
    public String generateID() {
        int max = 999999;
        int min = 100000;
        String IDstr = "R" + (int) (Math.random() * (max - min) + min);
        ReservationHandler resHandler = ReservationHandler.resHandler;
        resHandler.fillReservationList(readFile("src/hotel/prototype/Reservations.txt"));
        ArrayList<Reservation> reservations = resHandler.reservationList;

        if (isDuplicate(IDstr, reservations)) {
            return generateID();
        } else {
            return IDstr;
        }
    }
    /**
     * Checks to see if an ID is in use already
     * @param ID ID to search for
     * @param reservations list of all reservations
     * @return Boolean of true if ID is a duplicate, false otherwise
     */
    private boolean isDuplicate(String ID, ArrayList<Reservation> reservations) {
        for (Reservation r : reservations) {
            if (r.ID.equals(ID)) {
                return true;
            }
        }
        return false;
    }
}
