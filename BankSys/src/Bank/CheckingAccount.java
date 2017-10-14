package Bank;

import java.util.*;

public class CheckingAccount {

	private double balance;
	private double account;
	CheckingAccount acc;
	Scanner read = new Scanner(System.in);
	
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
		acc = new CheckingAccount();
	}
	
	public void cancelAccount() {
		
	}
	
	public void suspendAccount() {
		
	}
	
	public void reactivateAccount() {
		
	}
	
	public double getBalance() {
		return this.balance;
	}
	
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
	
	public void transferAmount() {
		
	}
	
	private void accountInvariant(){
		assert(balance >= 0) : "Balance must be greater than Zero";
	}
}
