package it.synclab.hrpm.model;

import java.sql.Date;

public class Stage implements Channel {

	private String title, tutor;
	private Date fromDate, toDate;
	private static final String HEADER = " TITLE; TUTOR; FROM_DATE; TO_DATE;";

	public Stage(String title, String tutor, Date fromDate, Date toDate) {
		super();
		this.title = title;
		this.tutor = tutor;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public Stage() {
		super();
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

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public static String getHeader() {
		return HEADER;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
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
		return "Stage [title=" + title + ", tutor=" + tutor + ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}

	public String toCSV() {
		return title + ";" + tutor + ";" + fromDate + ";" + toDate + ";";
	}

}
