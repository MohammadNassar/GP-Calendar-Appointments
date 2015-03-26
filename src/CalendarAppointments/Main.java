package CalendarAppointments;

// 'Calendar Appointments' module - By Mohammad Nassar - ID No. 120132108
// Version 3 - Adding a record/row to the database based on user request made by his input
// Appropriate input for method: 'getRecords' is:  ,Routine,,,13/01/2014,,  or  ,Routine,,,,,  or (to view all appointments) 	,,,,,,
// Appropriate input for method: 'addAppointment' is:  'routine', 30, 50, '01/01/1000', '12:34', '23:45'

//import CalendarAppointments.DatabaseConnection;
import java.util.*;
import java.text.*;

public class Main {

    public static void main(String[] args) {
        
        //getAppointmentsNoGUI();
        //addAppointment();
        //gpIsOpenOn("2014-02-12");
        //getDayOfWeek("2014-01-12");
        //String[] timesAvailable = getTimeSlotsAvailable("mohammad"); for(String val : timesAvailable)System.out.println(val);
        //System.out.println(getCurrentDate());
        //System.out.println(dateIsInThePast("2014-02-13"));
        //removeTokens("2014-0/2: 13");
        //String[] arr = {};
        //removeRepeated(arr);
        //System.out.println(isBusyAllDay("ali", "2014-05-20"));
        //System.out.println(recordExists("SELECT * FROM doctorsandnurses WHERE name like 'hassan' ;"));
        //System.out.println(getColumnNameForTimeSlot("13:00-13:15"));
        //String[] arr = {"one", "two", "three"};
        //addAppointment(arr);
        //System.out.println(isLeapYear("2014-02-29"));
        //System.out.println(isValidDateInCommonYear("2014-02-29"));
        //System.out.println(gpIsOpenOn("2014-02-29"));
        //String[] daysFor = getDaysForYearAndMonth("2014", "12"); for (String day : daysFor) System.out.println(day);
        //System.out.println(getCurrentYear());
        //System.out.println(getCurrentMonth());
        //System.out.println(getCurrentDay());
        //System.out.println(getCurrentDayOfWeek());
        //String[] allHours = getAllHours(); for (String hours : allHours) System.out.println(hours);
        //String[] allDays = getAllDays("2014", "01"); for (String day : allDays) System.out.println(day);
        //String[] allDaysOptions = getAllDays(); for (String day : allDaysOptions) System.out.println(day);
        //String[] allMonths = getAllMonths(); for (String month : allMonths) System.out.println(month);
        //String[] allYears = getAllYears(); for (String year : allYears) System.out.println(year);
        //String[] columnNames = getColumnNamesForTimeSlot("09:00-09:45"); for (String colName : columnNames) System.out.println(colName);
        //setAvailability(true, "09:30-10:15", "mohammad", "2014-05-02");
        //createAvailability("09:30-10:00", "mohammad", "2014-04-10");
        //String[] timeSlots = getAllTimeSlots("2014-03-01"); for (String time : timeSlots) System.out.println(time);
        //print(getKey(new String[][]{{"1","2"},{"3","4"},{"5","6"}}, 1));
        //print(getVal(new String[][]{{"1","2"},{"3","4"},{"5","6"}}, 1));
        //print(new String[]{"1","2","3","4","5"});
        //print(new String[][]{{"1","2","3"},{"4","5"},{"6","7","8"}});
        //print(getKeyAndValOfPatients());
        //getRoomsAvailable("2014-05-02","");
        //getRoomsAvailable("2014-05-02", "");
        //int[] indeces = getColumnIndecesForTimeSlot("09:00-09:45"); for (int index : indeces) System.out.println(index);
        print(getTimesFromRoom("2014-05-02"));
    }
    
    public static void execute (String instruction) { // This method can be used for SQL queries that do not return a value, e.g. INSERT, UPDATE and REMOVE.
        
        DatabaseConnection connect = new DatabaseConnection();
        System.out.println(instruction);
        connect.execute(instruction);
    }
    
    public static String[][] getAppointments(String[] line) {
        
        DatabaseConnection connect = new DatabaseConnection();
        
        String query = "SELECT * FROM appointments ";
        boolean condition = false; // Initially assume that some properties have been set.
        //String query = "SELECT appId, appType, patientId, appWithStaffId, date, startTime, finishTime FROM appointments;";
        
        
        for (int i=0; i<line.length; i++)
            line[i] = line[i].trim();
        
        if (! allUnset(line))
            condition = true;
        
        if (condition) {
            
            ArrayList<String> allConditions = new ArrayList<String>();
            
            String[] columnNames = {"appId ", "appType ", "patientId ", "appWithStaffId ", "date ", "startTime ", "finishTime ", "room", "summary"};
            for (int i=0; i<line.length; i++) {
                if ( ! line[i].equals("") )
                    allConditions.add(columnNames[i] + "LIKE '" + line[i] + "' ");
            }
            
            for (int i=0; i<allConditions.size(); i++) {
                if (i != allConditions.size()-1)
                    allConditions.set(i, allConditions.get(i) + "AND ");
            }
            
            query += "WHERE ";
            for (String tmp : allConditions)
                query += tmp;
            
        }
        
        query += "ORDER BY date, startTime, patientID ";
        query += ";";
        System.out.println(query);
        String[][] table = connect.getRecords(query);
        connect.exchangePatientIDsWithPatientNames(table);
        connect.exchangeStaffIDsWithStaffNames(table);
        return table;
    }
    
