package hotel.prototype;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Reservation class object. Stores ID, Check in/out date, room associated, and 
 * the customer associated.
 * @author K.Maki
 */
public final class Reservation {
    protected String ID;
    protected LocalDate checkIn;
    protected LocalDate checkOut;
    protected Room room;
    protected Customer customer;
    
    /**
     * Default constructor.
     */
    public Reservation(){
        ID = this.generateID();
        checkIn = null;
        checkOut = null;
        room = null;
        customer = null;
    }
    
    /**
     * Parameterized constructor.
     * @param ID
     * @param checkIn
     * @param checkOut
     * @param room 
     * @param customer
     */
    public Reservation(String ID, LocalDate checkIn, LocalDate checkOut, Room room, Customer customer){
        this.ID = ID;
        this.checkIn = checkIn;
        this.checkOut= checkOut;
        this.room = room;
        this.customer = customer;
    }
    
    public void setCheckIn(LocalDate checkIn){
        this.checkIn = checkIn;
    }
    
    public void setCheckOut(LocalDate checkOut){
        this.checkOut = checkOut;
    }
    
    public void setRoom(Room room){
        this.room = room;
    }
    
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    
    public String getID(){
        return this.ID;
    }
    
    public Room getRoom(){
        return this.room;
    }
    
    public String getCheckIn(){
        return checkIn.toString();
    }
    
    public String getCheckOut(){
        return checkIn.toString();
    }
    
    /**
     * Appends reservation data to the reservations file.
     * @throws IOException 
     */
    public void addReservation() throws IOException{
        FileController.appendFile("src/hotel/prototype/Reservations.csv",
                "\n" + this.toStringCSV()); 
    }
    
    public String toStringCSV(){
        String row = 
                    ID + "," + 
                    checkIn + "," + 
                    checkOut + "," +
                    room.getRoomNum() + "," + 
                    room.getSmoking() + "," +
                    room.getNumBeds() + "," +
                    room.getNumPeople() + "," + 
                    room.getSqftSize() + "," + 
                    room.getBedType() + "," +
                    room.getDescription() + "," +
                    customer.getCustomerName() + "," +
                    customer.getCustomerEmail();
        
        return row;
    }
    
    public String generateID(){
        int max = 999999;
        int min = 100000;
        return "R" + (int)(Math.random() * (max - min) + min);
    }
}