/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CalendarAppointments;

import java.util.ArrayList;
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
     * Test of getInstance method, of class DatabaseConnection.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        DatabaseConnection expResult = null;
        DatabaseConnection result = DatabaseConnection.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecords method, of class DatabaseConnection.
     */
    @Test
    public void testGetRecords() {
        System.out.println("getRecords");
        String instruction = "";
        DatabaseConnection instance = null;
        String[][] expResult = null;
        String[][] result = instance.getRecords(instruction);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDaysOff method, of class DatabaseConnection.
     */
    @Test
    public void testGetDaysOff() {
        System.out.println("getDaysOff");
        String instruction = "";
        DatabaseConnection instance = null;
        String[][] expResult = null;
        String[][] result = instance.getDaysOff(instruction);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKeyAndValOfPatients method, of class DatabaseConnection.
     */
    @Test
    public void testGetKeyAndValOfPatients() {
        System.out.println("getKeyAndValOfPatients");
        DatabaseConnection instance = null;
        String[][] expResult = null;
        String[][] result = instance.getKeyAndValOfPatients();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exchangePatientIDsWithPatientNames method, of class DatabaseConnection.
     */
    @Test
    public void testExchangePatientIDsWithPatientNames() {
        System.out.println("exchangePatientIDsWithPatientNames");
        Object[][] array = null;
        DatabaseConnection instance = null;
        Object[][] expResult = null;
        Object[][] result = instance.exchangePatientIDsWithPatientNames(array);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exchangeStaffIDsWithStaffNames method, of class DatabaseConnection.
     */
    @Test
    public void testExchangeStaffIDsWithStaffNames() {
        System.out.println("exchangeStaffIDsWithStaffNames");
        Object[][] array = null;
        DatabaseConnection instance = null;
        Object[][] expResult = null;
        Object[][] result = instance.exchangeStaffIDsWithStaffNames(array);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStaffNameWhoseIdIs method, of class DatabaseConnection.
     */
    @Test
    public void testGetStaffNameWhoseIdIs() {
        System.out.println("getStaffNameWhoseIdIs");
        String id = "";
        DatabaseConnection instance = null;
        String expResult = "";
        String result = instance.getStaffNameWhoseIdIs(id);
        assertEquals(expResult, result);
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
        DatabaseConnection instance = null;
        String[] expResult = null;
        String[] result = instance.getOneColumnFromTable(instruction);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKeyAndValOfDocsAndNurses method, of class DatabaseConnection.
     */
    @Test
    public void testGetKeyAndValOfDocsAndNurses() {
        System.out.println("getKeyAndValOfDocsAndNurses");
        String query = "";
        DatabaseConnection instance = null;
        String[] expResult = null;
        String[] result = instance.getKeyAndValOfDocsAndNurses(query);
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
        String staffID = "";
        String date = "";
        DatabaseConnection instance = null;
        String[] expResult = null;
        String[] result = instance.getTimesFromDoctorsandnurses(staffID, date);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimesFromRoom method, of class DatabaseConnection.
     */
    @Test
    public void testGetTimesFromRoom_String_String() {
        System.out.println("getTimesFromRoom");
        String room = "";
        String date = "";
        DatabaseConnection instance = null;
        String[] expResult = null;
        String[] result = instance.getTimesFromRoom(room, date);
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
        DatabaseConnection instance = null;
        String[] expResult = null;
        String[] result = instance.getNamesFromDoctorsandnurses(name);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recordExists method, of class DatabaseConnection.
     */
    @Test
    public void testRecordExists() {
        System.out.println("recordExists");
        String instruction = "";
        DatabaseConnection instance = null;
        boolean expResult = false;
        boolean result = instance.recordExists(instruction);
        assertEquals(expResult, result);
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
        DatabaseConnection instance = null;
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
        DatabaseConnection instance = null;
        instance.addRecords(instruction);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of execute method, of class DatabaseConnection.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        String instruction = "";
        DatabaseConnection instance = null;
        instance.execute(instruction);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimesFromRoom method, of class DatabaseConnection.
     */
    @Test
    public void testGetTimesFromRoom_String() {
        System.out.println("getTimesFromRoom");
        String instruction = "";
        DatabaseConnection instance = null;
        String[][] expResult = null;
        String[][] result = instance.getTimesFromRoom(instruction);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOneRowFromTable method, of class DatabaseConnection.
     */
    @Test
    public void testGetOneRowFromTable() {
        System.out.println("getOneRowFromTable");
        String tableName = "";
        String[] columnNames = null;
        String extraQuery = "";
        DatabaseConnection instance = null;
        String[] expResult = null;
        String[] result = instance.getOneRowFromTable(tableName, columnNames, extraQuery);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTable method, of class DatabaseConnection.
     */
    @Test
    public void testGetTable() {
        System.out.println("getTable");
        String tableName = "";
        String[] columnNames = null;
        String extraQuery = "";
        DatabaseConnection instance = null;
        String[][] expResult = null;
        String[][] result = instance.getTable(tableName, columnNames, extraQuery);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class DatabaseConnection.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        DatabaseConnection instance = null;
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertArrayListToArray method, of class DatabaseConnection.
     */
    @Test
    public void testConvertArrayListToArray() {
        System.out.println("convertArrayListToArray");
        ArrayList<String> list = null;
        DatabaseConnection instance = null;
        String[] expResult = null;
        String[] result = instance.convertArrayListToArray(list);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convert2DArrayListTo2DArray method, of class DatabaseConnection.
     */
    @Test
    public void testConvert2DArrayListTo2DArray() {
        System.out.println("convert2DArrayListTo2DArray");
        ArrayList<ArrayList<String>> list = null;
        DatabaseConnection instance = null;
        String[][] expResult = null;
        String[][] result = instance.convert2DArrayListTo2DArray(list);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
