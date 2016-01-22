package it.synclab.hrpm.main;

import java.awt.Transparency;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import it.synclab.hrpm.bootstrap.DBManager;
import it.synclab.hrpm.bootstrap.FileManager;
import it.synclab.hrpm.connectionPool.ConnectionPool;
import it.synclab.hrpm.enumeration.ChannelType;
import it.synclab.hrpm.enumeration.ConnectionCriteria;
import it.synclab.hrpm.factory.ChannelFactory;
import it.synclab.hrpm.model.Candidate;
import it.synclab.hrpm.model.Provider;
import it.synclab.hrpm.model.Rating;
import it.synclab.hrpm.services.CandidateService;
import it.synclab.hrpm.services.ChannelService;
import it.synclab.hrpm.services.PersistentService;

public class HRManagement {
	public static void main(String[] args) throws Exception, ClassNotFoundException {

		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection conn1 = connectionPool.getConnection();
		connectionPool.releaseConnection(conn1);
		Connection conn2 = connectionPool.getConnection();
		Connection conn3 = connectionPool.getConnection();
		Connection conn4 = connectionPool.getConnection();
		Connection conn5 = connectionPool.getConnection();

		System.out.println(
				"Numero connessioni disponibili nel ConnectionPool: " + connectionPool.getConnectionNumberAvailable());

		FileManager fm = new FileManager();
		Rating r1 = new Rating(1, 5, 6, 6);
		Rating r2 = new Rating(2, 7, 8, 7);
		Rating r3 = new Rating(3, 10, 9, 9);
		Rating r4 = new Rating(4, 6, 9, 8);

		System.out.println(r1.toCSV());

		fm.insert(r1);
		fm.insert(r2);
		fm.insert(r3);
		fm.insert(r4);

		fm.delete(r1);
		fm.delete(r3);

		CandidateService cs = new CandidateService(ConnectionCriteria.FILE);

		Provider synclab = (Provider) ChannelFactory.getInstance(ChannelType.PROVIDER);

		// inserisci candidato e set attributi
		synclab.setName("SyncLab");
		Candidate candidate = new Candidate("hgjfaljv", ChannelType.PROVIDER);
		candidate.setBirthDate("03/05/1987");
		cs.insert(candidate);
		ChannelService chs = new ChannelService(ConnectionCriteria.FILE);
		chs.insert(synclab);

		Candidate candidate2 = new Candidate("hgjfsssjv", ChannelType.UNSOLICITED_APPLICATION);

		// bootstrap();

		

	}

	private static void bootstrap() throws ParseException, InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {
		bootstrap(ConnectionCriteria.DB);
	}

	private static void bootstrap(ConnectionCriteria criteria) throws ParseException, InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException {
		if (criteria == ConnectionCriteria.FILE)
			FileManager.init();
		else if (criteria == ConnectionCriteria.DB)
			DBManager.init();

	}

}
