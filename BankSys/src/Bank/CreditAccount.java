package Bank;

public class CreditAccount {
	
	private double balance;
	private String user;
	private int SIN;
	
	public CreditAccount(){
		
	}
	
	public CreditAccount(String user, int SIN)
	{
		this.user = user;
		this.SIN = SIN;
		this.balance = 0;
	}
	
	public void withdrawAmount(double amount) {
		this.balance = this.balance - amount;
	}
	
	public void depositAmount(double amount) {
		this.balance = this.balance + amount;
	}
	
	public void createAccount(String user, int SIN) {
		CreditAccount acc =  new CreditAccount(user, SIN);
	}
	
	public void cancelAccount() {
		
	}
	
	public void suspendAccount() {
		
	}
	
	public void reactivateAccount() {
		
	}
	
	public void getBalance() {
		
	}
	
	public void terminateAccount() {
		
	}
	
	public void setOverdraftOption() {
		
	}
	public void setLimit() {
		
	}
	
	public void transferAmount(int amount, CheckingAccount acc) {
		this.withdrawAmount(amount);
		acc.depositAmount(amount);
	}
}
