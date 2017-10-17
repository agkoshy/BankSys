package Bank;

import java.time.Instant;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * CheckingAccount class
 *
 * This class creates a checking account and manages all things related to it. Such as the manipulation 
 * of the balance of the account. It also has methods that are invoked by the bank and that can suspend
 * and terminate the account.
 *
 * @author Alvis Koshy, Zhu Su
 * @version 1.0
 * @since 2017-10-17
 */
public class CheckingAccount
{
	//Fields
	private double balance;
	private int SIN;
	private Instant timestamp;
	private final String TYPE = "Chequeing;";
	
	DemandAccount demand;
	ArrayList<AccountActivity> record = new ArrayList<AccountActivity>();
	
	JRadioButton radioButton1;
	JRadioButton radioButton2;
	JRadioButton radioButton3;
	
	public CheckingAccount()
	{
		
	}
	
	public CheckingAccount(String user, int SIN)
	{
		this.SIN = SIN;
		this.balance = 0;
	}


	public int getSIN() {
		return SIN;
	}

	//Method that withdraws amount from an account
	public void withdrawAmount(double amount) {
		this.stateOfBalance();
		this.balance = this.balance - amount;
		//records in accountLog, repeated throughout all methods that change the state of the account
		record.add(new AccountActivity(this.getSIN(), timestamp, TYPE + "Withdraw" , amount));
	}
	
	public void depositAmount(double amount) {
		this.balance = this.balance + amount;
		record.add(new AccountActivity(this.getSIN(), timestamp, TYPE + "Deposit" , amount));
	}
	
	public void createAccount(String user, int SIN) {
		new CheckingAccount(user, SIN);
		record.add(new AccountActivity(this.getSIN(), timestamp, TYPE + "Creation" , 0));
	}
	
	//user initiated
	public void cancelAccount() {
		
		record.add(new AccountActivity(this.getSIN(), timestamp, TYPE + "Cancellation" , 0));
	}
	
	//bank initiated
	public void suspendAccount() {
		
		record.add(new AccountActivity(this.getSIN(), timestamp, TYPE + "Suspension" , 0));
	}
	
	//user initiated
	public void reactivateAccount() {
		
		record.add(new AccountActivity(this.getSIN(), timestamp, TYPE + "Reactivation" , 0));
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	//bank initiated
	public void terminateAccount() {
		
		record.add(new AccountActivity(this.getSIN(), timestamp, TYPE + "Termination" , 0));
	}
	
	public void setOverdraftOption() {
		//Creates a panel to pop up 
		JPanel overdraft = new JPanel();
		
		//adds the buttons into the panel
		overdraft.add(radioButton1 = new JRadioButton("No Overdraft Protection"));
		radioButton1.setActionCommand("No Overdraft Protection");
		overdraft.add(radioButton2 = new JRadioButton("Pay Per Use Overdraft Protection"));
		radioButton2.setActionCommand("Pay Per Use Overdraft Protection");
		overdraft.add(radioButton3 = new JRadioButton("Montly Fixed Fee Overdraft Protection"));
		radioButton3.setActionCommand("Montly Fixed Fee Overdraft Protection");
		
		//Adds the lightweight panel into an optionPane
		int result = JOptionPane.showConfirmDialog(null, overdraft, "Overdraft options", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			this.stateOfBalance();
		}
	}
		
	//A method that checks the state of the balance and if it goes below 0. If so then it returns false
	public boolean stateOfBalance() {
		//Returns true if the balance is <0 and false otherwise
		if (radioButton1.isSelected()) {
			// Checks to see if the balance
			if (this.getBalance() < 0) {
				demand.depositAmount(SIN, 45.00);
				accountInvariant();
				return true;
			}
		} else if (radioButton2.isSelected()) {
			if (this.getBalance() < 0) {
				demand.depositAmount(SIN, 5.00);
				return true;
			}
		} else if (radioButton3.isSelected()) {
			demand.depositAmount(SIN, 4.00);
				return true;
		}
		return false;
		
	}
	

	
	public void transferAmount(int amount, CreditAccount acc) {
		this.withdrawAmount(amount);
		acc.depositAmount(amount);
	}
	
	private void accountInvariant(){
		assert(balance >= 0) : "Balance must be greater than or equal Zero";
	}
}
