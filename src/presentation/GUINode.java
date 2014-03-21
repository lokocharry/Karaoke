package presentation;

import javax.swing.JFrame;

import persistence.Node;
import persistence.Process;

import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class GUINode extends JFrame {

	private static final long serialVersionUID = -4801063715460288145L;
	
	private Node node;
	private JTable table;
	private JScrollPane panelProcesses;
	private JTextPane textPane;
	private DefaultTableModel dtm;
	
	public GUINode(Node node){
		this.node=node;
		setSize(500, 300);
		setLayout(null);
		setResizable(false);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.GREEN);
		progressBar.setStringPainted(true);
		progressBar.setBounds(193, 237, 279, 14);
		getContentPane().add(progressBar);
		
		String[] aux={"Número ", "Canción"};
		dtm=new DefaultTableModel(aux, 0);
		table = new JTable(dtm);
		panelProcesses=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelProcesses.setViewportView(table);
		panelProcesses.setBounds(27, 123, 146, 128);
		add(panelProcesses);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(193, 32, 279, 194);
		add(textPane);
	}
	
	public void addProcessToTable(Process p){
		dtm.addRow(p.toVector());
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}
	
	public JTextPane getTextPane() {
		return textPane;
	}
	
}
