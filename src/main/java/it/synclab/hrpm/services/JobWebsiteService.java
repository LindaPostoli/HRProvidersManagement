package it.synclab.hrpm.services;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import it.synclab.hrpm.model.JobWebsite;

public class JobWebsiteService extends PersistentService<JobWebsite> {

	public JobWebsiteService() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		super();
	}
	
	@SuppressWarnings("unchecked")
	public List<JobWebsite> getByCandidate(String eMail){
		Query query= session.getNamedQuery("getByCandidateJobWebsite");
		query.setParameter("eMail", eMail);
		return (List<JobWebsite>) query.list();
	}
	
	
	

}
