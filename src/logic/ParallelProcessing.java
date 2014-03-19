package logic;

import persistence.Node;

public class ParallelProcessing implements Runnable{
	
	private Node node;
	private boolean pause = false;
	
	
	public ParallelProcessing(Node node){
		this.node=node;
	}
	
	public synchronized void pause(){
		pause = true;
	}
	
	public synchronized void play(){
		pause = false;
	}

	@Override
	public void run() {
		do {
			
		} while (true);
		
	}

}
