package util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import persistence.Node;
import persistence.Process;

public class Util {

	public static String fecha(){
		Calendar rightNow = Calendar.getInstance();
		int hora = rightNow.get(Calendar.HOUR_OF_DAY);
		int min = rightNow.get(Calendar.MINUTE);
		int sec = rightNow.get(Calendar.SECOND);
		return hora+":"+min+":"+sec;
	}
	
	public static ArrayList<Node> sort(ArrayList<Node> o){
		for (int i = 0; i < o.size(); i++) {
			for (int j = i+1; j < o.size(); j++) {
				if(o.get(i).getCapacity()<o.get(j).getCapacity()){
					Node aux=o.get(i);
					o.set(i, o.get(j));
					o.set(j, aux);
				}
			}
		}
		return o;
	}
	
	public static void printArray(ArrayList<Process> arrayList){
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i).toString());
		}
	}
	
	public static void paintLyrics(JTextPane textPane, String a){
		StyledDocument doc = textPane.getStyledDocument();
		for (int i = 0; i < a.length(); i++) {
			Style style = textPane.addStyle("I'm a Style", null);
	        StyleConstants.setForeground(style, Color.red);

	        try { doc.insertString(doc.getLength(), a.substring(0,i),style); }
	        catch (BadLocationException e){}

	        StyleConstants.setForeground(style, Color.blue);

	        try { doc.insertString(doc.getLength(), a.substring(i, a.length()),style); }
	        catch (BadLocationException e){}
	        try {
				Thread.sleep(300);
				textPane.setText("");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
