package it.synclab.hrpm.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class ReadCsv {

	private static final String SEPARATOR = ";";

	public Candidate createObj(String[] data) throws ParseException {

		Candidate candidate = new Candidate(data[0]);
		candidate.setName(data[1]);
		candidate.setSurname(data[2]);
		candidate.setBirthDate(data[3]);
		candidate.setAddress(data[4]);
		candidate.setZipCode(data[6]);
		candidate.setCity(data[7]);
		candidate.setCountry(data[8]);
		candidate.setPhoneNumber(data[9]);
		candidate.seteMail(data[10]);

		return candidate;
	}

	public Map<String, Candidate> read() {

		String csvFile = "Candidate.csv";
		BufferedReader file = null;

		String line = "";
		Map<String, Candidate> candidateMap = new HashMap<String, Candidate>();

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
		return candidateMap;
	}

}
