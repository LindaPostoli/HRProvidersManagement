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
@Table(name = "REFERENCES_")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "getAllReference", query = "select r from Reference r"),
		@NamedQuery(name = "getReference", query = "select r from Reference r where r.eMail = :eMail"),
		@NamedQuery(name = "getByCandidateReference", query = "select r from Reference r where r.candidate.eMail = :eMail"),
		@NamedQuery(name = "deleteAllReference", query = "delete from Reference r") })
public class Reference {

	private String eMail;
	private String name;
	private String surname;
	private String referenceCompany;
	private String phoneNumber;
	private StringBuffer opinion;
	private Candidate candidate;

	@Id
	@Column(name = "DEFERENCE_ID")
	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getReferenceCompany() {
		return referenceCompany;
	}

	public void setReferenceCompany(String referenceCompany) {
		this.referenceCompany = referenceCompany;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public StringBuffer getOpinion() {
		return opinion;
	}

	public void setOpinion(StringBuffer opinion) {
		this.opinion = opinion;
	}

	@OneToOne
	@JoinColumn(name = "CANDIDATE_ID")
	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((candidate == null) ? 0 : candidate.hashCode());
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
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
		Reference other = (Reference) obj;
		if (candidate == null) {
			if (other.candidate != null)
				return false;
		} else if (!candidate.equals(other.candidate))
			return false;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reference [eMail=" + eMail + ", name=" + name + ", surname=" + surname + ", referenceCompany="
				+ referenceCompany + ", phoneNumber=" + phoneNumber + ", opinion=" + opinion + ", candidate="
				+ candidate + "]";
	}

}
