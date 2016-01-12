package it.synclab.hrpm.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ReadCsv {

	private static final String SEPARATOR = ";";

	public Calendar setBirthDateString(String birthDate) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		Calendar date = Calendar.getInstance();
		date.setTime(format.parse(birthDate));
		return date;
	}

	public String ConvertCalendarToString(Calendar BirthDate) {
		Calendar birthDate = Calendar.getInstance();
		String birthDateToString = birthDate.toString();

		return birthDateToString;
	}

	public Candidate createObj(String[] data) throws ParseException {
		String taxCode = data[0];
		String name = data[1];
		String surname = data[2];
		String birthDateString = data[3];
		String birthPlace = data[4];
		String address = data[5];
		String zipCode = data[6];
		String city = data[7];
		String country = data[8];
		String phoneNumber = data[9];
		String eMail = data[10];
		Calendar birthDate= Calendar.getInstance();
		birthDate=setBirthDateString(birthDateString);

		return new Candidate(taxCode, name, surname, birthDate, birthPlace, address, zipCode, city, country, phoneNumber, eMail);
	}

	public void read() {

		String csvFile = "Candidate.csv";
		BufferedReader file = null;

		String line = "";
		Map<String, Object> candidateMap = new HashMap<String, Object>();

		try {

			file = new BufferedReader(new FileReader(csvFile));
			while ((line = file.readLine()) != null) {

				String[] candidate = line.split(SEPARATOR);

				Candidate candidateObj = createObj(candidate);

				candidateMap.put(candidate[0], candidateObj);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
