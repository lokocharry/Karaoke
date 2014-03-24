package presentation;

import javax.swing.JFrame;

import persistence.Node;

public class GUINodeParallel extends JFrame {
	
	private static final long serialVersionUID = -2533774588179605044L;
	
	private Node node;
	
	private PanelParallelProcessing panel;

	public GUINodeParallel(Node node){
		this.node=node;
		setSize(500, 300);
		setResizable(false);
		panel=new PanelParallelProcessing(node);
		add(panel);
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public PanelParallelProcessing getPanel() {
		return panel;
	}

	public void setPanel(PanelParallelProcessing panel) {
		this.panel = panel;
	}

}
