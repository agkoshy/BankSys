package Bank;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

import javax.swing.*;
public class RightPanel extends JPanel implements ActionListener, PropertyChangeListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6783424917586519882L;

	private JButton btnUser = new JButton("New User");
	private JButton btnDay = new JButton("Next Day");
	private JButton btnAccNew = new JButton("New Account");
	private JButton btnDeposit = new JButton("Deposit");
	private JButton btnWithdraw = new JButton("Withdraw");
	private JButton btnSuspend = new JButton("Suspend Account");
	private JButton btnCancel = new JButton("Cancel Account");
	private JButton btnReactivate = new JButton("Reactivate Account");
	private JButton btnMonth = new JButton("Next Month");

	private GUI gui;
	private CheckingAccount check = new CheckingAccount();
	private CreditAccount credit;
	private DemandAccount demand;
	User user;
	

    //private NumberFormat paymentFormat;
	
	private static final String FONT_FACE = "Arial";
	private static final int FONT_SIZE = 12;

	public RightPanel(GUI gui) {
		super(new GridLayout(15,1));
		
		btnUser.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnDay.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnAccNew.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnDeposit.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnWithdraw.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnSuspend.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnCancel.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnReactivate.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnMonth.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		
		add(btnUser);
		add(btnAccNew);
		add(btnDeposit);
		add(btnWithdraw);
		add(btnSuspend);
		add(btnCancel);
		add(btnReactivate);
		add(btnDay);
		add(btnMonth);
		
		btnUser.addActionListener(new User(gui));
		btnDay.addActionListener(this);
		btnAccNew.addActionListener(this);
		btnDeposit.addActionListener(this);
		btnWithdraw.addActionListener(this);
		btnSuspend.addActionListener(this);
		btnCancel.addActionListener(this);
		btnReactivate.addActionListener(this);
		btnMonth.addActionListener(this);
		
		this.setMaximumSize(this.getPreferredSize());
		
		this.setAccNew(false);
		this.setDeposit(true);
		this.setWithdraw(false);
		this.setCancel(false);
		this.setSuspend(false);
		this.setReactivate(false);
		this.setDay(false);
		this.setMonth(false);
		
		this.gui = gui;		
		//Checks to see which account has been chosen, creates an instance of chosen account
		if(User.checkOne.getState()) {
			check = new CheckingAccount();
		} else if(User.checkTwo.getState()) {
			credit = new CreditAccount();
		}
		
		demand = new DemandAccount();
		
	}
	
	public void setAccNew(boolean status) {
		btnAccNew.setEnabled(status);
	}
	
	public void setDeposit(boolean status) {
		btnDeposit.setEnabled(status);
	}
	public void setWithdraw(boolean status) {
		btnWithdraw.setEnabled(status);
	}
	public void setSuspend(boolean status) {
		btnSuspend.setEnabled(status);
	}
	public void setCancel(boolean status) {
		btnCancel.setEnabled(status);
	}
	public void setReactivate(boolean status) {
		btnReactivate.setEnabled(status);
	}
	public void setDay(boolean status) {
		btnDay.setEnabled(status);
	}

	public void setMonth(boolean status) {
		btnMonth.setEnabled(status);
	}
	public void depositBtn() {
		JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5)); 
		JLabel lblAccounts = new JLabel("Accounts: ");
		JLabel lblBalance = new JLabel("Amount: ");
		JTextField txtBalance = new JTextField(5);
		int amount = 10000;
		String[] accounts = new String[] {"Checking Account", "Credit Account", "Demand Account"};
		
		JComboBox<String> accList = new JComboBox<>(accounts);
		
		/*JFormattedTextField num = new JFormattedTextField(paymentFormat);
		num.setValue(new Integer(amount));
		num.setColumns(10);*/

		panel.add(lblAccounts);
		panel.add(accList);
		panel.add(lblBalance);
		panel.add(txtBalance);
		int result = JOptionPane.showConfirmDialog(null, panel, "Deposit Account",
				JOptionPane.OK_CANCEL_OPTION);
		/*
		if(accList.getSelectedIndex() == 0) {
			txtBalance.setText(Double.toString(check.getBalance()));
		} else if(accList.getSelectedIndex() == 1) {
		    txtBalance.setText(Double.toString(credit.getBalance()));
		} else if(accList.getSelectedIndex() == 2) {
			txtBalance.setText(Double.toString(demand.getBalance()));
		}*/
		if(result == JOptionPane.OK_OPTION) {
			if(accList.getSelectedIndex() == 0) {
				check.depositAmount(Double.valueOf(txtBalance.getText()));
				System.out.println(check.getBalance());
			} else if(accList.getSelectedIndex() == 1) {
				credit.depositAmount(Double.valueOf(txtBalance.getText()));
			} else if(accList.getSelectedIndex() == 2) {
				demand.depositAmount(Double.valueOf(txtBalance.getText()));
			}
		}
		

	}
	
	public void withdrawBtn() {
		JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5)); 
		JLabel lblAccounts = new JLabel("Accounts: ");
		JLabel lblBalance = new JLabel("Amount: ");
		JTextField txtBalance = new JTextField(5);
		int amount = 0;
		String[] accounts = new String[] {"Checking Account", "Credit Account"};
		
		JComboBox<String> accList = new JComboBox<>(accounts);
		
		JFormattedTextField num = new JFormattedTextField();
		num.setValue(new Integer(amount));
		num.setColumns(10);
		num.addPropertyChangeListener("value", this);

		panel.add(lblAccounts);
		panel.add(accList);
		panel.add(lblBalance);
		panel.add(num);
		int result = JOptionPane.showConfirmDialog(null, panel, "Withdraw Amount",
				JOptionPane.OK_CANCEL_OPTION);
		{
			if(result == JOptionPane.OK_OPTION) {
				if(accList.getSelectedIndex() == 0) {
					check.withdrawAmount(Double.valueOf(txtBalance.getText()));
					System.out.println(check.getBalance());
				} else if(accList.getSelectedIndex() == 1) {
					credit.withdrawAmount(Double.valueOf(txtBalance.getText()));
				}
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getSource() == btnDeposit);
		if(e.getSource().equals(btnDeposit)) {
			depositBtn();
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
