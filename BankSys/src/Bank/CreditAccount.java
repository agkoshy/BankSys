package Bank;

public class CreditAccount extends CheckingAccount {
	
	private CheckingAccount check = new CheckingAccount();
	private double balance;
	public CreditAccount(){
		super();
		this.balance = check.getBalance(balance);
	}
	public double withdrawAmount() {
		
		return this.balance;
	}
	
	public void depositAmount(double balance) {
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
	
	public void getBalance() {
		
	}
	
	public void terminateAccount() {
		
	}
	
	public void setOverdraftOption() {
		
	}
	public void setLimit() {
		
	}
	
	public void transferAmount() {
		
	}
}
