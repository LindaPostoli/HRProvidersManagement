package it.synclab.hrpm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Rating{

	private long id;
	private int professionality;
	private int personality;
	private int general;
	private String note;
	
	@OneToOne 
	private Candidate candidate;

	public Rating() {
		
	}

	@Id @GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "RATING_ID", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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