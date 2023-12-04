/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package hotel.prototype;

import static hotel.prototype.FileController.readFile;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Jonathan
 */
public class ReservationHandlerTest {
    
    public ReservationHandlerTest() {
    }
    
    public static void main(String[] args) {
        testFillRoomList();
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of fillReservationList method, of class ReservationHandler.
     */
    public void testFillReservationList() {
        System.out.println("fillReservationList");
        ArrayList<String> reservationLineData = null;
        ReservationHandler instance = new ReservationHandler();
        instance.fillReservationList(reservationLineData);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillRoomList method, of class ReservationHandler.
     */
    public static void testFillRoomList() {
        System.out.println("fillRoomList");
        ArrayList<String> roomLineData = readFile("src/hotel/prototype/Rooms.txt");
        ReservationHandler instance = new ReservationHandler();
        instance.fillRoomList(roomLineData);
        ArrayList<Room> expResult = new ArrayList<Room>();
        Boolean test;
        
        expResult.add(new Room(101,true,1,1,100,'S',"Cheap Room"));
        expResult.add(new Room(201,false,2,2,200,'K',"Medium Room" ));
        expResult.add(new Room(401,true,3,4,0,'Q',"Best Room"));
        
        if(expResult.get(0).toStringCSV().equals(instance.roomList.get(0).toStringCSV())){
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
        
        System.out.println("Expected: " + expResult.get(0).toStringCSV());
        System.out.println("Actual: " + instance.roomList.get(0).toStringCSV()); 
    }

    /**
     * Test of findRoom method, of class ReservationHandler.
     */
    @Test
    public void testFindRoom() {
        System.out.println("findRoom");
        int roomToFind = 0;
        ReservationHandler instance = new ReservationHandler();
        Room expResult = null;
        Room result = instance.findRoom(roomToFind);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findReservation method, of class ReservationHandler.
     */
    @Test
    public void testFindReservation() {
        System.out.println("findReservation");
        String id = "";
        ReservationHandler instance = new ReservationHandler();
        Reservation expResult = null;
        Reservation result = instance.findReservation(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class ReservationHandler.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        ReservationHandler instance = new ReservationHandler();
        Customer expResult = null;
        Customer result = instance.getUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class ReservationHandler.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        Customer user = null;
        ReservationHandler instance = new ReservationHandler();
        instance.setUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isReservationsEmpty method, of class ReservationHandler.
     */
    @Test
    public void testIsReservationsEmpty() {
        System.out.println("isReservationsEmpty");
        ReservationHandler instance = new ReservationHandler();
        boolean expResult = false;
        boolean result = instance.isReservationsEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isRoomsEmpty method, of class ReservationHandler.
     */
    @Test
    public void testIsRoomsEmpty() {
        System.out.println("isRoomsEmpty");
        ReservationHandler instance = new ReservationHandler();
        boolean expResult = false;
        boolean result = instance.isRoomsEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addReservationToList method, of class ReservationHandler.
     */
    @Test
    public void testAddReservationToList() {
        System.out.println("addReservationToList");
        Reservation r = null;
        ReservationHandler instance = new ReservationHandler();
        instance.addReservationToList(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRoomToList method, of class ReservationHandler.
     */
    @Test
    public void testAddRoomToList() {
        System.out.println("addRoomToList");
        Room r = null;
        ReservationHandler instance = new ReservationHandler();
        instance.addRoomToList(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeListedReservation method, of class ReservationHandler.
     */
    @Test
    public void testRemoveListedReservation() {
        System.out.println("removeListedReservation");
        Reservation r = null;
        ReservationHandler instance = new ReservationHandler();
        instance.removeListedReservation(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeListedRoom method, of class ReservationHandler.
     */
    @Test
    public void testRemoveListedRoom() {
        System.out.println("removeListedRoom");
        Room r = null;
        ReservationHandler instance = new ReservationHandler();
        instance.removeListedRoom(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
