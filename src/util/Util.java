package util;

import java.util.ArrayList;
import java.util.Calendar;

import persistence.Node;

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

}
