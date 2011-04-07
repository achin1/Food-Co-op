import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


/**
 *
 * @author Dave Wroblewski
 * @version 4/4/11
 * This is the GUI class for the main menu of the program
 * this class, all it's members, and all it's variables are completely
 * self explanatory
 * 
 * 
 * 
 * 
 * 
 */
public class MainFrame extends JFrame {
	
	
	/**
	 * Automatically generated serial ID 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates the panels for the main frame
	 * 2 panels on the frame itself one BoarderLayout.EAST
	 * the other BorderLayout.WEST, the latter will contain 3 additional panels
	 * Top middle and bottom
	 * 
	 * 
	 */
	private JPanel eastPanel;
	private JPanel westPanel;
	private JPanel topWestPanel;
	private JPanel middleWestPanel;
	private JPanel bottomWestPanel;
	private JPanel mainPanel;
	
	
	//JLabels
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel storeLabel;
	private JLabel kitchenLabel;
	
	//JTextFields
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	
	//JTextAreas and JScrollPanes
	private JTextArea generalLookupTextArea;
	private JScrollPane generalLookupScrollPane;
	
	private JTextArea storeTextArea;
	private JScrollPane storeScrollPane;
	
	private JTextArea kitchenTextArea;
	private JScrollPane kitchenScrollPane;
	
	
	//JButtons
	private JButton searchButton;
	private JButton viewMemberButton;
	private JButton updateMemberButton;
	private JButton addMemberButton;
	private JButton signIntoStoreButton;
	private JButton signIntoKitchenButton;
	private JButton viewScheduleButton;
	private JButton signOutOfStoreButton;
	private JButton signOutOfKitchenButton;
		
	private Controller controller;
	private Model model;
	
