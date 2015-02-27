// 'Calendar Appointments' module - By Mohammad Nassar - ID No. 120132108

import java.sql.*;

public class DatabaseConnection {
    
    private Connection connect;
    private Statement statement;
    private ResultSet result;
    
    public DatabaseConnection() {
        
        try {
            // Loading mysql driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Get/create the connection
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sega", "root", "");
            // Create a statement
            statement = connect.createStatement();
            
        } catch (ClassNotFoundException c) {
            System.out.println("Unable to create the connection. ==> ("+c+")");
        } catch (SQLException s) {
            System.out.println("Unable to create statement. ==> ("+s+")");
        }
    }
    
    // Retrieve records from the database
    public void getRecords(String instruction) {
        
        //String query = "SELECT * FROM Appointments;";
        String query = instruction;
        
        try {
            // Execute the SQL statement and save the returned value in variable 'result'.
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
}
