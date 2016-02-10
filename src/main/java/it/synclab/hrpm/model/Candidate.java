package it.synclab.hrpm.model;

import java.text.ParseException;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import it.synclab.hrpm.util.CalendarUtil;
import it.synclab.hrpm.regex.RegExpUtil;

@Entity
@Table(name = "CANDIDATES")
@XmlRootElement
@NamedQueries({ 
	    @NamedQuery(name = "getAllCandidate", query = "select c from Candidate c"),
		@NamedQuery(name = "getCandidate", query = "select c from Candidate c where c.eMail = :eMail order by c.rating.general asc"),
		@NamedQuery(name = "getByRatingCandidate", query = "select c from Candidate c where c.rating.general > :general"),
		@NamedQuery(name = "getByCityCandidate", query = "select c from Candidate c order by c.city"),
		@NamedQuery(name = "getAllRatingsCandidate", query = "select c.rating from Candidate c where c.rating is not null"),
		@NamedQuery(name = "deleteAllCandidate", query = "delete from Candidate c") })
public class Candidate {

	private String eMail;
	private String taxCode;
	private String name;
	private String surname;
	private Calendar birthDate;// Annotation data
	private String birthPlace;// Annotation data
	private String address;
	private String zipCode;
	private String city;
	private String country;
	private String phoneNumber;
	private Rating rating;


	public Candidate(String eMail) {
		this.eMail = eMail;
	}

	@Id
	@Column(name = "CANDIDATE_ID")
	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		if (RegExpUtil.checkEMmailFormat(eMail))
			this.eMail = eMail;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		if (RegExpUtil.checkTaxCodeFormat(taxCode))
			this.taxCode = taxCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (RegExpUtil.checkNameFormat(name))
			this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if (RegExpUtil.checkSurnameFormat(surname))
			this.surname = surname;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * 
	 * @param birthDate
	 *            as dd/mm/yyyy format
	 * @throws ParseException
	 */
	public void setBirthDate(String birthDate) throws ParseException {
		if (RegExpUtil.checkDateFormat(birthDate))
			this.birthDate = CalendarUtil.toCalendar(birthDate);
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		if (RegExpUtil.checkBirthPlaceFormat(birthPlace))
			this.birthPlace = birthPlace;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (RegExpUtil.checkAddressFormat(address))
			this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		if (RegExpUtil.checkZipCodeFormat(zipCode))
			this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		if (RegExpUtil.checkCityFormat(city))
			this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		if (RegExpUtil.checkCountryFormat(country))
			this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if (RegExpUtil.checkPhoneNumberFormat(phoneNumber))
			this.phoneNumber = phoneNumber;
	}

	@OneToOne
	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
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
		Candidate other = (Candidate) obj;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Candidate [eMail=" + eMail + ", taxCode=" + taxCode + ", name=" + name + ", surname=" + surname
				+ ", birthDate=" + birthDate + ", birthPlace=" + birthPlace + ", address=" + address + ", zipCode="
				+ zipCode + ", city=" + city + ", country=" + country + ", phoneNumber=" + phoneNumber + ", rating="
				+ rating + "]";
	}

}