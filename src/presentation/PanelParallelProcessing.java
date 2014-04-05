package presentation;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import persistence.Node;
import persistence.Process;

public class PanelParallelProcessing extends JPanel {

	private static final long serialVersionUID = -3407247541227349330L;
	
	private Node node;
	private JTable table;
	private JScrollPane panelProcesses;
	private JScrollPane panelProcessing;
	private JPanel panel;
	private DefaultTableModel dtm;
	
	public PanelParallelProcessing(Node node){
		this.node=node;
		setSize(500, 300);
		setLayout(new GridLayout(2, 1));
		
		String[] aux={"Número ", "Canción"};
		dtm=new DefaultTableModel(aux, 0);
		table = new JTable(dtm);
		panelProcesses=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelProcesses.setViewportView(table);		
		panelProcessing = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel=new JPanel();
		panelProcessing.setViewportView(panel);
		add(panelProcessing);
		add(panelProcesses);
	}
	
	public void addProcessToTable(Process p){
		dtm.addRow(p.toVector());
	}
	
	public void removeRow(int id){
		if(dtm.getRowCount()>0){
			for (int i = dtm.getRowCount() - 1; i >= 0; --i) {
	            if (dtm.getValueAt(i, 0).equals(id)) {
	            	dtm.removeRow(i);
	                break;
	        }
	    }
		}
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public JScrollPane getPanelProcessing() {
		return panelProcessing;
	}

	public JPanel getPanel() {
		return panel;
	}

}
