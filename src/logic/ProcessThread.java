package logic;

import test.Test;
import util.Util;

public class ProcessThread implements Runnable {
	
	private Test t;
	
	public ProcessThread(Test t){
		this.t=t;
	}

	@Override
	public void run() {
		do {
			if(t.getNodeList().isEmpty()==false){
				t.setNodeList(Util.sort(t.getNodeList()));
				if(t.getProcessList().isEmpty()==false)
					if(t.getNodeList().get(0).getCapacity()>0){
						t.getNodeList().get(0).addProcess(t.getProcessList().get(0));
//						Util.printArray(t.getProcessList());
						t.getProcessList().remove(0);
						if(t.getNm().getTmp().getRowCount()>0)
							t.getNm().getTmp().removeRow(0);
					}
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);
	}

}
