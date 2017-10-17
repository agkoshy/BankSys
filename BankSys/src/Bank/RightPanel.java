package Bank;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.Random;

import javax.swing.*;
public class RightPanel extends JPanel implements ActionListener{
	/**
	 * RightPanel class
	 *
	 * This class creates all the buttons, as well as what their states are and how they are manipulated by each other.
	 * 
	 *
	 * @author Alvis Koshy, Zhu Su
	 * @version 1.0
	 * @since 2017-10-17
	 */
	//Randomly generated serial
	private static final long serialVersionUID = 6783424917586519882L;
	
	//Buttons initialized
	private JButton btnUser = new JButton("New User");
	private JButton btnDay = new JButton("Next Day");
	private JButton btnAccNew = new JButton("New Account");
	private JButton btnDeposit = new JButton("Deposit");
	private JButton btnWithdraw = new JButton("Withdraw");
	private JButton btnReactivate = new JButton("Reactivate Account");
	private JButton btnMonth = new JButton("Next Month");
	
	//Other fields initialized
	private GUI gui;
	private CheckingAccount check = new CheckingAccount();
	private CreditAccount credit;
	private DemandAccount demand;
	User user;
	
	//Fields for the SIN
	Random ran = new Random();
	int SIN = 100000 + ran.nextInt(900000);
	
	//Fields for the size and font of the button	
	private static final String FONT_FACE = "Arial";
	private static final int FONT_SIZE = 12;

	public RightPanel(GUI gui) {
		super(new GridLayout(15,1));
		
		//Sets the fonts
		btnUser.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnDay.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnAccNew.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnDeposit.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnWithdraw.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnReactivate.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnMonth.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		
		//Adds the buttons to the panel
		add(btnUser);
		add(btnAccNew);
		add(btnDeposit);
		add(btnWithdraw);
		add(btnReactivate);
		add(btnDay);
		add(btnMonth);
		
		//Gives the buttons actionListeneres. btnUser is referred in the User class.
		btnUser.addActionListener(new User(gui));
		btnDay.addActionListener(this);
		btnAccNew.addActionListener(this);
		btnDeposit.addActionListener(this);
		btnWithdraw.addActionListener(this);
		btnReactivate.addActionListener(this);
		btnMonth.addActionListener(this);
		
		//No clipping with the frame
		this.setMaximumSize(this.getPreferredSize());
		
		//Sets the initial states of the other buttons
		this.setAccNew(false);
		this.setDeposit(false);
		this.setWithdraw(false);
		this.setReactivate(false);
		this.setDay(false);
		this.setMonth(false);
		
		this.gui = gui;		
		
		//Checks to see which account has been chosen, creates an instance of chosen account
		if(User.checkOne.getState()) {
			check = new CheckingAccount();
			check.createAccount(User.txtUser.getText(), SIN);
			check.setOverdraftOption();
		} else if(User.checkTwo.getState()) {
			credit = new CreditAccount();
			credit.createAccount(User.txtUser.getText(), SIN);

			credit.setLimit();
		}
		
		demand = new DemandAccount();
		
	}
	
	//Setters for enabling/disabling the buttons
	public void setAccNew(boolean status) {
		btnAccNew.setEnabled(status);
	}
	
	public void setDeposit(boolean status) {
		btnDeposit.setEnabled(status);
	}
	public void setWithdraw(boolean status) {
		btnWithdraw.setEnabled(status);
	}
	public void setReactivate(boolean status) {
		btnReactivate.setEnabled(status);
	}
	public void setDay(boolean status) {
		btnDay.setEnabled(status);
	}

	public void setMonth(boolean status) {
		btnMonth.setEnabled(status);
	}
	
	//Method that is invoked when btnDeposit is called
	public void depositBtn() {
		//Creates a new panel
		JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5)); 
		//Creates new labels
		JLabel lblAccounts = new JLabel("Accounts: ");
		JLabel lblBalance = new JLabel("Amount: ");
		//Creates a textfield
		JTextField txtBalance = new JTextField(5);
		
		//A two string array to put into the drop down menu JComboBox
		String[] accounts = new String[] {"Checking Account", "Credit Account", "Demand Account"};
		JComboBox<String> accList = new JComboBox<>(accounts);
		
		//Adds all the objects into the panel
		panel.add(lblAccounts);
		panel.add(accList);
		panel.add(lblBalance);
		panel.add(txtBalance);
		
		//Puts the lightweight panel into a JOptionPane
		int result = JOptionPane.showConfirmDialog(null, panel, "Deposit Account",
				JOptionPane.OK_CANCEL_OPTION);
		//Only invoked when OK is hit
		if(result == JOptionPane.OK_OPTION) {

			//Amount is deposited to its corresponding accounts.
			if(accList.getSelectedIndex() == 0) {
				check.depositAmount(Double.valueOf(txtBalance.getText()));
			} else if(accList.getSelectedIndex() == 1) {
				credit.depositAmount(Double.valueOf(txtBalance.getText()));
			} else if(accList.getSelectedIndex() == 2) {
				demand.depositAmount(user.SIN, Double.valueOf(txtBalance.getText()));
			}
		}
		

	}
	
	//Method that is invoked when btnWithdraw is called
	public void withdrawBtn() {
		
		//Creates a new panel
		JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
		
		//Creates new labels
		JLabel lblAccounts = new JLabel("Accounts: ");
		JLabel lblBalance = new JLabel("Amount: ");
		
		//Creates a textfield
		JTextField txtBalance = new JTextField(5);
		int amount = 0;
		
		//A two string array to put into the drop down menu JComboBox
		String[] accounts = new String[] {"Checking Account", "Credit Account"};		
		JComboBox<String> accList = new JComboBox<>(accounts);
		
		//Takes the text and formats it into a number
		JFormattedTextField num = new JFormattedTextField();
		num.setValue(new Integer(amount));
		num.setColumns(10);
		
		//Adds the objects into the panel
		panel.add(lblAccounts);
		panel.add(accList);
		panel.add(lblBalance);
		panel.add(num);
		
		//Adds lightweight panel into JOptionPane
		int result = JOptionPane.showConfirmDialog(null, panel, "Withdraw Amount",
				JOptionPane.OK_CANCEL_OPTION);
		{	
			//Withdraws an amount depending on the corresponding account
			if(result == JOptionPane.OK_OPTION) {
				if(accList.getSelectedIndex() == 0) {
					check.withdrawAmount(Double.valueOf(txtBalance.getText()));
				} else if(accList.getSelectedIndex() == 1) {
					credit.withdrawAmount(Double.valueOf(txtBalance.getText()));
				}
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//getSource() is called when a button is clicked, and then we invoke an action.
		if(e.getSource().equals(btnDeposit)) {
			depositBtn();
		} else if(e.getSource().equals(btnWithdraw)) {
			withdrawBtn();
		} else if(e.getSource().equals(btnReactivate)) {
			
		} else if(e.getSource().equals(btnDay)) {
			
		} else if(e.getSource().equals(btnMonth)) {
			
		}
	}

	
}
