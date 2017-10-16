package Bank;

import java.time.Instant;
import java.util.ArrayList;

public class DemandAccount {
	CheckingAccount cheq;
	CreditAccount cred;
	double balance;
	private Instant timestamp;
	private final String TYPE = "Demand/";
	
	public DemandAccount() {
		this.balance = 0;
	}
	
	ArrayList<AccountActivity> record = new ArrayList<AccountActivity>();
	
	public double getBalance() {
		return this.balance;
	}

	public void depositAmount(int SIN, double amount) {
		this.balance = this.balance + amount;
		record.add(new AccountActivity(SIN, timestamp, TYPE + "Deposit" , amount));
	}
}
