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
     * Fills reservationList array with reservations from a given ArrayList
     * of strings
     * @param reservationLineData 
     */
    private void fillReservationList(ArrayList<String> reservationLineData){
        String ID;
        LocalDate checkIn, checkOut;
        Room room = null;
        String[] lineData;
        
        for(int i = 0; i < reservationLineData.size();i++){
            lineData = reservationLineData.get(i).split(",");
            
            ID = lineData[0];
            checkIn = LocalDate.parse(lineData[1]);
            checkOut = LocalDate.parse(lineData[2]);
            //Find room and set to room variable
            
            reservationList.add(new Reservation(ID,checkIn,checkOut,room));
        }
    }
    
    private void changeResDate() { 

}
    
    private void findReservation() { 
        
    }
    
}

