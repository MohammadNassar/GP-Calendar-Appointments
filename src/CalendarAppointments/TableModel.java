package CalendarAppointments;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
    
    private String[] columnNames = {"App.ID", "Type", "Patient ID", "Satff ID", "Date", "Start Time", "Finish Time"};
    private String[] filter = {"", "", "", "", "", "", ""};
    private Object[][] tableData;
    
    public TableModel() {
        
        super();
        tableData = Main.getAppointments(filter);
    }
    
    public void setFilter(String[] filterArray) {
        
        filter = filterArray;
        tableData = Main.getAppointments(filter);
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
        
        return tableData[row][column];
    }
    
    public Class getColumnClass(int c) {
        
        return getValueAt(0, c).getClass();
    }
}
