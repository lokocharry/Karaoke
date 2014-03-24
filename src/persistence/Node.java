package persistence;

import java.util.ArrayList;

import javax.swing.JFrame;

import logic.NodeClassListener;
import logic.NodeEvent;
import logic.ParallelProcessing;
import logic.SerialProcessing;
import presentation.GUINodeParallel;
import presentation.GUINodeSerial;
import test.Test;

public class Node implements NodeClassListener {
	
	private int id;
	private short storage;
	private short memory;
	private short processing;
	private String processingType;
	private ArrayList<Process> processes;
	private Thread thread;
	private Runnable run;
	private JFrame gn;
	private Test t;
	
	public Node(int id, short storage, short memory, short processing, String processingType, Test t){
		this.id=id;
		this.storage=storage;
		this.memory=memory;
		this.processing=processing;
		this.processingType=processingType;
		this.t=t;
		processes=new ArrayList<>();
		onCreate(new NodeEvent(this, this));
	}

	public void addProcess(Process p){
		if(processes==null)
			processes=new ArrayList<>();
		processes.add(p);
		this.onProcessAdd(new NodeEvent(this, this));
	}
	
	public void startThread(JFrame gn){
		this.gn=gn;
		if(thread==null&&run==null){
			switch (processingType) {
			case "Serial":
				run=new SerialProcessing(this, ((GUINodeSerial) gn).getPanel().getPk());
				break;
			case "Paralelo":
				run=new ParallelProcessing(this, (GUINodeParallel) gn, t);
				break;
			}
			thread=new Thread(run);
			thread.start();
		}
	}
	
	public Object[] toVector(){
		Object [] aux=new Object[7];
		aux[0]=id;
		aux[1]=storage;
		aux[2]=processing;
		aux[3]=memory;
		aux[4]=processingType;
		aux[5]=memory+storage+processing;
		aux[6]=processes.size();
		return aux;
	}
	
	public int getCapacity(){
		return (memory+storage+processing)-processes.size();
	}

	public short getStorage() {
		return storage;
	}

	public void setStorage(short storage) {
		this.storage = storage;
	}

	public short getMemory() {
		return memory;
	}

	public void setMemory(short memory) {
		this.memory = memory;
	}

	public short getProcessing() {
		return processing;
	}

	public ArrayList<Process> getProcesses() {
		return processes;
	}

	public void setProcessing(short processing) {
		this.processing = processing;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProcessingType() {
		return processingType;
	}

	public void setProcessingType(String processingType) {
		this.processingType = processingType;
	}

	
	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}
	
	public Runnable getRun() {
		return run;
	}

	public void setRun(Runnable run) {
		this.run = run;
	}
	
	public JFrame getGn() {
		return gn;
	}

	public void setGn(JFrame gn) {
		this.gn = gn;
	}

	@Override
	public String toString() {
		return String.format("[Memory: %s, Storage: %s, Processing: %s]", memory, storage, processing);
	}

	@Override
	public void onCreate(NodeEvent n) {
		
	}

	@Override
	public void onProcessAdd(NodeEvent n) {
		if(gn instanceof GUINodeParallel){
			((GUINodeParallel) gn).getPanel().addProcessToTable(processes.get(processes.size()-1));
			((ParallelProcessing)run).add();
		}
		else
			((GUINodeSerial) gn).getPanel().addProcessToTable(processes.get(processes.size()-1));
		t.getNm().updateNode(id, processes.size());
	}

	@Override
	public void onProcessEnded(NodeEvent n, int id) {
		if(gn instanceof GUINodeParallel)
			((GUINodeParallel) gn).getPanel().removeRow(id);
		else
			((GUINodeSerial) gn).getPanel().removeRow(0);
		t.getNm().log("Proceso terminado");
		t.getNm().updateNode(id, processes.size());
	}

}
