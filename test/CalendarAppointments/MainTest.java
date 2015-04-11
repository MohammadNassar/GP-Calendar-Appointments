/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CalendarAppointments;

import java.util.ArrayList;
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
     * Test of getAccessPrivileges method, of class Main.
     */
    @Test
    public void testGetAccessPrivileges() {
        System.out.println("getAccessPrivileges");
        String staffID = "";
        boolean[] expResult = null;
        boolean[] result = Main.getAccessPrivileges(staffID);
        // //assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasAccessRight method, of class Main.
     */
    @Test
    public void testHasAccessRight() {
        System.out.println("hasAccessRight");
        String username = "";
        String password = "";
        boolean expResult = false;
        boolean result = Main.hasAccessRight(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStaffID method, of class Main.
     */
    @Test
    public void testGetStaffID() {
        System.out.println("getStaffID");
        String username = "";
        String password = "";
        String expResult = "";
        String result = Main.getStaffID(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of privilegesText method, of class Main.
     */
    @Test
    public void testPrivilegesText() {
        System.out.println("privilegesText");
        boolean[] privilegesArray = null;
        String expResult = "";
        String result = Main.privilegesText(privilegesArray);
        assertEquals(expResult, result);
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
     * Test of exchangePatientIDsWithPatientNames method, of class Main.
     */
    @Test
    public void testExchangePatientIDsWithPatientNames() {
        System.out.println("exchangePatientIDsWithPatientNames");
        Object[][] table = null;
        Object[][] expResult = null;
        Object[][] result = Main.exchangePatientIDsWithPatientNames(table);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exchangeStaffIDsWithStaffNames method, of class Main.
     */
    @Test
    public void testExchangeStaffIDsWithStaffNames() {
        System.out.println("exchangeStaffIDsWithStaffNames");
        Object[][] table = null;
        Object[][] expResult = null;
        Object[][] result = Main.exchangeStaffIDsWithStaffNames(table);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCopyOf method, of class Main.
     */
    @Test
    public void testGetCopyOf() {
        System.out.println("getCopyOf");
        Object[][] array = null;
        Object[][] expResult = null;
        Object[][] result = Main.getCopyOf(array);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkDailyAvailabilityOfStaff method, of class Main.
     */
    @Test
    public void testCheckDailyAvailabilityOfStaff() {
        System.out.println("checkDailyAvailabilityOfStaff");
        String staffID = "";
        String date = "";
        boolean[] expResult = null;
        boolean[] result = Main.checkDailyAvailabilityOfStaff(staffID, date);
        // //assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAbsentOrOnHoliday method, of class Main.
     */
    @Test
    public void testIsAbsentOrOnHoliday() {
        System.out.println("isAbsentOrOnHoliday");
        String staffID = "";
        String date = "";
        boolean expResult = false;
        boolean result = Main.isAbsentOrOnHoliday(staffID, date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOnHoliday method, of class Main.
     */
    @Test
    public void testIsOnHoliday() {
        System.out.println("isOnHoliday");
        String staffID = "";
        String date = "";
        boolean expResult = false;
        boolean result = Main.isOnHoliday(staffID, date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAbsent method, of class Main.
     */
    @Test
    public void testIsAbsent() {
        System.out.println("isAbsent");
        String staffID = "";
        String date = "";
        boolean expResult = false;
        boolean result = Main.isAbsent(staffID, date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDaysOff method, of class Main.
     */
    @Test
    public void testGetDaysOff() {
        System.out.println("getDaysOff");
        String[] line = null;
        String[][] expResult = null;
        String[][] result = Main.getDaysOff(line);
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
     * Test of addSummaryToAppointment method, of class Main.
     */
    @Test
    public void testAddSummaryToAppointment() {
        System.out.println("addSummaryToAppointment");
        String id = "";
        String summaryText = "";
        Main.addSummaryToAppointment(id, summaryText);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addGPDayOff method, of class Main.
     */
    @Test
    public void testAddGPDayOff() {
        System.out.println("addGPDayOff");
        String date = "";
        String type = "";
        String description = "";
        Main.addGPDayOff(date, type, description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeGPDayOff method, of class Main.
     */
    @Test
    public void testRemoveGPDayOff() {
        System.out.println("removeGPDayOff");
        String date = "";
        Main.removeGPDayOff(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editAppointment method, of class Main.
     */
    @Test
    public void testEditAppointment() {
        System.out.println("editAppointment");
        String[] array = null;
        String id = "";
        Main.editAppointment(array, id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKeyAndValOfPatients method, of class Main.
     */
    @Test
    public void testGetKeyAndValOfPatients() {
        System.out.println("getKeyAndValOfPatients");
        String[][] expResult = null;
        String[][] result = Main.getKeyAndValOfPatients();
        assertArrayEquals(expResult, result);
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
     * Test of getAllColumnNamesForTimeSlots method, of class Main.
     */
    @Test
    public void testGetAllColumnNamesForTimeSlots() {
        System.out.println("getAllColumnNamesForTimeSlots");
        String[] expResult = null;
        String[] result = Main.getAllColumnNamesForTimeSlots();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnNamesForTimeSlot method, of class Main.
     */
    @Test
    public void testGetColumnNamesForTimeSlot() {
        System.out.println("getColumnNamesForTimeSlot");
        String timeSlot = "";
        String[] expResult = null;
        String[] result = Main.getColumnNamesForTimeSlot(timeSlot);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnIndecesForTimeSlot method, of class Main.
     */
    @Test
    public void testGetColumnIndecesForTimeSlot() {
        System.out.println("getColumnIndecesForTimeSlot");
        String timeSlot = "";
        int[] expResult = null;
        int[] result = Main.getColumnIndecesForTimeSlot(timeSlot);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvailability method, of class Main.
     */
    @Test
    public void testSetAvailability() {
        System.out.println("setAvailability");
        boolean availableOrNot = false;
        String timeSlot = "";
        String docOrNurse = "";
        String date = "";
        Main.setAvailability(availableOrNot, timeSlot, docOrNurse, date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createAvailability method, of class Main.
     */
    @Test
    public void testCreateAvailability() {
        System.out.println("createAvailability");
        String timeSlot = "";
        String docOrNurse = "";
        String date = "";
        Main.createAvailability(timeSlot, docOrNurse, date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoomsAvailability method, of class Main.
     */
    @Test
    public void testSetRoomsAvailability() {
        System.out.println("setRoomsAvailability");
        boolean availableOrNot = false;
        String room = "";
        String date = "";
        String timeSlot = "";
        Main.setRoomsAvailability(availableOrNot, room, date, timeSlot);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createRoomsAvailability method, of class Main.
     */
    @Test
    public void testCreateRoomsAvailability() {
        System.out.println("createRoomsAvailability");
        String room = "";
        String date = "";
        String timeSlot = "";
        Main.createRoomsAvailability(room, date, timeSlot);
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
     * Test of getAllStartTimes method, of class Main.
     */
    @Test
    public void testGetAllStartTimes() {
        System.out.println("getAllStartTimes");
        String[] expResult = null;
        String[] result = Main.getAllStartTimes();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllFinishTimes method, of class Main.
     */
    @Test
    public void testGetAllFinishTimes() {
        System.out.println("getAllFinishTimes");
        String[] expResult = null;
        String[] result = Main.getAllFinishTimes();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDuration method, of class Main.
     */
    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        String timeSlot = "";
        int expResult = 0;
        int result = Main.getDuration(timeSlot);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRowIndex method, of class Main.
     */
    @Test
    public void testGetRowIndex() {
        System.out.println("getRowIndex");
        String[] array = null;
        String value = "";
        int expResult = 0;
        int result = Main.getRowIndex(array, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllTimeSlotsForDuration method, of class Main.
     */
    @Test
    public void testGetAllTimeSlotsForDuration() {
        System.out.println("getAllTimeSlotsForDuration");
        String durationStr = "";
        String[] expResult = null;
        String[] result = Main.getAllTimeSlotsForDuration(durationStr);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllTimeSlots method, of class Main.
     */
    @Test
    public void testGetAllTimeSlots_0args() {
        System.out.println("getAllTimeSlots");
        String[] expResult = null;
        String[] result = Main.getAllTimeSlots();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllTimeSlots method, of class Main.
     */
    @Test
    public void testGetAllTimeSlots_String() {
        System.out.println("getAllTimeSlots");
        String date = "";
        String[] expResult = null;
        String[] result = Main.getAllTimeSlots(date);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of filterBasedOnGeneralDailyAvailabilityOfStaff method, of class Main.
     */
    @Test
    public void testFilterBasedOnGeneralDailyAvailabilityOfStaff() {
        System.out.println("filterBasedOnGeneralDailyAvailabilityOfStaff");
        String staffID = "";
        String date = "";
        String[] timeSlots = null;
        String[] expResult = null;
        String[] result = Main.filterBasedOnGeneralDailyAvailabilityOfStaff(staffID, date, timeSlots);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllDurations method, of class Main.
     */
    @Test
    public void testGetAllDurations() {
        System.out.println("getAllDurations");
        String[] expResult = null;
        String[] result = Main.getAllDurations();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllHours method, of class Main.
     */
    @Test
    public void testGetAllHours() {
        System.out.println("getAllHours");
        String[] expResult = null;
        String[] result = Main.getAllHours();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllDays method, of class Main.
     */
    @Test
    public void testGetAllDays_0args() {
        System.out.println("getAllDays");
        String[] expResult = null;
        String[] result = Main.getAllDays();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllDays method, of class Main.
     */
    @Test
    public void testGetAllDays_String_String() {
        System.out.println("getAllDays");
        String yearStr = "";
        String monthStr = "";
        String[] expResult = null;
        String[] result = Main.getAllDays(yearStr, monthStr);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllMonths method, of class Main.
     */
    @Test
    public void testGetAllMonths() {
        System.out.println("getAllMonths");
        String[] expResult = null;
        String[] result = Main.getAllMonths();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllYears method, of class Main.
     */
    @Test
    public void testGetAllYears() {
        System.out.println("getAllYears");
        String[] expResult = null;
        String[] result = Main.getAllYears();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeSlotsAvailable method, of class Main.
     */
    @Test
    public void testGetTimeSlotsAvailable_3args() {
        System.out.println("getTimeSlotsAvailable");
        String docOrNurseID = "";
        String date = "";
        String duration = "";
        String[] expResult = null;
        String[] result = Main.getTimeSlotsAvailable(docOrNurseID, date, duration);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeSlotsAvailable method, of class Main.
     */
    @Test
    public void testGetTimeSlotsAvailable_String_String() {
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
     * Test of getCurrentYear method, of class Main.
     */
    @Test
    public void testGetCurrentYear() {
        System.out.println("getCurrentYear");
        String expResult = "";
        String result = Main.getCurrentYear();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentMonth method, of class Main.
     */
    @Test
    public void testGetCurrentMonth() {
        System.out.println("getCurrentMonth");
        String expResult = "";
        String result = Main.getCurrentMonth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentDay method, of class Main.
     */
    @Test
    public void testGetCurrentDay() {
        System.out.println("getCurrentDay");
        String expResult = "";
        String result = Main.getCurrentDay();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentDayOfWeek method, of class Main.
     */
    @Test
    public void testGetCurrentDayOfWeek() {
        System.out.println("getCurrentDayOfWeek");
        String expResult = "";
        String result = Main.getCurrentDayOfWeek();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidDateInCommonYear method, of class Main.
     */
    @Test
    public void testIsValidDateInCommonYear() {
        System.out.println("isValidDateInCommonYear");
        String dateStr = "";
        boolean expResult = false;
        boolean result = Main.isValidDateInCommonYear(dateStr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isLeapYear method, of class Main.
     */
    @Test
    public void testIsLeapYear() {
        System.out.println("isLeapYear");
        String dateStr = "";
        boolean expResult = false;
        boolean result = Main.isLeapYear(dateStr);
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
     * Test of getDaysForYearAndMonth method, of class Main.
     */
    @Test
    public void testGetDaysForYearAndMonth() {
        System.out.println("getDaysForYearAndMonth");
        String yearStr = "";
        String monthStr = "";
        String[] expResult = null;
        String[] result = Main.getDaysForYearAndMonth(yearStr, monthStr);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRooms method, of class Main.
     */
    @Test
    public void testGetAllRooms() {
        System.out.println("getAllRooms");
        String[] expResult = null;
        String[] result = Main.getAllRooms();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoomsAvailableOld method, of class Main.
     */
    @Test
    public void testGetRoomsAvailableOld() {
        System.out.println("getRoomsAvailableOld");
        String date = "";
        String timeSlot = "";
        String[] expResult = null;
        String[] result = Main.getRoomsAvailableOld(date, timeSlot);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimesFromRoom method, of class Main.
     */
    @Test
    public void testGetTimesFromRoom() {
        System.out.println("getTimesFromRoom");
        String date = "";
        String[][] expResult = null;
        String[][] result = Main.getTimesFromRoom(date);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoomsAvailable method, of class Main.
     */
    @Test
    public void testGetRoomsAvailable() {
        System.out.println("getRoomsAvailable");
        String date = "";
        String timeSlot = "";
        String[] expResult = null;
        String[] result = Main.getRoomsAvailable(date, timeSlot);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllKeysOnly method, of class Main.
     */
    @Test
    public void testGetAllKeysOnly() {
        System.out.println("getAllKeysOnly");
        String[][] array = null;
        String[] expResult = null;
        String[] result = Main.getAllKeysOnly(array);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllValuesOnly method, of class Main.
     */
    @Test
    public void testGetAllValuesOnly() {
        System.out.println("getAllValuesOnly");
        String[][] array = null;
        String[] expResult = null;
        String[] result = Main.getAllValuesOnly(array);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKey method, of class Main.
     */
    @Test
    public void testGetKey() {
        System.out.println("getKey");
        String[][] array = null;
        int row = 0;
        String expResult = "";
        String result = Main.getKey(array, row);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVal method, of class Main.
     */
    @Test
    public void testGetVal() {
        System.out.println("getVal");
        String[][] array = null;
        int row = 0;
        String expResult = "";
        String result = Main.getVal(array, row);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRowIndexWhereKeyIs method, of class Main.
     */
    @Test
    public void testGetRowIndexWhereKeyIs() {
        System.out.println("getRowIndexWhereKeyIs");
        String[][] array = null;
        String key = "";
        int expResult = 0;
        int result = Main.getRowIndexWhereKeyIs(array, key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class Main.
     */
    @Test
    public void testPrint_String() {
        System.out.println("print");
        String str = "";
        Main.print(str);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class Main.
     */
    @Test
    public void testPrint_StringArr() {
        System.out.println("print");
        String[] array = null;
        Main.print(array);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class Main.
     */
    @Test
    public void testPrint_StringArrArr() {
        System.out.println("print");
        String[][] array = null;
        Main.print(array);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class Main.
     */
    @Test
    public void testPrint_intArr() {
        System.out.println("print");
        int[] array = null;
        Main.print(array);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class Main.
     */
    @Test
    public void testPrint_intArrArr() {
        System.out.println("print");
        int[][] array = null;
        Main.print(array);
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
     * Test of convertArrayListToArray method, of class Main.
     */
    @Test
    public void testConvertArrayListToArray() {
        System.out.println("convertArrayListToArray");
        ArrayList<String> list = null;
        String[] expResult = null;
        String[] result = Main.convertArrayListToArray(list);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convert2DArrayListTo2DArray method, of class Main.
     */
    @Test
    public void testConvert2DArrayListTo2DArray() {
        System.out.println("convert2DArrayListTo2DArray");
        ArrayList<ArrayList<String>> list = null;
        String[][] expResult = null;
        String[][] result = Main.convert2DArrayListTo2DArray(list);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sort method, of class Main.
     */
    @Test
    public void testSort_StringArr() {
        System.out.println("sort");
        String[] array = null;
        String[] expResult = null;
        String[] result = Main.sort(array);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sort method, of class Main.
     */
    @Test
    public void testSort_StringArrArr() {
        System.out.println("sort");
        String[][] array = null;
        String[][] expResult = null;
        String[][] result = Main.sort(array);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortByVal method, of class Main.
     */
    @Test
    public void testSortByVal() {
        System.out.println("sortByVal");
        String[][] array = null;
        String[][] expResult = null;
        String[][] result = Main.sortByVal(array);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sort method, of class Main.
     */
    @Test
    public void testSort_intArr() {
        System.out.println("sort");
        int[] array = null;
        int[] expResult = null;
        int[] result = Main.sort(array);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sort method, of class Main.
     */
    @Test
    public void testSort_intArrArr() {
        System.out.println("sort");
        int[][] array = null;
        int[][] expResult = null;
        int[][] result = Main.sort(array);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class Main.
     */
    @Test
    public void testIsEmpty_ObjectArr() {
        System.out.println("isEmpty");
        Object[] array = null;
        boolean expResult = false;
        boolean result = Main.isEmpty(array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class Main.
     */
    @Test
    public void testIsEmpty_ObjectArrArr() {
        System.out.println("isEmpty");
        Object[][] array = null;
        boolean expResult = false;
        boolean result = Main.isEmpty(array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of concat2DArrays method, of class Main.
     */
    @Test
    public void testConcat2DArrays() {
        System.out.println("concat2DArrays");
        String[][] array1 = null;
        String[][] array2 = null;
        String[][] expResult = null;
        String[][] result = Main.concat2DArrays(array1, array2);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKeyAndValOfDocsAndNurses method, of class Main.
     */
    @Test
    public void testGetKeyAndValOfDocsAndNurses() {
        System.out.println("getKeyAndValOfDocsAndNurses");
        String[][] expResult = null;
        String[][] result = Main.getKeyAndValOfDocsAndNurses();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKeyAndValOfDocsAndNursesOld method, of class Main.
     */
    @Test
    public void testGetKeyAndValOfDocsAndNursesOld() {
        System.out.println("getKeyAndValOfDocsAndNursesOld");
        String[][] expResult = null;
        String[][] result = Main.getKeyAndValOfDocsAndNursesOld();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPatientAndStaffWithThisAppID method, of class Main.
     */
    @Test
    public void testGetPatientAndStaffWithThisAppID() {
        System.out.println("getPatientAndStaffWithThisAppID");
        String id = "";
        String[] expResult = null;
        String[] result = Main.getPatientAndStaffWithThisAppID(id);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class Main.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        Main.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of test method, of class Main.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Main.test();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
