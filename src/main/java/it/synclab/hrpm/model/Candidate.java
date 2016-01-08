package it.synclab.hrpm.model;

import java.util.Calendar;

public class Candidate {

	private String taxCode;
	private String surname;
	private String name;
	private Calendar birthDate;
	private String birthPlace;
	private String address;
	private String phoneNumber; // TO DO: control phoneNumber.length()=10
	private String eMail;

	private Rating rating;
	// TO DO: private enum channel

	public Candidate(String taxCode, String surname, String name, Calendar birthDate, String birthPlace, String address,
			String phoneNumber, String eMail, Rating rating) {
		super();
		this.taxCode = taxCode;
		this.surname = surname;
		this.name = name;
		this.birthDate = birthDate;
		this.birthPlace = birthPlace;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
		this.rating = rating;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((taxCode == null) ? 0 : taxCode.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (taxCode == null) {
			if (other.taxCode != null)
				return false;
		} else if (!taxCode.equals(other.taxCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Candidate [taxCode=" + taxCode + ", surname=" + surname + ", name=" + name + ", birthDate=" + birthDate
				+ ", birthPlace=" + birthPlace + ", address=" + address + ", phoneNumber=" + phoneNumber + ", eMail="
				+ eMail + ", rating=" + rating + "]";
	}

}
