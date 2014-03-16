package logic;

import java.util.EventListener;

public interface NodeClassListener extends EventListener {
	
	public void onCreate(NodeEvent n);
	public void onProcessAdd(NodeEvent n);
	public void onProcessEnded(NodeEvent n);

}