	public MainFrame(Controller c, Model m){
		controller = c;
		model = m;
		setBounds(400, 150, 600, 425);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setResizable(false);
		setVisible(true);
		setTitle("Main Menu");
		Font buttonFont = new Font("Calibri", Font.BOLD, 12);
		Font f2 = new Font("Calibri", Font.PLAIN, 14);
		eastPanel = new JPanel();
		westPanel = new JPanel();
		topWestPanel = new JPanel();
		middleWestPanel = new JPanel();
		bottomWestPanel = new JPanel();
		mainPanel = new JPanel();
		
		mainPanel.setLayout(null);
		
		eastPanel.setLayout(null);
		eastPanel.setBounds(430, 0, 170, 425);
		westPanel.setLayout(new GridLayout(3, 1));
		westPanel.setBounds(0, 0, 430, 425);
		topWestPanel.setLayout(null);
		middleWestPanel.setLayout(null);
		bottomWestPanel.setLayout(null);
		

//==============================================================
		/**
		 * Creates the area where the user enters
		 * a members first and last name and can search
		 * This is the top panel of the westPanel
		 * 
		 * 
		 */
		firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setFont(f2);
		firstNameLabel.setBounds(15, 25, 70, 10);
		
		lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setFont(f2);
		lastNameLabel.setBounds(15, 55, 70, 10);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(88, 23, 335, 20);
	
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(88, 53, 335, 20);
		
		searchButton = new JButton("Search");
		searchButton.setFont(buttonFont);
		searchButton.setBounds(343, 78, 80, 25);
		
		topWestPanel.add(firstNameLabel);
		topWestPanel.add(lastNameLabel);
		topWestPanel.add(firstNameTextField);
		topWestPanel.add(lastNameTextField);
		topWestPanel.add(searchButton);
//==============================================================
		/**
		 * creates the main text area where
		 * all the member information is placed
		 * this is the middle panel of the westPanel
		 * 
		 * 
		 */
		generalLookupTextArea = new JTextArea();
		generalLookupTextArea.setFont(f2);
		generalLookupTextArea.setEditable(false);
		generalLookupTextArea.setText("First Name\t\tLastName\t\tMembership Type\t\tE-Mail\t\t\t\n");
		generalLookupScrollPane = new JScrollPane(generalLookupTextArea);
		generalLookupScrollPane.setBounds(15, 0, 410, 125);
		middleWestPanel.add(generalLookupScrollPane);
		
//==============================================================
		/**
		 * Creates the bottom panel of buttons
		 * the bottom most panel on westPanel
		 * 
		 * 
		 */
		viewMemberButton = new JButton("View Member");
		viewMemberButton.setBounds(15, 30, 130, 20);
		viewMemberButton.setFont(buttonFont);
		
		updateMemberButton = new JButton("Update Member");
		updateMemberButton.setBounds(155, 30, 130, 20);
		updateMemberButton.setFont(buttonFont);
		
		addMemberButton = new JButton("Add Member");
		addMemberButton.setBounds(295, 30, 130, 20);
		addMemberButton.setFont(buttonFont);
		
		signIntoStoreButton = new JButton("Sign Into Store");
		signIntoStoreButton.setBounds(15, 60, 130, 20);
		signIntoStoreButton.setFont(buttonFont);
		
		signIntoKitchenButton = new JButton("Sign Into Kitchen");
		signIntoKitchenButton.setBounds(155, 60, 130, 20);
		signIntoKitchenButton.setFont(buttonFont);
		
		viewScheduleButton = new JButton("View Schedule");
		viewScheduleButton.setBounds(295, 60, 130, 20);
		viewScheduleButton.setFont(buttonFont);
		
		bottomWestPanel.add(viewMemberButton);
		bottomWestPanel.add(updateMemberButton);
		bottomWestPanel.add(addMemberButton);
		bottomWestPanel.add(signIntoStoreButton);
		bottomWestPanel.add(signIntoKitchenButton);
		bottomWestPanel.add(viewScheduleButton);
		
//==============================================================
		/**
		 * Creates the view on the east panel
		 * where the user can see who is logged
		 * into the store and kitchen, and can also
		 * log them out
		 * 
		 * 
		 */
		//Un-comment these 2 lines to add text to JTextAreas for testing
		storeLabel = new JLabel("Store:");
		storeLabel.setBounds(10, 15, 40, 10);
		storeLabel.setFont(f2);
		
		kitchenLabel = new JLabel("Kitchen:");
		kitchenLabel.setBounds(10, 200, 80, 10);
		kitchenLabel.setFont(f2);
		
		signOutOfStoreButton = new JButton("Sign Out");
		signOutOfStoreButton.setFont(buttonFont);
		signOutOfStoreButton.setBounds(60, 155, 80, 25);
		
		signOutOfKitchenButton = new JButton("Sign Out");
		signOutOfKitchenButton.setFont(buttonFont);
		signOutOfKitchenButton.setBounds(60, 340, 80, 25);
		
		storeTextArea = new JTextArea();
		storeTextArea.setFont(f2);
		storeTextArea.setEditable(false);
		//storeTextArea.setText("Name One\nName Two\nReallyReallyReallyLongLong AsianNameInStore\n1\n2\n3\n4\n5\n6\n7\n8\n9\n");
		
		storeScrollPane = new JScrollPane(storeTextArea);
		storeScrollPane.setBounds(10, 30, 130, 120);
		
		kitchenTextArea = new JTextArea();
		kitchenTextArea.setFont(f2);
		kitchenTextArea.setEditable(false);
		//storeTextArea.setText("Name One\nName Two\nReallyReallyReallyLongLong AsianNameInKitchen\n1\n2\n3\n4\n5\n6\n7\n8\n9\n");
		
		kitchenScrollPane = new JScrollPane(kitchenTextArea);
		kitchenScrollPane.setBounds(10, 215, 130, 120);
		
		
		eastPanel.add(storeLabel);
		eastPanel.add(kitchenLabel);
		eastPanel.add(storeScrollPane);
		eastPanel.add(kitchenScrollPane);
		eastPanel.add(signOutOfStoreButton);
		eastPanel.add(signOutOfKitchenButton);
		
//==============================================================
		//Sets the panels visible and adds them to the frame
		topWestPanel.setVisible(true);
		middleWestPanel.setVisible(true);
		bottomWestPanel.setVisible(true);
		westPanel.setVisible(true);
		eastPanel.setVisible(true);
		westPanel.add(topWestPanel);
		westPanel.add(middleWestPanel);
		westPanel.add(bottomWestPanel);
		
		add(mainPanel);
		mainPanel.add(westPanel);
		mainPanel.add(eastPanel);
		addListeners();
		validate();
		
		
	}
	
	/**
	 * Adds the listeners to the buttons
	 * 
	 * 
	 */
	private void addListeners(){
		ActionListener buttonListener = new ButtonListener();
		searchButton.addActionListener(buttonListener);
		viewMemberButton.addActionListener(buttonListener);
		updateMemberButton.addActionListener(buttonListener);
		addMemberButton.addActionListener(buttonListener);
		signIntoStoreButton.addActionListener(buttonListener);
		signIntoKitchenButton.addActionListener(buttonListener);
		viewScheduleButton.addActionListener(buttonListener);
		signOutOfStoreButton.addActionListener(buttonListener);
		signOutOfKitchenButton.addActionListener(buttonListener);
	}
	
