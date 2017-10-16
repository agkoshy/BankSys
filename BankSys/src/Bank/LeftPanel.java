package Bank;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class LeftPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2774883915004521478L;

	private JList<AccountActivity> accList = new JList<>();
	private DefaultListModel<AccountActivity> listModel = new DefaultListModel<>();
	JScrollPane scrollPane = new JScrollPane();
	JTextArea textArea = new JTextArea();
	private GUI gui;
	
	public LeftPanel(GUI gui) {
		super();	
		textArea.setSize(400,1000);
		accList.setModel(listModel);
		scrollPane.setViewportView(accList);
		scrollPane.setMaximumSize(this.getPreferredSize());
		add(scrollPane);
		this.gui = gui;
		
	}
}
