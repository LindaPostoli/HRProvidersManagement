package it.synclab.hrpm.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import it.synclab.hrpm.enumeration.ChannelType;

public class Candidate implements Entity {

	private String taxCode;
	private String name, surname;
	private Calendar birthDate;
	private String birthPlace;
	private String address, zipCode, city, country;
	public static final String HEADER = "TAX_CODE;NAME;SURNAME;BIRTH_DATE;BIRTH_PLACE;ADDRESS;ZIP_CODE;CITY;COUNTRY;PHONE_NUMBER;EMAIL;";
	private String phoneNumber, eMail; // TODO: control phoneNumber.length()=10

	private Rating rating;
	private ChannelType channelType;

	public Candidate(String taxCode) {
		this.taxCode = taxCode;
	}

	public Candidate(String taxCode, String name, String surname, Calendar birthDate, String birthPlace, String address,
			String zipCode, String city, String country, String phoneNumber, String eMail, Rating rating,
			ChannelType channelType) {
		this.taxCode = taxCode;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.birthPlace = birthPlace;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
		this.rating = rating;
		this.channelType = channelType;
	}

	public Candidate(String taxCode, String name, String surname, Calendar birthDate, String birthPlace, String address,
			String zipCode, String city, String country, String phoneNumber, String eMail) {
		this.taxCode = taxCode;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.birthPlace = birthPlace;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;

	}

	public Candidate(String taxCode, ChannelType channelType) {
		this.taxCode = taxCode;
		this.channelType = channelType;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
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
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		Calendar date = Calendar.getInstance();
		date.setTime(format.parse(birthDate));
		this.birthDate = date;
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

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public ChannelType getChannelType() {
		return channelType;
	}

	public void setChannelType(ChannelType channelType) {
		this.channelType = channelType;
	}

	public static String getHeader() {
		return HEADER;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((birthPlace == null) ? 0 : birthPlace.hashCode());
		result = prime * result + ((channelType == null) ? 0 : channelType.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((taxCode == null) ? 0 : taxCode.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (birthPlace == null) {
			if (other.birthPlace != null)
				return false;
		} else if (!birthPlace.equals(other.birthPlace))
			return false;
		if (channelType == null) {
			if (other.channelType != null)
				return false;
		} else if (!channelType.equals(other.channelType))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
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
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Candidate [taxCode=" + taxCode + ", name=" + name + ", surname=" + surname + ", birthDate=" + birthDate
				+ ", birthPlace=" + birthPlace + ", address=" + address + ", zipCode=" + zipCode + ", city=" + city
				+ ", country=" + country + ", phoneNumber=" + phoneNumber + ", eMail=" + eMail + ", rating=" + rating
				+ ", channel=" + channelType + "]";
	}

	public String toCSV() {
		return taxCode + ";" + name + ";" + surname + ";" + birthDate + ";" + birthPlace + ";" + address + ";" + zipCode
				+ city + ";" + country + ";" + phoneNumber + ";" + eMail + ";";
	}

	public String getKey() {
		return taxCode;
	}
}