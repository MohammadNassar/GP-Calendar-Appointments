package CalendarAppointments;

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
        //String loginUrl = "jdbc:mysql://dbprojects.eecs.qmul.ac.uk:3306/" + databaseName;  // (On Campus)
        String loginUrl = "jdbc:mysql://localhost:3307/" + databaseName;  // (Off Campus) ==> (requires reverse tunnelling see guide) ==> TUNNELING
        // For tunnelling enter this into the 'mobaXterm' program ==> ssh -N -L 3307:dbprojects.eecs.qmul.ac.uk:3306 mn302@bert.eecs.qmul.ac.uk
        
        try {
            // Loading mysql driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Get/create the connection (Connect to the local server ==> phpMyAAdmin)
            //connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/SEGA", "root", "");
            
            // Get/create the connection (Connect to the uni's server - On/Off Campus)
            connect = DriverManager.getConnection(loginUrl, loginUser, loginPassword);
            
            // Create a statement
            statement = connect.createStatement();
            
        } catch (ClassNotFoundException c) {
            System.out.println("Unable to create the connection. ==> ("+c+")");
        } catch (SQLException s) {
            System.out.println("Unable to get connection or create statement. ==> ("+s+")");
        }
    }
    
    // Retrieve records from the database
    public String[][] getRecords(String instruction) {
        
        //String query = "SELECT * FROM appointments;";
        String query = instruction;
        String[][] rowsInTable = {{"", "", "", "", "", "", "", "", ""}};
        
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
                String room = result.getString("room");
                String summary = result.getString("summary");
                
                list.get(index).add(appId);
                list.get(index).add(appType);
                list.get(index).add(patientId);
                list.get(index).add(appWithStaffId);
                list.get(index).add(date);
                list.get(index).add(startTime);
                list.get(index).add(finishTime);
                list.get(index).add(room);
                list.get(index).add(summary);
                index++;
            }
            
            rowsInTable = convert2DArrayListTo2DArray(list);
            //exchangePatientIDsWithPatientNames(rowsInTable);
            //exchangeStaffIDsWithStaffNames(rowsInTable);
            
        } catch (SQLException s) {
            System.out.println("Unable to execute query. ==> ("+s+")");
        }
        
        return rowsInTable;
    }
    
    // Retrieve records from the database
    public String[][] getDaysOff(String instruction) {
        
        //String query = "SELECT * FROM appointments;";
        String query = instruction;
        String[][] rowsInTable = {{""}};
        
        try {
            // Perform the query ==> (Execute the SQL statement and save the returned value in variable 'result').
            result = statement.executeQuery(query);
            
            ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
            int index = 0;
            while (result.next()) {
                
                list.add(new ArrayList<String>());
                // Concatenate results retrieved from table and print them.
                String day = result.getString("day");
                
                list.get(index).add(day);
                
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
    
    public String[][] getKeyAndValOfPatients() {
        
        String query = "SELECT * FROM Patient ;";
        System.out.println(query);
        String[][] array = {{}};
        try {
            result = statement.executeQuery(query);
            ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
            int index = 0;
            while (result.next()) {

                list.add(new ArrayList<String>());
                boolean addMName;
                // Concatenate results retrieved from table and print them.
                String key = result.getString("NhsNumber");
                String fname = result.getString("FirstName");
                String mname = result.getString("MiddleName");
                addMName = (result.wasNull()) ? false : true;
                String lname = result.getString("LastName");
                String val = "";
                if (addMName)
                    val = fname + " " + mname + " " + lname;
                else
                    val = fname + " " + lname;

                list.get(index).add(key);
                list.get(index).add(val);
                index++;
            }
            array = convert2DArrayListTo2DArray(list);
        }
        catch (SQLException s) {
        System.out.println("Unable to execute query. ==> ("+s+")");
        }
        return array;
    }
    
    public Object[][] exchangePatientIDsWithPatientNames(Object[][] array) {
        
        int col = 2;
        for (int i=0; i<array.length; i++) {
            String id = array[i][col].toString();
            String query = "SELECT * FROM Patient WHERE NhsNumber = '" + id + "' ;";
            //System.out.println(query);
            String name = id; // Initially name is set to id (the original value), just in case if any problem occurs, then the id number would stay there in the table.
            try {
                result = statement.executeQuery(query);
                if (result.next()) {
                    boolean addMName;
                    // Concatenate results retrieved from table and eventually add them where the id used to be.
                    String fname = result.getString("FirstName");
                    String mname = result.getString("MiddleName");
                    addMName = (result.wasNull()) ? false : true;
                    String lname = result.getString("LastName");
                    if (addMName)
                        name = fname + " " + mname + " " + lname;
                    else
                        name = fname + " " + lname;
                }
                array[i][2] = name;
            }
            catch (SQLException s) {
                System.out.println("Unable to execute query. ==> ("+s+")");
            }
        }
        return array;
    }
    
    public Object[][] exchangeStaffIDsWithStaffNames(Object[][] array) {
        
        int col = 3;
        for (int i=0; i<array.length; i++) {
            String id = array[i][col].toString();
            String query = "SELECT * FROM Staff WHERE StaffID = '" + id + "' ;";
            //System.out.println(query);
            String name = id;
            try {
                result = statement.executeQuery(query);
                if (result.next()) {
                    // Concatenate results retrieved from table and eventually add them where the id used to be.
                    String fname = result.getString("Forename");
                    String sname = result.getString("Surname");
                    name = fname + " " + sname;
                }
                array[i][col] = name;
            }
            catch (SQLException s) {
            System.out.println("Unable to execute query. ==> ("+s+")");
            }
        }
        return array;
    }
    
    public String getStaffNameWhoseIdIs(String id) {
        
        return id;
    }
    
    // Retrieve ANY records from the database
    public String[] getOneColumnFromTable(String instruction) {
        
        String[] commands = instruction.split(" ");
        String columnName = commands[1];
        
        String query = instruction;
        String[] rowsInTable = new String[0];
        
        try {
            // Perform the query ==> (Execute the SQL statement and save the returned value in variable 'result').
            result = statement.executeQuery(query);
            
            ArrayList<String> list = new ArrayList<String>();
            int index = 0;
            while (result.next()) {
                
                // Concatenate results retrieved from table and print them.
                String day = result.getString(columnName);
                
                list.add(day);
                index++;
            }
            
            if (list.size() > 0) {
                rowsInTable = new String[list.size()];
                for (int i=0; i<list.size(); i++) {
                    rowsInTable[i] = list.get(i);
                }
            }
            
        } catch (SQLException s) {
            System.out.println("Unable to execute query. ==> ("+s+")");
        }
        
        return rowsInTable;
    }
    
    // Retrieve records from the database
    public String[] getTimesFromDoctorsandnurses(String name, String date) {
        
        String query = "SELECT " +
        "a9,b9,c9,d9,a10,b10,c10,d10,a11,b11,c11,d11,a12,b12,c12,d12,a13,b13,c13,d13,a14,b14,c14,d14,a15,b15,c15,d15,a16,b16,c16,d16,a17,b17 " +
        "FROM " +
        "doctorsandnurses WHERE name LIKE '" + name + "' AND date LIKE '" + date + "' ;";
        
        System.out.println(query);
        
        String[] availabilityRow = new String[34];
        String[] atColumns = {"a9","b9","c9","d9","a10","b10","c10","d10","a11","b11","c11","d11","a12","b12","c12","d12",
                             "a13","b13","c13","d13","a14","b14","c14","d14","a15","b15","c15","d15","a16","b16","c16","d16","a17","b17"};
        
        try {
            // Perform the query ==> (Execute the SQL statement and save the returned value in variable 'result').
            result = statement.executeQuery(query);
        
            if (result.next()) {
                
                // Add results retrieved from table to an array.
                for (int i=0; i<atColumns.length; i++) {
                    availabilityRow[i] = result.getString(atColumns[i]);
                }
            }
        } catch (SQLException s) {
            System.out.println("Unable to execute query. ==> ("+s+")");
        }
        
        return availabilityRow;
    }
    
    // Retrieve records from the database
    public String[] getTimesFromRoom(String room, String date) {
        
        String query = "SELECT " +
        "a9,b9,c9,d9,a10,b10,c10,d10,a11,b11,c11,d11,a12,b12,c12,d12,a13,b13,c13,d13,a14,b14,c14,d14,a15,b15,c15,d15,a16,b16,c16,d16,a17,b17 " +
        ", room, date " + 
        "FROM " +
        "room WHERE room LIKE '" + room + "' AND date LIKE '" + date + "' ;";
        
        System.out.println(query);
        
        String[] availabilityRow = new String[34];
        String[] atColumns = {"a9","b9","c9","d9","a10","b10","c10","d10","a11","b11","c11","d11","a12","b12","c12","d12",
                             "a13","b13","c13","d13","a14","b14","c14","d14","a15","b15","c15","d15","a16","b16","c16","d16","a17","b17"};
        
        try {
            // Perform the query ==> (Execute the SQL statement and save the returned value in variable 'result').
            result = statement.executeQuery(query);
        
            if (result.next()) {
                
                // Add results retrieved from table to an array.
                for (int i=0; i<atColumns.length; i++) {
                    availabilityRow[i] = result.getString(atColumns[i]);
                }
            }
        } catch (SQLException s) {
            System.out.println("Unable to execute query. ==> ("+s+")");
        }
        
        return availabilityRow;
    }
    
    // Retrieve records from the database
    public String[] getNamesFromDoctorsandnurses(String name) { // NOT USED
        
        String query = "SELECT " +
        "a9,b9,c9,d9,a10,b10,c10,d10,a11,b11,c11,d11,a12,b12,c12,d12,a13,b13,c13,d13,a14,b14,c14,d14,a15,b15,c15,d15,a16,b16,c16,d16,a17,b17 " +
        "FROM " +
        "doctorsandnurses WHERE name LIKE '" + name + "' ;";
        
        System.out.println(query);
        
        String[] availabilityRow = new String[34];
        String[] atColumns = {"a9","b9","c9","d9","a10","b10","c10","d10","a11","b11","c11","d11","a12","b12","c12","d12",
                             "a13","b13","c13","d13","a14","b14","c14","d14","a15","b15","c15","d15","a16","b16","c16","d16","a17","b17"};
        
        try {
            // Perform the query ==> (Execute the SQL statement and save the returned value in variable 'result').
            result = statement.executeQuery(query);
        
            if (result.next()) {
                
                // Add results retrieved from table to an array.
                for (int i=0; i<atColumns.length; i++) {
                    availabilityRow[i] = result.getString(atColumns[i]);
                }
            }
        } catch (SQLException s) {
            System.out.println("Unable to execute query. ==> ("+s+")");
        }
        
        return availabilityRow;
    }
    
    public boolean recordExists(String instruction) {
        boolean exists = false;
        try {
            // Perform the query ==> (Execute the SQL statement and save the returned value in variable 'result').
            result = statement.executeQuery(instruction);
            if (result.next())
                exists = true;
        } catch (SQLException s) {
            System.out.println("Unable to execute query. ==> ("+s+")");
        }
        return exists;
    }
    
    // Retrieve records from the database
    public void getRecordsNoGUI(String instruction) {
        
        //String query = "SELECT * FROM appointments;";
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
                String room = result.getString("room");
                String summary = result.getString("summary");
                
                // Concatenate results retrieved from table and print them.
                String rowInTable = "App.No.: "+appId+"\t"+"App.Type is: "+appType+"\t";
                if (appType.equalsIgnoreCase("Routine")) rowInTable += "\t";
                rowInTable += "Patient: "+patientId+"\t"+"App.with: "+appWithStaffId+"\t";
                rowInTable += "Date: "+date+"\t"+"Start time: "+startTime+"\t"+"Finish time: "+finishTime+"\t";
                rowInTable += "Room: "+room+"\t"+"Summary: "+summary;
                System.out.println(rowInTable);
            }
            
        } catch (SQLException s) {
            System.out.println("Unable to execute query. ==> ("+s+")");
        }
    }
    
    // Add a record into the database
    public void addRecords(String instruction) {
        
        System.out.println(instruction);
        try {
            statement.executeUpdate(instruction);
        } catch (SQLException s) {
            System.out.println("Unable to execute query. ==> ("+s+")");
        }
    }
    
    public void execute(String instruction) {
        
        System.out.println(instruction);
        try {
            statement.executeUpdate(instruction);
        } catch (SQLException s) {
            System.out.println("Unable to execute query. ==> ("+s+")");
        }
    }
    // Retrieve records from the database
    public String[][] getTimesFromRoom(String instruction) {
        
        //String query = "SELECT * FROM appointments;";
        String query = instruction;
        String[][] rowsInTable = {{}};
        
        try {
            // Perform the query ==> (Execute the SQL statement and save the returned value in variable 'result').
            result = statement.executeQuery(query);
            
            ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
            int index = 0;
            while (result.next()) {
                
                list.add(new ArrayList<String>());
                // Concatenate results retrieved from table and print them.
                for (int i=1; i<=36; i++) {
                    String val = result.getString(i);
                    list.get(index).add(val);
                }
                index++;
            }
            rowsInTable = convert2DArrayListTo2DArray(list);
        } catch (SQLException s) {
            System.out.println("Unable to execute query. ==> ("+s+")");
        }
        
        return rowsInTable;
    }
    
    public String[][] getTable(String instruction) { // To improve.
        
        String[][] table = {};
        System.out.println(instruction);
        try {
            statement.executeQuery(instruction);
        } catch (SQLException s) {
            System.out.println("Unable to execute query. ==> ("+s+")");
        }
        return table;
    }
    
    public void close() {
       
        try {
            
            connect.close();
            System.out.println("Closed");
        } catch (SQLException s) {
            System.out.println("Unable to get connection or create statement. ==> ("+s+")");
        }
    }
    
    public String[] convertArrayListToArray(ArrayList<String> list) {
        
        String[] array = {};
        array = new String[list.size()];
        for (int i=0; i<list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
    
    public String[][] convert2DArrayListTo2DArray(ArrayList<ArrayList<String>> list) {
        
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
}
