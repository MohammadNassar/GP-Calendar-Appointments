// 'Calendar Appointments' module - By Mohammad Nassar - ID No. 120132108
// Version 2 - Retrieving information from the database based on user request made by his input
// Appropriate input is:  ,Routine,,,13/01/2014,,  or  ,Routine,,,,,  or (to view all appointments) 	,,,,,,

import java.util.*;

public class Main {

    public static void main(String[] args) {
        
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
        connect.getRecords(query);
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