    public static Object[][] exchangePatientIDsWithPatientNames(Object[][] table) {
        
        DatabaseConnection connect = new DatabaseConnection();
        return connect.exchangePatientIDsWithPatientNames(table);
    }
    public static Object[][] exchangeStaffIDsWithStaffNames(Object[][] table) {
        
        DatabaseConnection connect = new DatabaseConnection();
        return connect.exchangePatientIDsWithPatientNames(table);
    }
    
    public static Object[][] getCopyOf(Object[][] array) {
        
        Object[][] arrayToReturn = {};
        System.arraycopy(array, 0, arrayToReturn, 0, array.length);
        return arrayToReturn;
    }
    
    public static String[][] getDaysOff(String[] line) {
        
        DatabaseConnection connect = new DatabaseConnection();
        
        String query = "SELECT * FROM gpdaysoff ";
        boolean condition = false; // Initially assume that some properties have been set.
        
        
        for (int i=0; i<line.length; i++)
            line[i] = line[i].trim();
        
        if (! allUnset(line))
            condition = true;
        
        if (condition) {
            
            ArrayList<String> allConditions = new ArrayList<String>();
            
            String[] columnNames = {"day "};
            for (int i=0; i<line.length; i++) {
                if ( ! line[i].equals("") )
                    allConditions.add(columnNames[i] + "LIKE '" + line[i] + "' ");
            }
            
            for (int i=0; i<allConditions.size(); i++) {
                if (i != allConditions.size()-1)
                    allConditions.set(i, allConditions.get(i) + "AND ");
            }
            
            query += "WHERE ";
            for (String tmp : allConditions)
                query += tmp;
            
        }
        
        query += "ORDER BY day ";
        query += ";";
        System.out.println(query);
        String[][] table = connect.getDaysOff(query);
        return table;
    }
    
    public static void addAppointment(String[] array) {
        
        DatabaseConnection connect = new DatabaseConnection();
        
        ArrayList<String> list = new ArrayList<String>();
        for (int i=0; i<array.length; i++) {
            if (i != array.length-1)
                list.add("'" + array[i] + "', ");
            else
                list.add("'" + array[i] + "'");
        }
        
        String values = "";
        for (String val : list)
            values += val;
        
        String update = "INSERT INTO appointments " + 
                            "(appType, patientId, appWithStaffId, date, startTime, finishTime, room) " + 
                            "VALUES (" + values + ") ;";
        //System.out.println(update);
        connect.execute(update);
    }
    
    public static void editAppointment(String[] array, String id) {
        
        DatabaseConnection connect = new DatabaseConnection();
        
        String[] columnName = {"appType", "patientId", "appWithStaffId", "date", "startTime", "finishTime", "room"};
        
        ArrayList<String> list = new ArrayList<String>();
        for (int i=0; i<array.length; i++) {
            if (i != array.length-1)
                list.add(columnName[i] + " = '" + array[i] + "', ");
            else
                list.add(columnName[i] + " = '" + array[i] + "'");
        }
        
        String values = "";
        for (String val : list)
            values += val;
        
        String update = "UPDATE appointments " + 
                            "SET " + values + 
                            " WHERE appId = " + id + " ;";
        //System.out.println(update);
        connect.execute(update);
    }
    
    public static String[][] getKeyAndValOfPatients() {
        
        DatabaseConnection connect = new DatabaseConnection();
        String[][] array = connect.getKeyAndValOfPatients();
        return array;
    }
    
    // Return true if all entries are unset or empty
    private static boolean allUnset(String[] entries) {
        
        for (String tmp :  entries) {
            if (!tmp.equals(""))
                return false;
        }
        return true;
    }
    
    public static boolean strIsInArray(String str, String[] strArray) {
        
        for (String tmp : strArray) {
            if (tmp.equalsIgnoreCase(str))
                return true;
        }
        return false;
    }
    
    public static boolean recordExists(String instruction) {
        
        DatabaseConnection connect = new DatabaseConnection();
        return connect.recordExists(instruction);
    }
    
    public static String[] getOneColumnFromTable(String str) {
        
        DatabaseConnection connect = new DatabaseConnection();
        
        return connect.getOneColumnFromTable(str);
    }
    
