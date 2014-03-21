package logic;

import persistence.Node;
import persistence.Process;
import presentation.GUINode;
import util.Util;

public class SerialProcessing implements Run, Runnable{

	private Node node; 
	private volatile boolean pause = true;
	private GUINode gn;
	
	public SerialProcessing(Node node, GUINode gn){
		this.node=node;
		this.gn=gn;
	}

	@Override
	public void run() {
		do{
			if(pause!=true)
			if(node.getProcesses().isEmpty()==false){
				Process p = node.getProcesses().remove(0);
				String aux = "";
				while((aux=p.readLine())!=null){
					if(pause==true)
						break;
					Util.paintLyrics(gn.getTextPane(), aux);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}while(true);
	}
	
	@Override
	public void play() {
		pause=false;
	}

	@Override
	public void stop() {
		pause=true;
	}

}
