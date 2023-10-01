/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.prototype;

import java.time.LocalDate;

/**
 *
 * @author keato
 */
public class Reservation {
    
    private String ID;
    private LocalDate checkIn,checkOut;
    private Room room;
    
    //private Customer customer;
    
    public Reservation(){
        ID = null;
        checkIn = null;
        checkOut = null;
        room = null;
    }
    
    public void setID(String newID){
        ID = newID;
    }
    
    public void setCheckIn(LocalDate newDate){
        checkIn = newDate;
    }
    
    public void setCheckOut(LocalDate newDate){
        checkOut = newDate;
    }
    
    public void setRoom(Room newRoom){
        room = newRoom;
    }
}
