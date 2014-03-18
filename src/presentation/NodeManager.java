package presentation;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import persistence.Node;

import logic.ButtonListener;

import test.Test;
import util.Util;

public class NodeManager extends JFrame {

	private static final long serialVersionUID = 5868705653271843665L;
	
	private ArrayList<Node> nodeList;
	
	private JTabbedPane tabPanel;
	private JScrollPane log;
	private JTextArea txtLog;
	private JTable nodes;
	private DefaultTableModel tm;
	private JButton btnAddNode;
	private ButtonListener bl;
	
	private JScrollPane panel1;
	private JPanel panel2;
	private JPanel panel3;
	
	private JPanel panelNodeCreation;
	private JPanel panelProcessList;
	private JLabel lblMemory;
	private JLabel lblStorage;
	private JLabel lblProcessing;;
	private JComboBox<String> bxMemory;
	private JComboBox<String> bxStorage;
	private JComboBox<String> bxProcessing;
	
	private Test t;
	
	public NodeManager(Test t){
		setLayout(new GridLayout(2, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		
		nodeList=new ArrayList<>();
		
		this.t=t;
		
		bl=t.getBl();
		tabPanel=new JTabbedPane();
		tabPanel.setBorder(BorderFactory.createTitledBorder("Monitor"));
		
		panel1=new JScrollPane();
		String values1 []={"Número", "Almacenamiento", "Procesamiento", "Memoria", "Evaluación", "Procesos"};
		tm=new DefaultTableModel(values1, 0);
		nodes=new JTable(tm);
		panel1.setViewportView(nodes);
		
		panel2=new JPanel();
		String [] aux={"2", "4", "16"};
		panelNodeCreation=new JPanel();
		panelNodeCreation.setBorder(BorderFactory.createTitledBorder("Crear Proceso"));
		lblMemory=new JLabel("Memoria");
		bxMemory=new JComboBox<>(aux);
		lblStorage=new JLabel("Memoria");
		bxStorage=new JComboBox<>(aux);
		lblProcessing=new JLabel("Memoria");
		bxProcessing=new JComboBox<>(aux);
		btnAddNode=new JButton("Crear Nodo");
		btnAddNode.setActionCommand("add");
		btnAddNode.addActionListener(bl);
		panelNodeCreation.add(lblMemory);
		panelNodeCreation.add(bxMemory);
		panelNodeCreation.add(lblStorage);
		panelNodeCreation.add(bxStorage);
		panelNodeCreation.add(lblProcessing);
		panelNodeCreation.add(bxProcessing);
		panelNodeCreation.add(btnAddNode);
		tabPanel.addTab("Monitoreo", panel1);
		panel2.add(panelNodeCreation);
		tabPanel.addTab("Administración", panel2);
		
		panel3=new JPanel();
		panel3.setLayout(new GridLayout(2, 1));
		
		panelProcessList=new JPanel();
		panelProcessList.setBorder(BorderFactory.createTitledBorder("Lista de Procesos"));
		
		panel3.add(panelProcessList);
		tabPanel.addTab("Procesos", panel3);
		
		txtLog=new JTextArea(">>>"+Util.fecha()+": Aplicación iniciada\n");
		txtLog.setEditable(false);
		log=new JScrollPane(txtLog, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		log.setBorder(BorderFactory.createTitledBorder("Log"));
		txtLog.setCaretPosition(txtLog.getDocument().getLength());
		
		add(tabPanel);
		add(log);
	}
	
	public void addNode(Node n){
		nodeList.add(n);
		tm.addRow(n.toVector());
	}

	public JTextArea getTxtLog() {
		return txtLog;
	}

	public JComboBox<String> getBxMemory() {
		return bxMemory;
	}

	public JComboBox<String> getBxStorage() {
		return bxStorage;
	}

	public JComboBox<String> getBxProcessing() {
		return bxProcessing;
	}
	
}
