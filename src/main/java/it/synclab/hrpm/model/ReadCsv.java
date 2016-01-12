package it.synclab.hrpm.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReadCsv {

	private static final String SEPARATOR = ";";
	
	public Calendar setBirthDateString(String birthDate) throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("dd/mm/yyyy");
		Calendar date=Calendar.getInstance();
		date.setTime(format.parse(birthDate));
		return date;
	}
	
	public String ConvertCalendarToString(Calendar BirthDate) {
		Calendar birthDate = Calendar.getInstance();
		String birthDateToString = birthDate.toString();
		
		return birthDateToString;	
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
				Calendar data=Calendar.getInstance();
				try {
					data = setBirthDateString(candidate[3]);
					
				} catch (ParseException e) {
					System.out.println(e);
				}
//				String date = 
				Candidate candidateObj = new Candidate(candidate[0], candidate[1], candidate[2], data, candidate[4], 
						candidate[5], candidate[6], candidate[7], candidate[8],	candidate[9], candidate[10]);
				
				
				candidateMap.put(candidate[0], candidateObj);
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
