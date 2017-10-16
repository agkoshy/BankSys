package Bank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class AccountActivity {
	
	private static final String FILENAME = "accountLog.txt";

	public static void accountLog() {

	}

	/*
	 * use the Insertion Sort algorithm to sort all the records in the
	 * accountLog by Social Insurance Number (SIN), such that any record with a
	 * smaller SIN will be ordered before any record with a larger SIN, and for
	 * records with the same SIN any record with an earlier Date and Time will
	 * be ordered before any record with a later Date and Time.
	 */
	public static User[] sortAccountLog(User[] recordSet) {
		User temp;
		for (int i = 1; i < recordSet.length; i++)
		{
			for (int j = i; j > 0; j--)
			{
				if (recordSet[j].getSIN() < recordSet[j-1].getSIN())
				{
					temp = recordSet[j];
					recordSet[j] = recordSet [j-1];
					recordSet[j-1] = temp;
				}
				else if(recordSet[j].getSIN() == recordSet[j-1].getSIN())
				{
					if(recordSet[j].getDate() < recordSet[j-1].getDate())
					{
						temp = recordSet[j];
						recordSet[j] = recordSet[j-1];
						recordSet[j-1] = temp;
					}
				}
			}
		}
		return recordSet;
	}

	/*
	 * process records in the accountLog at the end of each business day
	 * according to the rules in the document
	 * /cs/course/2011E/CIBC_Overdraft_Protection_Service_Addendum.pdf and Rule
	 * 1 and Rule 2 for credit accounts above.
	 */
	public static void processAccountLogEndOfDay(User[][] accountLog)
	{
		String x;
		
		// process withdraws, deposits, user cancellation, reactivation
		
		for(int i = 0; i < accountLog.length; i++)
		{
			
		}
	}

	/*
	 * process records in the accountLog at the end of each calendar month
	 * according to the rules in the document
	 * /cs/course/2011E/CIBC_Overdraft_Protection_Service_Addendum.pdf and Rule
	 * 1 and Rule 2 for credit accounts above.
	 */
	public static void processAccountLogEndOfMonth() throws IOException {
		
		// process suspension, termination, certain conditions

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
