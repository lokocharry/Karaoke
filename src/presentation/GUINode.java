package presentation;

import javax.swing.JFrame;

import persistence.Node;

public class GUINode extends JFrame {

	private static final long serialVersionUID = -4801063715460288145L;
	
	private Node node;
	
	public GUINode(Node node){
		this.node=node;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}
	
	

}
