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

                roomList.add(new Room(integerParser(dataArr[0]),
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
    
    public static ArrayList readCustomerFile(String fileName) {
        String fileData;
        String[] dataArr = null;
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        ArrayList<Integer> reservationIDs = new ArrayList<Integer>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            while ((fileData = br.readLine()) != null) {
                dataArr = fileData.split(",");
                
                for(int i = 2; i<dataArr.length;i++){
                    reservationIDs.add(integerParser(dataArr[i]));
                }
                
                customerList.add(new Customer(dataArr[0],dataArr[1],reservationIDs));
            }
            br.close();
            fr.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return customerList;
    }

    public static ArrayList readReservationFile(String fileName) {
        String fileData;
        String[] dataArr = null;
        ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            while ((fileData = br.readLine()) != null) {
                dataArr = fileData.split(",");

                reservationList.add(new Reservation(dataArr[0],
                         dateParser(dataArr[1]),
                         dateParser(dataArr[2]),
                         new Room()/*integerParser(dataArr[4]))*/));

            }
            br.close();
            fr.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return reservationList;
    }

    public static void writeToFile(String fileName) {

    }

    public static Room findRoom(ArrayList<Room> roomList, int roomToFind) {
        if (roomList == null) {
            return null;
        }

        for (Room r : roomList) {
            if (r.roomNum == roomToFind) {
                return r;
            }
        }
        return null;
    }

    public static void replaceRoomLine(Room room, String fileName) {
        /* figured we may need code to find and replace a single line in the
        text file at will
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
                if (integerParser(dataArr[0]) == room.roomNum){
                    
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
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
        if (stringData != null) {
            return Boolean.parseBoolean(stringData);
        } else {
            return false;
        }
    }

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
