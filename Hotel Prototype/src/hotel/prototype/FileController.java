/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.prototype;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jonathan
 */
public class FileController {

    //private static String roomsFile = "rooms.txt";
    public static ArrayList readRoomFile(String fileName) {
        String fileData;
        String[] dataArr = null;
        ArrayList<Room> roomList = new ArrayList<Room>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            while ((fileData = br.readLine()) != null) {
                dataArr = fileData.split(",");

                roomList.add(new Room(Integer.parseInt(dataArr[0]),
                        booleanParser(dataArr[1]),
                        integerParser(dataArr[2]),
                        integerParser(dataArr[3]),
                        integerParser(dataArr[4]),
                        dataArr[5].charAt(0),
                        dataArr[6]));

            }
            br.close();
            fr.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return roomList;
    }

    public static void writeToFile(String fileName) {

    }

    public static void appendFile(String fileName, String data) throws IOException {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.append(data);
            fw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static int integerParser(String stringData) {
        try {
            return Integer.parseInt(stringData);
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }

    public static boolean booleanParser(String stringData) {
        if(stringData != null){
        return Boolean.parseBoolean(stringData);
        } else {
            return false;
        }
    }
}
