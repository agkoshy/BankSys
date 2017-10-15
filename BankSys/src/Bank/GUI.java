package Bank;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;


public class GUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4640203251073468696L;
	
	JFrame frame = new JFrame("Bank System");
	JScrollPane scrollPane = new JScrollPane();

	public LeftPanel leftPanel;
	public RightPanel rightPanel;
	
	public GUI() {

		// Create the root panel
		JPanel buttonContainer = new JPanel();
		rightPanel = new RightPanel(this);
		buttonContainer.add(rightPanel);
		JPanel textContainer = new JPanel();
		leftPanel = new LeftPanel(this);
		textContainer.add(leftPanel);
		textContainer.add(buttonContainer);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		mainPanel.add(textContainer);
		frame.setSize(new Dimension(500,500));
		frame.add(mainPanel);
	    frame.getContentPane().add(mainPanel, BorderLayout.WEST);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
	}
	public LeftPanel getLeftPanel() {
		return this.leftPanel;
	}

	public RightPanel getRightPanel() {
		return this.rightPanel;
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GUI();
			}
		});

	}
}
