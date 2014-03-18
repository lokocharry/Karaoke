package logic;

import java.util.ArrayList;

import persistence.Process;

public class SerialProcessing implements Runnable{

	private ArrayList<Process> processes;
	private boolean pause = false;
	
	
	public SerialProcessing(ArrayList<Process> processes){
		this.processes = processes;
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
			if(processes.isEmpty()==false){
				Process p = processes.get(0);
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
