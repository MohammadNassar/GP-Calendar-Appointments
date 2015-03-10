// 'Calendar Appointments' module - By Mohammad Nassar - ID No. 120132108

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {
    
    private Connection connect;
    private Statement statement;
    private ResultSet result;
    
    public DatabaseConnection() {
        
        String loginUser = "SEGA";
        String loginPassword = "";
        String databaseName = "SEGA";
        String loginUrl = "jdbc:mysql://dbprojects.eecs.qmul.ac.uk:3306/" + databaseName;  // (On Campus)
        //String loginUrl = "jdbc:mysql://localhost:3307/" + databaseName;  // (Off Campus) ==> (requires reverse tunnelling see guide)
        
        try {
            // Loading mysql driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Get/create the connection (Connect to the local server ==> phpMyAAdmin)
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/SEGA", "root", "");
            
            // Get/create the connection (Connect to the uni's server - On/Off Campus)
            //connect = DriverManager.getConnection(loginUrl, loginUser, loginPassword);
            
            // Create a statement
            statement = connect.createStatement();
            
        } catch (ClassNotFoundException c) {
            System.out.println("Unable to create the connection. ==> ("+c+")");
        } catch (SQLException s) {
            System.out.println("Unable to get connection or create statement. ==> ("+s+")");
        }
    }
    
    // Retrieve records from the database
    public String[][] getAppointments(String instruction) {
        
        //String query = "SELECT * FROM Appointments;";
        String query = instruction;
        String[][] rowsInTable = {{"", "", "", "", "", "", ""}};
        
        try {
            // Perform the query ==> (Execute the SQL statement and save the returned value in variable 'result').
            result = statement.executeQuery(query);
            
            ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
            int index = 0;
            while (result.next()) {
                
                list.add(new ArrayList<String>());
                // Concatenate results retrieved from table and print them.
                String appId = result.getString("appId");
                String appType = result.getString("appType");
                String patientId = result.getString("patientId");
                String appWithStaffId = result.getString("appWithStaffId");
                String date = result.getString("date");
                String startTime = result.getString("startTime");
                String finishTime = result.getString("finishTime");
                
                list.get(index).add(appId);
                list.get(index).add(appType);
                list.get(index).add(patientId);
                list.get(index).add(appWithStaffId);
                list.get(index).add(date);
                list.get(index).add(startTime);
                list.get(index).add(finishTime);
                index++;
            }
            
            if (list.size() > 0) {
                rowsInTable = new String[list.size()][list.get(0).size()];
                for (int i=0; i<list.size(); i++) {
                    for (int j=0; j<list.get(i).size(); j++) {
                        rowsInTable[i][j] = list.get(i).get(j);
                    }
                }
            }
            
        } catch (SQLException s) {
            System.out.println("Unable to execute query. ==> ("+s+")");
        }
        
        return rowsInTable;
    }
    
    // Retrieve records from the database
    public void getAppointmentsOld(String instruction) {
        
        //String query = "SELECT * FROM Appointments;";
        String query = instruction;
        
        try {
            // Perform the query ==> (Execute the SQL statement and save the returned value in variable 'result').
            result = statement.executeQuery(query);
            
            while (result.next()) {
                String appId = result.getString("appId");
                String appType = result.getString("appType");
                String patientId = result.getString("patientId");
                String appWithStaffId = result.getString("appWithStaffId");
                String date = result.getString("date");
                String startTime = result.getString("startTime");
                String finishTime = result.getString("finishTime");
                
                // Concatenate results retrieved from table and print them.
                String rowInTable = "App.No.: "+appId+"\t"+"App.Type is: "+appType+"\t";
                if (appType.equalsIgnoreCase("Routine")) rowInTable += "\t";
                rowInTable += "Patient: "+patientId+"\t"+"App.with: "+appWithStaffId+"\t";
                rowInTable += "Date: "+date+"\t"+"Start time: "+startTime+"\t"+"Finish time: "+finishTime+"\t";
                System.out.println(rowInTable);
            }
            
        } catch (SQLException s) {
            System.out.println("Unable to execute query. ==> ("+s+")");
        }
    }
    
    // Add a record into the database
    public void addAppointment(String instruction) {
        
        try {
            statement.executeUpdate(instruction);
        } catch (SQLException s) {
            System.out.println("Unable to execute query. ==> ("+s+")");
        }
    }
}
