package logic;

import java.util.EventObject;

import persistence.Process;

public class NodeEvent extends EventObject {
	
	private static final long serialVersionUID = -1680091234734273255L;
	
	private Process p;
	private Object source;

	public NodeEvent(Object source, Process p) {
		super(source);
		this.source=source;
		this.p=p;
	}

	public Process getP() {
		return p;
	}

	public Object getSource() {
		return source;
	}

	public void setSource(Object source) {
		this.source = source;
	}

}
