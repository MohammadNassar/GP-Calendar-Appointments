// 'Calendar Appointments' module - By Mohammad Nassar - ID No. 120132108
// Version 3 - Adding a record/row to the database based on user request made by his input
// Appropriate input for method: 'getRecords' is:  ,Routine,,,13/01/2014,,  or  ,Routine,,,,,  or (to view all appointments) 	,,,,,,
// Appropriate input for method: 'addRecords' is:  'routine', 30, 50, '01/01/1000', '12:34', '23:45'

import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        //getRecordsOld();
        //addRecords();
    }
    
    public static void getRecordsOld() {
        
        DatabaseConnection connect = new DatabaseConnection();
        
        String query = "SELECT * FROM Appointments ";
        boolean condition = false; // Initially assume that some properties have been set.
        //String query = "SELECT appId, appType, patientId, appWithStaffId, date, startTime, finishTime FROM Appointments;";
        
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
        connect.getAppointmentsOld(query);
    }
    
    public static String[][] getRecords(String[] line) {
        
        DatabaseConnection connect = new DatabaseConnection();
        
        String query = "SELECT * FROM Appointments ";
        boolean condition = false; // Initially assume that some properties have been set.
        //String query = "SELECT appId, appType, patientId, appWithStaffId, date, startTime, finishTime FROM Appointments;";
        
        
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
        String[][] table = connect.getAppointments(query);
        return table;
    }
    
    public static void addRecords() {
        
        DatabaseConnection connect = new DatabaseConnection();
        
        /*String query = "INSERT INTO Appointments " + 
                            "(appType, patientId, appWithStaffId, date, startTime, finishTime)" + 
                            "VALUES ('Care Management', 5, 2, '02/02/2014', '00:10', '00:50') ;";*/
        
        Scanner in = new Scanner(System.in);
        String msg = "Please enter details of the new appointment according to the properties below (separated by commas)\n";
        msg += "appType, patientId, appWithStaffId, date, startTime, finishTime\n";
        System.out.println(msg);
        String input = in.nextLine();
        
        String update = "INSERT INTO Appointments " + 
                            "(appType, patientId, appWithStaffId, date, startTime, finishTime)" + 
                            "VALUES (" + input + ") ;";
        
        connect.addAppointment(update);
    }
    
    // Return true if all entries are unset or empty
    private static boolean allUnset(String[] entries) {
        
        for (String tmp :  entries) {
            if (!tmp.equals(""))
                return false;
        }
        return true;
    }
    
}
