package it.synclab.hrpm.model;

import java.text.ParseException;
import java.util.Calendar;

import it.synclab.hrpm.util.CalendarUtil;

public class Stage implements Channel {

	private int id;
	private String title, tutor;
	private Calendar fromDate, toDate;
	private static final String HEADER = "ID;TITLE;TUTOR;FROM_DATE;TO_DATE";

	public Stage(int id, String title, String tutor, Calendar fromDate, Calendar toDate) {
		super();
		this.id = id;
		this.title = title;
		this.tutor = tutor;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	/**
	 * 
	 * @param id
	 *            as Integer format
	 *            
	 */
	public Stage(String id) {
		this.id = Integer.parseInt(id);
	}
	
	public Stage() {
		super();
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	/**
	 * 
	 * @param id
	 *            as Integer format
	 *            
	 */
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public Calendar getFromDate() {
		return fromDate;
	}

	public void setFromDate(Calendar fromDate) {
		this.fromDate = fromDate;
	}
	
	/**
	 * 
	 * @param fromDate
	 *            as dd/mm/yyyy format
	 * @throws ParseException
	 */
	public void setFromDate(String toDate) throws ParseException {
		this.toDate = CalendarUtil.toCalendar(toDate);
	}
	
	public Calendar getToDate() {
		return toDate;
	}

	public void setToDate(Calendar toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * 
	 * @param toDate
	 *            as dd/mm/yyyy format
	 * @throws ParseException
	 */
	public void setToDate(String toDate) throws ParseException {
		this.toDate = CalendarUtil.toCalendar(toDate);
	}
	
	public String getHeader() {
		return HEADER;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
		result = prime * result + ((tutor == null) ? 0 : tutor.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stage other = (Stage) obj;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (toDate == null) {
			if (other.toDate != null)
				return false;
		} else if (!toDate.equals(other.toDate))
			return false;
		if (tutor == null) {
			if (other.tutor != null)
				return false;
		} else if (!tutor.equals(other.tutor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stage [id=" + id + ", title=" + title + ", tutor=" + tutor + ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}

	public String toCSV() {
		return id + ";" + title + ";" + tutor + ";" + CalendarUtil.toString(fromDate) + ";" + CalendarUtil.toString(toDate) + ";";
	}

	public String getKey() {
		return String.valueOf(id);
	}

}
