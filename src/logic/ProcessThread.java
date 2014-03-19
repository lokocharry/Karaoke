package logic;

import test.Test;
import util.Util;

public class ProcessThread implements Runnable {
	
	private Test t;
	
	public ProcessThread(Test t){
		this.t=t;
		System.out.println("Hilo procesos");
	}

	@Override
	public void run() {
		do {
			if(t.getNodeList().isEmpty()==false){
				t.setNodeList(Util.sort(t.getNodeList()));
				if(t.getProcessList().isEmpty()==false)
					if(t.getNodeList().get(0).getCapacity()>0){
						t.getNodeList().get(0).addProcess(t.getProcessList().get(0));
						System.out.println(t.getProcessList().remove(0).toString());
					}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} while (true);
	}

}
