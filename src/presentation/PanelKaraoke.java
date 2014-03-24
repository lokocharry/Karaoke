package presentation;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;

public class PanelKaraoke extends JPanel {

	private static final long serialVersionUID = 2631778198130917601L;
	
	private JTextPane textPane;
	private JProgressBar progressBar;
	
	public PanelKaraoke(){
		setSize(280, 220);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		progressBar = new JProgressBar();
		progressBar.setForeground(Color.GREEN);
		progressBar.setStringPainted(true);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		
		add(textPane);
		add(progressBar);
		
	}
	
	public void updateProgress(int value){
		progressBar.setValue(value);
		progressBar.repaint();
	}
	
	public JTextPane getTextPane() {
		return textPane;
	}

}
