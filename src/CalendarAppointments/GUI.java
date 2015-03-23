package CalendarAppointments;

import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class GUI extends JFrame {
    
	// setResizable(false);
	// loginFrame items
	private JLabel logoHolder, userLabel, passLabel;
	private ImageIcon logo;
	private JPanel loginItemsHolder1, loginItemsHolder2, loginItemsHolder3;
	private JTextField userText;
	private JPasswordField passText;
	private JButton enter, reset, cancel;
	
	// appFrame items
        private JFrame appFrame;
	private JLabel item1, idLabel, typeLabel, patientLabel, staffLabel, dateLabel, startTimeLabel, finishTimeLabel;
	private JTextField idTextField, typeTextField, patientTextField, staffTextField, dateTextField, startTimeTextField, finishTimeTextField;
	private JButton button1, searchButton, resetButton, addButton, updateButton, setHolidaysButton;
        private JComboBox typesList;
        private JRadioButton routineType, careManagementType, allTypes;
        private ButtonGroup radioGroupTypes;
	private JPanel appPanel, optionsPanel, menuPanel, mainPanel;
        private TableModel tableModel;
	private JTable appTable;
	private JScrollPane appScroll, optionsScroll, mainScroll;
        private JTextArea textArea1, textArea2;
        private String[] arr = {};
        private String[][] tableData = Main.getAppointments(arr);
	
        // addAppFrame items
        private JFrame addAppFrame;
        private JLabel idAddLabel, typeAddLabel, patientAddLabel, staffAddLabel, dateAddLabel, startTimeAddLabel, finishTimeAddLabel, appTimeAddLabel;
        private JRadioButton routineTypeAdd, careManagementTypeAdd;
        private ButtonGroup radioGroupAdd;
        private JTextField idAddText, typeAddText, patientAddText, staffAddText, dateAddText, startTimeAddText, finishTimeAddText;
        private JComboBox staffListAdd, timesListAdd;
        private JButton checkDateButton, submitAdd, resetAdd, cancelAdd;
        private String timeSelectedAdd, dateLookedAt, typeChosenAdd = "", oldTimeSlot, oldStaff, oldDate, id;
        
        // editAppFrame items
        private JFrame editAppFrame;
        private JLabel idEditLabel, appInfoLabel;
        private JTextField idEditText;
        private JTextArea appInfoArea;
        private JButton editEditButton, removeEditButton, cancelEditButton;
        
        // General
        private boolean inEditingMode;
        
        // Days Off and Holidays Frame
        private JFrame daysOffFrame;
        private JButton searchDaysOff, resetDaysOff, addDaysOff, removeDaysOff;
        private JTextField searchDaysOffText;
        private DaysOffTableModel daysOffTableModel;
        private JTable daysOffTable;
        
	public GUI() {
		
		super("Surgery's 'Calnedar Appointments' System");
		loginFrame();
	}
	
	private void loginFrame() {
		
		//super("Surgery's 'Calnedar Appointments' System");
		setLayout(new FlowLayout());
		
		logo = new ImageIcon(getClass().getResource("logo.png"));
		logoHolder = new JLabel(logo);
		add(logoHolder);
		
		userLabel = new JLabel("Please enter your Username:");
		userText = new JTextField(15);
		passLabel = new JLabel("Please enter your Password:");
		passText = new JPasswordField(15);
		
		enter = new JButton("Enter");
		reset = new JButton("Reset");
		cancel = new JButton("Cancel");
		
		loginItemsHolder1 = new JPanel();
		loginItemsHolder2 = new JPanel();
		loginItemsHolder3 = new JPanel();
		loginItemsHolder1.setBackground(Color.GREEN);
		loginItemsHolder2.setBackground(Color.GREEN);
		loginItemsHolder3.setBackground(Color.GREEN);
		loginItemsHolder1.add(userLabel);
		loginItemsHolder1.add(userText);
		loginItemsHolder2.add(passLabel);
		loginItemsHolder2.add(passText);
		loginItemsHolder3.add(enter);
		loginItemsHolder3.add(reset);
		loginItemsHolder3.add(cancel);
		
		add(loginItemsHolder1);
		add(loginItemsHolder2);
		add(loginItemsHolder3);
		
		/*add(userLabel);
		add(userText);
		add(passLabel);
		add(passText);
		add(enter);
		add(reset);
		add(cancel);*/
		
		Listener listen = new Listener();
		
		enter.addActionListener(listen);
		reset.addActionListener(listen);
		cancel.addActionListener(listen);
	}
	
	private void appFrame() {
		
		setVisible(false);
		appFrame = new JFrame("Appointments System");
		appFrame.setVisible(true);
		appFrame.setSize(900, 600);
		appFrame.setLocation(300, 100);
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagConstraints c = new GridBagConstraints();
		
		mainPanel = new JPanel(new GridBagLayout());
		appPanel = new JPanel(new GridBagLayout());
		item1 = new JLabel("label");
		button1 = new JButton("button");
		
		// For positioning of item on the X and Y coordinates.
		c.gridx = 0;
		c.gridy= 1;
		appPanel.add(item1, c);
		// For spacing, e.g. padding or margin.
		c.insets = new Insets(5, 5, 5, 5);
		c.gridx = 0;
		c.gridy = 2;
		appPanel.add(button1, c);
		String[] columnNames = {"appId ", "appType ", "patientId ", "appWithStaffId ", "date ", "startTime ", "finishTime "};
		/*String[][] tableData = {
						{"13 ", "Routine", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "},
						{"2", "Routine", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "},
						{"1", "Care Management", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "}
					};*/
                tableModel = new TableModel();
		appTable = new JTable(tableModel);
                /*appTable = new JTable(tableModel) {
                    public TableCellRenderer getCellRenderer(int row, int column) {
                        if ((row == 0) && (column == 0)) {
                            return new ButtonsRenderer();
                        }
                        // else...
                        return super.getCellRenderer(row, column);
                    }
                };*/
                //appTable.setDefaultRenderer(Object.class, new ButtonsRenderer());
                //TableCellRenderer tableCellRenderer = appTable.getCellRenderer(0,3);
                appTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                appTable.setPreferredScrollableViewportSize(new Dimension(500, 400));
                //appTable.setFillsViewportHeight(true);
                //appTable = new JTable(tableModel.getTableData(), tableModel.getColumnsNames());
		// To set the preferred view port size, which may require me to add a scroll bar in order to see the entire table.
		//appTable.setPreferredScrollableViewportSize(new Dimension(400, 100));
		// To make the table adjust height to fit with window, in order to avoid scrolling.
		//appTable.setFillsViewportHeight(true);
                //Below is what caused my table to not have headers and float in the centre vertically, as I should add the JTable object in a JScrollPane object; not a JPanel object.
		//appPanel.add(appTable);
		
		optionsPanel = new JPanel(new GridBagLayout());
		idLabel = new JLabel("ID");
		idTextField = new JTextField(15);
		typeLabel = new JLabel("Type");
		//typeTextField = new JTextField(15);
                /*routineType = new JRadioButton("Routine", false);
                careManagementType = new JRadioButton("Care Management", false);
                allTypes = new JRadioButton("All", true);
                radioGroupTypes = new ButtonGroup();
                    radioGroupTypes.add(routineType);
                    radioGroupTypes.add(careManagementType);
                    radioGroupTypes.add(allTypes);*/
                typesList = new JComboBox(new String[]{"All", "Routine", "Care Management"});
		patientLabel = new JLabel("Patient ID");
		patientTextField = new JTextField(15);
		staffLabel = new JLabel("Staff ID");
		staffTextField = new JTextField(15);
		dateLabel = new JLabel("Date");
		dateTextField = new JTextField(15);
		startTimeLabel = new JLabel("Start Time");
		startTimeTextField = new JTextField(15);
		finishTimeLabel = new JLabel("Finish Time");
		finishTimeTextField = new JTextField(15);
		searchButton = new JButton("Search");
                resetButton = new JButton("Reset");
		addButton = new JButton("Add");
		updateButton = new JButton("Edit / Remove");
		setHolidaysButton = new JButton("Holidays & Days Off");
		
		c.gridx = 0;
		c.gridy = 2;
		optionsPanel.add(idLabel);
		optionsPanel.add(idTextField, c);
		c.gridy = 3;
		optionsPanel.add(typeLabel, c);
		c.gridy = 4;
		//optionsPanel.add(typeTextField, c);
                /*c.gridy = 4; optionsPanel.add(routineType, c);
                c.gridy = 4; optionsPanel.add(careManagementType, c);
                c.gridy = 4; optionsPanel.add(allTypes, c);*/
                optionsPanel.add(typesList, c);
		c.gridy = 5;
		optionsPanel.add(patientLabel, c);
		c.gridy = 6;
		optionsPanel.add(patientTextField, c);
		c.gridy = 7;
		optionsPanel.add(staffLabel, c);
		c.gridy = 8;
		optionsPanel.add(staffTextField, c);
		c.gridy = 9;
		optionsPanel.add(dateLabel, c);
		c.gridy = 10;
		optionsPanel.add(dateTextField, c);
		c.gridy = 11;
		optionsPanel.add(startTimeLabel, c);
		c.gridy = 12;
		optionsPanel.add(startTimeTextField, c);
		c.gridy = 13;
		optionsPanel.add(finishTimeLabel, c);
		c.gridy = 14;
		optionsPanel.add(finishTimeTextField, c);
		c.gridy = 15; c.gridx = -1;
		optionsPanel.add(searchButton, c);
		c.gridy = 15; c.gridx = 1;
		optionsPanel.add(resetButton, c);
		c.gridy = 16; c.gridx = -1;
		optionsPanel.add(addButton, c);
		c.gridy = 16; c.gridx = 1;
		optionsPanel.add(updateButton, c);
		c.gridy = 17; c.gridx = -1;
		optionsPanel.add(setHolidaysButton, c);
                
                //textArea1 = new JTextArea(80, 40);
                //mainPanel.add(textArea1);
                
		//appFrame.add(appPanel);
		appScroll = new JScrollPane(appTable);
                //appTable.setFillsViewportHeight(true);
		// Horizontal spacing //c.weightx = 1.0;
		// Vertical spacing //c.weighty = 1.0;
		mainPanel.add(optionsPanel);
		mainPanel.add(appScroll);
		mainScroll = new JScrollPane(mainPanel);
		appFrame.add(mainScroll);
		
		Listener listen = new Listener();
		button1.addActionListener(listen);
                appTable.addMouseListener(listen);
                searchButton.addActionListener(listen);
                resetButton.addActionListener(listen);
                addButton.addActionListener(listen);
                updateButton.addActionListener(listen);
                setHolidaysButton.addActionListener(listen);
	}
        
        public void addAppFrame() {
            
            appFrame.setEnabled(false);
            //if (inEditingMode) editAppFrame.setEnabled(false);
            
            String frameName = (! inEditingMode) ? "Add an Appointment" : "Editing an Appointment";
            addAppFrame = new JFrame(frameName);
            addAppFrame.setVisible(true);
            addAppFrame.setBounds(400, 200, 350, 400);
            JPanel addAppPanel = new JPanel();
            addAppPanel.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            
            //idAddLabel  = new JLabel("ID");
            typeAddLabel = new JLabel("Type");
            patientAddLabel = new JLabel("Patient");
            dateAddLabel = new JLabel("Date");
            staffAddLabel = new JLabel("Staff");
            //startTimeAddLabel = new JLabel("Start Time");
            //finishTimeAddLabel = new JLabel("Finish Time");
            appTimeAddLabel = new JLabel("Choose Time Slot");
            
            
            //idAddText = new JTextField(15);
            //typeAddText = new JTextField(15);
            routineTypeAdd = new JRadioButton("Routine", false);
            careManagementTypeAdd = new JRadioButton("Care Management", false);
                radioGroupAdd = new ButtonGroup();
                radioGroupAdd.add(routineTypeAdd);
                radioGroupAdd.add(careManagementTypeAdd);
                
            patientAddText = new JTextField(15);
            //staffAddText = new JTextField(15);
            dateAddText = new JTextField(15);
            //startTimeAddText = new JTextField(15);
            //finishTimeAddText = new JTextField(15);
            
            String[] arr = {"Add & Check Date First"};
            staffListAdd = new JComboBox(arr);
            staffListAdd.setEnabled(false);
            
            String[] timeSlotsAvailableArray = {"Add & Check Date First"};
            timesListAdd = new JComboBox(timeSlotsAvailableArray);
            timesListAdd.setEnabled(false);
            
            dateLookedAt = "";
            typeChosenAdd = "";
            
            // By adding this button (which does not really have an action) I invoke the user to make the focus lost from the date text field.
            checkDateButton = new JButton("Check Date");
            submitAdd = new JButton("Submit");
            resetAdd = new JButton("Reset");
            cancelAdd = new JButton("Cancel");
            
            c.gridx = 0;
            c.gridy = 1;
            //addAppPanel.add(idAddLabel, c);
            c.gridy = 2;
            //addAppPanel.add(idAddText, c);
            c.gridy = 3;
            addAppPanel.add(typeAddLabel, c);
            c.gridy = 4;
            //addAppPanel.add(typeAddText, c);
            addAppPanel.add(routineTypeAdd, c);
            c.gridy = 5; //c.gridx = 1;
            addAppPanel.add(careManagementTypeAdd, c);
            c.gridy = 6; //c.gridx = 0;
            addAppPanel.add(patientAddLabel, c);
            c.gridy = 7;
            addAppPanel.add(patientAddText, c);
            c.gridy = 8;
            //addAppPanel.add(staffAddText, c);
            c.gridy = 9;
            addAppPanel.add(dateAddLabel, c);
            c.gridy = 10;
            addAppPanel.add(dateAddText, c);
            c.gridy = 11;
            //addAppPanel.add(startTimeAddLabel, c);
            c.gridy = 12;
            //addAppPanel.add(startTimeAddText, c);
            c.gridy = 13;
            //addAppPanel.add(finishTimeAddLabel, c);
            c.gridy = 14;
            //addAppPanel.add(finishTimeAddText, c);
            c.gridy = 15;
            addAppPanel.add(checkDateButton, c);
            c.gridy = 16;
            addAppPanel.add(staffAddLabel, c);
            c.gridy = 17;
            addAppPanel.add(staffListAdd, c);
            c.gridy = 18;
            addAppPanel.add(appTimeAddLabel, c);
            c.gridy = 19;
            addAppPanel.add(timesListAdd, c);
            c.gridy = 20;
            addAppPanel.add(submitAdd, c);
            c.gridy = 21;
            addAppPanel.add(resetAdd, c);
            //c.gridy = 22;
            //addAppPanel.add(cancelAdd, c);
            
            JScrollPane addAppScroll = new JScrollPane(addAppPanel);
            addAppFrame.add(addAppScroll);
            
            Listener listen = new Listener();
            
            routineTypeAdd.addItemListener(listen);
            careManagementTypeAdd.addItemListener(listen);
            staffListAdd.addItemListener(listen);
            
            checkDateButton.addActionListener(listen);
            submitAdd.addActionListener(listen);
            resetAdd.addActionListener(listen);
            //cancelAdd.addActionListener(listen);
            /*cancelAdd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    addAppFrame.setVisible(false);
                    //addAppFrame.dispose();
                    //addAppFrame.hide();
                }
            });*/
            addAppFrame.addWindowListener( new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    if (inEditingMode)
                        inEditingMode = false;
                    appFrame.setEnabled(true);
                    if (inEditingMode) editAppFrame.setEnabled(true);
                    
                }
            });
        }
        
        public void editAppFrame() {
            
            appFrame.setEnabled(false);
            
            int row = appTable.getSelectedRow();
            String[] rowDetails = getTableRowDetails(row);
            
            id = rowDetails[0];
            String rowInfo = rowDetails[rowDetails.length-1];
            
            oldTimeSlot = rowDetails[5];
            oldStaff = rowDetails[3];
            oldDate = rowDetails[4];
            
            editAppFrame = new JFrame("Appointment Details");
            editAppFrame.setVisible(true);
            editAppFrame.setBounds(400, 200, 350, 400);
            JPanel editAppPanel = new JPanel();
            editAppPanel.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            
            idEditLabel  = new JLabel("Appointment ID");
            appInfoLabel  = new JLabel("Appointment Details");
            
            idEditText = new JTextField(id);
            idEditText.setEditable(false);
            
            appInfoArea = new JTextArea(rowInfo);
            appInfoArea.setEditable(false);
            
            editEditButton = new JButton("Edit");
            removeEditButton = new JButton("Remove");
            cancelEditButton = new JButton("Cancel");
            
            c.gridx = 0;
            c.gridy = 1;
            editAppPanel.add(idEditLabel, c);
            c.gridy = 2;
            editAppPanel.add(idEditText, c);
            c.gridy = 3;
            editAppPanel.add(appInfoLabel, c);
            c.gridy = 4;
            editAppPanel.add(appInfoArea, c);
            c.gridy = 5;
            editAppPanel.add(editEditButton, c);
            c.gridy = 6;
            editAppPanel.add(removeEditButton, c);
            //c.gridy = 7;
            //editAppPanel.add(cancelEditButton, c);
            
            JScrollPane editAppScroll = new JScrollPane(editAppPanel);
            editAppFrame.add(editAppScroll);
            
            Listener listen = new Listener();
            
            editEditButton.addActionListener(listen);
            removeEditButton.addActionListener(listen);
            /*cancelEditButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    editAppFrame.setVisible(false);
                    //editAppFrame.dispose();
                    //editAppFrame.hide();
                }
            });*/
            editAppFrame.addWindowListener( new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    if (inEditingMode)
                        inEditingMode = false;
                    appFrame.setEnabled(true);
                }
            });
        }
        
        public void daysOffFrame() {
            
            appFrame.setEnabled(false);
            
            daysOffFrame = new JFrame("Days Off and Holidays");
            daysOffFrame.setVisible(true);
            daysOffFrame.setBounds(400, 200, 450, 400);
            JPanel daysOffOptionsPanel = new JPanel();
            JPanel daysOffMainPanel = new JPanel();
            daysOffOptionsPanel.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            
            searchDaysOff = new JButton("Search");
            resetDaysOff = new JButton("Reset");
            addDaysOff = new JButton("Add Days Off");
            removeDaysOff = new JButton("Remove Days Off");
            searchDaysOffText = new JTextField(15);
            
            daysOffTableModel = new DaysOffTableModel();
            daysOffTable = new JTable(daysOffTableModel);
            daysOffTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            daysOffTable.setPreferredScrollableViewportSize(new Dimension(80, 200));
            
            c.gridy = 1; c.gridx = 1;
            daysOffOptionsPanel.add(searchDaysOffText, c);
            c.gridy = 2; c.gridx = 1;
            daysOffOptionsPanel.add(searchDaysOff, c);
            c.gridy = 2; c.gridx = 2;
            daysOffOptionsPanel.add(resetDaysOff, c);
            c.gridy = 3; c.gridx = 1;
            daysOffOptionsPanel.add(addDaysOff, c);
            c.gridy = 3; c.gridx = 2;
            daysOffOptionsPanel.add(removeDaysOff, c);
            
            JScrollPane daysOffTableScroll = new JScrollPane(daysOffTable);
            daysOffMainPanel.add(daysOffTableScroll);
            daysOffMainPanel.add(daysOffOptionsPanel);
            JScrollPane daysOffScroll = new JScrollPane(daysOffMainPanel);
            
            daysOffFrame.add(daysOffScroll);
            
            Listener listen = new Listener();
            
            searchDaysOff.addActionListener(listen);
            resetDaysOff.addActionListener(listen);
            addDaysOff.addActionListener(listen);
            removeDaysOff.addActionListener(listen);
            
            daysOffFrame.addWindowListener( new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    appFrame.setEnabled(true);
                }
            });
        }
        public void updateListOfStaff() {
            
            //System.out.println("focusLost");
            staffListAdd.removeAllItems();
            String[] staffOptions = new String[0];

            if (! dateAddText.getText().equals("")) {
                //staffOptions = Main.getOneColumnFromTable("SELECT name FROM doctorsandnurses WHERE date LIKE '" + dateLookedAt + "' ;");
                staffOptions = Main.getOneColumnFromTable("SELECT name FROM doctorsandnurses ;");
                staffOptions = Main.removeRepeated(staffOptions);
                staffListAdd.setEnabled(true);
                
                for (String val : staffOptions)
                    staffListAdd.addItem(val);
            }
            else {
                String[] options = {"Add & Check Date First"};
                staffListAdd.addItem(options[0]);
                staffListAdd.setEnabled(false);
            }
        }
        
        public void updateListOfTimes() {
            
            //System.out.println("focusLost");
            timesListAdd.removeAllItems();
            String[] timesOptions = new String[0];
            
            if (! dateAddText.getText().equals("")) {
                if (Main.recordExists("SELECT * FROM doctorsandnurses WHERE date LIKE '"+dateAddText.getText()+"' AND  name LIKE '"+staffListAdd.getSelectedItem()+"' ;"))
                    timesOptions = Main.getTimeSlotsAvailable((String)staffListAdd.getSelectedItem(), dateLookedAt);
                else
                    timesOptions = Main.getAllTimeSlots();
                timesListAdd.setEnabled(true);
                
                for (String val : timesOptions)
                    timesListAdd.addItem(val);
            }
            else {
                String[] options = {"Add & Check Date First"};
                timesListAdd.addItem(options[0]);
                timesListAdd.setEnabled(false);
            }
        }
        
        /*public JComboBox updateListOfStaff(JComboBox list) {
            
            //System.out.println("focusLost");
            list.removeAllItems();
            String[] staffOptions = new String[0];

            if (! dateEditText.getText().equals("")) {
                //staffOptions = Main.getOneColumnFromTable("SELECT name FROM doctorsandnurses WHERE date LIKE '" + dateEditText.getText() + "' ;");
                staffOptions = Main.getOneColumnFromTable("SELECT name FROM doctorsandnurses ;");
                staffOptions = Main.removeRepeated(staffOptions);
                list.setEnabled(true);
                
                for (String val : staffOptions)
                    list.addItem(val);
            }
            else {
                String[] options = {"Add & Check Date First"};
                list.addItem(options[0]);
                list.setEnabled(false);
            }
            return list;
        }
        
        public JComboBox updateListOfTimes(JComboBox list) {
            
            //System.out.println("focusLost");
            list.removeAllItems();
            String[] timesOptions = new String[0];
            
            if (! dateEditText.getText().equals("")) {
                if (Main.recordExists("SELECT * FROM doctorsandnurses WHERE date LIKE '"+dateEditText.getText()+"' AND  name LIKE '"+staffListEdit.getSelectedItem()+"' ;"))
                    timesOptions = Main.getTimeSlotsAvailable((String)staffListEdit.getSelectedItem(), dateEditText.getText());
                else
                    timesOptions = Main.getAllTimeSlots();
                list.setEnabled(true);
                
                for (String val : timesOptions)
                    list.addItem(val);
            }
            else {
                String[] options = {"Add & Check Date First"};
                list.addItem(options[0]);
                list.setEnabled(false);
            }
            return list;
        }*/
        
        public void resetAddApp() {
            
            /*radioGroupAdd.clearSelection();
            routineTypeAdd.setSelected(false);
            careManagementTypeAdd.setSelected(false);*/
            dateAddText.setText("");
            updateListOfStaff();
            updateListOfTimes();
        }
        
        public String[] getTableRowDetails(int row) {
            
            String id = (String) appTable.getModel().getValueAt(row, 0);
            String type = (String) appTable.getModel().getValueAt(row, 1);
            String patient = (String) appTable.getModel().getValueAt(row, 2);
            String staff = (String) appTable.getModel().getValueAt(row, 3);
            String date = (String) appTable.getModel().getValueAt(row, 4);
            String timeSlot1 = ((String) appTable.getModel().getValueAt(row, 5)).substring(0, 5);
            String timeSlot2 = appTable.getModel().getValueAt(row, 6).toString().substring(0, 5);
            String timeSlot = timeSlot1 + "-" + timeSlot2;
            
            /*JOptionPane.showMessageDialog(null, id + "\n" + type + "\n" + patient + "\n" + date + "\n" + 
                                                staff + "\n" + timeSlot1 + "\n" + timeSlot2 + "\n" + timeSlot + "\n");*/
            
            String rowInfo = "Patient ID:\t\t" + id + "\nAppointment Type:\t" + type + "\nPatient Name:\t\t" + patient + 
                    "\nDate:\t\t" + date + "\nDoc/Nurse Name:\t" + staff + "\nAppointment Time Slot:\t" + timeSlot + "\n";
            
            /*idEditText.setText(id);
            if (type.equalsIgnoreCase("routine"))
                routineTypeEdit.setSelected(true);
            else
                careManagementTypeEdit.setSelected(true);
            patientEditText.setText(patient);
            dateEditText.setText(date);
            staffEditText.setText(staff);
            timeSlotEditText.setText(timeSlot);
            staffListEdit.removeAllItems();
            timesListEdit.removeAllItems();
            staffListEdit.addItem(staff);
            timesListEdit.addItem(timeSlot);*/
            return new String[] {id, type, patient, staff, date, timeSlot, rowInfo};
        }
        
	private class Listener implements ActionListener, ItemListener, MouseListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == enter) {
				
				String user = userText.getText();
				String passArr = Arrays.toString(passText.getPassword());
				String pass = "";
				
				// Convert password to string
				for (int i=0; i<passArr.length(); i++) {
					char ch = passArr.charAt(i);
					if (ch != '[' && ch != ']' && ch != ',' && ch != ' ')
						pass += ch;
				}
				
				if (! user.equals("") && ! pass.equals("")) {
					
					String[] dbUser = {"mohammad", "groupa"};
					String[] dbPass = {"1000", "aBcD"};
					boolean access= false;
					
					for (int i=0; i<dbUser.length; i++) {
						if (dbUser[i].equals(user) && dbPass[i].equals(pass)) {
							access = true;
							break;
						}
					}
					
					if (access) {
						JOptionPane.showMessageDialog(null, "You have successfully accessed the program.", "Access Guaranteed", JOptionPane.WARNING_MESSAGE);
						appFrame();
					}
					else {
						JOptionPane.showMessageDialog(null, "You have entered an incorrect username and/or password!!\nPlease try again.", "Incorrect Input !!", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					String msg = "Please enter:\n\n";
					if (user.equals(""))
						msg += "    - Username\n";
					if (pass.equals(""))
						msg += "    - Password\n";
					JOptionPane.showMessageDialog(null, msg+"\n", "Data Missing", JOptionPane.WARNING_MESSAGE);
				}
			}
			else if(e.getSource() == reset) {
				
				userText.setText("");
				passText.setText("");
			}
			else if(e.getSource() == cancel) {
				
				System.exit(0);
			}
			
                        // appFrame actions listener
			if (e.getSource() == button1) {
				System.out.println("Hi...");
			}
                        else if (e.getSource() == searchButton) {
                            //String textId, textType, textpatient, textStaff, textDate, textStartTime, textFinishTime;
                            String[] values = new String[7];
                            values[0] = idTextField.getText();
                            //values[1] = typeTextField.getText();
                            //values[1] = (routineType.isSelected()) ? routineType.getActionCommand() : (careManagementType.isSelected()) ? careManagementType.getActionCommand() : "";
                            values[1] = (typesList.getSelectedItem().toString().equals("All")) ? "" : typesList.getSelectedItem().toString();
                            values[2] = patientTextField.getText();
                            values[3] = staffTextField.getText();
                            values[4] = dateTextField.getText();
                            values[5] = startTimeTextField.getText();
                            values[6] = finishTimeTextField.getText();
                            //JOptionPane.showMessageDialog(null, textId+textType+textpatient+textStaff+textDate+textStartTime+textFinishTime);
                            //tableData = Main.getAppointments(values);
                            tableModel.setFilter(values);
                            tableModel.fireTableDataChanged();
                        }
                        else if (e.getSource() == resetButton) {
                            
                            idTextField.setText("");
                            //typeTextField.setText("");
                            typesList.removeAllItems();
                            String[] typesListOptions = {"All", "Routine", "Care Management"};
                            for (String val : typesListOptions)
                                typesList.addItem(val);
                            patientTextField.setText("");
                            staffTextField.setText("");
                            dateTextField.setText("");
                            startTimeTextField.setText("");
                            finishTimeTextField.setText("");
                            String[] values = {};
                            tableModel.setFilter(values);
                            tableModel.fireTableDataChanged();
                        }
                        else if (e.getSource() == addButton) {
                            
                            addAppFrame();
                        }
                        else if (e.getSource() == updateButton) {
                            
                            if (appTable.getSelectedRow() > -1)
                                editAppFrame();
                            else
                                JOptionPane.showMessageDialog(null, "Please select an appointment from the table first !!");
                        }
                        else if (e.getSource() == setHolidaysButton) {
                            
                            daysOffFrame();
                        }
                        
                        // addAppFrame actions listener
                        if (e.getSource() == checkDateButton) {
                            if (! dateAddText.getText().equals("")) {
                                if (Main.dateIsInCorrectFormat(dateAddText.getText())) {
                                    if (Main.gpIsOpenOn(dateAddText.getText())) {
                                        dateLookedAt = dateAddText.getText();
                                        updateListOfStaff();
                                        updateListOfTimes();
                                    }
                                    else {
                                        resetAddApp();
                                        JOptionPane.showMessageDialog(null, "Sorry the GP is not open on this day !!");
                                    }
                                }
                                else {
                                    resetAddApp();
                                    JOptionPane.showMessageDialog(null, "Please enter date in this format:\nyyyy-mm-dd");
                                }
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Please enter a date !!");
                            }
                        }
                        else if (e.getSource() == submitAdd) {
                            String msg = "";
                            boolean incomplete = true;
                            if (! typeChosenAdd.equalsIgnoreCase("Routine") && ! typeChosenAdd.equalsIgnoreCase("Care Management"))
                            //if (! routineTypeAdd.isSelected() || ! careManagementTypeAdd.isSelected())
                                msg += "- Choose Type of Appointment\n";
                            if (patientAddText.getText().equals(""))
                                msg += "- Enter patient name\n";
                            if (dateAddText.getText().equals("") || ! Main.dateIsInCorrectFormat(dateAddText.getText()) || ! Main.gpIsOpenOn(dateAddText.getText()))
                                msg += "- Add a correct date\n";
                            if (staffListAdd.getSelectedItem().equals("Add & Check Date First") || staffListAdd.getSelectedItem().equals("") || staffListAdd.getSelectedItem().equals(null))
                                msg += "- Select staff\n";
                            if (timesListAdd.getSelectedItem().equals("Add & Check Date First") || timesListAdd.getSelectedItem().equals("") || staffListAdd.getSelectedItem().equals(null))
                                msg += "- Select a timeslot\n";
                            if (msg.equals(""))
                                incomplete = false;
                            else
                                JOptionPane.showMessageDialog(null, msg);
                            // If form is complete add the new appointment.
                            if (! incomplete) {
                                
                                if (! inEditingMode) { // Then it is NOT in EDITING mode; it is actually adding a totally new appointment
                                    // Add new appointment
                                    String[] timeSlots = timesListAdd.getSelectedItem().toString().split("-");
                                    String[] array = {
                                        typeChosenAdd,
                                        patientAddText.getText(),
                                        staffListAdd.getSelectedItem().toString(),
                                        dateAddText.getText(),
                                        timeSlots[0],
                                        timeSlots[1]
                                    };
                                    Main.addAppointment(array);

                                    // Update availability timeslots
                                    if (Main.recordExists("SELECT * FROM doctorsandnurses WHERE date LIKE '"+dateAddText.getText()+"' AND  name LIKE '"+staffListAdd.getSelectedItem()+"' ;")) {
                                        Main.execute("UPDATE doctorsandnurses SET "+ Main.getColumnNameForTimeSlot(timesListAdd.getSelectedItem().toString()) +" = 'n' WHERE name = '"+ staffListAdd.getSelectedItem().toString() +"' AND date = '"+ dateAddText.getText() +"' ;");
                                    }
                                    else {
                                        Main.execute("INSERT INTO doctorsandnurses (name, date, "+ Main.getColumnNameForTimeSlot(timesListAdd.getSelectedItem().toString()) +") VALUES ('"+ staffListAdd.getSelectedItem().toString() +"', '"+ dateAddText.getText() +"', '"+ "n" +"') ;");
                                    }
                                    JOptionPane.showConfirmDialog(null, "Appointment has been recorded successfully.", "Complete", JOptionPane.CLOSED_OPTION);
                                }
                                else { // Then it is in EDITING mode
                                    // Edit an existing appointment, which is identified by its ID.
                                    String[] timeSlots = timesListAdd.getSelectedItem().toString().split("-");
                                    String[] array = {
                                        typeChosenAdd,
                                        patientAddText.getText(),
                                        staffListAdd.getSelectedItem().toString(),
                                        dateAddText.getText(),
                                        timeSlots[0],
                                        timeSlots[1]
                                    };
                                    Main.editAppointment(array, id);

                                    // Update availability timeslots accordingly
                                    Main.execute("UPDATE doctorsandnurses SET "+ Main.getColumnNameForTimeSlot(oldTimeSlot) +" = 'y' WHERE name = '"+ oldStaff +"' AND date = '"+ oldDate +"' ;");
                                    Main.execute("UPDATE doctorsandnurses SET "+ Main.getColumnNameForTimeSlot(timesListAdd.getSelectedItem().toString()) +" = 'n' WHERE name = '"+ staffListAdd.getSelectedItem().toString() +"' AND date = '"+ dateAddText.getText() +"' ;");
                                    
                                    JOptionPane.showConfirmDialog(null, "Appointment has been recorded successfully.", "Complete", JOptionPane.CLOSED_OPTION);
                                    inEditingMode = false;
                                }
                                
                                addAppFrame.setVisible(false);
                                appFrame.setEnabled(true);
                                editAppFrame.dispose();
                                //editAppFrame.setEnabled(true);
                                tableModel.setFilter(new String[]{});
                                tableModel.fireTableDataChanged();
                            }
                        }
                        else if (e.getSource() == resetAdd) {
                            
                            //idAddText.setText("");
                            //typeAddText.setText("");
                            patientAddText.setText("");
                            //staffAddText.setText("");
                            dateAddText.setText("");
                            //startTimeAddText.setText("");
                            //finishTimeAddText.setText("");
                            updateListOfStaff();
                            updateListOfTimes();
                        }
                        
                        // updateAppFrame actions listener
                        if (e.getSource() == editEditButton) {
                            
                            inEditingMode = true;
                            addAppFrame();
                        }
                        else if (e.getSource() == removeEditButton) {
                            int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this appointment?", "Title", JOptionPane.YES_NO_OPTION);
                            if (ans == JOptionPane.YES_OPTION) {
                                int row = appTable.getSelectedRow();
                                String id = (String) appTable.getModel().getValueAt(row, 0);
                                String timeSlot1 = ((String) appTable.getModel().getValueAt(row, 5)).substring(0, 5);
                                String timeSlot2 = appTable.getModel().getValueAt(row, 6).toString().substring(0, 5);
                                String timeSlot = timeSlot1 + "-" + timeSlot2;
                                String staff = (String) appTable.getModel().getValueAt(row, 3);
                                String date = (String) appTable.getModel().getValueAt(row, 4);
                                
                                // Delete appointment from table appointments.
                                Main.execute("DELETE FROM appointments WHERE appId = " + id + " ;");
                                // Re-edit availability of time slot in table doctorsandnurses.
                                Main.execute("UPDATE doctorsandnurses SET "+ Main.getColumnNameForTimeSlot(timeSlot) +" = 'y' WHERE name like '"+ staff +"' AND  date like '"+ date +"' ;");
                                JOptionPane.showMessageDialog(null, "Appointment has been deleted successfully.");
                                editAppFrame.dispose();
                                appFrame.setEnabled(true);
                                tableModel.setFilter(new String[]{});
                                tableModel.fireTableDataChanged();
                            }
                        }
                        
                        // setHolidaysFrame actions listener
                        if (e.getSource() == searchDaysOff) {
                            
                            String[] array = {searchDaysOffText.getText().toString()};
                            daysOffTableModel.setFilter(array);
                            daysOffTableModel.fireTableDataChanged();
                        }
                        else if (e.getSource() == resetDaysOff) {
                            
                            searchDaysOffText.setText("");
                            daysOffTableModel.setFilter(new String[]{});
                            daysOffTableModel.fireTableDataChanged();
                        }
                        else if (e.getSource() == addDaysOff) {
                            
                            String date = JOptionPane.showInputDialog("Please enter a date...");
                            if (! date.equals("")) {
                                if (Main.dateIsInCorrectFormat(date)) {
                                    if (Main.recordExists("SELECT * FROM gpdaysoff WHERE day LIKE '" + date + "'; "))
                                        JOptionPane.showMessageDialog(null, "This day already exists, please try again.");
                                    else {
                                        Main.execute("INSERT INTO gpdaysoff (day) VALUES ('" + date + "') ;");
                                        daysOffTableModel.setFilter(new String[]{});
                                        daysOffTableModel.fireTableDataChanged();
                                    }
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "Please enter date in this format:\nyyyy-mm-dd");
                                }
                            }
                        }
                        else if (e.getSource() == removeDaysOff) {
                            
                            if(daysOffTable.getSelectedRow() < 0)
                                JOptionPane.showMessageDialog(null, "Please select a day from the table first !!");
                            else {
                                int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this appointment?", "Title", JOptionPane.YES_NO_OPTION);
                                if (ans == JOptionPane.YES_OPTION) {
                                    int row = daysOffTable.getSelectedRow();
                                    String day = (String) daysOffTable.getModel().getValueAt(row, 0);
                                    // Delete appointment from table appointments.
                                    Main.execute("DELETE FROM gpdaysoff WHERE day = '" + day + "' ;");
                                    JOptionPane.showMessageDialog(null, "Appointment has been deleted successfully.");
                                    daysOffTableModel.setFilter(new String[]{});
                                    daysOffTableModel.fireTableDataChanged();
                                }
                            }
                        }
		}
                
                public void itemStateChanged(ItemEvent e) {
                    
                    if (routineTypeAdd.isSelected()) {
                        //JOptionPane.showMessageDialog(null, "Routine is selected");
                        typeChosenAdd = "Routine";
                        //typeChosenEdit = "Routine";
                    }
                    else if (careManagementTypeAdd.isSelected()) {
                        //JOptionPane.showMessageDialog(null, "Care Management is selected");
                        typeChosenAdd = "Care Management";
                        //typeChosenEdit = "Care Management";
                    }
                    
                    if (e.getStateChange() == ItemEvent.SELECTED) { // If a staff is selected from the staff list.
                        //JOptionPane.showMessageDialog(null, "Selected Here");
                        updateListOfTimes();
                        //timesListEdit = updateListOfTimes(timesListEdit);
                    }
                }
                
                public void mouseExited(MouseEvent e) {}
                
                public void mouseEntered(MouseEvent e) {}
                
                public void mouseReleased(MouseEvent e) {}
                
                public void mousePressed(MouseEvent e) {}
                
                public void mouseClicked(MouseEvent e) {
                    
                    if (e.getClickCount() == 1) {
                        
                    }
                    
                    if (e.getClickCount() == 2) {
                        /*int row = appTable.getSelectedRow();
                        int col = appTable.getSelectedColumn();
                        String tableValue = (String) appTable.getModel().getValueAt(row, col);
                        JOptionPane.showMessageDialog(null, row + " " + col + "\n" + tableValue);*/
                        editAppFrame();
                    }
                }
	}
	
	public static void main(String[] args) {
		
		GUI gui = new GUI();
		
		gui.setVisible(true);
		//gui.pack();
		gui.setSize(500, 500);
		gui.setLocation(400, 100);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}