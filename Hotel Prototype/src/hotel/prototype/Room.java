package hotel.prototype;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Object class representing the hotel rooms
 * @author Jonathan, Keaton
 */
public class Room {

    /**
     *  The room number of room
     */
    public SimpleIntegerProperty roomNum;

    /**
     *  Whether smoking is allowed in the room
     */
    public SimpleBooleanProperty smoking;

    /**
     *  number of beds in the room
     */
    public SimpleIntegerProperty numBeds;

    /**
     * max occupancy of the room
     */
    public SimpleIntegerProperty numPeople;

    /**
     * size of the room in square feet
     */
    public SimpleIntegerProperty sqftSize;

    /**
     * description of the room
     */
    public SimpleStringProperty description;

    /**
     * type of beds in the room
     */
    public char bedType;
    
    public SimpleIntegerProperty cost;

    /**
     * Default constructor
     */
    public Room() {
        roomNum = new SimpleIntegerProperty(0);
        smoking = new SimpleBooleanProperty(false);
        numBeds = new SimpleIntegerProperty(1);
        numPeople = new SimpleIntegerProperty(1);
        sqftSize = new SimpleIntegerProperty(200);
        bedType = 'Q';
        description = new SimpleStringProperty("Basic room");
    }
    
    /**
     * Parameterized constructor
     * @param roomNum The number of the room
     * @param smoking Whether smoking is allowed or not in the room
     * @param numBeds How many beds are in the room
     * @param numPeople max occupancy of the room
     * @param sqftSize The size of the room in square footage
     * @param bedType The size of the beds (king,queen,twin)
     * @param description A general description of the room
     */
    public Room(int roomNum, boolean smoking, int numBeds, int numPeople, int sqftSize, char bedType, String description,int cost) {
        this.roomNum = new SimpleIntegerProperty(roomNum);
        this.smoking = new SimpleBooleanProperty(smoking);
        this.numBeds = new SimpleIntegerProperty(numBeds);
        this.numPeople = new SimpleIntegerProperty(numPeople);
        this.sqftSize = new SimpleIntegerProperty(sqftSize);
        this.bedType = bedType;
        this.description = new SimpleStringProperty(description);
        this.cost = new SimpleIntegerProperty(cost);
    }
    
    /**
     * Creates string of room properties separated by commas
     * @return Comma separated string
     */
    public String toStringCSV(){
        StringBuilder sb = new StringBuilder();
        
        sb.append(roomNum.get()).append(",");
        sb.append(smoking.get()).append(",");
        sb.append(numBeds.get()).append(",");
        sb.append(numPeople.get()).append(",");
        sb.append(sqftSize.get()).append(",");
        sb.append(bedType).append(",");
        sb.append(description.get()).append(",");
        sb.append(cost.get());
        
        return sb.toString();
    }
    
    /**
     * Getter method for getting the roomNumber
     * @return the room object's room number
     */
    public Integer getRoomNum() {
        return roomNum.get();
    }
    
    /**
     * Getter method for getting the smoking status of the room
     * @return Boolean value representing smoking status in room
     */
    public Boolean getSmoking() {
        return smoking.get();
    }
    
    /**
     * Getter method for getting the number of beds in the room
     * @return an integer value representing number of beds in room
     */
    public Integer getNumBeds() {
        return numBeds.get();
    }
    
    /**
     * Getter method for getting the max occupancy of the room
     * @return integer value representing max occupancy of room
     */
    public Integer getNumPeople() {
        return numPeople.get();
    }
    
    /**
     * Getter method for getting the size of the room in square footage
     * @return integer value representing the room size
     */
    public Integer getSqftSize() {
        return sqftSize.get();
    }
    
    /**
     * Getter method for getting the bed type in the room
     * @return Char value representing bed type (k,q,t)
     */
    public char getBedType() {
        return bedType;
    }

    /**
     * Getter method for getting the description of the room
     * @return String of the description
     */
    public String getDescription() {
        return description.get();
    }
    
    public Integer getCost(){
        return cost.get();
    }
    
}
