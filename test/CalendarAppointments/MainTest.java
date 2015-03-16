/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CalendarAppointments;

import java.util.Date;
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
public class MainTest {
    
    public MainTest() {
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
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Main.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of execute method, of class Main.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        String instruction = "";
        Main.execute(instruction);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAppointments method, of class Main.
     */
    @Test
    public void testGetAppointments() {
        System.out.println("getAppointments");
        String[] line = null;
        String[][] expResult = null;
        String[][] result = Main.getAppointments(line);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAppointment method, of class Main.
     */
    @Test
    public void testAddAppointment() {
        System.out.println("addAppointment");
        String[] array = null;
        Main.addAppointment(array);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of strIsInArray method, of class Main.
     */
    @Test
    public void testStrIsInArray() {
        System.out.println("strIsInArray");
        String str = "";
        String[] strArray = null;
        boolean expResult = false;
        boolean result = Main.strIsInArray(str, strArray);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recordExists method, of class Main.
     */
    @Test
    public void testRecordExists() {
        System.out.println("recordExists");
        String instruction = "";
        boolean expResult = false;
        boolean result = Main.recordExists(instruction);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOneColumnFromTable method, of class Main.
     */
    @Test
    public void testGetOneColumnFromTable() {
        System.out.println("getOneColumnFromTable");
        String str = "";
        String[] expResult = null;
        String[] result = Main.getOneColumnFromTable(str);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gpIsOpenOn method, of class Main.
     */
    @Test
    public void testGpIsOpenOn() {
        System.out.println("gpIsOpenOn");
        String date = "";
        boolean expResult = false;
        boolean result = Main.gpIsOpenOn(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllDoctorsAndNurses method, of class Main.
     */
    @Test
    public void testGetAllDoctorsAndNurses() {
        System.out.println("getAllDoctorsAndNurses");
        String[] expResult = null;
        String[] result = Main.getAllDoctorsAndNurses();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnNameForTimeSlot method, of class Main.
     */
    @Test
    public void testGetColumnNameForTimeSlot() {
        System.out.println("getColumnNameForTimeSlot");
        String timeSlot = "";
        String expResult = "";
        String result = Main.getColumnNameForTimeSlot(timeSlot);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllTimeSlots method, of class Main.
     */
    @Test
    public void testGetAllTimeSlots() {
        System.out.println("getAllTimeSlots");
        String[] expResult = null;
        String[] result = Main.getAllTimeSlots();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeSlotsAvailable method, of class Main.
     */
    @Test
    public void testGetTimeSlotsAvailable() {
        System.out.println("getTimeSlotsAvailable");
        String docOrNurse = "";
        String date = "";
        String[] expResult = null;
        String[] result = Main.getTimeSlotsAvailable(docOrNurse, date);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBusyAllDay method, of class Main.
     */
    @Test
    public void testIsBusyAllDay() {
        System.out.println("isBusyAllDay");
        String docOrNurse = "";
        String date = "";
        boolean expResult = false;
        boolean result = Main.isBusyAllDay(docOrNurse, date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDayOfWeek method, of class Main.
     */
    @Test
    public void testGetDayOfWeek() {
        System.out.println("getDayOfWeek");
        String date = "";
        int expResult = 0;
        int result = Main.getDayOfWeek(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stringToDate method, of class Main.
     */
    @Test
    public void testStringToDate() {
        System.out.println("stringToDate");
        String strDate = "";
        Date expResult = null;
        Date result = Main.stringToDate(strDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentDate method, of class Main.
     */
    @Test
    public void testGetCurrentDate() {
        System.out.println("getCurrentDate");
        String expResult = "";
        String result = Main.getCurrentDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dateIsInThePast method, of class Main.
     */
    @Test
    public void testDateIsInThePast() {
        System.out.println("dateIsInThePast");
        String dateStr = "";
        boolean expResult = false;
        boolean result = Main.dateIsInThePast(dateStr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dateTimeAreInThePast method, of class Main.
     */
    @Test
    public void testDateTimeAreInThePast() {
        System.out.println("dateTimeAreInThePast");
        String dateTimeStr = "";
        boolean expResult = false;
        boolean result = Main.dateTimeAreInThePast(dateTimeStr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dateIsInCorrectFormat method, of class Main.
     */
    @Test
    public void testDateIsInCorrectFormat() {
        System.out.println("dateIsInCorrectFormat");
        String strDate = "";
        boolean expResult = false;
        boolean result = Main.dateIsInCorrectFormat(strDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNumber method, of class Main.
     */
    @Test
    public void testIsNumber_String() {
        System.out.println("isNumber");
        String str = "";
        boolean expResult = false;
        boolean result = Main.isNumber(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNumber method, of class Main.
     */
    @Test
    public void testIsNumber_char() {
        System.out.println("isNumber");
        char ch = ' ';
        boolean expResult = false;
        boolean result = Main.isNumber(ch);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTokens method, of class Main.
     */
    @Test
    public void testRemoveTokens() {
        System.out.println("removeTokens");
        String str = "";
        String expResult = "";
        String result = Main.removeTokens(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeRepeated method, of class Main.
     */
    @Test
    public void testRemoveRepeated() {
        System.out.println("removeRepeated");
        String[] array = null;
        String[] expResult = null;
        String[] result = Main.removeRepeated(array);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of trimAll method, of class Main.
     */
    @Test
    public void testTrimAll_String() {
        System.out.println("trimAll");
        String str = "";
        String expResult = "";
        String result = Main.trimAll(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of trimAll method, of class Main.
     */
    @Test
    public void testTrimAll_StringArr() {
        System.out.println("trimAll");
        String[] strArray = null;
        String[] expResult = null;
        String[] result = Main.trimAll(strArray);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAppointmentsNoGUI method, of class Main.
     */
    @Test
    public void testGetAppointmentsNoGUI() {
        System.out.println("getAppointmentsNoGUI");
        Main.getAppointmentsNoGUI();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAppointmentNoGUI method, of class Main.
     */
    @Test
    public void testAddAppointmentNoGUI() {
        System.out.println("addAppointmentNoGUI");
        Main.addAppointmentNoGUI();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
