package Bank;

public class CheckingAccount {

	private double balance;
	private double account;
	
	public CheckingAccount() {
		this.balance = 0.0;
		this.account = 0;
		
		
		accountInvariant();
	}
	
	
	public CheckingAccount(double balance) {
		
		this.balance = balance;
		
	}


	public double withdrawAmount() {
		this.balance = this.balance - this.account;
		return this.balance;
	}
	
	public void depositAmount(double balance) {
		this.balance += this.account;
		this.balance = balance;
	}
	
	public void createAccount() {
		
	}
	
	public void cancelAccount() {
		
	}
	
	public void suspendAccount() {
		
	}
	
	public void reactivateAccount() {
		
	}
	
	public double getBalance(double balance) {
		return this.balance = balance;
	}
	
	public void terminateAccount() {
		
	}
	
	public void setOverdraftOption() {
		
	}
	public void setLimit() {
		
	}
	
	public void transferAmount() {
		
	}
	
	private void accountInvariant(){
		assert(balance >= 0) : "Balance must be greater than Zero";
	}
}
