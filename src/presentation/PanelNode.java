package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import logic.ParallelProcessing;
import logic.SerialProcessing;

import persistence.Node;
import persistence.Process;

public class PanelNode extends JPanel {
	
	private static final long serialVersionUID = -8023097265392613744L;
	
	private JToggleButton btnState;
	private JButton btnDelete;
	private JLabel lblNode;
	private Node node;
	
	public PanelNode(Node n){
		this.node=n;
		lblNode=new JLabel("ID: "+this.node.getId());
		btnState=new JToggleButton("OFF");
		btnState.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange()==ItemEvent.SELECTED){
					btnState.setText("ON");
					if(node.getRun() instanceof SerialProcessing)
						((SerialProcessing) node.getRun()).play();
					else
						((ParallelProcessing) node.getRun()).play();
			      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
			    	  btnState.setText("OFF");
			    	  if(node.getRun() instanceof SerialProcessing)
							((SerialProcessing) node.getRun()).stop();
			    	  else
						((ParallelProcessing) node.getRun()).stop();
			      }
			}
		});
		
		btnDelete = new JButton("BORRAR");
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList<Process> aux = node.getProcesses(); 
				for (int i = 0; i < aux.size(); i++) {
					node.getT().getNm().addProcess(aux.get(i));
				}
				if(node.getRun() instanceof SerialProcessing)				
					((SerialProcessing) node.getRun()).stop();
				else{
					((ParallelProcessing) node.getRun()).stop();
					for (int i = 0; i < ((ParallelProcessing) node.getRun()).getAux().size(); i++) {
						node.getT().getNm().addProcess(((ParallelProcessing) node.getRun()).getAux().get(i));
					}
				}
				node.getGn().setVisible(false);
				node.getGn().dispose();
				remove();
				
			}
		});
		setBorder(BorderFactory.createTitledBorder("Nodo #"+this.node.getId()));
		add(lblNode);
		add(btnState);
		add(btnDelete);
	}
	
	private void remove(){		
		node.getT().getNm().getPanelNodeList().remove(this);
        this.setVisible(false);
        node.getT().getNodeList().remove(node);
        System.out.println(node.getT().getNodeList().size());
        node.getT().getNm().removeRow(node.getId());
	}

}
