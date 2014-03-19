package presentation;

import javax.swing.JFrame;

import persistence.Node;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class GUINode extends JFrame {

	private static final long serialVersionUID = -4801063715460288145L;
	
	private Node node;
	private JTable table;
	
	public GUINode(Node node){
		this.node=node;
		getContentPane().setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.GREEN);
		progressBar.setStringPainted(true);
		progressBar.setBounds(123, 237, 279, 14);
		getContentPane().add(progressBar);
		
		String[] aux={
				"Número ", "Canción"
			};
		table = new JTable();
		table.setModel(new DefaultTableModel( aux,0
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(52);
		table.getColumnModel().getColumn(1).setPreferredWidth(103);
		table.setBounds(27, 123, 86, 128);
		getContentPane().add(table);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(123, 32, 279, 194);
		getContentPane().add(textPane);
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}
	
	public static void main(String[] args) {
		
		GUINode n = new GUINode(null);
		n.setVisible(true);
		n.setSize(500, 500);
		
		
	}
}
