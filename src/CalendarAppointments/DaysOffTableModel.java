package CalendarAppointments;

import javax.swing.table.AbstractTableModel;

public class DaysOffTableModel extends AbstractTableModel {
    
    private final String[] columnNames = {"Days Off Dates", "Type", "Description"};
    private String[] filter = {""};
    private Object[][] tableData;
    
    public DaysOffTableModel() {
        
        super();
        tableData = Main.getDaysOff(filter);
    }
    
    public void setFilter(String[] filterArray) {
        
        filter = filterArray;
        tableData = Main.getDaysOff(filter);
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
            tableData = new Object[][] {{"", "", ""}};
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
