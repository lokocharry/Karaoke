package logic;

import persistence.Node;
import presentation.GUINode;

public class ParallelProcessing implements Run, Runnable{
	
	private Node node;
	private boolean pause = false;
	private GUINode gn;
	
	public ParallelProcessing(Node node, GUINode gn){
		this.node=node;
		this.gn=gn;
	}

	@Override
	public void run() {
		do {
			
		} while (true);
		
	}
	
	@Override
	public synchronized void play() {
		pause = false;
	}

	@Override
	public synchronized void stop() {
		pause = true;
	}

}
