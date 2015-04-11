package CalendarAppointments;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
    
    private final String[] columnNames = {"App.ID", "Type", "Patient ID", "Satff ID", "Date", "Start Time", "Finish Time", "Room", "Summary"};
    private String[] filter = {"", "", "", "", "", "", "", "", ""};
    private Object[][] tableData, emptyTable = {{"","","","","","","","",""}};
    
    public TableModel() {
        
        super();
        tableData = Main.getAppointments(filter);
    }
    
    public void setFilter(String[] filterArray) {
        
        filter = filterArray;
        tableData = Main.getAppointments(filter);
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
    }
    
    public int getRowCount() {
        
        return tableData.length;
    }
    
    public int getColumnCount() {
        
        return columnNames.length;
    }
    
    public Object getValueAt(int row, int column) {
        
        if (Main.isEmpty(tableData))
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
        // It means do not let any cell in the table to be edited by user from within the table itself.
        return false;
    }
}
