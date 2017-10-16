package Bank;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class RightPanel extends JPanel implements ActionListener{
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
		this.setDeposit(false);
		this.setWithdraw(false);
		this.setCancel(false);
		this.setSuspend(false);
		this.setReactivate(false);
		this.setDay(false);
		this.setMonth(false);
		
		this.gui = gui;		
		
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