    public static boolean gpIsOpenOn(String date) {
        
        DatabaseConnection connect = new DatabaseConnection();
        
        String[] dates = connect.getOneColumnFromTable("SELECT day FROM `gpdaysoff`;");
        
        //boolean docOrNurseAvailable = true;
        //for (String eachDate : dates){System.out.println(eachDate);}
        
        // Checking if the date (entered by user) is in the table called: 'gpdaysoff'.
        for (String aDate : dates) {
            if (aDate.equals(date))
                return false;
        }
        // Checking if the date (entered by user) is not on a 'Sunday'.
        if (getDayOfWeek(date) == 1)
            return false;
        // Checking whether the date is in the future or in the past
        if (dateIsInThePast(date))
            return false;
        if (!isValidDateInCommonYear(date))
            return false;
        //System.out.println(true);
        return true;
    }
    
    public static String[] getAllDoctorsAndNurses() {
        String[] timeSlots = {"Ali", "John"};
        return timeSlots;
    }
    
    public static String[] getAllColumnNamesForTimeSlots() {
        
        String[] columnNames = {"a9","b9","c9","d9","a10","b10","c10","d10","a11","b11","c11","d11","a12","b12","c12","d12",
                              "a13","b13","c13","d13","a14","b14","c14","d14","a15","b15","c15","d15","a16","b16","c16","d16","a17","b17"};
        return columnNames;
    }
    
    public static String[] getColumnNamesForTimeSlot(String timeSlot) {
        String[] timeSlots = timeSlot.split("-");
        String start = timeSlots[0];
        String finish = timeSlots[1];
        String[] allStartTimes = getAllStartTimes();
        String[] allFinishTimes = getAllFinishTimes();
        String[] columnNames = getAllColumnNamesForTimeSlots();
        
        int startIndex = 0, finishIndex = 0;
        for (int i=0; i<allStartTimes.length; i++) {
            if (start.equals(allStartTimes[i]))
                startIndex = i;
            if (finish.equals(allFinishTimes[i])) {
                finishIndex = i;
                break;
            }
        }
        
        String[] columnNamesToReturn = new String[(finishIndex - startIndex) + 1];
        for (int i = 0, index = startIndex; index<=finishIndex; i++, index++) {
            columnNamesToReturn[i] = columnNames[index];
        }
        
        return columnNamesToReturn;
    }
    
    public static int[] getColumnIndecesForTimeSlot(String timeSlot) {
        String[] timeSlots = timeSlot.split("-");
        String start = timeSlots[0];
        String finish = timeSlots[1];
        String[] allStartTimes = getAllStartTimes();
        String[] allFinishTimes = getAllFinishTimes();
        
        int startIndex = 0, finishIndex = 0;
        for (int i=0; i<allStartTimes.length; i++) {
            if (start.equals(allStartTimes[i]))
                startIndex = i;
            if (finish.equals(allFinishTimes[i])) {
                finishIndex = i;
                break;
            }
        }
        
        int[] columnIndecesToReturn = new int[(finishIndex - startIndex) + 1];
        for (int i = 0, index = startIndex; index<=finishIndex; i++, index++) {
            columnIndecesToReturn[i] = index;
        }
        
        return columnIndecesToReturn;
    }
    
    public static void setAvailability(boolean availableOrNot, String timeSlot, String docOrNurse, String date) {
        
        DatabaseConnection connect = new DatabaseConnection();
        String availability = (availableOrNot)? "'y' " : "'n' ";
        String query = "UPDATE doctorsandnurses SET ";
        String[] columnNames = getColumnNamesForTimeSlot(timeSlot);
        for (int i=0; i<columnNames.length; i++) {
            if (i != columnNames.length-1) // If NOT at the last index or element in the array.
                query += columnNames[i] + " = " + availability + ", ";
            else
                query += columnNames[i] + " = " + availability;
        }
        query += "WHERE name LIKE '" + docOrNurse + "' AND date LIKE '" + date + "' ;";
        //System.out.println(query);
        connect.execute(query);
    }
    
    public static void createAvailability(String timeSlot, String docOrNurse, String date) {
        
        DatabaseConnection connect = new DatabaseConnection();
        String availability = " 'n'";
        String query = "INSERT INTO doctorsandnurses (name, date, ";
        String[] columnNames = getColumnNamesForTimeSlot(timeSlot);
        for (int i=0; i<columnNames.length; i++) {
            if (i != columnNames.length-1) // If NOT at the last index or element in the array.
                query += columnNames[i] + ", ";
            else
                query += columnNames[i];
        }
        query += ") VALUES ('";
        query += docOrNurse + "', '" + date +"',";
        for (int i=0; i<columnNames.length; i++) {
            if (i != columnNames.length-1) // If NOT at the last index or element in the array.
                query += availability + ",";
            else
                query += availability;
        }
        
        query += ");";
        //System.out.println(query);
        connect.execute(query);
    }
    
    public static String getColumnNameForTimeSlot(String timeSlot) { // OLD
        String[] timeSlots = getAllTimeSlots();
        String[] columnNames = getAllColumnNamesForTimeSlots();
        
        String columnName = "";
        for (int i=0; i<timeSlots.length; i++) {
            if (timeSlots[i].equals(timeSlot)) {
                columnName = columnNames[i];
                break;
            }
        }
        return columnName;
    }
    
