package Bank;

import java.util.*;

public class CheckingAccount
{

	private double balance;
	private String user;
	private int SIN;
	
	public CheckingAccount()
	{
		
	}
	
	public CheckingAccount(String user, int SIN)
	{
		this.user = user;
		this.SIN = SIN;
		this.balance = 0;
	}


	public int getSIN() {
		return SIN;
	}

	public void withdrawAmount(double amount) {
		this.balance = this.balance - amount;
	}
	
	public void depositAmount(double amount) {
		this.balance = this.balance + amount;
	}
	
	public void createAccount(String user, int SIN) {
		CheckingAccount acc = new CheckingAccount(user, SIN);
	}
	
	//user initiated
	public void cancelAccount() {
		
	}
	
	//bank initiated
	public void suspendAccount() {
		
	}
	
	//user initiated
	public void reactivateAccount() {
		
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	//bank initiated
	public void terminateAccount() {
		
	}
	
	public int setOverdraftOption() {
		
		System.out.println("Choose between No Overdraft Protection(1), Pay Per Use Overdraft Protection(2)"
				+ "or Monthly Fixed Fee Overdraft Protection(3).");
		int n = read.nextInt();
		String y = read.nextLine();
		System.out.println("Enter an option: " + n);
		if(n == 1)
		{
			//Option 1: No Overdraft Protection
			System.out.println("Choosing the No Overdraft Protection will mean that you will not be able to"
					+ "withdraw an amount that will cause the balance in your account to go below 0. In addition,"
					+ "any such action will result in a fee of $45.00"
					+ " being charged to your account. Are you sure you would like this option?");
			System.out.println("Enter an option(Y/N): " + y);
			do {
				if (y == "Y") {

				} else if (y == "N") {
					setOverdraftOption();
				}
			} while(y != "Y" || y != "N");
		}
		else if(n == 2)
		{
			//Option 2: Pay Per Use Overdraft Protection
			System.out.println("Choosing the Pay Per Use Overdraft Protection will mean that you will be charged"
					+ "a $5.00 fee every time in which an overdraft is created or increased. There is no charge"
					+ "unless you use this service. Are you sure you would like this option?");
			System.out.println("Enter an option(Y/N): " + y);
			do {
				if (y == "Y") {

				} else if (y == "N") {
					setOverdraftOption();
				}
			} while(y != "Y" || y != "N");
			
		}
		else if(n == 3)
		{
			//Option 3: Monthly Fixed Fee Overdraft Protection
			System.out.println("Choosing the Monthly Fixed Fee Overdraft Protection will mean that you will be charged"
					+ "$4.00 every month, regardless of the utilization of the overdraft."
					+ " Are you sure you would like this option?");
			System.out.println("Enter an option(Y/N): " + y);
			do {
				if (y == "Y") {

				} else if (y == "N") {
					setOverdraftOption();
				}
			} while(y != "Y" || y != "N");
		}
		return n;
		
	}
	public void setLimit() {
		
	}
	
	public void transferAmount(int amount, CreditAccount acc) {
		this.withdrawAmount(amount);
		acc.depositAmount(amount);
	}
	
	private void accountInvariant(){
		assert(balance >= 0) : "Balance must be greater than Zero";
	}
}
