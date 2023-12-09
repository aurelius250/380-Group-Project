/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package hotel.prototype;

import static hotel.prototype.FileController.findAndAdd;
import static hotel.prototype.FileController.replaceLine;
import java.util.ArrayList;

/**
 *
 * @author Jonathan
 */
public class FileControllerTest {
    
    public FileControllerTest() {
    }
    
    public static void main(String[] args) {
        testToAddToLine();
    }
    

    /**
     * Test of readFile method, of class FileController.
     */
    public static void testReadFile() {
        System.out.println("readFile");
        String fileName = "src/hotel/prototype/Customers.txt";
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Jonathan,email@email.com,password,");
        expResult.add("test,test@email.com,test,R863020");
        expResult.add("joke,joke@email.com,joke,R842168");
        expResult.add("easy,easy@email.com,easy,");
        ArrayList<String> result = FileController.readFile(fileName);
        Boolean test;
        
        if(result.equals(expResult)){
            System.out.println("Success");
            test = true;
        } else {
            System.out.println("Failure");
            test = false;
        }
        
        System.out.println("Expected: " + true);
        System.out.println("Actual: " + test);    
    }
    
    public static void testReplaceLine(){
        replaceLine("src/hotel/prototype/Customers.txt","false,Jonathan,email@email.com,password,Success","false,Jonathan,email@email.com,password,");
    }
    
    public static void testToAddToLine(){
        findAndAdd("src/hotel/prototype/Customers.txt",",success","false,Jonathan,email@email.com,password");
    }
}