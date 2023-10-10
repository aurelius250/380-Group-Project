/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.prototype;

import java.util.ArrayList;
import java.time.LocalDate;
/**
 *
 * @author tomc
 */
public class ReservationHandler {
    protected ArrayList reservationList;
    
    /**
     * fills reservationList array with reservations from a given ArrayList
     * of strings
     * @param reservationLineData 
     */
    private void fillReservationList(ArrayList<String> reservationLineData){
        String id;
        LocalDate checkIn, checkOut;
        Room room = null;
        String[] data;
        for(int i = 0; i < reservationLineData.size();i++){
            data = reservationLineData.get(i).split(",");
            
            id = data[0];
            checkIn = LocalDate.parse(data[1]);
            checkOut = LocalDate.parse(data[2]);
            //find room and set to room variable
            
            reservationList.add(new Reservation(id,checkIn,checkOut,room));
        }
    }
    
    private void changeResDate() { 

}
    private void findReservation() { 
        
    }
    
}

