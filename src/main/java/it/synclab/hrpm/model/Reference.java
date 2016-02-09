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
@Table(name="REFERENCE")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "getAllReference", query = "select r from Reference r"),
		@NamedQuery(name = "getReference", query = "select r from Reference r where r.eMail = :eMail"),
		@NamedQuery(name = "getBySurnameReference", query = "select r from Reference r where r.surname = :surname"),
		@NamedQuery(name = "getByReferenceCompanyReference", query = "select r from Reference r where r.referenceCompany = :referenceCompany"),
		@NamedQuery(name = "deleteAllReference", query = "delete from Reference r"),
		@NamedQuery(name = "deleteReference", query = "delete r from Reference r")
		})

public class Reference implements Channel {

	private String name;
	private String surname;
	private String referenceCompany;
	private String phoneNumber;
	private String opinion;
	private String eMail;
	
	@OneToOne
	@JoinColumn(name="CANDIDATE_ID")
	private Candidate candidate;
	
		
	public Reference(String eMail) {
		this.eMail = eMail;
	}

	public Reference() {
		super();
	}
	
	@Id
	@Column(name = "REFERENCE_ID", unique = true, nullable = false)
	public String getEMail() {
		return eMail;
	}

	public void setEMail(String eMail) {
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

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reference [name=" + name + ", surname=" + surname + ", referenceCompany=" + referenceCompany
				+ ", phoneNumber=" + phoneNumber + ", opinion=" + opinion + ", eMail=" + eMail + ", candidate="
				+ candidate + "]";
	}
	
	



	

}
