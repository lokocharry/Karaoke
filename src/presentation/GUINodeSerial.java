package presentation;

import javax.swing.JFrame;

import persistence.Node;
import util.Util;

public class GUINodeSerial extends JFrame {

	private static final long serialVersionUID = -4801063715460288145L;
	
	private Node node;
	private PanelSerialProcessing panel;
	
	public GUINodeSerial(Node node){
		this.node=node;
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(500, 300);
		setLayout(null);
		setResizable(false);
		setLocation(Util.screenSizeHeight(),0);
		panel=new PanelSerialProcessing(node);
		add(panel);
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public PanelSerialProcessing getPanel() {
		return panel;
	}

	public void setPanel(PanelSerialProcessing panel) {
		this.panel = panel;
	}
	
}