    public static String[] getAllStartTimes() {
        
        String[] startTimes = { "09:00", "09:15", "09:30", "09:45",
                                "10:00", "10:15", "10:30", "10:45",
                                "11:00", "11:15", "11:30", "11:45",
                                "12:00", "12:15", "12:30", "12:45",
                                "13:00", "13:15", "13:30", "13:45",
                                "14:00", "14:15", "14:30", "14:45",
                                "15:00", "15:15", "15:30", "15:45",
                                "16:00", "16:15", "16:30", "16:45",
                                "17:00", "17:15"
        };
        return startTimes;
    }
    
    public static String[] getAllFinishTimes() {
        
        String[] startTimes = { "09:15", "09:30", "09:45", "10:00", 
                                "10:15", "10:30", "10:45", "11:00", 
                                "11:15", "11:30", "11:45", "12:00", 
                                "12:15", "12:30", "12:45", "13:00", 
                                "13:15", "13:30", "13:45", "14:00", 
                                "14:15", "14:30", "14:45", "15:00", 
                                "15:15", "15:30", "15:45", "16:00", 
                                "16:15", "16:30", "16:45", "17:00", 
                                "17:15", "17:30"
        };
        return startTimes;
    }
    
    public static String[] getAllTimeSlotsForDuration(String durationStr, String date) {
        
        int duration = Integer.parseInt(durationStr.substring(0, 2));
        String[] timeSlotsToReturn = new String[0];
        String[] startTimes = getAllStartTimes();
        String[] finishTimes = getAllFinishTimes();
        
        if (duration == 15) {
            timeSlotsToReturn = new String[getAllTimeSlots(date).length];
            for (int i=0; i<timeSlotsToReturn.length; i++) {
                timeSlotsToReturn[i] = startTimes[i] + "-" + finishTimes[i];
            }
        }
        else if (duration == 30) {
            timeSlotsToReturn = new String[getAllTimeSlots(date).length-1];
            for (int i=0; i<timeSlotsToReturn.length; i++) {
                timeSlotsToReturn[i] = startTimes[i] + "-" + finishTimes[i+1];
            }
        }
        else if (duration == 45) {
            timeSlotsToReturn = new String[getAllTimeSlots(date).length-2];
            for (int i=0; i<timeSlotsToReturn.length; i++) {
                timeSlotsToReturn[i] = startTimes[i] + "-" + finishTimes[i+2];
            }
        }
        else if (duration == 60) {
            timeSlotsToReturn = new String[getAllTimeSlots(date).length-3];
            for (int i=0; i<timeSlotsToReturn.length; i++) {
                timeSlotsToReturn[i] = startTimes[i] + "-" + finishTimes[i+3];
            }
        }
        
        return timeSlotsToReturn;
    }
    
    public static String[] getAllTimeSlots() {
        String[] timeSlots = {"09:00-09:15", "09:15-09:30", "09:30-09:45", "09:45-10:00",
                                "10:00-10:15", "10:15-10:30", "10:30-10:45", "10:45-11:00",
                                "11:00-11:15", "11:15-11:30", "11:30-11:45", "11:45-12:00",
                                "12:00-12:15", "12:15-12:30", "12:30-12:45", "12:45-13:00",
                                "13:00-13:15", "13:15-13:30", "13:30-13:45", "13:45-14:00",
                                "14:00-14:15", "14:15-14:30", "14:30-14:45", "14:45-15:00",
                                "15:00-15:15", "15:15-15:30", "15:30-15:45", "15:45-16:00",
                                "16:00-16:15", "16:15-16:30", "16:30-16:45", "16:45-17:00",
                                "17:00-17:15", "17:15-17:30"
        };
        return timeSlots;
    }
    
    public static String[] getAllTimeSlots(String date) {
        
        String[] timeSlots = getAllTimeSlots();
        if (getDayOfWeek(date) == 7) { // Then day is a saturday, so only return timeslots from 09:00 to 12:00
            String[] saturdayTimeSlots = new String[12];
            System.arraycopy(timeSlots, 0, saturdayTimeSlots, 0, 12);
            return saturdayTimeSlots;
        }
        return timeSlots;
    }
    
    public static String[] getAllDurations() {
        
        String[] durations = {"15 Minutes", "30 Minutes", "45 Minutes", "60 Minutes"};
        return durations;
    }
    
    public static String[] getAllHours() {
        
        String[] hours = {"All", "09:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00", 
                          "13:00 - 14:00", "14:00 - 15:00", "15:00 - 16:00", "16:00 - 17:00", "17:00 - 17.30"
        };
        return hours;
    }
    
