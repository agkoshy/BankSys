package Bank;

import java.time.Instant;
import java.util.ArrayList;
/**
 * DemandAccount class
 *
 * This class is a demand account class and checks all the fees that the user has ended up getting. This information is then
 * given to the bank on whether the account needs to be suspended or terminated.
 *
 * @author Alvis Koshy, Zhu Su
 * @version 1.0
 * @since 2017-10-17
 */
public class DemandAccount {
	
	//Primary fields
	CheckingAccount cheq;
	CreditAccount cred;
	double balance;
	private Instant timestamp;
	private final String TYPE = "Demand/";
	ArrayList<AccountActivity> record = new ArrayList<AccountActivity>();
	
	
	public DemandAccount() {
		this.balance = 0;
		
		accountInvariant();
	}
	
	//Getter for the balance in Demand Account
	public double getBalance() {
		return this.balance;
	}
	
	//Method that allows the user to make payments
	public void depositAmount(int SIN, double amount) {
		this.balance = this.balance + amount;
		record.add(new AccountActivity(SIN, timestamp, TYPE + "Deposit" , amount));
	}
	

	private void accountInvariant(){
		assert(this.balance >= 0) : "Balance must be greater than or equal Zero";
	}
}
