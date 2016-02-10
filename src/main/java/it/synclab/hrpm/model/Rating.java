package it.synclab.hrpm.model;

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

@Entity
@Table(name = "RATINGS")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "getAllRating", query = "select r from Rating r"),
		@NamedQuery(name = "getRating", query = "select r from Rating r where r.candidate.eMail = :eMail"),
		@NamedQuery(name = "getByGeneralRating", query = "select r from Rating r where r.general > :general order by r.general"),
		@NamedQuery(name = "deleteAllRating", query = "delete from Rating r") })
public class Rating {

	private long id;
	private int professionality;
	private int personality;
	private int general;
	private String note;
	private Candidate candidate;

	public Rating() {
	}

	@Id
	@GeneratedValue
	@Column(name = "RATING_ID")
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

	public int getProfessionality() {
		return professionality;
	}

	public void setProfessionality(int professionality) {
		this.professionality = professionality;
	}

	public int getPersonality() {
		return personality;
	}

	public void setPersonality(int personality) {
		this.personality = personality;
	}

	public int getGeneral() {
		return general;
	}

	public void setGeneral(int general) {
		this.general = general;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
		Rating other = (Rating) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", professionality=" + professionality + ", personality=" + personality
				+ ", general=" + general + ", note=" + note + "]";
	}

}