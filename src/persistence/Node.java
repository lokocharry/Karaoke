package persistence;

import java.util.ArrayList;

import presentation.GUINode;

import logic.NodeClassListener;
import logic.NodeEvent;
import logic.ParallelProcessing;
import logic.SerialProcessing;

public class Node implements NodeClassListener {
	
	private int id;
	private short storage;
	private short memory;
	private short processing;
	private String processingType;
	private ArrayList<Process> processes;
	private Thread thread;
	private Runnable run;
	private GUINode gn;
	
	public Node(int id, short storage, short memory, short processing, String processingType){
		this.id=id;
		this.storage=storage;
		this.memory=memory;
		this.processing=processing;
		this.processingType=processingType;
		processes=new ArrayList<>();
		onCreate(new NodeEvent(this, this));
	}

	public void addProcess(Process p){
		if(processes==null)
			processes=new ArrayList<>();
		processes.add(p);
		this.onProcessAdd(new NodeEvent(this, this));
	}
	
	public void startThread(GUINode gn){
		this.gn=gn;
		if(thread==null&&run==null){
			switch (processingType) {
			case "Serial":
				run=new SerialProcessing(this, gn);
				break;
			case "Paralelo":
				run=new ParallelProcessing(this, gn);
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
	
	public GUINode getGn() {
		return gn;
	}

	public void setGn(GUINode gn) {
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
		if(processes.isEmpty()==false)
			gn.addProcessToTable(processes.get(processes.size()-1));
	}

	@Override
	public void onProcessEnded(NodeEvent n) {
		
	}

}
