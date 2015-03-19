package CalendarAppointments;

import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;

public class ButtonsRenderer extends JPanel implements TableCellRenderer {
    
    JButton button;
    
    public ButtonsRenderer() {
        
        button = new JButton("Click");
        setOpaque(true);
    }
    
    public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int col) {
        
        if (isSelected)
            JOptionPane.showMessageDialog(null, "Hey");
        //return (Component) obj;
        return this;
    }
}
