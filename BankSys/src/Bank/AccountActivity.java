package Bank;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountActivity {
	
	private static final String FILENAME = "accountLog.txt";
	private int SIN;
	private Date date;
	private String action;
	private double amount;
	
	/*
	 * Constructor
	 */

	public AccountActivity(int SIN, Date date, String action, double amount) {
		this.SIN = SIN;
		this.date = date;
		this.action = action;
		this.amount = amount;
	}

	public static void accountLog() {

	}
	
	AccountActivity[] event = new AccountActivity[3];

	/*
	 * use the Insertion Sort algorithm to sort all the records in the
	 * accountLog by Social Insurance Number (SIN), such that any record with a
	 * smaller SIN will be ordered before any record with a larger SIN, and for
	 * records with the same SIN any record with an earlier Date and Time will
	 * be ordered before any record with a later Date and Time.
	 * 
	 * Utilizes ArrayList and Collections package
	 */
	public static ArrayList<AccountActivity> sortAccountLog(ArrayList<AccountActivity> recordSet) {
		AccountActivity temp;
		for (int i = 1; i < recordSet.size(); i++)
		{
			for (int j = i; j > 0; j--)
			{
				if (recordSet.get(j).getSIN() < recordSet.get(j-1).getSIN())
				{
					temp = recordSet.get(j);
					recordSet.set(j, recordSet.get(j-1));
					recordSet.set(j-1, temp);
				}
				else if(recordSet.get(j).getSIN() == recordSet.get(j-1).getSIN())
				{
					if(recordSet.get(j).getLongDate() < recordSet.get(j-1).getLongDate())
					{
						temp = recordSet.get(j);
						recordSet.set(j, recordSet.get(j-1));
						recordSet.set(j-1, temp);
					}
				}
			}
		}
		return recordSet;
	}
	
	/*
	 * Returns time
	 */
	
	private long getLongDate()
	{
		return this.date.getTime();
	}
	
	/*
	 * Returns SIN
	 */

	private int getSIN() {
		return this.SIN;
	}

	/*
	 * process records in the accountLog at the end of each business day
	 * according to the rules in the document
	 * /cs/course/2011E/CIBC_Overdraft_Protection_Service_Addendum.pdf and Rule
	 * 1 and Rule 2 for credit accounts above.
	 * 
	 * When invoked, searches through accountLog for End of Day processes and act
	 */
	public static void processAccountLogEndOfDay(ArrayList<AccountActivity> accountLog)
	{
		for(AccountActivity e: accountLog)
		{
			if (e.action == "")
			{
				
			}
			if (e.action == "etc")
			{
				
			}
		}
	}

	/*
	 * process records in the accountLog at the end of each calendar month
	 * according to the rules in the document
	 * /cs/course/2011E/CIBC_Overdraft_Protection_Service_Addendum.pdf and Rule
	 * 1 and Rule 2 for credit accounts above.
	 * 
	 * When invoked, searches through accountLog for End of Month processes and act
	 */
	public static void processAccountLogEndOfMonth(ArrayList<AccountActivity> accountLog)
	{
		for(AccountActivity e: accountLog)
		{
			if (e.action == "")
			{
				
			}
			if (e.action == "etc")
			{
				
			}
		}
	}

	/*
	 * Save accountLog to file
	 */
	
	public static void saveAccountLog(ArrayList<AccountActivity> accountLog) throws IOException {
		FileWriter writer = new FileWriter(FILENAME);
		PrintWriter pwriter = new PrintWriter(writer);
		for (AccountActivity e: accountLog)
		{
			pwriter.printf("%-15s%-30s%-15s%-15d", e.SIN, e.date, e.action, e.amount);
		}
		pwriter.close();
	}

	/* 
	 * retrieve the previously saved accountLog from a file.
	 */
	
	public static List<String> retrieveAccountLog() throws IOException
	{
		List<String> log = Files.readAllLines(Paths.get(FILENAME));
		return log;
	}

}
