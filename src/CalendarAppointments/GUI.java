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
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class GUI extends JFrame {
    
	// setResizable(false);
	// loginFrame items
        private JFrame loginFrame;
	private JLabel logoHolder, userLabel, passLabel;
	private ImageIcon logo;
	private JPanel loginItemsHolder1, loginItemsHolder2, loginItemsHolder3;
	private JTextField userText;
	private JPasswordField passText;
	private JButton enter, reset, cancel;
        private boolean userIsDoctor, userIsNurse, userIsReceptionist, userIsOfficeManager;
	
	// appFrame items
        private JFrame appFrame;
	private JLabel item1, idLabel, typeLabel, patientLabel, staffLabel, dateLabel, yearLabel, monthLabel, dayLabel, hourLabel, startTimeLabel, finishTimeLabel;
	private JTextField idTextField, typeTextField, patientTextField, staffTextField, dateTextField, startTimeTextField, finishTimeTextField;
	private JButton button1, searchButton, resetButton, addButton, updateButton, setHolidaysButton, logoutButton;
        private JComboBox typesList, timeSlotsList, yearsList, monthsList, daysList, hoursList;
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
        private JLabel idAddLabel, typeAddLabel, patientAddLabel, staffAddLabel, dateAddLabel, startTimeAddLabel, finishTimeAddLabel, durationAddLabel, appTimeAddLabel, roomAddLabel;
        private JRadioButton routineTypeAdd, careManagementTypeAdd;
        private ButtonGroup radioGroupAdd;
        private JTextField idAddText, typeAddText, patientAddText, staffAddText, dateAddText, startTimeAddText, finishTimeAddText;
        private JComboBox patientsListAdd, staffListAdd, durationsListAdd, timesListAdd, roomsListAdd, yearsListAdd, monthsListAdd, daysListAdd;
        private JButton checkDateButton, submitAdd, resetAdd, cancelAdd;
        private String timeSelectedAdd, dateLookedAt, typeChosenAdd = "", oldTimeSlot, oldStaff, oldDate, oldRoom, id, oldPatient, oldType;
        private String[][] patientsKeyAndVal, docsAndNursesKeyAndVal;
        
        // editAppFrame items
        private JFrame editAppFrame;
        private JLabel idEditLabel, appInfoLabel;
        private JTextField idEditText;
        private JTextArea appInfoArea;
        private JButton addSummaryButton, editEditButton, removeEditButton, cancelEditButton;
        
        // General
        private boolean inEditingMode, noEditingMadeYet;
        
        // Days Off and Holidays Frame
        private JFrame daysOffFrame;
        private JButton searchDaysOff, resetDaysOff, addDaysOff, removeDaysOff;
        private JTextField searchDaysOffText;
        private DaysOffTableModel daysOffTableModel;
        private JTable daysOffTable;
        
        // Add summary Frame
        private JFrame addSummaryFrame;
        private JTextArea summaryText;
        private JButton submitSummaryButton, resetSummaryButton;
        private JTextField summaryCounter;
        
	public GUI() {
		
		//super("Surgery's 'Calnedar Appointments' System");
		loginFrame();
	}
	
	private void loginFrame() {
		
		//super("Surgery's 'Calnedar Appointments' System");
                loginFrame = new JFrame("Surgery's 'Calnedar Appointments' System");
		//loginFrame.pack();
		loginFrame.setSize(500, 500);
		loginFrame.setLocation(400, 100);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setLayout(new FlowLayout());
		
		logo = new ImageIcon(getClass().getResource("logo.png"));
		logoHolder = new JLabel(logo);
		loginFrame.add(logoHolder);
		
		userLabel = new JLabel("Please enter your Username:");
		userText = new JTextField(15);
		passLabel = new JLabel("Please enter your Password:");
		passText = new JPasswordField(15);
		
		enter = new JButton("Login");
		reset = new JButton("Reset");
		cancel = new JButton("Exit");
		
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
		
		loginFrame.add(loginItemsHolder1);
		loginFrame.add(loginItemsHolder2);
		loginFrame.add(loginItemsHolder3);
		
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
                
                loginFrame.setVisible(true);
                
                loginFrame.addWindowListener( new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        Main.close();
                    }
                });
	}
	
	private void appFrame() {
		
		loginFrame.setVisible(false);
		appFrame = new JFrame("Appointments System");
		appFrame.setVisible(true);
		appFrame.setSize(900, 600);
		appFrame.setLocation(300, 100);
		//appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		//dateLabel = new JLabel("Date");
		//dateTextField = new JTextField(15);
                yearLabel = new JLabel("    Year");
                monthLabel = new JLabel("Month");
                dayLabel = new JLabel("Day    ");
                hourLabel = new JLabel("Hour ");
                yearsList = new JComboBox(Main.getAllYears());
                monthsList = new JComboBox(Main.getAllMonths());
                daysList = new JComboBox(Main.getAllDays());
                hoursList = new JComboBox(Main.getAllHours());
                timeSlotsList = new JComboBox(Main.getAllTimeSlots());
		//startTimeLabel = new JLabel("Start Time");
		//startTimeTextField = new JTextField(15);
		//finishTimeLabel = new JLabel("Finish Time");
		//finishTimeTextField = new JTextField(15);
		searchButton = new JButton("Search");
                resetButton = new JButton("Reset");
		addButton = new JButton("Add Appointment");
		updateButton = new JButton("Edit / Remove / Add Summary");
		setHolidaysButton = new JButton("Holidays & Days Off");
                logoutButton = new JButton("Log Out");
		
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
		//c.gridy = 9;
		//optionsPanel.add(dateLabel, c);
                c.gridy = 9; c.anchor = GridBagConstraints.LINE_START;
                optionsPanel.add(yearLabel, c);
		c.gridy = 10;
                optionsPanel.add(yearsList, c);
                c.gridy = 9; c.anchor = GridBagConstraints.CENTER;
                optionsPanel.add(monthLabel, c);
                c.gridy = 10;
                optionsPanel.add(monthsList, c);
                c.gridy = 9; c.anchor = GridBagConstraints.LINE_END;
                optionsPanel.add(dayLabel, c);
                c.gridy = 10;
                optionsPanel.add(daysList, c);
                c.gridy = 9; c.gridx = 1; c.anchor = GridBagConstraints.CENTER;
                optionsPanel.add(hourLabel, c);
                c.gridy = 10;
                optionsPanel.add(hoursList, c);
                c.gridy = 11; c.gridx = 0;
		//optionsPanel.add(dateTextField, c);
		c.gridy = 12;
		//optionsPanel.add(startTimeLabel, c);
		c.gridy = 13;
		//optionsPanel.add(startTimeTextField, c);
		c.gridy = 14;
		//optionsPanel.add(finishTimeLabel, c);
		c.gridy = 15;
		//optionsPanel.add(finishTimeTextField, c);
		c.gridy = 16; c.gridx = -1;
		optionsPanel.add(addButton, c);
		c.gridy = 16; c.gridx = 1;
		optionsPanel.add(searchButton, c);
		c.gridy = 18; c.gridx = -1;
		optionsPanel.add(updateButton, c);
		c.gridy = 18; c.gridx = 1;
		optionsPanel.add(resetButton, c);
		c.gridy = 19; c.gridx = -1;
		optionsPanel.add(setHolidaysButton, c);
                c.gridy = 19; c.gridx = 1;
		optionsPanel.add(logoutButton, c);
                
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
                logoutButton.addActionListener(listen);
                
                appFrame.addWindowListener( new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        loginFrame();
                    }
                });
	}
        
        public void addAppFrame() {
            
            appFrame.setEnabled(false);
            if (inEditingMode) editAppFrame.setEnabled(false);
            
            String frameName = (! inEditingMode) ? "Add an Appointment" : "Editing an Appointment";
            addAppFrame = new JFrame(frameName);
            addAppFrame.setVisible(true);
            addAppFrame.setBounds(400, 200, 350, 450);
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
            durationAddLabel = new JLabel("Duration");
            appTimeAddLabel = new JLabel("Choose Time Slot");
            roomAddLabel = new JLabel("Choose Room");
            
            
            //idAddText = new JTextField(15);
            //typeAddText = new JTextField(15);
            routineTypeAdd = new JRadioButton("Routine", false);
            careManagementTypeAdd = new JRadioButton("Care Management", false);
                radioGroupAdd = new ButtonGroup();
                radioGroupAdd.add(routineTypeAdd);
                radioGroupAdd.add(careManagementTypeAdd);
                
            //patientAddText = new JTextField(15);
            patientsKeyAndVal = Main.getKeyAndValOfPatients();
            patientsListAdd = new JComboBox(Main.getAllValuesOnly(patientsKeyAndVal));
            //staffAddText = new JTextField(15);
            
            String[] years = Main.getAllYears(), months = Main.getAllMonths(), days = Main.getAllDays();
            years[0] = "Year"; months[0] = "Month"; days[0] = "Day";
            yearsListAdd = new JComboBox(years);
            monthsListAdd = new JComboBox(months);
            daysListAdd = new JComboBox(days);
            
            dateAddText = new JTextField(15);
            dateAddText.setEditable(false);
            //startTimeAddText = new JTextField(15);
            //finishTimeAddText = new JTextField(15);
            
            String[] arr = {"Add & Check Date First"};
            staffListAdd = new JComboBox(arr);
            staffListAdd.setEnabled(false);
            
            durationsListAdd = new JComboBox(Main.getAllDurations());
            
            timesListAdd = new JComboBox(arr);
            timesListAdd.setEnabled(false);
            
            roomsListAdd = new JComboBox(arr/*Main.getAllRooms()*/);
            roomsListAdd.setEnabled(false);
            
            //dateLookedAt = "";
            typeChosenAdd = "";
            
            if (inEditingMode) {
                /* Cancel old reservations, retrieve old details and set these details to be selected by default.
                *  Hence whenever I use information like staff and patient I actually get the primary key 
                *  of that staff/patient and use it to get name from list using other helper methods in class 'Main'. */
                Main.setAvailability(true, oldTimeSlot, oldStaff, oldDate);
                Main.setRoomsAvailability(true, oldRoom, oldDate, oldTimeSlot);
                
                int row = appTable.getSelectedRow();
                
                if (oldType.equalsIgnoreCase("Routine")) {
                    routineTypeAdd.setSelected(true);
                    typeChosenAdd = "Routine";
                }
                else {
                    careManagementTypeAdd.setSelected(true);
                    typeChosenAdd = "Care Management";
                }
                String patientAndStaff[] = Main.getPatientAndStaffWithThisAppID(id);
                oldPatient = patientAndStaff[0];
                // Staff list select is done in method: 'updateListOfStaff'.
                //oldStaff = patientAndStaff[1]; //System.out.println(oldPatient + " " + oldStaff);
                int patientIndex = Main.getRowIndexWhereKeyIs(patientsKeyAndVal, oldPatient);
                patientsListAdd.setSelectedIndex(patientIndex);
                
                dateAddText.setText(oldDate);
                updateListOfStaff();
                updateListOfTimes();
                
                noEditingMadeYet = false;
            }
            
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
            //addAppPanel.add(patientAddText, c);
            addAppPanel.add(patientsListAdd, c);
            c.gridy = 8;
            //addAppPanel.add(staffAddText, c);
            c.gridy = 9;
            addAppPanel.add(dateAddLabel, c);
            c.gridy = 10; c.anchor = GridBagConstraints.LINE_START;
            addAppPanel.add(yearsListAdd, c);
            c.gridy = 10; c.anchor = GridBagConstraints.CENTER;
            addAppPanel.add(monthsListAdd, c);
            c.gridy = 10; c.anchor = GridBagConstraints.LINE_END;
            addAppPanel.add(daysListAdd, c);
            c.gridy = 11; c.anchor = GridBagConstraints.CENTER;
            addAppPanel.add(dateAddText, c);
            c.gridy = 12;
            //addAppPanel.add(startTimeAddLabel, c);
            c.gridy = 13;
            //addAppPanel.add(startTimeAddText, c);
            c.gridy = 14;
            //addAppPanel.add(finishTimeAddLabel, c);
            c.gridy = 15;
            //addAppPanel.add(finishTimeAddText, c);
            c.gridy = 16;
            addAppPanel.add(checkDateButton, c);
            c.gridy = 17;
            addAppPanel.add(staffAddLabel, c);
            c.gridy = 18;
            addAppPanel.add(staffListAdd, c);
            c.gridy = 19;
            addAppPanel.add(durationAddLabel, c);
            c.gridy = 20;
            addAppPanel.add(durationsListAdd, c);
            c.gridy = 21;
            addAppPanel.add(appTimeAddLabel, c);
            c.gridy = 22;
            addAppPanel.add(timesListAdd, c);
            c.gridy = 23;
            addAppPanel.add(roomAddLabel, c);
            c.gridy = 24;
            addAppPanel.add(roomsListAdd, c);
            c.gridy = 25;
            addAppPanel.add(submitAdd, c);
            c.gridy = 26;
            addAppPanel.add(resetAdd, c);
            //c.gridy = 22;
            //addAppPanel.add(cancelAdd, c);
            
            JScrollPane addAppScroll = new JScrollPane(addAppPanel);
            addAppFrame.add(addAppScroll);
            
            Listener listen = new Listener();
            
            routineTypeAdd.addItemListener(listen);
            careManagementTypeAdd.addItemListener(listen);
            staffListAdd.addItemListener(listen);
            //durationsListAdd.addItemListener(listen);
            durationsListAdd.addItemListener( new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        // If duration is changed then update timeslots.
                        updateListOfTimes();
                    }
                }
            });
            timesListAdd.addItemListener( new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        // If timeslot is changed/selected, then update rooms list.
                        updateListOfRooms();
                    }
                }
            });
            
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
                    if (inEditingMode) {
                        // Re-add the old reservations, because user cancelled the editing by pressing the exit icon.
                        Main.setAvailability(false, oldTimeSlot, oldStaff, oldDate);
                        Main.setRoomsAvailability(false, oldRoom, oldDate, oldTimeSlot);
                        editAppFrame.setEnabled(true);
                        inEditingMode = false;
                    }
                    else {
                        appFrame.setEnabled(true);
                    }
                }
            });
        }
        
        public void editAppFrame() {
            
            appFrame.setEnabled(false);
            
            int row = appTable.getSelectedRow();
            String[] rowDetails = getTableRowDetails(row);
            
            id = rowDetails[0];
            String rowInfo = rowDetails[rowDetails.length-1];
            
            oldType = rowDetails[1];
            oldTimeSlot = rowDetails[5];
            String patientAndStaff[] = Main.getPatientAndStaffWithThisAppID(id);
            oldPatient = patientAndStaff[0];
            //oldStaff = rowDetails[3];
            oldStaff = patientAndStaff[1]; System.out.println(oldPatient + " " + oldStaff);
            oldDate = rowDetails[4];
            oldRoom = rowDetails[6];
            
            editAppFrame = new JFrame("Appointment Details");
            editAppFrame.setVisible(true);
            editAppFrame.setBounds(400, 200, 500, 450);
            JPanel editAppPanel = new JPanel();
            editAppPanel.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            
            idEditLabel  = new JLabel("Appointment ID");
            appInfoLabel  = new JLabel("Appointment Details");
            
            idEditText = new JTextField(id);
            idEditText.setEditable(false);
            
            appInfoArea = new JTextArea(rowInfo);
            appInfoArea.setEditable(false);
            appInfoArea.setSize(new Dimension(450, 200));
            appInfoArea.setLineWrap(true);
            JScrollPane appInfoAreaScroll = new JScrollPane(appInfoArea);
            
            addSummaryButton = new JButton("Add Summary");
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
            editAppPanel.add(appInfoAreaScroll, c);
            c.gridy = 5;
            editAppPanel.add(addSummaryButton, c);
            c.gridy = 6;
            editAppPanel.add(editEditButton, c);
            c.gridy = 7;
            editAppPanel.add(removeEditButton, c);
            //c.gridy = 8;
            //editAppPanel.add(cancelEditButton, c);
            
            JScrollPane editAppScroll = new JScrollPane(editAppPanel);
            editAppFrame.add(editAppScroll);
            
            Listener listen = new Listener();
            
            addSummaryButton.addActionListener(listen);
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
        
        public void addSummaryFrame() {
            
            editAppFrame.setEnabled(false);
            
            addSummaryFrame = new JFrame("Days Off and Holidays");
            addSummaryFrame.setVisible(true);
            addSummaryFrame.setBounds(400, 200, 660, 400);
            JPanel addSummaryPanel = new JPanel();
            addSummaryPanel.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            
            summaryText = new JTextArea(10, 15);
            summaryText.setLineWrap(true);
            JScrollPane summaryTextScroll = new JScrollPane(summaryText);
            summaryCounter = new JTextField(5);
            submitSummaryButton = new JButton("Submit Summary");
            resetSummaryButton = new JButton("Reset");
            
            c.gridy = 1; c.gridx = 1;
            addSummaryPanel.add(summaryTextScroll, c);
            c.gridy = 1; c.gridx = 2;
            addSummaryPanel.add(summaryCounter, c);
            c.gridy = 2; c.gridx = 1;
            addSummaryPanel.add(submitSummaryButton, c);
            c.gridy = 2; c.gridx = 2;
            addSummaryPanel.add(resetSummaryButton, c);
            JScrollPane daysOffScroll = new JScrollPane(addSummaryPanel);
            
            addSummaryFrame.add(daysOffScroll);
            
            Listener listen = new Listener();
            
            submitSummaryButton.addActionListener(listen);
            resetSummaryButton.addActionListener(listen);
            
            summaryText.getDocument().addDocumentListener( new DocumentListener() {
                
                public void changedUpdate(DocumentEvent e) {
                    summaryCounter.setText(Integer.toString(summaryText.getText().length()));
                }
                public void removeUpdate(DocumentEvent e) {
                    summaryCounter.setText(Integer.toString(summaryText.getText().length()));
                }
                public void insertUpdate(DocumentEvent e) {
                    summaryCounter.setText(Integer.toString(summaryText.getText().length()));
                }
            });
            
            addSummaryFrame.addWindowListener( new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    editAppFrame.setEnabled(true);
                }
            });
        }
        
        public void daysOffFrame() {
            
            appFrame.setEnabled(false);
            
            daysOffFrame = new JFrame("Days Off and Holidays");
            daysOffFrame.setVisible(true);
            daysOffFrame.setBounds(400, 200, 660, 400);
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
            daysOffTable.setPreferredScrollableViewportSize(new Dimension(300, 300));
            daysOffTable.getColumnModel().getColumn(0).setPreferredWidth(90);
            daysOffTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            daysOffTable.getColumnModel().getColumn(2).setPreferredWidth(160);
            
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
                //staffOptions = Main.getOneColumnFromTable("SELECT name FROM doctorsandnurses WHERE date LIKE '" + dateAddText.getText()/*dateLookedAt*/ + "' ;");
                /*staffOptions = Main.getOneColumnFromTable("SELECT name FROM doctorsandnurses ;"); staffOptions = Main.removeRepeated(staffOptions);*/
                docsAndNursesKeyAndVal = Main.getKeyAndValOfDocsAndNurses();
                staffOptions = Main.getAllValuesOnly(docsAndNursesKeyAndVal);
                staffListAdd.setEnabled(true);
                
                for (String val : staffOptions)
                    staffListAdd.addItem(val);
                if (inEditingMode && noEditingMadeYet) {
                    int staffIndex = Main.getRowIndexWhereKeyIs(docsAndNursesKeyAndVal, oldStaff);
                    staffListAdd.setSelectedIndex(staffIndex);
                }
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
            
             // If date is not empty AND list of staff is not empty.
            if (! dateAddText.getText().equals("") && staffListAdd.getItemCount() != 0 && ! staffListAdd.getSelectedItem().equals("Add & Check Date First")) {
                //if (Main.recordExists("SELECT * FROM doctorsandnurses WHERE date LIKE '"+dateAddText.getText()+"' AND  name = '"+Main.getKey(docsAndNursesKeyAndVal, staffListAdd.getSelectedIndex())+"' ;"))
                timesOptions = Main.getTimeSlotsAvailable(Main.getKey(docsAndNursesKeyAndVal, staffListAdd.getSelectedIndex()), dateAddText.getText()/*dateLookedAt*/, durationsListAdd.getSelectedItem().toString());
                //else timesOptions = Main.getAllTimeSlotsForDuration(durationsListAdd.getSelectedItem().toString());
                timesListAdd.setEnabled(true);
                
                if (timesOptions.length > 0) {
                    for (String val : timesOptions)
                        timesListAdd.addItem(val);
                    if (inEditingMode && noEditingMadeYet) {
                        // Update selection of duration according to old one.
                        int duration = Main.getDuration(oldTimeSlot);
                        int index = (duration == 15) ? 0 : (duration == 30) ? 1 : (duration == 45) ? 2 : 3;
                        durationsListAdd.setSelectedIndex(index);
                        // Update selection of timeslot according to old one.
                        int timeSlotIndex = Main.getRowIndex(timesOptions, oldTimeSlot);
                        timesListAdd.setSelectedIndex(timeSlotIndex);
                        updateListOfRooms();
                    }
                }
                else{
                    timesListAdd.addItem("No Available Time Slots");
                    timesListAdd.setEnabled(false);}
            }
            else {
                String[] options = {"Add & Check Date First"};
                timesListAdd.addItem(options[0]);
                timesListAdd.setEnabled(false);
            }
        }
        
        public void updateListOfDurations() {
            
            durationsListAdd.removeAllItems();
            String[] allDurations = Main.getAllDurations();
            if (typeChosenAdd.equals("Routine")) {
                durationsListAdd.addItem(allDurations[0]);
                //durationsListAdd.setSelectedIndex(0);
            }
            else {
                for (String val : allDurations)
                    durationsListAdd.addItem(val);
            }
        }
        
        public void updateListOfRooms() {
            
            roomsListAdd.removeAllItems();
             // If list of time slots is not empty.
            if (timesListAdd.getItemCount() != 0 && ! timesListAdd.getSelectedItem().toString().equals("Add & Check Date First") && ! timesListAdd.getSelectedItem().toString().equals("No Available Time Slots")) {
                roomsListAdd.setEnabled(true);
                String[] allRooms = Main.getRoomsAvailable(dateAddText.getText(), timesListAdd.getSelectedItem().toString());
                //String[] allRooms = Main.getAllRooms();
                for (String room : allRooms)
                    roomsListAdd.addItem(room);
                if (inEditingMode && noEditingMadeYet) {
                    int index = Main.getRowIndex(allRooms, oldRoom);
                    roomsListAdd.setSelectedIndex(index);
                }
            }
            else {
                String[] options = {"Add & Check Date First"};
                roomsListAdd.addItem(options[0]);
                roomsListAdd.setEnabled(false);
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
                    timesOptions = Main.getTimeSlotsAvailable(Main.getKey(docsAndNursesKeyAndVal, staffListAdd.getSelectedIndex()), dateAddText.getText() /*dateLookedAt, durationsListAdd.getSelectedItem().toString());
                else
                    timesOptions = Main.getAllTimeSlotsForDuration(durationsListAdd.getSelectedItem().toString());
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
            String room = appTable.getModel().getValueAt(row, 7).toString();
            String summary = appTable.getModel().getValueAt(row, 8).toString();
            
            /*JOptionPane.showMessageDialog(null, id + "\n" + type + "\n" + patient + "\n" + date + "\n" + 
                                                staff + "\n" + timeSlot1 + "\n" + timeSlot2 + "\n" + timeSlot + "\n");*/
            
            String rowInfo = "Patient ID:\t\t" + id + "\nAppointment Type:\t" + type + "\nPatient Name:\t\t" + patient + 
                    "\nDate:\t\t" + date + "\nDoc/Nurse Name:\t" + staff + "\nAppointment Time Slot:\t" + timeSlot + 
                    "\nRoom:\t\t" + room + "\n____________________________________________________________\n\t\tSummary:\n" + summary + "\n";
            
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
            return new String[] {id, type, patient, staff, date, timeSlot, room, summary, rowInfo};
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
					
					boolean access = Main.hasAccessRight(user, pass);
					
					if (access) {
                                            String staffID = Main.getStaffID(user, pass);
                                            boolean[] privileges = Main.getAccessPrivileges(staffID);
                                            userIsDoctor = privileges[0];
                                            userIsNurse = privileges[1];
                                            userIsReceptionist = privileges[2];
                                            userIsOfficeManager = privileges[3];
                                            JOptionPane.showMessageDialog(null, "You have successfully accessed the program.\n\n"+Main.privilegesText(privileges), "Access Guaranteed", JOptionPane.INFORMATION_MESSAGE);
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
				
                                Main.close();
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
                            //values[4] = dateTextField.getText();
                            String year = (yearsList.getSelectedItem().toString().equals("All")) ? "%" : yearsList.getSelectedItem().toString();
                            String month = (monthsList.getSelectedItem().toString().equals("All")) ? "%" : monthsList.getSelectedItem().toString();
                            String day = (daysList.getSelectedItem().toString().equals("All")) ? "%" : daysList.getSelectedItem().toString();
                            values[4] = year + "-" + month + "-" + day;
                            //values[5] = startTimeTextField.getText();
                            //values[6] = finishTimeTextField.getText();
                            values[5] = (hoursList.getSelectedItem().toString().equals("All")) ? "" : hoursList.getSelectedItem().toString().substring(0,2) + "%";
                            values[6] = ""; // Does not need to be set any more.
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
                            //dateTextField.setText("");
                            yearsList.removeAllItems();
                            String[] allYears = Main.getAllYears();
                            for (String val : allYears)
                                yearsList.addItem(val);
                            monthsList.removeAllItems();
                            String[] allMonths = Main.getAllMonths();
                            for (String val : allMonths)
                                monthsList.addItem(val);
                            daysList.removeAllItems();
                            String[] allDays = Main.getAllDays();
                            for (String val : allDays)
                                daysList.addItem(val);
                            hoursList.removeAllItems();
                            String[] allHours = Main.getAllHours();
                            for (String val : allHours)
                                hoursList.addItem(val);
                            //startTimeTextField.setText("");
                            //finishTimeTextField.setText("");
                            String[] values = {};
                            tableModel.setFilter(values);
                            tableModel.fireTableDataChanged();
                        }
                        else if (e.getSource() == addButton) {
                            
                            addAppFrame();
                        }
                        else if (e.getSource() == updateButton) {
                            
                            if (appTable.getSelectedRow() > -1) {
                                if (appTable.getModel().getValueAt(appTable.getSelectedRow(), 0).toString().equals(""))
                                    JOptionPane.showMessageDialog(null, "No Records Available !!");
                                else
                                    editAppFrame();
                            }
                            else
                                JOptionPane.showMessageDialog(null, "Please select an appointment from the table first !!");
                        }
                        else if (e.getSource() == setHolidaysButton) {
                            if (userIsOfficeManager)
                                daysOffFrame();
                            else
                                JOptionPane.showMessageDialog(null, "Sorry you do not have access rights to use this functionality !!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else if (e.getSource() == logoutButton) {
                            appFrame.setVisible(false);
                            loginFrame();
                        }
                        
                        // addAppFrame actions listener
                        if (e.getSource() == checkDateButton) {
                            String dateSelected = yearsListAdd.getSelectedItem().toString() + "-" + monthsListAdd.getSelectedItem().toString() + "-" + daysListAdd.getSelectedItem().toString();
                            if (! dateSelected.equalsIgnoreCase("Year-Month-Day")/*! dateAddText.getText().equals("")*/) {
                                if (Main.dateIsInCorrectFormat(dateSelected)) {
                                    if (Main.gpIsOpenOn(dateSelected)) {
                                        //dateLookedAt = dateAddText.getText();
                                        dateAddText.setText(dateSelected);
                                        updateListOfStaff();
                                        updateListOfTimes();
                                    }
                                    else {
                                        resetAddApp();
                                        String moreInfo = "";
                                        if (Main.getDayOfWeek(dateSelected) == 1)
                                            moreInfo += "We are closed on Sundays !!";
                                        else if (Main.dateIsInThePast(dateSelected))
                                            moreInfo += "Appointments can only be made in the future !!";
                                        else if (! Main.isValidDateInCommonYear(dateSelected))
                                            moreInfo += "This date is invalid !!";
                                        else
                                            moreInfo += "We are closed on this day due to 'Training' or 'Public Holiday' !!";
                                        JOptionPane.showMessageDialog(null, "Sorry the GP is not open on this day !!\n"+moreInfo, "Incorrect Action !!", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                                else {
                                    resetAddApp();
                                    JOptionPane.showMessageDialog(null, "Please enter date in this format:\nyyyy-mm-dd", "Incorrect Action !!", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            else {
                                resetAddApp();
                                JOptionPane.showMessageDialog(null, "Please enter a date and press the 'Check Date' button !!", "Incorrect Action !!", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else if (e.getSource() == submitAdd) {
                            String msg = "";
                            boolean incomplete = true;
                            if (! typeChosenAdd.equalsIgnoreCase("Routine") && ! typeChosenAdd.equalsIgnoreCase("Care Management"))
                            //if (! routineTypeAdd.isSelected() || ! careManagementTypeAdd.isSelected())
                                msg += "- Choose Type of Appointment\n";
                            //if (patientAddText.getText().equals(""))
                                //msg += "- Enter patient name\n";
                            if (dateAddText.getText().equals("") || ! Main.dateIsInCorrectFormat(dateAddText.getText()) || ! Main.gpIsOpenOn(dateAddText.getText()))
                                msg += "- Add a correct date\n";
                            if (staffListAdd.getSelectedItem().equals("Add & Check Date First") || staffListAdd.getSelectedItem().equals("") || staffListAdd.getSelectedItem().equals(null))
                                msg += "- Select staff\n";
                            if (timesListAdd.getSelectedItem().equals("Add & Check Date First") || timesListAdd.getSelectedItem().equals("") || timesListAdd.getSelectedItem().equals(null))
                                msg += "- Select a timeslot\n";
                            if (roomsListAdd.getSelectedItem().equals("Add & Check Date First") || roomsListAdd.getSelectedItem().equals("") || roomsListAdd.getSelectedItem().equals(null))
                                msg += "- Select a room\n";
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
                                        //patientAddText.getText(),
                                        Main.getKey(patientsKeyAndVal, patientsListAdd.getSelectedIndex()),
                                        Main.getKey(docsAndNursesKeyAndVal, staffListAdd.getSelectedIndex()),
                                        dateAddText.getText(),
                                        timeSlots[0],
                                        timeSlots[1],
                                        roomsListAdd.getSelectedItem().toString()
                                    };
                                    Main.addAppointment(array);

                                    // Update availability timeslots of 'doctors and nurses'
                                    if (Main.recordExists("SELECT * FROM doctorsandnurses WHERE date LIKE '"+dateAddText.getText()+"' AND  name = '"+Main.getKey(docsAndNursesKeyAndVal, staffListAdd.getSelectedIndex())+"' ;")) {
                                        //Main.execute("UPDATE doctorsandnurses SET "+ Main.getColumnNameForTimeSlot(timesListAdd.getSelectedItem().toString()) +" = 'n' WHERE name = '"+ Main.getKey(docsAndNursesKeyAndVal, staffListAdd.getSelectedIndex()) +"' AND date = '"+ dateAddText.getText() +"' ;");
                                        Main.setAvailability(false, timesListAdd.getSelectedItem().toString(), Main.getKey(docsAndNursesKeyAndVal, staffListAdd.getSelectedIndex()), dateAddText.getText());
                                    }
                                    else {
                                        //Main.execute("INSERT INTO doctorsandnurses (name, date, "+ Main.getColumnNameForTimeSlot(timesListAdd.getSelectedItem().toString()) +") VALUES ('"+ Main.getKey(docsAndNursesKeyAndVal, staffListAdd.getSelectedIndex()) +"', '"+ dateAddText.getText() +"', '"+ "n" +"') ;");
                                        Main.createAvailability(timesListAdd.getSelectedItem().toString(), Main.getKey(docsAndNursesKeyAndVal, staffListAdd.getSelectedIndex()), dateAddText.getText());
                                    }
                                    if (Main.recordExists("SELECT * FROM room WHERE room = '"+ roomsListAdd.getSelectedItem().toString() +"' AND date = '"+ dateAddText.getText() +"' ;"))
                                        Main.setRoomsAvailability(false, roomsListAdd.getSelectedItem().toString(), dateAddText.getText(), timesListAdd.getSelectedItem().toString());
                                    else
                                        Main.createRoomsAvailability(roomsListAdd.getSelectedItem().toString(), dateAddText.getText(), timesListAdd.getSelectedItem().toString());
                                    
                                    JOptionPane.showConfirmDialog(null, "Appointment has been recorded successfully.", "Complete", JOptionPane.CLOSED_OPTION);
                                }
                                else { // Then it is in EDITING mode
                                    // Edit an existing appointment, which is identified by its ID.
                                    String[] timeSlots = timesListAdd.getSelectedItem().toString().split("-");
                                    String[] array = {
                                        typeChosenAdd,
                                        //patientAddText.getText(),
                                        Main.getKey(patientsKeyAndVal, patientsListAdd.getSelectedIndex()),
                                        Main.getKey(docsAndNursesKeyAndVal, staffListAdd.getSelectedIndex()),
                                        dateAddText.getText(),
                                        timeSlots[0],
                                        timeSlots[1],
                                        roomsListAdd.getSelectedItem().toString()
                                    };
                                    Main.editAppointment(array, id);
                                    
                                    // Update availability timeslots of 'doctors and nurses' accordingly
                                    //Main.execute("UPDATE doctorsandnurses SET "+ Main.getColumnNameForTimeSlot(oldTimeSlot) +" = 'y' WHERE name = '"+ oldStaff +"' AND date = '"+ oldDate +"' ;");
                                    ////Main.setAvailability(true, oldTimeSlot, oldStaff, oldDate);
                                    //Main.execute("UPDATE doctorsandnurses SET "+ Main.getColumnNameForTimeSlot(timesListAdd.getSelectedItem().toString()) +" = 'n' WHERE name = '"+ Main.getKey(docsAndNursesKeyAndVal, staffListAdd.getSelectedIndex()) +"' AND date = '"+ dateAddText.getText() +"' ;");
                                    if (Main.recordExists("SELECT * FROM doctorsandnurses WHERE date LIKE '"+dateAddText.getText()+"' AND  name = '"+Main.getKey(docsAndNursesKeyAndVal, staffListAdd.getSelectedIndex())+"' ;"))
                                        Main.setAvailability(false, timesListAdd.getSelectedItem().toString(), Main.getKey(docsAndNursesKeyAndVal, staffListAdd.getSelectedIndex()), dateAddText.getText());
                                    else
                                        Main.createAvailability(timesListAdd.getSelectedItem().toString(), Main.getKey(docsAndNursesKeyAndVal, staffListAdd.getSelectedIndex()), dateAddText.getText());
                                    
                                    ////Main.setRoomsAvailability(true, oldRoom, oldDate, oldTimeSlot);
                                    if (Main.recordExists("SELECT * FROM room WHERE room = '"+ roomsListAdd.getSelectedItem().toString() +"' AND date = '"+ dateAddText.getText() +"' ;"))
                                        Main.setRoomsAvailability(false, roomsListAdd.getSelectedItem().toString(), dateAddText.getText(), timesListAdd.getSelectedItem().toString());
                                    else
                                        Main.createRoomsAvailability(roomsListAdd.getSelectedItem().toString(), dateAddText.getText(), timesListAdd.getSelectedItem().toString());
                                    JOptionPane.showConfirmDialog(null, "Appointment has been recorded successfully.", "Complete", JOptionPane.CLOSED_OPTION);
                                    editAppFrame.dispose();
                                    //editAppFrame.setEnabled(true);
                                    inEditingMode = false;
                                }
                                
                                appFrame.setEnabled(true);
                                addAppFrame.setVisible(false);
                                tableModel.setFilter(new String[]{});
                                tableModel.fireTableDataChanged();
                            }
                        }
                        else if (e.getSource() == resetAdd) {
                            
                            //idAddText.setText("");
                            //typeAddText.setText("");
                            //patientAddText.setText("");
                            patientsListAdd.setSelectedIndex(0);
                            //staffAddText.setText("");
                            dateAddText.setText("");
                            //startTimeAddText.setText("");
                            //finishTimeAddText.setText("");
                            updateListOfStaff();
                            updateListOfTimes();
                            durationsListAdd.setSelectedIndex(0);
                        }
                        
                        // updateAppFrame actions listener
                        if (e.getSource() == addSummaryButton) {
                            
                            if (userIsDoctor)
                                addSummaryFrame();
                            else
                                JOptionPane.showMessageDialog(null, "Sorry you do not have permission to add a summary to an appointment !!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else if (e.getSource() == editEditButton) {
                            
                            if (Main.dateIsInThePast(oldDate))
                                JOptionPane.showMessageDialog(null, "You cannot edit an old appointment !!", "Incorrect Action !!", JOptionPane.ERROR_MESSAGE);
                            else {
                                inEditingMode = true;
                                noEditingMadeYet = true;
                                addAppFrame();
                            }
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
                                //Main.execute("UPDATE doctorsandnurses SET "+ Main.getColumnNameForTimeSlot(timeSlot) +" = 'y' WHERE name like '"+ staff +"' AND  date like '"+ date +"' ;");
                                Main.setAvailability(true, timeSlot, staff, date);
                                JOptionPane.showMessageDialog(null, "Appointment has been deleted successfully.");
                                editAppFrame.dispose();
                                appFrame.setEnabled(true);
                                tableModel.setFilter(new String[]{});
                                tableModel.fireTableDataChanged();
                            }
                        }
                        
                        // addSummaryFrame actions listener
                        if (e.getSource() == submitSummaryButton) {
                            if (summaryText.getText().length() > 255)
                                JOptionPane.showMessageDialog(null, "You have exceeded the maximum length of a summary, which is 255 characters !!\nPlease reduce the text and re-submit.", "Error", JOptionPane.ERROR_MESSAGE);
                            else {
                                String summaryTextString = summaryText.getText(); //JOptionPane.showMessageDialog(null, summaryTextString);
                                Main.addSummaryToAppointment(id, summaryTextString);
                                JOptionPane.showMessageDialog(null, "The summary has been added to the appointment record with ID "+ id +" successfully.");
                                addSummaryFrame.dispose();
                                editAppFrame.dispose();
                                appFrame.setVisible(true);
                                appFrame.setEnabled(true);
                                tableModel.setFilter(new String[]{});
                                tableModel.fireTableDataChanged();
                            }
                        }
                        else if (e.getSource() == resetSummaryButton) {
                            
                            int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear the text area?", "Clear text area?", JOptionPane.YES_NO_OPTION);
                            if (ans == JOptionPane.YES_OPTION)
                                summaryText.setText("");
                        }
                        
                        // setHolidaysFrame actions listener
                        if (e.getSource() == searchDaysOff) {
                            
                            String[] array = {searchDaysOffText.getText().toString()};
                            if (! array[0].equals("")) {
                                if (Main.recordExists("SELECT date FROM gpdaysoff WHERE date LIKE '"+ array[0] +"' ;")) {
                                    daysOffTableModel.setFilter(array);
                                    daysOffTableModel.fireTableDataChanged();
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "This date does not exist in the list of the GP holidays !!", "Error", JOptionPane.ERROR_MESSAGE);
                                    daysOffTableModel.setFilter(new String[]{});
                                    daysOffTableModel.fireTableDataChanged();
                                }
                            }
                            else {
                                daysOffTableModel.setFilter(new String[]{});
                                daysOffTableModel.fireTableDataChanged();
                            }
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
                                    if (Main.recordExists("SELECT * FROM gpdaysoff WHERE date LIKE '" + date + "'; "))
                                        JOptionPane.showMessageDialog(null, "This day already exists, please try again.");
                                    else {
                                        String type = JOptionPane.showInputDialog("Please enter the type of holiday/day off\n(Maximum 45 characters !!)...");
                                        String description = JOptionPane.showInputDialog("Please enter a description of the holiday/day off\n(Maximum 45 characters !!)...");
                                        if (type.length() <= 45 && description.length() <= 45) {
                                            Main.addGPDayOff(date, type, description);
                                            daysOffTableModel.setFilter(new String[]{});
                                            daysOffTableModel.fireTableDataChanged();
                                        }
                                        else
                                            JOptionPane.showMessageDialog(null, "Sorry you have entered too many characters for 'Type' and/or 'Description' !!\nThe limit is 45 characters, please try again.", "Error", JOptionPane.ERROR_MESSAGE);
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
                                String type = daysOffTable.getValueAt(daysOffTable.getSelectedRow(), 1).toString();
                                if (type.equalsIgnoreCase("Public"))
                                    JOptionPane.showMessageDialog(null, "This is a public holiday and cannot be deleted !!", "Error", JOptionPane.ERROR_MESSAGE);
                                else {
                                    int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this holiday?", "Title", JOptionPane.YES_NO_OPTION);
                                    if (ans == JOptionPane.YES_OPTION) {
                                        int row = daysOffTable.getSelectedRow();
                                        String date = (String) daysOffTable.getModel().getValueAt(row, 0);
                                        // Delete appointment from table appointments.
                                        Main.removeGPDayOff(date);
                                        JOptionPane.showMessageDialog(null, "Holiday/day off has been deleted successfully.");
                                        daysOffTableModel.setFilter(new String[]{});
                                        daysOffTableModel.fireTableDataChanged();
                                    }
                                }
                            }
                        }
		}
                
                public void itemStateChanged(ItemEvent e) {
                    
                    if (routineTypeAdd.isSelected()) {
                        //JOptionPane.showMessageDialog(null, "Routine is selected");
                        typeChosenAdd = "Routine";
                        updateListOfDurations();
                        //typeChosenEdit = "Routine";
                    }
                    else if (careManagementTypeAdd.isSelected()) {
                        //JOptionPane.showMessageDialog(null, "Care Management is selected");
                        typeChosenAdd = "Care Management";
                        updateListOfDurations();
                        //typeChosenEdit = "Care Management";
                    }
                    
                    if (e.getStateChange() == ItemEvent.SELECTED) { // If a staff and/or duration is selected from the staff list and/or duration list.
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
                        if (appTable.getModel().getValueAt(appTable.getSelectedRow(), 0).toString().equals(""))
                            JOptionPane.showMessageDialog(null, "No Records Available !!");
                        else
                            editAppFrame();
                    }
                }
	}
	
	public static void main(String[] args) {
		
		//GUI gui = new GUI();
		
		/*gui.setVisible(true);
		//gui.pack();
		gui.setSize(500, 500);
		gui.setLocation(400, 100);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
	}
	
}