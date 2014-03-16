package persistence;

import java.util.ArrayList;

import logic.NodeClassListener;
import logic.NodeEvent;

public class Node implements NodeClassListener {
	
	private short storage;
	private short memory;
	private short processing;
	private ArrayList<Process> processes;
	
	public Node(short storage, short memory, short processing){
		this.storage=storage;
		this.memory=memory;
		this.processing=processing;
		onCreate(new NodeEvent(this, this));
	}
	
	public void addProcess(Process p){
		if(processes==null)
			processes=new ArrayList<>();
		processes.add(p);
		this.onProcessAdd(new NodeEvent(this, this));
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

	public void setProcessing(short processing) {
		this.processing = processing;
	}

	@Override
	public void onCreate(NodeEvent n) {
		System.out.println("Nodo creado");
	}

	@Override
	public void onProcessAdd(NodeEvent n) {
		System.out.println("Proceso añadido");
	}

	@Override
	public void onProcessEnded(NodeEvent n) {
		System.out.println("Proceso terminado");
	}
	
//	public static void main(String[] args) {
//		Node n=new Node((short)2, (short)2, (short)2);
//		n.addProcess(new Process("C:/Users/Aldebaran/Desktop/requisitos SO procesos.txt"));
//	}

}
