package it.synclab.hrpm.model;

public class Reference implements Channel {

	private String name, surname, referenceCompany, phoneNumber, opinion;
	private static final String HEADER = "NAME; SURNAME; REFERENCE_COMPANY; PHONE_NUMBER; OPINION";

	public Reference(String name, String surname, String referenceCompany, String phoneNumber, String opinion) {
		this.name = name;
		this.surname = surname;
		this.referenceCompany = referenceCompany;
		this.phoneNumber = phoneNumber;
		this.opinion = opinion;
	}

	public Reference() {
		super();
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

	public static String getHeader() {
		return HEADER;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((opinion == null) ? 0 : opinion.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((referenceCompany == null) ? 0 : referenceCompany.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (opinion == null) {
			if (other.opinion != null)
				return false;
		} else if (!opinion.equals(other.opinion))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (referenceCompany == null) {
			if (other.referenceCompany != null)
				return false;
		} else if (!referenceCompany.equals(other.referenceCompany))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reference [name=" + name + ", surname=" + surname + ", referenceCompany=" + referenceCompany
				+ ", phoneNumber=" + phoneNumber + ", opinion=" + opinion + "]";
	}

	public String toCSV() {
		return name + ";" + surname + ";" + referenceCompany + ";" + phoneNumber + ";" + opinion + ";";
	}

}