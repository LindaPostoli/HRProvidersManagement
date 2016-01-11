package it.synclab.hrpm.services;

import it.synclab.hrpm.enumeration.ConnectionCriteria;
import it.synclab.hrpm.model.Channel;

public class ChannelService extends PersistentService<Channel> {
	
	public ChannelService(ConnectionCriteria criteria) {
		super(criteria);
	}
	
}
