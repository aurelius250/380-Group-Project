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
    private String desc;

    public Room() {
        roomNum = 0;
        smoking = false;
        numBeds = 1;
        numPeople = 1;
        sqftSize = 200;
        bedType = 'Q';
        desc = "Basic room";
    }

    public Room(int i,boolean a, int b, int c, int d, char e, String f) {
        roomNum = i;
        smoking = a;
        numBeds = b;
        numPeople = c;
        sqftSize = d;
        bedType = e;
        desc = f;
    }
}
