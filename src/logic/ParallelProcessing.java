package logic;

import java.util.ArrayList;

import persistence.Node;
import presentation.GUINodeParallel;
import presentation.PanelKaraoke;
import test.Test;

public class ParallelProcessing implements Run, Runnable{
	
	private Node node;
	private volatile boolean pause = true;
	private GUINodeParallel gn;
	private ArrayList<SerialProcessing> sp;
	private Thread thread;
	private Test t;
	
	public ParallelProcessing(Node node, GUINodeParallel gn, Test t){
		this.node=node;
		this.gn=gn;
		this.t=t;
		sp=new ArrayList<>();
	}

	@Override
	public void run() {
		do {
			if(pause==false){
				for (int i = 0; i < sp.size(); i++) {
					sp.get(i).play();
				}
			}
			else{
				for (int i = 0; i < sp.size(); i++) {
					SerialProcessing s=sp.get(i);
					if(s!=null)
						s.stop();
				}
			}
		} while (true);
	}
	
	public void add(){
		if(node.getProcesses().isEmpty()==false){
			Node n=new Node((short)0, (short)0, (short)0, (short)0, "Serial", t);
			n.getProcesses().add(node.getProcesses().get(0));
			n.setGn(gn);
			PanelKaraoke p=new PanelKaraoke();
			SerialProcessing s=new SerialProcessing(n, p);
			gn.getPanel().getPanel().add(p);
			sp.add(s);
			thread=new Thread(s);
			thread.start();
		}
	}
	
	@Override
	public void play() {
		pause = false;
	}

	@Override
	public void stop() {
		pause = true;
	}

}
