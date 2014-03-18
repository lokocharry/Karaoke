package persistence;

import java.util.ArrayList;

import logic.NodeClassListener;
import logic.NodeEvent;

public class Node implements NodeClassListener {
	
	private int id;
	private short storage;
	private short memory;
	private short processing;
	private String processingType;
	private ArrayList<Process> processes;
	
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

	@Override
	public String toString() {
		return String.format("[Memory: %s, Storage: %s, Processing: %s]", memory, storage, processing);
	}

	@Override
	public void onCreate(NodeEvent n) {
		
	}

	@Override
	public void onProcessAdd(NodeEvent n) {
		
	}

	@Override
	public void onProcessEnded(NodeEvent n) {
		
	}
	
//	public static void main(String[] args) {
//		Node n=new Node((short)2, (short)2, (short)2);
//		JFileChooser fc=new JFileChooser();
//		Process p = null;
//		if (fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
//	    {
//			p=new Process(fc.getSelectedFile().toString());
//	    }
//		n.addProcess(p);
//		System.out.println(p.readLine());
//	}

}
