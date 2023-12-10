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

    public String getCustomerName() {
        return customer.getCustomerName();
    }

    public String getCustomerEmail() {
        return customer.getCustomerEmail();
    }

    public Integer getRoomNum() {
        return room.getRoomNum();
    }

    public Boolean getSmoking() {
        return room.getSmoking();
    }

    public Integer getNumBeds() {
        return room.getNumBeds();
    }

    public Integer getNumPeople() {
        return room.getNumPeople();
    }

    public Integer getSqftSize() {
        return room.getSqftSize();
    }

    public char getBedType() {
        return room.getBedType();
    }

    public String getDescription() {
        return room.getDescription();
    }

    /**
     * Appends reservation data to the reservations file.
     *
     * @throws IOException
     */
    public void addReservation() throws IOException {
        FileController.appendFile("src/hotel/prototype/Reservations.txt",
                "\n" + this.toStringCSV());
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

    private boolean isDuplicate(String ID, ArrayList<Reservation> reservations) {
        for (Reservation r : reservations) {
            if (r.ID.equals(ID)) {
                return true;
            }
        }
        return false;
    }
}
