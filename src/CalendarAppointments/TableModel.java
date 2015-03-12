package CalendarAppointments;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
    
    private Object[] columnNames = {"appId ", "appType ", "patientId ", "appWithStaffId ", "date ", "startTime ", "finishTime "};
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
    
    public Object[] getColumnsNames() {
        
        return columnNames;
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
}
