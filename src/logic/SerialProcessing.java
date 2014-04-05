package logic;

import persistence.Node;
import persistence.Process;
import presentation.PanelKaraoke;
import util.Util;

public class SerialProcessing implements Run, Runnable{

	private Node node; 
	private volatile boolean pause = true;
	private PanelKaraoke pk;
	private Process p;
	private int line;
	
	public SerialProcessing(Node node, PanelKaraoke pk){
		this.node=node;
		this.pk=pk;
	}

	@Override
	public void run() {
		int percent;
		do{
			if(pause==false){
				if(p!=null){
					String aux = p.readLine();
					percent=(int)((line*100)/p.getLineCount());
					pk.updateProgress(percent);
					line++;
					if(aux!=null){
						Util.paintLyrics(pk.getTextPane(), aux);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					else{
						node.onProcessEnded(new NodeEvent(this, node), p.getId());
						line=0;
						p=null;
					}
			}
				else{
					if(node.getProcesses().isEmpty()==false)
						p = node.getProcesses().remove(0);
					    if(p!=null)
					    		node.getGn().setTitle("SE ESTA REPRODUCIENDO: "+p.getFile().getName());
				}
			}
		}while(true);
	}
	
	@Override
	public void play() {
		pause=false;
	}

	@Override
	public void stop() {
		pause=true;
	}

}
