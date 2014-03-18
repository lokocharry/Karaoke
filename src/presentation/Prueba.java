package presentation;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Prueba extends JFrame {

	String a="aaaaa";
	JTextPane textPane = new JTextPane();
    StyledDocument doc = textPane.getStyledDocument();
	
	public Prueba(){
        add(textPane);
	}
	
	public void surtale(){
		for (int i = 0; i < a.length(); i++) {
			System.out.println(a.substring(0,i));
			System.out.println(a.substring(i, a.length()));
			System.out.println("--------------------------");
			Style style = textPane.addStyle("I'm a Style", null);
	        StyleConstants.setForeground(style, Color.red);

	        try { doc.insertString(doc.getLength(), a.substring(0,i),style); }
	        catch (BadLocationException e){}

	        StyleConstants.setForeground(style, Color.blue);

	        try { doc.insertString(doc.getLength(), a.substring(i, a.length()),style); }
	        catch (BadLocationException e){}
	        try {
				Thread.sleep(1000);
				textPane.setText("");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Prueba p=new  Prueba();
		p.setSize(300, 300);
		p.setVisible(true);
		p.surtale();
	}
}
