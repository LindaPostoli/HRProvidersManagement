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
@Table(name = "UNIVERSITY")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "getAllUniversity", query = "select u from University u"),
	@NamedQuery(name = "getUniversity", query = "select u from University u where u.eMail = :eMail"),
	@NamedQuery(name = "getByNameUniversity", query = "select u from University u where u.name = :name"),
	@NamedQuery(name = "getByCityUniversity", query = "select u from University u where u.city = :city"),
	@NamedQuery(name = "getByFieldOfStudyUniversity", query = "select u from University u where u.fieldOfStudy = :fieldOfStudy"),
	@NamedQuery(name = "deleteAllUniversity", query = "delete from University u"),
	@NamedQuery(name = "deleteUniversity", query = "delete u from University u") })
public class University implements Channel {

	private String name;
	private String address;
	private String zipCode;
	private String city;
	private String country;
	private String phoneNumber;
	private String eMail;
	private String fieldOfStudy;

	@OneToOne
	@JoinColumn(name = "CANDIDATE_ID")
	private Candidate candidate;

	public University(String name) {
		this.name = name;
	}

	public University() {
		super();
	}

	@Id
	@Column(name = "UNIVERSITY_ID", unique = true, nullable = false)
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

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getFieldOfStudy() {
		return fieldOfStudy;
	}

	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		University other = (University) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "University [name=" + name + ", address=" + address + ", zipCode=" + zipCode + ", city=" + city
				+ ", country=" + country + ", phoneNumber=" + phoneNumber + ", eMail=" + eMail + ", fieldOfStudy="
				+ fieldOfStudy + ", candidate=" + candidate + "]";
	}

}
