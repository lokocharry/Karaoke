package logic;

import java.util.EventObject;

import persistence.Node;

public class NodeEvent extends EventObject {
	
	private static final long serialVersionUID = -1680091234734273255L;
	
	private Node node;

	public NodeEvent(Object source, Node node) {
		super(source);
		this.node=node;
	}

	public Node getNode() {
		return node;
	}

}
