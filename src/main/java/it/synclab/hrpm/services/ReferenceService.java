package it.synclab.hrpm.services;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import it.synclab.hrpm.model.Reference;

public class ReferenceService extends PersistentService<Reference> {

	public ReferenceService() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		super();
	}
	
	public List<Reference> getByCandidate(String eMail){
		Query query= session.getNamedQuery("getByCandidateReference");
		query.setParameter("eMail", eMail);
		return (List<Reference>) query.list();
	}
	
	

}
