package hotel.prototype;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Johnathan, Keaton
 */
public class Room {
    public SimpleIntegerProperty roomNum;
    public SimpleBooleanProperty smoking;
    public SimpleIntegerProperty numBeds;
    public SimpleIntegerProperty numPeople;
    public SimpleIntegerProperty sqftSize;
    public SimpleStringProperty description;
    public char bedType;

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
     * @param roomNum
     * @param smoking
     * @param numBeds
     * @param numPeople
     * @param sqftSize
     * @param bedType
     * @param description 
     */
    public Room(int roomNum, boolean smoking, int numBeds, int numPeople, int sqftSize, char bedType, String description) {
        this.roomNum = new SimpleIntegerProperty(roomNum);
        this.smoking = new SimpleBooleanProperty(smoking);
        this.numBeds = new SimpleIntegerProperty(numBeds);
        this.numPeople = new SimpleIntegerProperty(numPeople);
        this.sqftSize = new SimpleIntegerProperty(sqftSize);
        this.bedType = bedType;
        this.description = new SimpleStringProperty(description);
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
        sb.append(description.get());
        
        return sb.toString();
    }

    public Integer getRoomNum() {
        return roomNum.get();
    }

    public Boolean getSmoking() {
        return smoking.get();
    }

    public Integer getNumBeds() {
        return numBeds.get();
    }

    public Integer getNumPeople() {
        return numPeople.get();
    }

    public Integer getSqftSize() {
        return sqftSize.get();
    }

    public char getBedType() {
        return bedType;
    }

    public String getDescription() {
        return description.get();
    }
    
}
