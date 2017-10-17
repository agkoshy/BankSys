package Bank;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
/**
 * CreditAccount class
 *
 * This class incorporates the credit account with all its manipulations. It sets a limit and invokes a penalty depending
 * on which rule the user had chosen.
 *
 * @author Alvis Koshy, Zhu Su
 * @version 1.0
 * @since 2017-10-17
 */
public class CreditAccount {
	
	//Initialized Fields
	private double balance;
	private int SIN;
	private Instant timestamp;
	private final String TYPE = "Credit/";
	DemandAccount demand;
	CheckingAccount acc;
	ArrayList<AccountActivity> record = new ArrayList<AccountActivity>();
	
	//JRadioButtons that only allow the User to choose one option
	JRadioButton radioButton1;
	JRadioButton radioButton2;
	
	public CreditAccount(){
		
	}
	
	public CreditAccount(String user, int SIN)
	{
		this.SIN = SIN;
		this.balance = 0;
	}
	
	public int getSIN() {
		return SIN;
	}
	
	public void withdrawAmount(double amount) {
		this.balance = this.balance - amount;
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
	
	//sets the limit of the account
	public void setLimit() {
		JPanel limit = new JPanel();
		limit.add(radioButton1 = new JRadioButton("High Credit Limit with Exceed Penalty"));
		radioButton1.setActionCommand("High Credit Limit with Exceed Penalty");
		limit.add(radioButton2 = new JRadioButton("Low Credit Limit with no Exceed Penalty"));
		radioButton2.setActionCommand("Low Credit Limit with no Exceed Penalty");
		
		int result = JOptionPane.showConfirmDialog(null, limit, "Credit Limit options", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			if (radioButton1.isSelected()) {
				record.add(new AccountActivity(this.getSIN(), timestamp, TYPE + "High Credit Limit with Exceed Penalty" , 0));
			} else if (radioButton2.isSelected()) {
				record.add(new AccountActivity(this.getSIN(), timestamp, TYPE + "Low Credit Limit with no Exceed Penalty" , 0));
			}
			this.stateOfLimit();
		}
	}
	
	//This method checks the state of balance, whether its sum of the checking account and the limit of credit account is => 0
	public void stateOfLimit() {
		double d = acc.getBalance()-this.getBalance();
		if(radioButton1.isSelected()) {
			if(d < 0) {
				acc.depositAmount(d);
				demand.depositAmount(SIN, 29.00);
			}
		} else if(radioButton2.isSelected()) {
			if(d < 0) {
				acc.depositAmount(d);
			}
		}
	}
	
	public void transferAmount(int amount, CreditAccount acc) {
		this.withdrawAmount(amount);
		acc.depositAmount(amount);
	}
}
