package presentation;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import persistence.Node;

public class PanelNode extends JPanel {
	
	private static final long serialVersionUID = -8023097265392613744L;
	
	private JToggleButton btnState;
	private JLabel lblNode;
	private Node node;
	
	public PanelNode(Node node){
		this.node=node;
		lblNode=new JLabel("ID: "+this.node.getId());
		btnState=new JToggleButton("OFF");
		btnState.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {
				if(ev.getStateChange()==ItemEvent.SELECTED){
					btnState.setText("ON");
			      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
			    	  btnState.setText("OFF");
			      }
			}
		});
		setBorder(BorderFactory.createTitledBorder("Nodo #"+this.node.getId()));
		add(lblNode);
		add(btnState);
	}

}
