package test;

import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import logic.ButtonListener;
import persistence.Node;
import persistence.Process;
import presentation.NodeManager;
import util.Util;

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
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	        }
	        catch (UnsupportedLookAndFeelException e) {
	        }
	        catch (ClassNotFoundException e) {
	        }
	        catch (InstantiationException e) {
	        }
	        catch (IllegalAccessException e) {
	        	
	      }
		Test t=new Test();
		t.getNm().setVisible(true);
		t.getNm().setSize(Util.screenSizeWidth()/2, Util.screenSizeHeight());
		t.getNm().setResizable(false);
	}
	

}
