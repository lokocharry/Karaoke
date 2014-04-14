package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import persistence.Node;
import persistence.Process;
import presentation.GUINodeParallel;
import presentation.GUINodeSerial;
import test.Test;

public class ButtonListener implements ActionListener {
	
	private int nodeId=1;
	private int processId=1;
	private Test t;
	private Process p;
	private Node node;
	
	
	public ButtonListener(Test t){
		this.t=t;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action=e.getActionCommand();
		switch (action) {
		case "add":
			Node n=new Node(nodeId,  (short)Integer.parseInt((String) t.getNm().getBxStorage().getSelectedItem()),
					(short)Integer.parseInt((String) t.getNm().getBxMemory().getSelectedItem()),
					(short)Integer.parseInt((String) t.getNm().getBxProcessing().getSelectedItem()),
					(String)t.getNm().getBxProcessingType().getSelectedItem(), t);
			t.getNodeList().add(n);
			JFrame gn=null;
			if(n.getProcessingType().equals("Serial"))
				gn=new GUINodeSerial(n);
			else
				gn=new GUINodeParallel(n);
			n.setGn(gn);
			t.getNm().addNodeToTable(n);
			t.getNm().addNodeToList(n);
			t.getNm().log("Nodo "+n.getProcessingType()+" numero "+ nodeId + " con puntuacion (" +(n.getMemory() + n.getProcessing()+n.getStorage())+") ha sido creado");
			n.startThread(gn);
			gn.setVisible(true);
			nodeId++;
		break;
		case "file":
			if (t.getNm().getFc().showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
				p=new Process(processId, t.getNm().getFc().getSelectedFile().toString());
				t.getNm().getTxtFile().setText(t.getNm().getFc().getSelectedFile().toString());
				processId++;
		    }		
		break;
		case "create":
			try {
				if (p != null) {
					t.getNm().addProcess(p);
					t.getNm().getTxtFile().setText("Archivo no seleccionado");
					t.getNm().log("Proceso" + p.getFile().getName()+" creado");
					t.getNm().stratThread();
					p=null;	
				}else
					t.getNm().log("Archivo invalido");
			} catch (Exception e2) {
				t.getNm().log("Archivo invalido");
			}
			
		break;	
		}
	}
}
