package it.synclab.hrpm.main;

import java.text.ParseException;

import it.synclab.hrpm.bootstrap.FileManager;
import it.synclab.hrpm.connectionPool.ConnectionPool;
import it.synclab.hrpm.core.Connection;
import it.synclab.hrpm.enumeration.ChannelType;
import it.synclab.hrpm.enumeration.ConnectionCriteria;
import it.synclab.hrpm.factory.ChannelFactory;
import it.synclab.hrpm.model.Candidate;
import it.synclab.hrpm.model.Provider;
import it.synclab.hrpm.model.UnsolicitedApplication;
import it.synclab.hrpm.services.CandidateService;
import it.synclab.hrpm.services.ChannelService;

public class HRManagement {
	public static void main(String[] args) throws Exception {
		
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection conn1 = connectionPool.getConnection();
		connectionPool.releaseConnection(conn1);
		Connection conn2 = connectionPool.getConnection();
		Connection conn3 = connectionPool.getConnection();
		Connection conn4 = connectionPool.getConnection();
		Connection conn5 = connectionPool.getConnection();
		
		System.out.println("Numero connessioni disponibili: " + connectionPool.getConnectionNumberAvailable());
				
		//bootstrap();
	}

	private static void bootstrap() throws ParseException {
		bootstrap(ConnectionCriteria.FILE);
	}

	private static void bootstrap(ConnectionCriteria criteria) throws ParseException {
		if (criteria == ConnectionCriteria.FILE)
			FileManager.init();

		CandidateService cs = new CandidateService(criteria);

		Provider synclab = (Provider) ChannelFactory.getInstance(ChannelType.PROVIDER);
		
		
		synclab.setName("SyncLab");
		Candidate candidate = new Candidate("hgjfaljv", ChannelType.PROVIDER);

		
		
		candidate.setBirthDate("03/05/1987");

		cs.insert(candidate);
		ChannelService chs = new ChannelService(criteria);
		chs.insert(synclab);
	
		Candidate candidate2 = new Candidate("hgjfsssjv", ChannelType.UNSOLICITED_APPLICATION);
		
	}

}
