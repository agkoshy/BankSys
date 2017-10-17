package Bank;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

/**
 * GUI class
 *
 * This class is the GUI and possess as the main graphical interface for the program. It is divided into two, one display panel 
 * and the buttons panel.
 *
 * @author Alvis Koshy, Zhu Su
 * @version 1.0
 * @since 2017-10-17
 */
public class GUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4640203251073468696L;
	
	JFrame frame = new JFrame("Bank System");
	JScrollPane scrollPane = new JScrollPane();

	public RightPanel rightPanel;
	
	JTextArea textArea;
	
	public GUI() {

		JPanel buttonContainer = new JPanel();
		rightPanel = new RightPanel(this);
		buttonContainer.add(rightPanel);
		
		JPanel textContainer = new JPanel();
		textArea = new JTextArea(27, 28);
		textArea.setEditable(false);
		
		frame.setSize(500, 500);
		scrollPane = new JScrollPane(textArea);
		textContainer.add(scrollPane);
		JPanel main = new JPanel();
		main.add(textContainer);
		main.add(buttonContainer);
		main.setLayout(new FlowLayout());
		frame.add(main);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
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
