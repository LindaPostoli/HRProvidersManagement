package it.synclab.hrpm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "JOB_WEBSITES")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "getAllJobWebsite", query = "select j from JobWebsite j"),
		@NamedQuery(name = "getJobWebsite", query = "select j from JobWebsite j where j.url = :url "),
		@NamedQuery(name = "getByCandidateJobWebsite", query = "select j from JobWebsite j where j.candidate.eMail = :eMail"),
		@NamedQuery(name = "deleteAllJobWebsite", query = "delete from JobWebsite j") })
public class JobWebsite {

	private String url;
	private String name;
	private Candidate candidate;

	public JobWebsite(String url) {
		this.url = url;
	}

	@Id
	@Column(name = "JOB_WEBSITE_ID")
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	@OneToOne
	@JoinColumn(name = "CANDIDATE_ID")
	public Candidate getCandidate() {
		return candidate;
	}
	
	public void setCandidate(Candidate candidate) {
		this.candidate=candidate;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		JobWebsite other = (JobWebsite) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JobWebsite [url=" + url + ", name=" + name + ", candidate=" + candidate + "]";
	}

}
