package Bank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

public class AccountActivity {
	
	private static final String FILENAME = "accountLog.txt";
	private int SIN;
	private long time;
	private String action;
	private double amount;

	public AccountActivity(int SIN, long time, String action, double amount) {
		this.SIN = SIN;
		this.time = time;
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
					if(recordSet.get(j).getDate() < recordSet.get(j-1).getDate())
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

	private long getDate() {
		return this.time;
	}

	private int getSIN() {
		return this.SIN;
	}

	/*
	 * process records in the accountLog at the end of each business day
	 * according to the rules in the document
	 * /cs/course/2011E/CIBC_Overdraft_Protection_Service_Addendum.pdf and Rule
	 * 1 and Rule 2 for credit accounts above.
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

	// save the accountLog to a file.
	public static void saveAccountLog(String[] content, Path file) {
		
	}

	// retrieve the previously saved accountLog from a file.
	public static Path retrieveAccountLog() {
		Path file = Paths.get("accountLog.txt");
		return file;
	}

}
