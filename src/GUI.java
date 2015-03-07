import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JLabel item1, idLabel, typeLabel, patientLabel, staffLabel, dateLabel, startTimeLabel, finishTimeLabel;
	private JTextField idTextField, typeTextField, patientTextField, staffTextField, dateTextField, startTimeTextField, finishTimeTextField;
	private JButton button1, searchButton, addButton, updateButton, removeButton;
	private JPanel appPanel, optionsPanel, menuPanel, mainPanel;
	private JTable appTable;
	private JScrollPane appScroll, optionsScroll, mainScroll;
        private String[] arr = {};
        private String[][] tableData = Main.getRecords(arr);
	
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
		JFrame appFrame = new JFrame("Appointments System");
		appFrame.setVisible(true);
		appFrame.setSize(800, 500);
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
						{"1", "Care Management", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "},
						{"4", "Care Management", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "},
						{"5", "Routine", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "},
						{"3", "Routine", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "},
						{"6", "Routine", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "},
						{"7", "Care Management", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "},
						{"8", "Routine", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "},
						{"9", "Care Management", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "},
						{"10", "Care Management", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "},
						{"11", "Care Management", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "},
						{"12", "Routine", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "},
						{"14", "Routine", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "},
						{"15", "Care Management", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "},
						{"16", "Routine", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "},
						{"17", "Care Management", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "},
						{"18", "Care Management", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "},
						{"19", "Routine", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "},
						{"20", "Routine", "5 ", "2 ", "02/02/2014 ", "00:10 ", "00:50 "}
					};*/
		appTable = new JTable(tableData, columnNames);
		// To set the preferred view port size, which may require me to add a scroll bar in order to see the entire table.
		//appTable.setPreferredScrollableViewportSize(new Dimension(400, 100));
		// To make the table adjust height to fit with window, in order to avoid scrolling.
		//appTable.setFillsViewportHeight(true);
		appPanel.add(appTable);
		
		optionsPanel = new JPanel(new GridBagLayout());
		idLabel = new JLabel("ID");
		idTextField = new JTextField(15);
		typeLabel = new JLabel("Type");
		typeTextField = new JTextField(15);
		patientLabel = new JLabel("Patient ID");
		patientTextField = new JTextField(15);
		staffLabel = new JLabel("Staff ID");
		staffTextField = new JTextField(15);
		dateLabel = new JLabel("Date ID");
		dateTextField = new JTextField(15);
		startTimeLabel = new JLabel("Start Time");
		startTimeTextField = new JTextField(15);
		finishTimeLabel = new JLabel("Finish Time");
		finishTimeTextField = new JTextField(15);
		searchButton = new JButton("Search");
		addButton = new JButton("Add");
		updateButton = new JButton("Update");
		removeButton = new JButton("Remove");
		
		c.gridx = 0;
		c.gridy = 2;
		optionsPanel.add(idLabel);
		optionsPanel.add(idTextField, c);
		c.gridy = 3;
		optionsPanel.add(typeLabel, c);
		c.gridy = 4;
		optionsPanel.add(typeTextField, c);
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
		optionsPanel.add(addButton, c);
		c.gridy = 16; c.gridx = -1;
		optionsPanel.add(updateButton, c);
		c.gridy = 16; c.gridx = 1;
		optionsPanel.add(removeButton, c);
		
		//appFrame.add(appPanel);
		appScroll = new JScrollPane(appPanel);
		// Horizontal spacing //c.weightx = 1.0;
		// Vertical spacing //c.weighty = 1.0;
		mainPanel.add(optionsPanel);
		mainPanel.add(appScroll);
		mainScroll = new JScrollPane(mainPanel);
		appFrame.add(mainScroll);
		
		Listener listen = new Listener();
		button1.addActionListener(listen);
                searchButton.addActionListener(listen);
	}
	
	private class Listener implements ActionListener {
		
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
			
			if (e.getSource() == button1) {
				System.out.println("Hi...");
			}
                        if (e.getSource() == searchButton) {
                            //String textId, textType, textpatient, textStaff, textDate, textStartTime, textFinishTime;
                            String[] values = new String[7];
                            values[0] = idTextField.getText();
                            values[1] = typeTextField.getText();
                            values[2] = patientTextField.getText();
                            values[3] = staffTextField.getText();
                            values[4] = dateTextField.getText();
                            values[5] = startTimeTextField.getText();
                            values[6] = finishTimeTextField.getText();
                            //JOptionPane.showMessageDialog(null, textId+textType+textpatient+textStaff+textDate+textStartTime+textFinishTime);
                            tableData = Main.getRecords(values);
                            //tableData.fireTableDataChanged();
                            //tableData.repaint();
                            //appPanel.setVisible(false);
                            //appPanel.setVisible(true);
                            /*String[] res = Main.getRecords2(values);
                            for (String tmp : res)
                                JOptionPane.showMessageDialog(null, res);*/
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