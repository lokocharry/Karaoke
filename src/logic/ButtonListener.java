package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import persistence.Node;
import persistence.Process;
import test.Test;

public class ButtonListener implements ActionListener {
	
	private int nodeId=1;
	private int processId=1;
	private Test t;
	private Process p;
	
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
					(String)t.getNm().getBxProcessingType().getSelectedItem());
			t.getNm().addNodeToTable(n);
			t.getNm().addNodeToList(n);
			t.getNm().log("Nodo creado");
			nodeId++;
		break;
		case "file":
			if (t.getNm().getFc().showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
				p=new Process(processId, t.getNm().getFc().getSelectedFile().toString());
				t.getNm().getTxtFile().setText(t.getNm().getFc().getSelectedFile().toString());
		    }		
		break;
		case "create":
			t.getProcessList().add(p);
			t.getNm().addProcess(p);
			t.getNm().getTxtFile().setText("Archivo no seleccionado");
			t.getNm().log("Proceso creado");
			t.getNm().stratThread();
			p=null;
		break;	
		}
	}
}
