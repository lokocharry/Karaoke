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
		progressBar.setBounds(126, 182, 276, 14);
		getContentPane().add(progressBar);
		
		String[] aux={
				"Número ", "Canción"
			};
		table = new JTable();
		table.setModel(new DefaultTableModel( aux,0
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(52);
		table.getColumnModel().getColumn(1).setPreferredWidth(103);
		table.setBorder(new CompoundBorder(new CompoundBorder(null, new LineBorder(new Color(0, 0, 0), 2)), null));
		table.setBounds(10, 123, 86, 128);
		getContentPane().add(table);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(123, 32, 279, 128);
		getContentPane().add(textPane);
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}
}
