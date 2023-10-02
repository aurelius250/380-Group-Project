package hotel.prototype;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author jon01
 */
public class Room {
    private int roomNum;
    private boolean smoking;
    private int numBeds;
    private int numPeople;
    private int sqftSize;
    private char bedType;
    private String description;

    public Room() {
        roomNum = 0;
        smoking = false;
        numBeds = 1;
        numPeople = 1;
        sqftSize = 200;
        bedType = 'Q';
        description = "Basic room";
    }

    public Room(int roomNum, boolean smoking, int numBeds, int numPeople, int sqftSize, char bedType, String description) {
        this.roomNum = roomNum;
        this.smoking = smoking;
        this.numBeds = numBeds;
        this.numPeople = numPeople;
        this.sqftSize = sqftSize;
        this.bedType = bedType;
        this.description = description;
    }
}
