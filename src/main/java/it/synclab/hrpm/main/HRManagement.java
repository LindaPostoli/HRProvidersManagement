package it.synclab.hrpm.main;

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
	
	private static void bootstrap() {
		ConnectionCriteria criteria = ConnectionCriteria.FILE;
		CandidateService cs = new CandidateService(criteria);
		// cs.insert(object);
	}
	
	ChannelFactory cf= new ChannelFactory();
	Channel synclab= cf.getInstance(ChannelType.COMPANY);
	Candidate linda= new Candidate("pstlnd87z100l", synclab);
	
	
	
	
}
