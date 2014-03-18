package test;

import logic.ButtonListener;
import presentation.NodeManager;

public class Test {
	
	private NodeManager nm;
	private ButtonListener bl;
	
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

	public static void main(String[] args) {
		Test t=new Test();
		t.getNm().setVisible(true);
	}
	

}
