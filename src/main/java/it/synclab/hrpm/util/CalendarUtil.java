package it.synclab.hrpm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarUtil {
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd/mm/yyyy");
	
	public static final String toString(Calendar calendar) {
		return FORMAT.format(calendar.getTime());
	}
	
	public static final Calendar toCalendar(String string) throws ParseException {
		Calendar date = Calendar.getInstance();
		date.setTime(FORMAT.parse(string));
		return date;
	}
}
