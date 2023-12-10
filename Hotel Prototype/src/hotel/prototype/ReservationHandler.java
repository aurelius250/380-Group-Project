/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.prototype;

import static hotel.prototype.FileController.booleanParser;
import static hotel.prototype.FileController.integerParser;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * ReservationHandler holds and creates ArrayLists of room and reservation
 * objects for use during run-time
 *
 * @author tomc , Jonathan
 */
public class ReservationHandler {

    protected Customer user;

    /**
     * ArrayList of Reservation objects
     */
    protected ArrayList<Reservation> reservationList;

    /**
     * ArrayList of room objects
     */
    protected ArrayList<Room> roomList;

    public static ReservationHandler resHandler = new ReservationHandler();

    /**
     * default constructor
     */
    public ReservationHandler() {
        reservationList = new ArrayList<Reservation>();
        roomList = new ArrayList<Room>();
        user = null;
    }

    /**
     * Fills reservationList array with reservations from a given ArrayList of
     * strings
     *
     * @param reservationLineData ArrayList of lines gained from text file as
     * strings
     */
//    public void fillReservationList(ArrayList<String> reservationLineData) {
//        String ID;
//        LocalDate checkIn, checkOut;
//        Room room = null;
//        Customer customer = null;
//        String[] lineData;
//
//        for (int i = 0; i < reservationLineData.size(); i++) {
//            lineData = reservationLineData.get(i).split(",");
//
//            ID = lineData[0];
//            checkIn = LocalDate.parse(lineData[1]);
//            checkOut = LocalDate.parse(lineData[2]);
//            room = findRoom(integerParser(lineData[3]));
//            //TODO get customer data
//
//            reservationList.add(new Reservation(ID, checkIn, checkOut, room, customer));
//        }
//    }
    /**
     * Fills reservationList array with reservations from a given ArrayList of
     * strings
     *
     * @param reservationLineData ArrayList of lines gained from text file as
     * strings
     */
    public void fillReservationList(ArrayList<String> reservationLineData) {
        String ID;
        LocalDate checkIn, checkOut;
        Room room = null;
        Customer customer = null;
        String[] lineData;

        for (int i = 0; i < reservationLineData.size(); i++) {
            lineData = reservationLineData.get(i).split(",");

            ID = lineData[0];
            checkIn = parseLocalDate(lineData[1]);
            checkOut = parseLocalDate(lineData[2]);
            room = findRoom(integerParser(lineData[3]));
            customer = new Customer();
            customer.customerName = lineData[4];
            customer.customerEmail = lineData[5];
            customer.customerAddress = lineData[6];
            customer.customerZip = integerParser(lineData[7]);
            for(int x = 0; x < lineData[8].length();x++){
                customer.cardNum[x]=integerParser(lineData[8].charAt(x));
            }
            customer.expiry = lineData[9];
            for(int x = 0; x < lineData[10].length();x++){
                customer.phoneNum[x]=integerParser(lineData[10].charAt(x));
            }
            customer.cvv = integerParser(lineData[11]);
            reservationList.add(new Reservation(ID, checkIn, checkOut, room, customer));
        }
    }

    public void SetToUserReservations() {
        ArrayList<Reservation> temp = new ArrayList<Reservation>();
        for (int i = 0; i < reservationList.size(); i++) {
            for (int x = 0; x < user.reservationIDs.size(); x++) {
                if (x < reservationList.size() && reservationList.get(i).getID().equals(user.reservationIDs.get(x))) {
                    temp.add(reservationList.get(i));
                }
            }
        }
        reservationList = temp;
    }
    private LocalDate parseLocalDate(String dateString) {
        if (dateString != null && !dateString.trim().isEmpty()) {
            try {
                return LocalDate.parse(dateString);
            } catch (DateTimeParseException e) {
                // Handle parsing error, e.g., log the error or provide a default date
                System.err.println("Error parsing date: " + dateString);
            }
        }
        // Return a default date or handle null case based on your requirements
        return LocalDate.now(); // Replace with your default date or handling logic
    }

    /**
     * Fills roomList array with room objects using data from a given ArrayList
     * of strings
     *
     * @param roomLineData ArrayList of lines gained from text file as strings
     */
    public void fillRoomList(ArrayList<String> roomLineData) {
        int roomNum, numBeds, numPeople, sqftSize,cost;
        boolean smoking;
        char bedType;
        String description;
        String[] lineData;

        for (int i = 0; i < roomLineData.size(); i++) {
            lineData = roomLineData.get(i).split(",");

            roomNum = integerParser(lineData[0]);
            smoking = booleanParser(lineData[1]);
            numBeds = integerParser(lineData[2]);
            numPeople = integerParser(lineData[3]);
            sqftSize = integerParser(lineData[4]);
            bedType = lineData[5].charAt(0);
            description = lineData[6];
            cost = integerParser(lineData[7]);

            roomList.add(new Room(roomNum,
                    smoking,
                    numBeds,
                    numPeople,
                    sqftSize,
                    bedType,
                    description,cost));
        }

    }

    /**
     * Method for finding a specific room within an ArrayList based on room
     * number
     *
     * @param roomToFind The Room number of the room to be searched for
     * @return The Room that is found within the ArrayList or null if not found
     */
    public Room findRoom(int roomToFind) {
        if (roomList == null) {
            return null;
        }

        for (Room r : roomList) {
            if (r.roomNum.intValue() == roomToFind) {
                return r;
            }
        }

        return null;
    }

    public Reservation findReservation(String id) {
        if (reservationList == null) {
            return null;
        }

        for (Reservation r : reservationList) {
            if (r.ID.contentEquals(id)) {
                return r;
            }
        }

        return null;
    }

    public Customer getUser() {
        return user;
    }

    public void setUser(Customer user) {
        this.user = user;
    }

    /**
     * Method for checking if the reservationsList is empty or not
     *
     * @return true if the list is empty and false if it contains any objects
     */
    public boolean isReservationsEmpty() {
        return reservationList.isEmpty();
    }

    /**
     * Method for checking if the reservationsList is empty or not
     *
     * @return true if the list is empty and false if it contains any objects
     */
    public boolean isRoomsEmpty() {
        return roomList.isEmpty();
    }

    /**
     * Adds a given reservation to the reservation ArrayList
     *
     * @param r the reservation to be added
     */
    public void addReservationToList(Reservation r) {
        reservationList.add(r);
    }

    /**
     * Adds a given room to the room ArrayList
     *
     * @param r The room to be added
     */
    public void addRoomToList(Room r) {
        roomList.add(r);
    }

    /**
     * removes a given reservation from the reservation ArrayList
     *
     * @param r The reservation to be removed
     */
    public void removeListedReservation(Reservation r) {
        reservationList.remove(r);
    }

    /**
     * removes a given room from the room ArrayList
     *
     * @param r The room to be removed
     */
    public void removeListedRoom(Room r) {
        roomList.remove(r);
    }
}
