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
@Table(name = "PROVIDER")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "getAllProvider", query = "select p from Provider p"),
		@NamedQuery(name = "getProvider", query = "select p from Provider p where p.eMail = :eMail"),
		@NamedQuery(name = "getByCandidateJobWebsite", query = "select p from Provider p where p.candidate.eMail = :eMail"),
		@NamedQuery(name = "getByCityProvider", query = "select p from Provider p where p.city = :city"),
		@NamedQuery(name = "getByNameProvider", query = "select p from Provider p where p.name = :name"),
		@NamedQuery(name = "deleteProvider", query = "select p from Provider p where p.eMail = :eMail"),
		@NamedQuery(name = "deleteAllProvider", query = "delete from Provider p") })
public class Provider implements Channel {

	private String eMail;
	private String name;
	private String address;
	private String zipCode;
	private String city;
	private String country;
	private String phoneNumber;

	@OneToOne
	@JoinColumn(name = "CANDIDATE_ID")
	private Candidate candidate;

	public Provider(String eMail) {
		this.eMail = eMail;
	}

	public Provider() {
		super();
	}
	
	@Id
	@Column(name = "PROVIDER_ID", unique = true, nullable = false)
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
		Provider other = (Provider) obj;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Provider [eMail=" + eMail + ", name=" + name + ", address=" + address + ", zipCode=" + zipCode
				+ ", city=" + city + ", country=" + country + ", phoneNumber=" + phoneNumber + ", candidate="
				+ candidate + "]";
	}
	
	

}
