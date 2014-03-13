package persistence;

public class Node {
	
	private short storage;
	private short memory;
	private short processing;
	
	public Node(short storage, short memory, short processing){
		this.storage=storage;
		this.memory=memory;
		this.processing=processing;
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

}
