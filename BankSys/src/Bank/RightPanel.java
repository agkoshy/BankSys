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
	private JButton btnSin = new JButton("Social Insurance Number");
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
		btnSin.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnAccNew.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnDeposit.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnWithdraw.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnSuspend.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnCancel.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnReactivate.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		btnMonth.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
		
		add(btnUser);
		add(btnSin);
		add(btnAccNew);
		add(btnDeposit);
		add(btnWithdraw);
		add(btnSuspend);
		add(btnCancel);
		add(btnReactivate);
		add(btnMonth);
		
		btnUser.addActionListener(this);
		btnSin.addActionListener(this);
		btnAccNew.addActionListener(this);
		btnDeposit.addActionListener(this);
		btnWithdraw.addActionListener(this);
		btnSuspend.addActionListener(this);
		btnCancel.addActionListener(this);
		btnReactivate.addActionListener(this);
		btnMonth.addActionListener(this);
		
		this.setMaximumSize(this.getPreferredSize());
		
		this.gui = gui;

		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
