/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.prototype;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Jonathan
 */
public class FileController {

    private static String roomsFile = "rooms.txt";

    public static void readRoomsFile() {
        String roomData;
        try {
            FileReader fr = new FileReader(roomsFile);
            BufferedReader br = new BufferedReader(fr);
            while ((roomData = br.readLine()) != null) {
                for (int i = 0; i < roomData.length(); i++) {
                    /*Read the string and seperate each piece of information by 
                comma and assign to room class values appropriately.*/
                }
            }
            br.close();
            fr.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void writeToRoomsFile() {
    }
}
