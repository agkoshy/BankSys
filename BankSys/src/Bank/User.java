package Bank;
import java.util.*;


public class User {
	CheckingAccount check;
	CreditAccount credit;
	private double balance;
	private int sin;
	Scanner read  = new Scanner(System.in);
	
	public User() {
		
	}
	
	public User(int sin, double balance)
	{
		this.balance = balance;
		this.sin = sin;
		
	}
	public void create() {
		System.out.println("Do you want to create a Checking Account or a Credit Account?");
		int n = read.nextInt();
		System.out.println("Enter which account you want (1 for Checking or 2 for Credit): " + n);
		
		if(n == 1)
		{
			check.createAccount();
		}
	}
	
	
}
