package it.synclab.hrpm.regex;

import java.util.regex.Pattern;

public class RegExpUtil {

	private static final String nameRegex = "[A-Z]+[a-z]*";
	private static final String surnameRegex = "[A-Z]+[a-z]*";
	private static final String taxCodeRegex = "[a-zA-Z]{6}\\d\\d[a-zA-Z]\\d\\d[a-zA-Z]\\d\\d\\d[a-zA-Z]";
	private static final String phoneNumberRegex = "\\++39+3+[0-9]{9}";
	private static final String eMailRegex = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
	private static final String addressRegex = "[a-zA-Z\\ ]*+ +[0-9]*";
	private static final String zipCodeRegex = "[0-9]{5}";
	private static final String cityRegex = "[A-Z]+[a-z]*";
	private static final String countryRegex = "[A-Z]+[a-z]*";
	private static final String dateFormatRegex = "(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)\\d\\d";
	private static final String birthPlaceRegex = "[A-Z]+[a-z]*";
	private static final String urlRegex = "http\\://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,3}(/\\S*)?";

	private static Pattern p;
	
	public static boolean isValidRegexFormat(String field) {

		return p.matcher(field).matches();
	}

	public static boolean checkDateFormat(String date) {
		p = Pattern.compile(dateFormatRegex);
		return isValidRegexFormat(date);
	}

	public static boolean checkNameFormat(String name) {
		p = Pattern.compile(nameRegex);
		return isValidRegexFormat(name);
	}

	public static boolean checkSurnameFormat(String surname) {
		p = Pattern.compile(surnameRegex);
		return isValidRegexFormat(surname);
	}

	public static boolean checkTaxCodeFormat(String taxCode) {
		p = Pattern.compile(taxCodeRegex);
		return isValidRegexFormat(taxCode);
	}

	public static boolean checkPhoneNumberFormat(String phoneNumber) {
		p = Pattern.compile(phoneNumberRegex);
		return isValidRegexFormat(phoneNumber);
	}

	public static boolean checkEMmailFormat(String eMail) {
		p = Pattern.compile(eMailRegex);
		return isValidRegexFormat(eMail);
	}

	public static boolean checkAddressFormat(String address) {
		p = Pattern.compile(addressRegex);
		return isValidRegexFormat(address);
	}

	public static boolean checkZipCodeFormat(String zipCode) {
		p = Pattern.compile(zipCodeRegex);
		return isValidRegexFormat(zipCode);
	}

	public static boolean checkCityFormat(String city) {
		p = Pattern.compile(cityRegex);
		return isValidRegexFormat(city);
	}

	public static boolean checkCountryFormat(String country) {
		p = Pattern.compile(countryRegex);
		return isValidRegexFormat(country);
	}

	public static boolean checkBirthPlaceFormat(String birthPlace) {
		p = Pattern.compile(birthPlaceRegex);
		return isValidRegexFormat(birthPlace);
	}

	public static boolean checkUrlFormat(String url) {
		p = Pattern.compile(urlRegex);
		return isValidRegexFormat(url);
	}

}
