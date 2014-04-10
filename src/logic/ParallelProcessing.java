package logic;

import java.util.ArrayList;

import persistence.Node;
import persistence.Process;
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
	private ArrayList<Process> aux;
	
	public ParallelProcessing(Node node, GUINodeParallel gn, Test t){
		this.node=node;
		this.gn=gn;
		this.t=t;
		sp=new ArrayList<>();
		aux=new ArrayList<>();
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
			Process p=node.getProcesses().remove(0);
			n.getProcesses().add(p);
			aux.add(p);
			n.setGn(gn);
			PanelKaraoke pk=new PanelKaraoke();
			SerialProcessing s=new SerialProcessing(n, pk);
			gn.getPanel().getPanel().add(pk);
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

	public ArrayList<Process> getAux() {
		return aux;
	}

}
