/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.prototype;

import static hotel.prototype.FileController.booleanParser;
import static hotel.prototype.FileController.integerParser;
import java.util.ArrayList;
import java.time.LocalDate;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * ReservationHandler holds and creates ArrayLists of room and reservation
 * objects for use during run-time
 * @author tomc , Jonathan
 */
public class ReservationHandler {

    protected ArrayList reservationList;
    protected ArrayList<Room> roomList;
    
    /** 
     * default constructor
     */
     public ReservationHandler() {
        reservationList = new ArrayList();
        roomList = new ArrayList();
    }

    /**
     * Fills reservationList array with reservations from a given ArrayList of
     * strings
     *
     * @param reservationLineData ArrayList of lines gained from text file as strings
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
            checkIn = LocalDate.parse(lineData[1]);
            checkOut = LocalDate.parse(lineData[2]);
            room = findRoom(integerParser(lineData[3]));
            //TODO get customer data

            reservationList.add(new Reservation(ID, checkIn, checkOut, room, customer));
        }
    }
    /**
     * Fills roomList array with room objects using data from a given ArrayList of
     * strings
     * @param roomLineData ArrayList of lines gained from text file as strings 
     */
    public void fillRoomList(ArrayList<String> roomLineData) {
        int roomNum, numBeds, numPeople, sqftSize;
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
            
            roomList.add(new Room(roomNum,
                        smoking,
                        numBeds,
                        numPeople,
                        sqftSize,
                        bedType,
                        description));
        }
        
        System.out.println("success");
    }
    
    /**
     * Method for finding a specific room within an ArrayList based on room number
     * @param roomToFind The Room number of the room to be searched for
     * @return The Room that is found within the ArrayList or null if not found
     */
    public Room findRoom(int roomToFind) {
        if (roomList == null) {
            return null;
        }

        for (Room r : roomList) {
            if (r.roomNum == new SimpleIntegerProperty(roomToFind)) {
                return r;
            }
        }
        
        return null;
    }
    
    /**
     * Method for checking if the reservationsList is empty or not
     * @return true if the list is empty and false if it contains any objects
     */
    public boolean isReservationsEmpty(){
        if(reservationList == null){
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Method for checking if the reservationsList is empty or not
     * @return true if the list is empty and false if it contains any objects
     */
    public boolean isRoomsEmpty(){
        if(roomList == null){
            return true;
        }
        else {
            return false;
        }
    }
    
}
