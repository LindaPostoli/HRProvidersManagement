package it.synclab.hrpm.factory;

import it.synclab.hrpm.model.Channel;
import it.synclab.hrpm.model.UnsolicitedApplication;
import it.synclab.hrpm.model.JobWebsite;
import it.synclab.hrpm.model.Provider;
import it.synclab.hrpm.model.University;
import it.synclab.hrpm.model.Stage;
import it.synclab.hrpm.model.Reference;
import it.synclab.hrpm.enumeration.ChannelType;
import it.synclab.hrpm.exception.ChannelNotFoundException;

public class ChannelFactory {

	public static final Channel getInstance(ChannelType channelID) {

		
		switch (channelID) {
		case PROVIDER:
			return new Provider();
		case UNSOLICITED_APPLICATION:
			return new UnsolicitedApplication();
		case JOB_WEBSITE:
			return new JobWebsite();
		case UNIVERSITY:
			return new University();
		case STAGE:
			return new Stage();
		case REFERENCE:
			return new Reference();
		}
		throw new ChannelNotFoundException(channelID.name() + " not founded!");
		

	}

}
