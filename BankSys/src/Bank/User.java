package Bank;
import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;


public class User implements ActionListener{
	
	Random ran = new Random();
	public Date date;
	
	CheckingAccount check;
	CreditAccount credit;
	private GUI gui;
	private JLabel lblUser = new JLabel("Name: ");
	private JLabel lblAcc = new JLabel("Choose Account(s): ");
	private JTextField txtUser = new JTextField(5);

	private Checkbox checkOne = new Checkbox("Checking Account");
	private Checkbox checkTwo = new Checkbox("Credit Account");
	
	private JPanel myPanel = new JPanel(new GridLayout(0, 1, 5, 5));

	
	public User(GUI gui) {
		this.gui = gui;
	}
	
	public void create() {
		
		myPanel.add(lblUser);
		myPanel.add(txtUser);
		myPanel.add(lblAcc);
		myPanel.add(checkOne);
		myPanel.add(checkTwo);
		
		txtUser.setText("");
		checkOne.setState(false);
		checkTwo.setState(false);
		
		int result = JOptionPane.showConfirmDialog(null, myPanel, "Are you sure you want these accounts",
				JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) 
		{
			// Checks to see if the fields are empty if user hits "OK"
			if (txtUser.getText().isEmpty()) 
			{
				// Shows an error pane if the user does hit "OK" with empty
				// fields
				JOptionPane.showMessageDialog(null, "One or more fields are empty!", "Missing fields!",
						JOptionPane.ERROR_MESSAGE);
			}
			else if((checkOne.getState() || checkTwo.getState()) != true) 
			{
				JOptionPane.showMessageDialog(null, "Must choose at least one account!", "Account must be chosen!",
						JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				// Generates User SIN
				
				int SIN = (int) (100000000 + (ran.nextFloat() * 900000000));
				
				// Generate Account
				
				if (checkOne.getState() == true)
				{
					check.createAccount(txtUser.getText(), SIN);
				}
				
				if (checkTwo.getState() == true)
				{
					credit.createAccount(txtUser.getText(), SIN);
				}
				
				// Enables buttons to true only after the user initializes
				gui.getRightPanel().setAccNew(true);
				gui.getRightPanel().setDeposit(true);
				gui.getRightPanel().setWithdraw(true);
				gui.getRightPanel().setCancel(true);
				gui.getRightPanel().setReactivate(true);
				gui.getRightPanel().setDay(true);
				gui.getRightPanel().setMonth(true);

				gui.leftPanel.textArea.setText("");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		create();
	}

	public int getSIN() {
		// TODO Auto-generated method stub
		return SIN;
	}

	public int getDate() {
		// TODO Auto-generated method stub
		return Date;
	}
	
	
}
