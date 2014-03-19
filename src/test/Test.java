package test;

import java.util.ArrayList;
import java.util.Arrays;

import logic.ButtonListener;
import persistence.Node;
import persistence.Process;
import presentation.NodeManager;

public class Test {
	
	private NodeManager nm;
	private ButtonListener bl;
	private ArrayList<Process> processList;
	private ArrayList<Node> nodeList;
	
	public NodeManager getNm() {
		if(nm==null)
			nm=new NodeManager(this);
		return nm;
	}

	public ButtonListener getBl() {
		if(bl==null)
			bl=new ButtonListener(this);
		return bl;
	}

	public void setNodeList(ArrayList<Node> nodeList) {
		this.nodeList = nodeList;
	}

	public ArrayList<Process> getProcessList() {
		if(processList==null)
			processList=new ArrayList<>();
		return processList;
	}

	public ArrayList<Node> getNodeList() {
		if(nodeList==null)
			nodeList=new ArrayList<>();
		return nodeList;
	}

	public static void main(String[] args) {
		Test t=new Test();
		t.getNm().setVisible(true);
	}
	

}
