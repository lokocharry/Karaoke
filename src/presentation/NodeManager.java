package presentation;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import persistence.Node;
import persistence.Process;

import logic.ButtonListener;

import test.Test;
import util.Util;

public class NodeManager extends JFrame {

	private static final long serialVersionUID = 5868705653271843665L;
	
	private JTabbedPane tabPanel;
	private JScrollPane log;
	private JTextArea txtLog;
	private JTable nodes;
	private DefaultTableModel tmn;
	private JTable process;
	private DefaultTableModel tmp;
	private JButton btnAddNode;
	private ButtonListener bl;
	private JScrollPane panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel auxPanel;
	
	private JPanel panelNodeCreation;
	private JScrollPane panelNodeList;
	private JScrollPane panelProcessList;
	private JPanel panelProcessCreation;
	private JLabel lblMemory;
	private JLabel lblStorage;
	private JLabel lblProcessing;
	private JLabel lblProcessingType;
	private JComboBox<String> bxMemory;
	private JComboBox<String> bxStorage;
	private JComboBox<String> bxProcessing;
	private JComboBox<String> bxProcessingType;
	
	private JLabel lblFile;
	private JTextField txtFile;
	private JFileChooser fc;
	private JButton btnFile;
	private JButton btnCreateProcess;
	
	private Test t;
	
	public NodeManager(Test t){
		setLayout(new GridLayout(2, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		
		this.t=t;
		
		bl=t.getBl();
		tabPanel=new JTabbedPane();
		tabPanel.setBorder(BorderFactory.createTitledBorder("Monitor"));
		
		panel1=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		String values1 []={"Número", "Almacenamiento", "Procesamiento", "Memoria", "Tipo de procesamiento", "Evaluación", "Procesos"};
		tmn=new DefaultTableModel(values1, 0);
		nodes=new JTable(tmn);
		panel1.setViewportView(nodes);
		
		panel2=new JPanel();
		panel2.setLayout(new GridLayout(2, 1));
		String [] aux={"2", "4", "16"};
		String [] aux2={"Serial", "Paralelo"};
		panelNodeCreation=new JPanel();
		panelNodeCreation.setBorder(BorderFactory.createTitledBorder("Crear Nodo"));
		lblMemory=new JLabel("Memoria");
		bxMemory=new JComboBox<>(aux);
		lblStorage=new JLabel("Almacenamiento");
		bxStorage=new JComboBox<>(aux);
		lblProcessing=new JLabel("Procesamiento");
		bxProcessing=new JComboBox<>(aux);
		lblProcessingType=new JLabel("Tipo de procesamiento");
		bxProcessingType=new JComboBox<>(aux2);
		btnAddNode=new JButton("Crear Nodo");
		btnAddNode.setActionCommand("add");
		btnAddNode.addActionListener(bl);
		panelNodeCreation.add(lblMemory);
		panelNodeCreation.add(bxMemory);
		panelNodeCreation.add(lblStorage);
		panelNodeCreation.add(bxStorage);
		panelNodeCreation.add(lblProcessing);
		panelNodeCreation.add(bxProcessing);
		panelNodeCreation.add(lblProcessingType);
		panelNodeCreation.add(bxProcessingType);
		panelNodeCreation.add(btnAddNode);
		panelNodeList=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelNodeList.setBorder(BorderFactory.createTitledBorder("Nodos"));
		auxPanel=new JPanel();
		auxPanel.setLayout(new BoxLayout(auxPanel, BoxLayout.Y_AXIS));
		panelNodeList.setViewportView(auxPanel);
		tabPanel.addTab("Monitoreo", panel1);
		panel2.add(panelNodeCreation);
		panel2.add(panelNodeList);
		tabPanel.addTab("Administración", panel2);
		
		panel3=new JPanel();
		panel3.setLayout(new GridLayout(2, 1));
		
		panelProcessList=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelProcessList.setBorder(BorderFactory.createTitledBorder("Lista de Procesos"));
		String values2 []={"Número", "Archivo"};
		tmp=new DefaultTableModel(values2, 0);
		process=new JTable(tmp);
		panelProcessList.setViewportView(process);
		
		panelProcessCreation=new JPanel();
		panelProcessCreation.setBorder(BorderFactory.createTitledBorder("Crear Proceso"));
		lblFile=new JLabel("Archivo");
		txtFile=new JTextField("Archivo no seleccionado");
		txtFile.setEditable(false);
		btnFile=new JButton("Seleccionar archivo");
		btnFile.setActionCommand("file");
		btnFile.addActionListener(bl);
		btnCreateProcess=new JButton("Crear Proceso");
		btnCreateProcess.setActionCommand("create");
		btnCreateProcess.addActionListener(bl);
		panelProcessCreation.add(lblFile);
		panelProcessCreation.add(txtFile);
		panelProcessCreation.add(btnFile);
		panelProcessCreation.add(btnCreateProcess);
		fc=new JFileChooser();
		
		panel3.add(panelProcessList);
		panel3.add(panelProcessCreation);
		tabPanel.addTab("Procesos", panel3);
		
		txtLog=new JTextArea(">>>"+Util.fecha()+": Aplicación iniciada\n");
		txtLog.setEditable(false);
		log=new JScrollPane(txtLog, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		log.setBorder(BorderFactory.createTitledBorder("Log"));
		txtLog.setCaretPosition(txtLog.getDocument().getLength());
		
		add(tabPanel);
		add(log);
	}
	
	public void addNodeToTable(Node n){
		t.getNodeList().add(n);
		tmn.addRow(n.toVector());
	}
	
	public void addNodeToList(Node n){
		PanelNode p=new PanelNode(n);
		auxPanel.add(p);
		panelNodeList.validate();
	}
	
	public void addProcess(Process p){
		t.getProcessList().add(p);
		tmp.addRow(p.toVector());
	}
	
	public void log(String text){
		txtLog.append(">>>"+Util.fecha()+": "+text+"\n");
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

	public JFileChooser getFc() {
		return fc;
	}

	public JTextField getTxtFile() {
		return txtFile;
	}

	public JComboBox<String> getBxProcessingType() {
		return bxProcessingType;
	}
	
}
