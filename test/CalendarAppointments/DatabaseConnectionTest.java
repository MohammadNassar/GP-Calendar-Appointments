/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CalendarAppointments;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hp
 */
public class DatabaseConnectionTest {
    
    public DatabaseConnectionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRecords method, of class DatabaseConnection.
     */
    @Test
    public void testGetRecords() {
        System.out.println("getRecords");
        String instruction = "";
        DatabaseConnection instance = new DatabaseConnection();
        String[][] expResult = null;
        String[][] result = instance.getRecords(instruction);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOneColumnFromTable method, of class DatabaseConnection.
     */
    @Test
    public void testGetOneColumnFromTable() {
        System.out.println("getOneColumnFromTable");
        String instruction = "";
        DatabaseConnection instance = new DatabaseConnection();
        String[] expResult = null;
        String[] result = instance.getOneColumnFromTable(instruction);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimesFromDoctorsandnurses method, of class DatabaseConnection.
     */
    @Test
    public void testGetTimesFromDoctorsandnurses() {
        System.out.println("getTimesFromDoctorsandnurses");
        String name = "";
        String date = "";
        DatabaseConnection instance = new DatabaseConnection();
        String[] expResult = null;
        String[] result = instance.getTimesFromDoctorsandnurses(name, date);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNamesFromDoctorsandnurses method, of class DatabaseConnection.
     */
    @Test
    public void testGetNamesFromDoctorsandnurses() {
        System.out.println("getNamesFromDoctorsandnurses");
        String name = "";
        DatabaseConnection instance = new DatabaseConnection();
        String[] expResult = null;
        String[] result = instance.getNamesFromDoctorsandnurses(name);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecordsNoGUI method, of class DatabaseConnection.
     */
    @Test
    public void testGetRecordsNoGUI() {
        System.out.println("getRecordsNoGUI");
        String instruction = "";
        DatabaseConnection instance = new DatabaseConnection();
        instance.getRecordsNoGUI(instruction);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRecords method, of class DatabaseConnection.
     */
    @Test
    public void testAddRecords() {
        System.out.println("addRecords");
        String instruction = "";
        DatabaseConnection instance = new DatabaseConnection();
        instance.addRecords(instruction);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
