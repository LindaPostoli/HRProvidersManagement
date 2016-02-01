package it.synclab.hrpm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="UNSOLICITED_APP")
public class UnsolicitedApplication implements Channel {

	private long id;
	
	@OneToOne
	@JoinColumn(name="CANDIDATE_ID")
	  private Candidate candidate;
				
	public UnsolicitedApplication() {
		super();
	}
	
	public UnsolicitedApplication(String id){
		this.id = Integer.parseInt(id);
	}
		
	@Id @GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "UNSOLICITED_APP_ID", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		UnsolicitedApplication other = (UnsolicitedApplication) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "UnsolicitedApplication [id=" + id + ", candidate=" + candidate + "]";
	}

	
	
}
