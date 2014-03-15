package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class NodeManager extends JFrame {

	private static final long serialVersionUID = 5868705653271843665L;
	
	private JTabbedPane tabPanel;
	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	
	public NodeManager(){
		tabPanel=new JTabbedPane();
		
		panel1=new JPanel();
		tabPanel.addTab("Monitoreo", panel1);
		panel2=new JPanel();
		tabPanel.addTab("Administración", panel2);
		panel3=new JPanel();
		tabPanel.addTab("Creación", panel3);
		
		add(tabPanel);
	}
	
	public static void main(String[] args) {
		NodeManager n=new NodeManager();
		n.setSize(500, 500);
		n.setVisible(true);
	}

}
