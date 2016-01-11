package it.synclab.hrpm.main;

import it.synclab.hrpm.enumeration.ConnectionCriteria;
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
	
}
