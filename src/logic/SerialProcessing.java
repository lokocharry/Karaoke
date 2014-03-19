package logic;

import persistence.Node;
import persistence.Process;

public class SerialProcessing implements Runnable{

	private Node node; 
	private boolean pause = false;
	
	public SerialProcessing(Node node){
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

		do{
			if(pause!=true)
			if(node.getProcesses().isEmpty()==false){
				Process p = node.getProcesses().get(0);
				String aux = "";
				while((aux=p.readLine())!=null){
					System.out.println(aux);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}while(true);
	}

}
