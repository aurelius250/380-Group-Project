/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.prototype;

import static hotel.prototype.FileController.booleanParser;
import static hotel.prototype.FileController.integerParser;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author tomc
 */
public class ReservationHandler {

    protected ArrayList reservationList;
    protected ArrayList roomList;

    /**
     * Fills reservationList array with reservations from a given ArrayList of
     * strings
     *
     * @param reservationLineData
     */
    private void fillReservationList(ArrayList<String> reservationLineData) {
        String ID;
        LocalDate checkIn, checkOut;
        Room room = null;
        String[] lineData;

        for (int i = 0; i < reservationLineData.size(); i++) {
            lineData = reservationLineData.get(i).split(",");

            ID = lineData[0];
            checkIn = LocalDate.parse(lineData[1]);
            checkOut = LocalDate.parse(lineData[2]);
            //Find room and set to room variable

            reservationList.add(new Reservation(ID, checkIn, checkOut, room));
        }
    }

    private void fillRoomList(ArrayList<String> roomLineData) {
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
    }

    private void changeResDate() {

    }

    private void findReservation() {

    }

}
