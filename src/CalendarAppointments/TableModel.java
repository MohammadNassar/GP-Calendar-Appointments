package CalendarAppointments;

import javax.swing.table.AbstractTableModel;
import javax.swing.*;

public class TableModel extends AbstractTableModel {
    
    private String[] columnNames = {"App.ID", "Type", "Patient ID", "Satff ID", "Date", "Start Time", "Finish Time", "Room", "Summary"};
    //private String[] columnNames = {"Edit/Remove", "App.ID", "Type", "Patient ID", "Satff ID", "Date", "Start Time", "Finish Time", "Room", "Summary"};
    private String[] filter = {"", "", "", "", "", "", "", "", ""};
    private Object[][] tableData, friendlyTableData, emptyTable = {{"","","","","","","","",""}};
    private Object[] patientsIDs, staffIDs;
    
    public TableModel() {
        
        super();
        tableData = Main.getAppointments(filter);
        //tableData = addControlButtons(tableData);
        /*friendlyTableData = getCopyOf(tableData);
        keepPatientsIDs();
        keepStaffIDs();
        Main.exchangePatientIDsWithPatientNames(friendlyTableData);
        Main.exchangeStaffIDsWithStaffNames(friendlyTableData);*/
    }
    
    public void setFilter(String[] filterArray) {
        
        filter = filterArray;
        tableData = Main.getAppointments(filter);
        //tableData = addControlButtons(tableData);
        /*friendlyTableData = getCopyOf(tableData);
        keepPatientsIDs();
        keepStaffIDs();
        Main.exchangePatientIDsWithPatientNames(friendlyTableData);
        Main.exchangeStaffIDsWithStaffNames(friendlyTableData);*/
    }
    
    public void keepPatientsIDs() {
        
        patientsIDs = new String[tableData.length];
        int col = 2;
        for (int i=0; i<tableData.length; i++) {
            patientsIDs[i] = tableData[i][col];
        }
    }
    
    public void keepStaffIDs() {
        
        staffIDs = new String[tableData.length];
        int col = 3;
        for (int i=0; i<tableData.length; i++) {
            staffIDs[i] = tableData[i][col];
        }
    }
    
    public Object getPatientID(int row) {
        
        return patientsIDs[row];
    }
    
    public Object getStaffID(int row) {
        
        return staffIDs[row];
    }
    
    public static Object[][] getCopyOf(Object[][] array) {
        
        Object[][] arrayToReturn = new Object[array.length][array[0].length];
        for (int i=0; i<array.length; i++) {
            for (int j=0; j<array[0].length; j++) {
                arrayToReturn[i][j] = array[i][j];
            }
        }
        return arrayToReturn;
    }
    
    public String[] getColumnsNames() {
        
        return columnNames;
    }
    
    public String getColumnName(int column) {
        
        return columnNames[column].toString();
    }
    
    public Object[][] getTableData() {
        
        return tableData;
        //return friendlyTableData;
    }
    
    public int getRowCount() {
        
        return tableData.length;
    }
    
    public int getColumnCount() {
        
        return columnNames.length;
    }
    
    public Object getValueAt(int row, int column) {
        
        if (Main.isEmpty(tableData))
            //return new String[][]{{"","","","","","","","",""}};
            tableData = new String[][]{{"","","","","","","","",""}};
        return tableData[row][column];
    }
    
    public void setValueAt(Object value, int row, int col) {
        
        tableData[row][col] = value;
        fireTableCellUpdated(row, col);
        
    }
    
    public Class getColumnClass(int c) {
        
        return getValueAt(0, c).getClass();
    }
    
    public boolean isCellEditable(int row, int col) {
        
        /*if (col < 2) // Means if row index selected is less than 2, then it cannot be edited.
            return false;
        else
            return true;*/
        return false;
    }
    
    public Object[][] addControlButtons(Object[][] tableData) {
        
        Object[][] newTableData = new Object[tableData.length][tableData[0].length+1];
        
        for (int i=0; i<tableData.length; i++) {
            for (int j=0; j<tableData[0].length; j++) {
                newTableData[i][j+1] = tableData[i][j];
            }
        }
        
        for (int i=0; i<newTableData.length; i++) {
            JButton button = new JButton("Edit");
            //button.setOpaque(true);
            newTableData[i][0] = button;
        }
        
        return newTableData;
    }
}
