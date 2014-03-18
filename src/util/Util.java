package util;

import java.util.Calendar;

public class Util {

	public static String fecha(){
		Calendar rightNow = Calendar.getInstance();
		int hora = rightNow.get(Calendar.HOUR_OF_DAY);
		int min = rightNow.get(Calendar.MINUTE);
		int sec = rightNow.get(Calendar.SECOND);
		return hora+":"+min+":"+sec;
	}

}
