package it.synclab.hrpm.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegExpUtil {

	private static final String nameRegex = "[A-Z]+[a-z]*";
	private static final String surnameRegex = "[A-Z]+[a-z]*";
	private static final String taxCodeRegex = "[a-zA-Z]{6}\\d\\d[a-zA-Z]\\d\\d[a-zA-Z]\\d\\d\\d[a-zA-Z]";
	private static final String phoneNumberRegex = "\\++39+3+[0-9]{7}";
	private static final String eMailRegex = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
	private static final String addressRegex = "[a-zA-Z\\ ]*+ +[0-9]*";
	private static final String zipCodeRegex = "[0-9]{5}";
	private static final String cityRegex = "[A-Z]+[a-z]*";
	private static final String countryRegex = "[A-Z]+[a-z]*";
	private static final String dateFormatRegex = "(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)\\d\\d";
	private static final String birthPlaceRegex = "[A-Z]+[a-z]*";
	private static final String urlRegex = "http\\://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,3}(/\\S*)?";

	public boolean checkNameFormat(String name) {

		return true;
	}

	public boolean checkSurnameFormat(String surname) {

		return true;
	}

	public boolean checkTaxCodeFormat(String taxCode) {

		return true;
	}

	public boolean checkPhoneNumberFormat(String phoneNumber) {

		return true;
	}

	public boolean checkEMmailFormat(String eMail) {

		return true;
	}

	public boolean checkAddressFormat(String address) {

		return true;
	}

	public boolean checkZipCodeFormat(String zipCode) {

		return true;
	}

	public boolean checkCityFormat(String city) {

		return true;
	}

	public boolean checkCountryFormat(String country) {

		return true;
	}

	public boolean checkBirthPlaceFormat(String birthPlace) {

		return true;
	}

	public boolean checkUrlFormat(String url) {

		return true;
	}

}
