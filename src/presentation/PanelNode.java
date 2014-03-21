package presentation;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import logic.ParallelProcessing;
import logic.SerialProcessing;

import persistence.Node;

public class PanelNode extends JPanel {
	
	private static final long serialVersionUID = -8023097265392613744L;
	
	private JToggleButton btnState;
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
		setBorder(BorderFactory.createTitledBorder("Nodo #"+this.node.getId()));
		add(lblNode);
		add(btnState);
	}

}
