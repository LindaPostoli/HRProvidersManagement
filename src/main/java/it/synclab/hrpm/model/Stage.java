package it.synclab.hrpm.model;

import java.text.ParseException;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import it.synclab.hrpm.util.CalendarUtil;

@Entity
@Table(name = "STAGES")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "getAllStage", query = "select s from Stage s"),
		@NamedQuery(name = "getStage", query = "select s from Stage s where s.id = :id"),
		@NamedQuery(name = "getByTutorStage", query = "select s from Stage s where s.tutor = :tutor"),
		@NamedQuery(name = "deleteAllStage", query = "delete from Stage s")})
public class Stage {

	private long id;
	private String title;
	private String tutor;
	private Calendar fromDate;
	private Calendar toDate;
	private Candidate candidate;

	public Stage() {
	}

	@Id
	@GeneratedValue
	@Column(name = "STAGER_ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name = "CANDIDATE_ID")
	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stage [id=" + id + ", title=" + title + ", tutor=" + tutor + ", fromDate=" + fromDate + ", toDate="
				+ toDate + ", candidate=" + candidate + "]";
	}

}
