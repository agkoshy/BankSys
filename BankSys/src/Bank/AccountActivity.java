package Bank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

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
	public static User[] sortAccountLog(User[] set) {
		int temp;
		for (int i = 1; i < set.length; i++)
		{
			for (int j = i; j > 0; j--)
			{
				if (set[j].getSIN() < set[j-1].getSIN())
				{
					temp = set[j].getSIN();
					set[j] = set [j-1].getSIN();
					set[j-1].getSIN() = temp;
				}
				else if(set[j].getSIN() == set[j-1].getSIN())
				{
					temp = set[j].getDate();
					set[j] = set [j-1].getDate();
					set[j-1].getDate() = temp;
				}
			}
		}
		return set;
	}

	/*
	 * process records in the accountLog at the end of each business day
	 * according to the rules in the document
	 * /cs/course/2011E/CIBC_Overdraft_Protection_Service_Addendum.pdf and Rule
	 * 1 and Rule 2 for credit accounts above.
	 */
	public static void processAccountLogEndOfDay() throws IOException {
		String fileloc = retrieveAccountLog().toString();
		
		BufferedWriter writer = null;
		String x = "";
		
		writer = new BufferedWriter(new FileWriter(fileloc, true));
		
		writer.write(x);
		writer.close();
		
	}

	/*
	 * process records in the accountLog at the end of each calendar month
	 * according to the rules in the document
	 * /cs/course/2011E/CIBC_Overdraft_Protection_Service_Addendum.pdf and Rule
	 * 1 and Rule 2 for credit accounts above.
	 */
	public static void processAccountLogEndOfMonth() throws IOException {
		String fileloc = retrieveAccountLog().toString();
		
		BufferedWriter writer = null;
		String x = "";
		
		writer = new BufferedWriter(new FileWriter(fileloc, true));
		
		writer.write(x);
		writer.close();

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
