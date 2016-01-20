package it.synclab.hrpm.regex;

import java.util.regex.Matcher;
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
	private static Matcher m;
	
	
	public static boolean validRegexFormat(String field, String regex) {
		p = Pattern.compile(regex);
		m = p.matcher(field);
		
		return m.matches();
	}
	
	public static boolean checkNameFormat(String name) {
		
		return validRegexFormat(name, nameRegex);
	}

	public static boolean checkSurnameFormat(String surname) {
		
		return validRegexFormat(surname, surnameRegex);
	}

	public static boolean checkTaxCodeFormat(String taxCode) {
		
		return validRegexFormat(taxCode, taxCodeRegex);
	}

	public static boolean checkPhoneNumberFormat(String phoneNumber) {
		
		return validRegexFormat(phoneNumber, phoneNumberRegex);
	}

	public static boolean checkEMmailFormat(String eMail) {
		
		return validRegexFormat(eMail, eMailRegex);
	}

	public static boolean checkAddressFormat(String address) {
		
		return validRegexFormat(address, addressRegex);
	}

	public static boolean checkZipCodeFormat(String zipCode) {
		
		return validRegexFormat(zipCode, zipCodeRegex);
	}

	public static boolean checkCityFormat(String city) {
		
		return validRegexFormat(city, cityRegex);
	}

	public static boolean checkCountryFormat(String country) {
		
		return validRegexFormat(country, countryRegex);
	}

	public static boolean checkBirthPlaceFormat(String birthPlace) {

		return validRegexFormat(birthPlace, birthPlaceRegex);
	}

	public static boolean checkUrlFormat(String url) {
		
		return validRegexFormat(url, urlRegex);
	}

}
