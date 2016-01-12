package it.synclab.hrpm.main;


import java.text.ParseException;

import it.synclab.hrpm.bootstrap.FileManager;
import it.synclab.hrpm.enumeration.ChannelType;
import it.synclab.hrpm.enumeration.ConnectionCriteria;
import it.synclab.hrpm.factory.ChannelFactory;
import it.synclab.hrpm.model.Candidate;
import it.synclab.hrpm.model.Channel;
import it.synclab.hrpm.model.Company;

import it.synclab.hrpm.services.CandidateService;

public class HRManagement {
	public static void main(String[] args) throws Exception {
		bootstrap();
	}

	private static void bootstrap() throws ParseException {
		bootstrap(ConnectionCriteria.FILE);
	}

	private static void bootstrap(ConnectionCriteria criteria) throws ParseException {
		if (criteria == ConnectionCriteria.FILE)
			FileManager.init();

		CandidateService cs = new CandidateService(criteria);
		ChannelFactory cf= new ChannelFactory();
		Channel synclab= cf.getInstance(ChannelType.COMPANY);
		synclab.setName("SyncLab");
		Candidate candidate= new Candidate("pstlnd87z100l", synclab);
		candidate.setBirthDateString("03/05/1987");
		cs.insert(candidate);
		
		System.out.println(candidate.getChannel().toCSV());
	}

	
	
	
	
	



}
