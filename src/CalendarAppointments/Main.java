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
        //getCurrentDate();
        //System.out.println(dateIsInThePast("2014-02-13"));
        //removeTokens("2014-0/2: 13");
        //String[] arr = {};
        //removeRepeated(arr);
        //System.out.println(isBusyAllDay("ali", "2014-05-20"));
        //System.out.println(recordExists("SELECT * FROM doctorsandnurses WHERE name like 'hassan' ;"));
        //System.out.println(getColumnNameForTimeSlot("13:00-13:15"));
        //String[] arr = {"one", "two", "three"};
        //addAppointment(arr);
    }
    
    public static void execute (String instruction) { // This method can be used for SQL queries that do not return a value, e.g. INSERT, UPDATE and REMOVE.
        
        DatabaseConnection connect = new DatabaseConnection();
        
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
            
            String[] columnNames = {"appId ", "appType ", "patientId ", "appWithStaffId ", "date ", "startTime ", "finishTime "};
            for (int i=0; i<line.length; i++) {
                if ( ! line[i].equals("") )
                    allConditions.add(columnNames[i] + "= '" + line[i] + "' ");
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
                            "(appType, patientId, appWithStaffId, date, startTime, finishTime)" + 
                            "VALUES (" + values + ") ;";
        System.out.println(update);
        connect.execute(update);
    }
    
    public static void editAppointment(String[] array, String id) {
        
        DatabaseConnection connect = new DatabaseConnection();
        
        String[] columnName = {"appType", "patientId", "appWithStaffId", "date", "startTime", "finishTime"};
        
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
        System.out.println(update);
        connect.execute(update);
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
        //System.out.println(true);
        return true;
    }
    
    public static String[] getAllDoctorsAndNurses() {
        String[] timeSlots = {"Ali", "John"};
        return timeSlots;
    }
    
    public static String getColumnNameForTimeSlot(String timeSlot) {
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
        String[] columnNames = {"a9","b9","c9","d9","a10","b10","c10","d10","a11","b11","c11","d11","a12","b12","c12","d12",
                              "a13","b13","c13","d13","a14","b14","c14","d14","a15","b15","c15","d15","a16","b16","c16","d16","a17","b17"};
        
        String columnName = "";
        for (int i=0; i<timeSlots.length; i++) {
            if (timeSlots[i].equals(timeSlot)) {
                columnName = columnNames[i];
                break;
            }
        }
        return columnName;
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
    
    public static String[] getTimeSlotsAvailable(String docOrNurse, String date) {
        
        DatabaseConnection connect = new DatabaseConnection();
        
        String[] timeSlotsOptions = {"09:00-09:15", "09:15-09:30", "09:30-09:45", "09:45-10:00",
                                     "10:00-10:15", "10:15-10:30", "10:30-10:45", "10:45-11:00",
                                     "11:00-11:15", "11:15-11:30", "11:30-11:45", "11:45-12:00",
                                     "12:00-12:15", "12:15-12:30", "12:30-12:45", "12:45-13:00",
                                     "13:00-13:15", "13:15-13:30", "13:30-13:45", "13:45-14:00",
                                     "14:00-14:15", "14:15-14:30", "14:30-14:45", "14:45-15:00",
                                     "15:00-15:15", "15:15-15:30", "15:30-15:45", "15:45-16:00",
                                     "16:00-16:15", "16:15-16:30", "16:30-16:45", "16:45-17:00",
                                     "17:00-17:15", "17:15-17:30"
        };
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
    
    public static void getAppointmentsNoGUI() {
        
        DatabaseConnection connect = new DatabaseConnection();
        
        String query = "SELECT * FROM appointments ";
        boolean condition = false; // Initially assume that some properties have been set.
        //String query = "SELECT appId, appType, patientId, appWithStaffId, date, startTime, finishTime FROM appointments;";
        
        Scanner in = new Scanner(System.in);
        String msg = "Please enter details of any of the below properties (separated by commas)\n";
        msg += "appId, appType, patientId, appWithStaffId, date, startTime, finishTime\n";
        System.out.println(msg);
        String input = in.nextLine();
        String[] line = input.split(",");
        for (int i=0; i<line.length; i++)
            line[i] = line[i].trim();
        
        if (! allUnset(line))
            condition = true;
        
        if (condition) {
            
            ArrayList<String> allConditions = new ArrayList<String>();
            
            String[] columnNames = {"appId ", "appType ", "patientId ", "appWithStaffId ", "date ", "startTime ", "finishTime "};
            for (int i=0; i<line.length; i++) {
                if ( ! line[i].equals("") )
                    allConditions.add(columnNames[i] + "= '" + line[i] + "' ");
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
        msg += "appType, patientId, appWithStaffId, date, startTime, finishTime\n";
        System.out.println(msg);
        String input = in.nextLine();
        
        String update = "INSERT INTO appointments " + 
                            "(appType, patientId, appWithStaffId, date, startTime, finishTime)" + 
                            "VALUES (" + input + ") ;";
        
        //connect.addRecords(update);
        connect.execute(update);
    }
    
}
