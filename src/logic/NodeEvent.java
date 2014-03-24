package logic;

import java.util.EventObject;

import persistence.Node;

public class NodeEvent extends EventObject {
	
	private static final long serialVersionUID = -1680091234734273255L;
	
	private Node node;
	private Object source;

	public NodeEvent(Object source, Node node) {
		super(source);
		this.source=source;
		this.node=node;
	}

	public Node getNode() {
		return node;
	}

	public Object getSource() {
		return source;
	}

	public void setSource(Object source) {
		this.source = source;
	}

}
