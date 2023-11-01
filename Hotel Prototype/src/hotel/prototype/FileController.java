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
import java.time.LocalDate;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Jonathan
 */
public class FileController {
    //private static String roomsFile = "rooms.txt";
    /**
     * Reads from a text file and generates an ArrayList of strings of the whole
     * unbroken line from the text file
     * @param fileName name of the text file to be read from
     * @return An ArrayList of room objects
     */
    public static ArrayList readFile(String fileName){
        String fileData;
        String[] dataArr = null;
        ArrayList<String> list = new ArrayList<String>();
        
        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            
            while ((fileData = br.readLine()) != null){
                list.add(fileData);
            }
            
            br.close();
            fr.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * Reads from a text file and generates an ArrayList of room objects from the file
     * @param fileName name of the text file to be read from
     * @return An ArrayList of room objects
     */
    public static ArrayList readRoomFile(String fileName) {
        String fileData;
        String[] dataArr = null;
        ArrayList<Room> roomList = new ArrayList<Room>();
        int roomNum,numBeds,numPeople,sqftSize;
        boolean smoking;
        char bedType;
        String description;
        
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            
            while ((fileData = br.readLine()) != null) {
                dataArr = fileData.split(",");
                roomNum = integerParser(dataArr[0]);
                smoking = booleanParser(dataArr[1]);
                numBeds = integerParser(dataArr[2]);
                numPeople = integerParser(dataArr[3]);
                sqftSize = integerParser(dataArr[4]);
                bedType = dataArr[5].charAt(0);
                description = dataArr[6];
                        
                roomList.add(new Room(roomNum,
                        smoking,
                        numBeds,
                        numPeople,
                        sqftSize,
                        bedType,
                        description));

            }
            
            br.close();
            fr.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        return roomList;
    }
    
    /**
     * Reads from a file and generates an ArrayList of Customer objects from the file
     * @param fileName name of the text file to be read from
     * @return an ArrayList of Customer objects
     */
    public static ArrayList readCustomerFile(String fileName) {
        String customerName,customerEmail;
        String fileData;
        String[] dataArr = null;
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        ArrayList<Integer> reservationIDs = new ArrayList<Integer>();
        
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            
            while ((fileData = br.readLine()) != null) {
                dataArr = fileData.split(",");
                customerName = dataArr[0];
                customerEmail= dataArr[1];
                
                for(int i = 2; i<dataArr.length;i++){
                    reservationIDs.add(integerParser(dataArr[i]));
                }
                
                customerList.add(new Customer(customerName,customerEmail,reservationIDs));
            }
            
            br.close();
            fr.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        return customerList;
    }
    
    /**
     * Reads from a file and generates an ArrayList of Reservation objects from
     * the file
     * @param fileName name of the text file to be read from
     * @return an ArrayList of Reservation objects
     */
    public static ArrayList readReservationFile(String fileName) {
        String fileData,reservationID;
        LocalDate checkIn, checkOut;
        String[] dataArr = null;
        ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
        
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            
            while ((fileData = br.readLine()) != null) {
                dataArr = fileData.split(",");
                
                reservationID = dataArr[0];
                checkIn = dateParser(dataArr[1]);
                checkOut = dateParser(dataArr[2]);

                reservationList.add(new Reservation(reservationID,
                         checkIn,
                         checkOut,
                         new Room()/*integerParser(dataArr[4]))*/));

            }
            
            br.close();
            fr.close();
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        return reservationList;
    }

    
    
    /**
     * Method for replacing a line in text file with new or updated Room object
     * data
     * @param room The Room object to pull data from
     * @param fileName The name of the text file to write to
     */
    public static void replaceRoomLine(Room room, String fileName) {
        /* Figured we may need code to find and replace a single line in the
        text file at will.
         */
        String fileData;
        String[] dataArr;
        String currentRoomData = room.roomNum + "," + room.smoking + "," 
                + room.numBeds + "," + room.numPeople + "," + room.sqftSize 
                + "," + room.bedType + "," + room.description;
        
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            
            while ((fileData = br.readLine()) != null){
                dataArr = fileData.split(",");
                if (new SimpleIntegerProperty(integerParser(dataArr[0])) == room.roomNum){
                    
                }
                
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    /**
    * Method for appending string data to lines in a text file
    * @param fileName The name of the file to have text added to
    * @param data The string data of the text to be added to the file
    * @throws IOException 
    */
    public static void appendFile(String fileName, String data) throws IOException {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.append(data);
            fw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    /**
     * Method for converting string data to integer data
     * @param stringData The string to be converted to an integer
     * @return The integer value of the converted string
     */
    public static int integerParser(String stringData) {
        try {
            return Integer.parseInt(stringData);
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }
    
    /**
     * Method for converting string data to Boolean data
     * @param stringData The string to be converted to an integer
     * @return The Boolean value of the converted string
     */
    public static boolean booleanParser(String stringData) {
        if (stringData != null) {
            return Boolean.parseBoolean(stringData);
        } else {
            return false;
        }
    }
    
    /**
     * Method for converting string data to data of the LocalDate type
     * @param stringData The string to be converted to the LocalDate type
     * @return The LocalDate equivalent of the converted string
     */
    public static LocalDate dateParser(String stringData) {
        LocalDate localDate;
        if (stringData != null) {
            localDate = LocalDate.parse(stringData);
            return localDate;
        } else {
            return null;
        }
    }
}
