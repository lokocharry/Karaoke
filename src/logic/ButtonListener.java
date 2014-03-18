package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import persistence.Node;
import test.Test;
import util.Util;

public class ButtonListener implements ActionListener {
	
	private int id=0;
	private Test t;
	
	public ButtonListener(Test t){
		this.t=t;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action=e.getActionCommand();
		if(action.equals("add")){
			t.getNm().addNode(new Node(id,  (short)Integer.parseInt((String) t.getNm().getBxStorage().getSelectedItem()),
											(short)Integer.parseInt((String) t.getNm().getBxMemory().getSelectedItem()),
											(short)Integer.parseInt((String) t.getNm().getBxProcessing().getSelectedItem())));
			t.getNm().getTxtLog().append(">>>"+Util.fecha()+": Nodo creado\n");
			id++;
		}
	}

}
