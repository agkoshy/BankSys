package Bank;

import java.util.ArrayList;
import java.util.Date;

public class DemandAccount {
	double balance;
	private Date date;
	private final String TYPE = "Demand/";
	
	public DemandAccount() {
		this.balance = 0;
	}
	
	ArrayList<AccountActivity> record = new ArrayList<AccountActivity>();
	
	public double getBalance() {
		return this.balance;
	}

	public void depositAmount(double amount) {
		this.balance = this.balance + amount;
		record.add(new AccountActivity(0, date.getTime(), TYPE + "Deposit" , amount));
	}
}