    public static String[] getAllDays() {
        
        String[] daysArr = {"All", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
                            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", 
                            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
        };
        return daysArr;
    }
    
    
    public static String[] getAllDays(String yearStr, String monthStr) {
        
        String[] allDays = getDaysForYearAndMonth(yearStr, monthStr);
        String[] allDaysOptions = new String[allDays.length + 1];
        allDaysOptions[0] = "All";
        System.arraycopy(allDays, 0, allDaysOptions, 1, allDays.length);
        
        return allDaysOptions;
    }
    
    public static String[] getAllMonths() {
        
        String[] allMonths = {"All", "01", "02", "03", "04", "05", "06", 
                              "07", "08", "09", "10", "11", "12"
        };
        return allMonths;
    }
    
    public static String[] getAllYears() {
        
        String[] allYears = {"All", "2013", "2014", "2015", "2016", 
                             "2017", "2018", "2019", "2020"
        };
        return allYears;
    }
    
    public static String[] getTimeSlotsAvailable(String docOrNurse, String date, String duration) {
        
        DatabaseConnection connect = new DatabaseConnection();
        
        String[] timeSlotsOptions = getAllTimeSlotsForDuration(duration, date);
        String[] timesAvailableForDocOrNurse = connect.getTimesFromDoctorsandnurses(docOrNurse, date);
        
        ArrayList<String> timeSlotsAvailableArrayList = new ArrayList<String>();
        String[] timeSlotsAvailableArray;
        int durationInt = Integer.parseInt(duration.substring(0, 2));
        
        if (durationInt == 15) {
            for (int i=0; i<timesAvailableForDocOrNurse.length; i++) {
                // If timeslot does not have 'n' (for no - not available) then this timeslot is available so add it to  the array list.
                if (timesAvailableForDocOrNurse[i].equalsIgnoreCase("y"))
                    timeSlotsAvailableArrayList.add(timeSlotsOptions[i]);
            }
        }
        else if (durationInt == 30) {
            for (int i=0; i<timesAvailableForDocOrNurse.length-1; i++) {
                // If timeslot does not have 'n' (for no - not available) then this timeslot is available so add it to  the array list.
                if (timesAvailableForDocOrNurse[i].equalsIgnoreCase("y") && timesAvailableForDocOrNurse[i+1].equalsIgnoreCase("y"))
                    timeSlotsAvailableArrayList.add(timeSlotsOptions[i]);
            }
        }
        else if (durationInt == 45) {
            for (int i=0; i<timesAvailableForDocOrNurse.length-2; i++) {
                // If timeslot does not have 'n' (for no - not available) then this timeslot is available so add it to  the array list.
                if (timesAvailableForDocOrNurse[i].equalsIgnoreCase("y") && timesAvailableForDocOrNurse[i+1].equalsIgnoreCase("y") && timesAvailableForDocOrNurse[i+2].equalsIgnoreCase("y"))
                    timeSlotsAvailableArrayList.add(timeSlotsOptions[i]);
            }
        }
        else if (durationInt == 60) {
            for (int i=0; i<timesAvailableForDocOrNurse.length-3; i++) {
                // If timeslot does not have 'n' (for no - not available) then this timeslot is available so add it to  the array list.
                if (timesAvailableForDocOrNurse[i].equalsIgnoreCase("y") && timesAvailableForDocOrNurse[i+1].equalsIgnoreCase("y") && timesAvailableForDocOrNurse[i+2].equalsIgnoreCase("y") && timesAvailableForDocOrNurse[i+3].equalsIgnoreCase("y"))
                    timeSlotsAvailableArrayList.add(timeSlotsOptions[i]);
            }
        }
        
        timeSlotsAvailableArray = new String[timeSlotsAvailableArrayList.size()];
        
        for (int i=0; i<timeSlotsAvailableArray.length; i++)
            timeSlotsAvailableArray[i] = timeSlotsAvailableArrayList.get(i);
        
        return timeSlotsAvailableArray;
    }
    
    public static String[] getTimeSlotsAvailable(String docOrNurse, String date) { // OLD
        
        DatabaseConnection connect = new DatabaseConnection();
        
        String[] timeSlotsOptions = getAllTimeSlots(date);
        String[] timesAvailableForDocOrNurse = connect.getTimesFromDoctorsandnurses(docOrNurse, date);
        
        ArrayList<String> timeSlotsAvailableArrayList = new ArrayList<String>();
        String[] timeSlotsAvailableArray;
        
        for (int i=0; i<timesAvailableForDocOrNurse.length; i++) {
            // If timeslot does not have 'n' (for no - not available) then this timeslot is available so add it to  the array list.
            if (timesAvailableForDocOrNurse[i].equalsIgnoreCase("y"))
                timeSlotsAvailableArrayList.add(timeSlotsOptions[i]);
        }
        
        timeSlotsAvailableArray = new String[timeSlotsAvailableArrayList.size()];
        
        for (int i=0; i<timeSlotsAvailableArray.length; i++)
            timeSlotsAvailableArray[i] = timeSlotsAvailableArrayList.get(i);
        
        return timeSlotsAvailableArray;
    }
    