	/**
	 * @param: an array list of strings
	 * @return: none
	 * 
	 * Takes the result arraylist and formats it to be displayed in the generalLookupTextArea
	 */
	/*public void printSearchResult(ArrayList<String> searchResult)
	{
		for(int j = 0; j < searchResult.size(); j++){
			for(int i = 0; i < 3; i++)
			{
				if(i < 2){
					searchResult.set(j,searchResult.get(j).replaceFirst(" ","\t\t"));
				}
				else{
					searchResult.set(j,searchResult.get(j).replaceFirst(" ","\t\t\t"));
				}
				
			}
			generalLookupTextArea.append(searchResult.get(j)+ "\t\t\t\n");
		}
		
		
		//generalLookupTextArea.append("Michael\t\tWang\t\tCoordinator\t\t\tmwang10@binghamton.edu\t\t\t\n");
		//generalLookupTextArea.append("Jeremy\t\tSimpson\t\tCore\t\t\tjsimpso1@binghamton.edu\t\t\t\n");
		//generalLookupTextArea.append("Jeremy\t\tSmith\t\tVolunteer\t\t\tjsmith1@binghamton.edu\t\t\t\n");
		//"First Name\t\tLastName\t\tMembership Type\t\t\tE-Mail\t\t\t\n"
	}
	
	*/
	public void printSearchResult(ArrayList<Member> searchResult)
	{
		for(int j = 0; j < searchResult.size(); j++){
			generalLookupTextArea.append(searchResult.get(j).getFirstName()+ "\t\t"+ searchResult.get(j).getLastName()+ "\t\t"
											+ searchResult.get(j).getMembershipType() + "\t\t\t"
											+ searchResult.get(j).getEmailAddress()+ "\t\t\n");
		}
		
		
		//generalLookupTextArea.append("Michael\t\tWang\t\tCoordinator\t\t\tmwang10@binghamton.edu\t\t\t\n");
		//generalLookupTextArea.append("Jeremy\t\tSimpson\t\tCore\t\t\tjsimpso1@binghamton.edu\t\t\t\n");
		//generalLookupTextArea.append("Jeremy\t\tSmith\t\tVolunteer\t\t\tjsmith1@binghamton.edu\t\t\t\n");
		//"First Name\t\tLastName\t\tMembership Type\t\t\tE-Mail\t\t\t\n"
	}
	/**
	 * 
	 * @param errorMessage a string to be displayed in the error message popup
	 * 
	 * displays a given string as an error message
	 */
	
	
	public void displayException(String errorMessage)
	{
		JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
	}
	/**
	 * 
	 * @author Dave Wroblewski
	 * @version 4/4/11
	 * 
	 * This is the inner ActionListener class
	 * 
	 * 
	 * 
	 */
	class ButtonListener implements ActionListener{

		String str;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(searchButton)){
				str = "You must enter a first and a last name!";
				if(firstNameTextField.getText().equals("") || lastNameTextField.getText().equals("")){
					JOptionPane.showMessageDialog(null, str, "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					printSearchResult(controller.lookUpMember(firstNameTextField.getText(), lastNameTextField.getText()));
				}
			
			}else if(e.getSource().equals(viewMemberButton)){
				str = "View member method to go here.";
				JOptionPane.showMessageDialog(null, str, "Error", JOptionPane.INFORMATION_MESSAGE);
			
			}else if(e.getSource().equals(updateMemberButton)){
				str = "Update member method to go here.";
				JOptionPane.showMessageDialog(null, str, "Error", JOptionPane.INFORMATION_MESSAGE);
			
			}else if(e.getSource().equals(addMemberButton)){
				str = "Add member method to go here.";
				JOptionPane.showMessageDialog(null, str, "Error", JOptionPane.INFORMATION_MESSAGE);
			
			}else if(e.getSource().equals(signIntoStoreButton)){
				str = "Sign into store method to go here.";
				JOptionPane.showMessageDialog(null, str, "Error", JOptionPane.INFORMATION_MESSAGE);
			
			}else if(e.getSource().equals(signIntoKitchenButton)){
				str = "Sign into kitchen method to go here.";
				JOptionPane.showMessageDialog(null, str, "Error", JOptionPane.INFORMATION_MESSAGE);
			
			}else if(e.getSource().equals(viewScheduleButton)){
				str = "View schedule method to go here.";
				JOptionPane.showMessageDialog(null, str, "Error", JOptionPane.INFORMATION_MESSAGE);
			
			}else if(e.getSource().equals(signOutOfStoreButton)){
				str = "Sign out of store method to go here.";
				JOptionPane.showMessageDialog(null, str, "Error", JOptionPane.INFORMATION_MESSAGE);
			
			}else if(e.getSource().equals(signOutOfKitchenButton)){
				str = "Sign out of kitchen method to go here.";
				JOptionPane.showMessageDialog(null, str, "Error", JOptionPane.INFORMATION_MESSAGE);
			
			}else{
				System.exit(0);
			}	
		}		
	}
}
