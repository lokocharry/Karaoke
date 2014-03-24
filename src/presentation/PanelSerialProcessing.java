package presentation;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import persistence.Node;
import persistence.Process;

public class PanelSerialProcessing extends JPanel {
	
	private static final long serialVersionUID = -8253504378875286685L;
	
	private Node node;
	private JTable table;
	private JScrollPane panelProcesses;
	private PanelKaraoke pk;
	private DefaultTableModel dtm;
	
	public PanelSerialProcessing(Node node){
		this.node=node;
		setSize(500, 300);
		setLayout(new GridLayout(2, 1));
		
		String[] aux={"Número ", "Canción"};
		dtm=new DefaultTableModel(aux, 0);
		table = new JTable(dtm);
		panelProcesses=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelProcesses.setViewportView(table);
		pk=new PanelKaraoke();
		add(pk);
		add(panelProcesses);
	}
	
	public void addProcessToTable(Process p){
		dtm.addRow(p.toVector());
	}
	
	public void removeRow(int index){
		if(dtm.getRowCount()>0){
			dtm.removeRow(index);
		}
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public PanelKaraoke getPk() {
		return pk;
	}

}