    public static boolean isBusyAllDay(String docOrNurse, String date) {
        
        String [] availableTimes = getTimeSlotsAvailable(docOrNurse, date);
        if (availableTimes.length == 0)
            // If no available timeslots are returned then the doc/nurse is busy all day, so return true.
            return true;
        // Otherwise return false.
        return false;
    }
    
    public static int getDayOfWeek(String date) {
        
        date = trimAll(date);
        String[] dates = date.split("-");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]) - 1;
        int day = Integer.parseInt(dates[2]);
        
        /*Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(stringToDate(date));*/
        //Calendar calendar = new GregorianCalendar(2014, 01, 12, 15, 20);
        Calendar calendar = new GregorianCalendar(year, month, day);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        // If the number is 1 then day is Sunday, and if it's 7 then it's Saturday, and so on.
        //System.out.println(dayOfWeek);
        
        return dayOfWeek;
    }
    
    public static Date stringToDate(String strDate) {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(strDate);
        } catch (ParseException e) {
            System.out.println("Unable to parse date format object into date. ==> " + e);
        }
        
        return date;
    }
    
    public static String getCurrentDate() {
        
        String[] dateFormats = {"yyyy-MM-dd", "HH:mm", "HH:mm:ss", "yyyy-MM-dd HH:mm:ss"};
        DateFormat dateFormat = new SimpleDateFormat(dateFormats[0]);
        Date date = new Date();
        String dateAsStr = dateFormat.format(date);
        // Or Also
        /*Calendar calendar = Calendar.getInstance();
        String dateAsStr = dateFormat.format(calendar.getTime());*/
        //System.out.println(dateAsStr);
        return dateAsStr;
    }
    
    public static String getCurrentYear() {
        
        return (getCurrentDate().substring(0, 4));
    }
    
    public static String getCurrentMonth() {
        
        return (getCurrentDate().substring(5, 7));
    }
    
    public static String getCurrentDay() {
        
        return (getCurrentDate().substring(8, 10));
    }
    
    public static String getCurrentDayOfWeek() {
        
        String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", };
        
        switch (getDayOfWeek(getCurrentDate())) {
            case 1 : return weekDays[0];
            case 2 : return weekDays[1];
            case 3 : return weekDays[2];
            case 4 : return weekDays[3];
            case 5 : return weekDays[4];
            case 6 : return weekDays[5];
            default : return weekDays[6];
        }
    }
    
    public static boolean isValidDateInCommonYear(String dateStr) {
        
        int month = Integer.parseInt(dateStr.substring(5, 7));
        int day = Integer.parseInt(dateStr.substring(8, 10));
        //System.out.println(month + "-" + day);
        if (!isLeapYear(dateStr) && month == 02 && day == 29)
            return false;
        return true;
    }
    
    public static boolean isLeapYear(String dateStr) {
        
        double year = Double.parseDouble(dateStr.substring(0, 4));
        //System.out.println(year);
        double res = year / 4;
        return isInt(year);
    }
    
    public static boolean dateIsInThePast(String dateStr) {
        
        dateStr = removeTokens(dateStr);
        //System.out.println(dateStr);
        
        int dateToCheck = Integer.parseInt(dateStr);
        int dateNow = Integer.parseInt(removeTokens(getCurrentDate()));
        
        int difference = dateToCheck - dateNow;
        if (difference < 0)
            return true;
        return false;
    }
    
    public static boolean dateTimeAreInThePast(String dateTimeStr) {
        
        String newDateTimeStr = "";
        for (int i=0; i<dateTimeStr.length(); i++) {
            if (dateTimeStr.charAt(i) != '-' && dateTimeStr.charAt(i) != '/' && dateTimeStr.charAt(i) != ' ' && dateTimeStr.charAt(i) != ':')
                newDateTimeStr += dateTimeStr.charAt(i);
        }//System.out.println(newDateTimeStr);
        return true;
    }
    
    public static boolean dateIsInCorrectFormat(String strDate) {
        
        if (strDate.length() == 10) {
            if (strDate.charAt(4) == '-' && strDate.charAt(7) == '-') {
                if (isNumber(strDate.substring(0,4)) && isNumber(strDate.substring(5,7)) && isNumber(strDate.substring(8,10)))
                    return true;
            }
        }
        return false;
    }
    
    public static String[] getDaysForYearAndMonth(String yearStr, String monthStr) {
        
        String[] daysToReturn;
        int arraySize;
        String[] daysArr = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
                         "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", 
                         "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
        };
        int year = Integer.parseInt(yearStr.substring(0, 4));
        int month = Integer.parseInt(monthStr.substring(0, 2));
        
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            arraySize = 31;
        else if (month == 4 || month == 6 || month == 9 || month == 11)
            arraySize = 30;
        else {
            if (isLeapYear(yearStr))
                arraySize = 29;
            else
                arraySize = 28;
        }
        
        daysToReturn = new String[arraySize];
        for (int i = 0; i < arraySize; i++)
            daysToReturn[i] = daysArr[i];
        return daysToReturn;
    }
    
    public static String[] getAllRooms() {
        
        /*DatabaseConnection connect = new DatabaseConnection();
        String[] allRooms = connect.getOneColumnFromTable("SELECT roomId FROM room ;");*/
        String[] allRooms = {"A001", "A002", "A003", "A004", "A005", "A006", "A007", "A008", "A009", "A010", 
                             "A101", "A102", "A103", "A104", "A105", "A106", "A107", "A108", "A109", "A110" 
        };
        return allRooms;
    }
    
    public static String[] getRoomsAvailableOld(String date, String timeSlot) { // OLD
        
        String[] rooms = getAllRooms();
        for (int i=0; i<rooms.length; i++) {
            if (! recordExists("SELECT * FROM room WHERE room = '" + rooms[i] + "' AND date = '" + date + "' ;"))
                print(rooms[i]);//return rooms;
            else {

            }
        }
        return rooms;
    }
    
    // Retrieve records from the database
    public static String[][] getTimesFromRoom(String date) {
        
        DatabaseConnection connect = new DatabaseConnection();
        //String[] allRooms = getAllRooms();
        String query = "SELECT " +
        "a9,b9,c9,d9,a10,b10,c10,d10,a11,b11,c11,d11,a12,b12,c12,d12,a13,b13,c13,d13,a14,b14,c14,d14,a15,b15,c15,d15,a16,b16,c16,d16,a17,b17 " +
        ", room, date FROM room ";
        //query += "WHERE room LIKE ";
        /*for (int i=0; i<allRooms.length; i++) {
            if (i != allRooms.length-1)
                query += "'" + allRooms[i] + "' OR ";
            else
                query += "'" + allRooms[i] + "' ";
        }
        query +=  "AND date LIKE '" + date + "' ;";*/
        query += "WHERE date LIKE '" + date + "' ;";
        System.out.println(query);
        String[][] array = connect.getTimesFromRoom(query);
        return array;
    }
    
    public static String[] getRoomsAvailable(String date, String timeSlot) {
        
        String[][] timesFromRoom = getTimesFromRoom(date);
        int[] columnIndeces = getColumnIndecesForTimeSlot(timeSlot);
        String[] allRooms = getAllRooms();
        String[] roomsAvailableToReturn = {};
        int roomsColumn = 34;
        ArrayList<String> OKList = new ArrayList<String>();
        ArrayList<String> toConsiderList = new ArrayList<String>();
        // Add the rooms that need to be checked for availability
        System.out.println(timesFromRoom.length + " " + timesFromRoom[0].length);
        if (timesFromRoom.length > 0) {
            for (int i=0; i<timesFromRoom.length; i++) {
                toConsiderList.add(timesFromRoom[i][roomsColumn]);
            }
        }
        // Add the OK rooms
        for (int i=0; i<timesFromRoom.length; i++) {
            if(! toConsiderList.contains(timesFromRoom[i][roomsColumn]))
                OKList.add(timesFromRoom[i][roomsColumn]);
        }
        // Check the toConsider rooms for availability at specified time slot.
        for (int i=0; i<toConsiderList.size(); i++) {
            // Find row in 'timesFromRoom' where value equals toConsiderList.get(i).
            findRow : for(int j=0; j<timesFromRoom.length; j++) {
                if (timesFromRoom[j][roomsColumn].equals(toConsiderList.get(i))) {
                    boolean flag = true;
                    for (int k=columnIndeces[0]; k<columnIndeces.length-1; k++) {
                        if (!timesFromRoom[j][k].equalsIgnoreCase("y"))
                            flag = false;
                    }
                    if (flag)
                        OKList.add(toConsiderList.get(i));
                    break findRow;
                }
            }
        }
        
        roomsAvailableToReturn = convertArrayListToArray(OKList);
        return roomsAvailableToReturn;
    }
    
    public static String[] getAllKeysOnly(String[][] array) {
        
        String[] arrayToReturn = new String[array.length];
        for (int i=0; i<array.length; i++)
            arrayToReturn[i] = array[i][0];
        return arrayToReturn;
    }
    
    public static String[] getAllValuesOnly(String[][] array) {
        
        String[] arrayToReturn = new String[array.length];
        for (int i=0; i<array.length; i++)
            arrayToReturn[i] = array[i][1];
        return arrayToReturn;
    }
    
    public static String getKey(String[][] array, int row) {
        
        return array[row][0];
    }
    
    public static String getVal(String[][] array, int row) {
        
        return array[row][1];
    }
    
    public static void print(String str) {
        
        System.out.println(str);
    }
    
    public static void print(String[] array) {
        
        for (String val : array)
            System.out.print(val + "\t");
        System.out.println();
    }
    
    public static void print(String[][] array) {
        
        for (int i=0; i<array.length; i++) {
            for (int j=0; j<array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    public static boolean isNumber(String str) {
        
        for (int i=0; i<str.length(); i++) {
            if (! isNumber(str.charAt(i)))
                return false;
        }
        return true;
    }
    
    public static boolean isNumber(char ch) {
        
        if (Character.isDigit(ch))
            return true;
        return false;
    }
    
    private static boolean isInt(double num) {
        
        //if ( num == Math.floor(num) && !Double.isInfinite(num))
        //System.out.println((num / 4) + "\n" + (int)(num / 4));
        if ((num / 4) == (int) (num / 4))
            return true;
        return false;
    }
    
    public static String removeTokens(String str) {
        
        String newStr = "";
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) != '-' && str.charAt(i) != '/' && str.charAt(i) != ' ' && str.charAt(i) != ':')
                newStr += str.charAt(i);
        }//System.out.println(newStr);
        return newStr;
    }
    
    public static String[] removeRepeated(String[] array) {
        
        //String[] arr = {"apple", "orange", "banana", "apple"};
        ArrayList<String> list = new ArrayList<String>();
        for (String val : array) {
            boolean exists = false;
            for (int i=0; i<list.size(); i++) {
                if (list.get(i).equals(val))
                    exists = true;
            }
            if (! exists)
                list.add(val);
        }
        //System.out.println(list);
        String[] newArray = new String[list.size()];
        newArray = list.toArray(newArray);
        //for (String val : newArray) System.out.print(val+" ");
        return newArray;
    }
    
    public static String trimAll(String str) {
        
        String newStr = "";
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) != ' ')
                newStr += str.charAt(i);
        }
        return newStr;
    }
    
    public static String[] trimAll(String[] strArray) {
        
        for (int i=0; i<strArray.length; i++) {
            strArray[i] = trimAll(strArray[i]);
        }
        return strArray;
    }
    
    public static String[] convertArrayListToArray(ArrayList<String> list) {
        
        String[] array = {};
        array = new String[list.size()];
        for (int i=0; i<list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
    
    public static String[][] convert2DArrayListTo2DArray(ArrayList<ArrayList<String>> list) {
        
        String[][] array = {{}};
        if (list.size() > 0) {
            array = new String[list.size()][list.get(0).size()];
            for (int i=0; i<list.size(); i++) {
                for (int j=0; j<list.get(i).size(); j++) {
                    array[i][j] = list.get(i).get(j);
                }
            }
        }
        return array;
    }
    
    public static void close() {
        
        DatabaseConnection connect = new DatabaseConnection();
        connect.close();
    }
    
    public static void getAppointmentsNoGUI() {
        
        DatabaseConnection connect = new DatabaseConnection();
        
        String query = "SELECT * FROM appointments ";
        boolean condition = false; // Initially assume that some properties have been set.
        //String query = "SELECT appId, appType, patientId, appWithStaffId, date, startTime, finishTime FROM appointments;";
        
        Scanner in = new Scanner(System.in);
        String msg = "Please enter details of any of the below properties (separated by commas)\n";
        msg += "appId, appType, patientId, appWithStaffId, date, startTime, finishTime, room, summary\n";
        System.out.println(msg);
        String input = in.nextLine();
        String[] line = input.split(",");
        for (int i=0; i<line.length; i++)
            line[i] = line[i].trim();
        
        if (! allUnset(line))
            condition = true;
        
        if (condition) {
            
            ArrayList<String> allConditions = new ArrayList<String>();
            
            String[] columnNames = {"appId ", "appType ", "patientId ", "appWithStaffId ", "date ", "startTime ", "finishTime ", "room", "summary"};
            for (int i=0; i<line.length; i++) {
                if ( ! line[i].equals("") )
                    allConditions.add(columnNames[i] + "LIKE '" + line[i] + "' ");
            }
            
            for (int i=0; i<allConditions.size(); i++) {
                if (i != allConditions.size()-1)
                    allConditions.set(i, allConditions.get(i) + "AND ");
            }
            
            query += "WHERE ";
            for (String tmp : allConditions)
                query += tmp;
            
        }
        
        query += "ORDER BY date, startTime, patientID ";
        query += ";";
        System.out.println(query);
        connect.getRecordsNoGUI(query);
    }
    
    public static void addAppointmentNoGUI() {
        
        DatabaseConnection connect = new DatabaseConnection();
        
        /*String query = "INSERT INTO appointments " + 
                            "(appType, patientId, appWithStaffId, date, startTime, finishTime)" + 
                            "VALUES ('Care Management', 5, 2, '02/02/2014', '00:10', '00:50') ;";*/
        
        Scanner in = new Scanner(System.in);
        String msg = "Please enter details of the new appointment according to the properties below (separated by commas)\n";
        msg += "appType, patientId, appWithStaffId, date, startTime, finishTime, room\n";
        System.out.println(msg);
        String input = in.nextLine();
        
        String update = "INSERT INTO appointments " + 
                            "(appType, patientId, appWithStaffId, date, startTime, finishTime, room)" + 
                            "VALUES (" + input + ") ;";
        
        //connect.addRecords(update);
        connect.execute(update);
    }
    
}
