package it.synclab.hrpm.bootstrap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import it.synclab.hrpm.enumeration.ChannelType;
import it.synclab.hrpm.factory.ChannelFactory;
import it.synclab.hrpm.model.Candidate;
import it.synclab.hrpm.model.Channel;
import it.synclab.hrpm.model.Entity;
import it.synclab.hrpm.model.Rating;

public class FileManager {

	private static String candidateFileName = Candidate.class.getSimpleName() + ".csv";
	private static String ratingFileName = Rating.class.getSimpleName() + ".csv";
	public static final String BASEPATH = "hr" + File.separator;

	private static void newFile(String fileName, String header) {
		File file = new File(BASEPATH + fileName);
		if (file.exists() || header == null)
			return;

		FileWriter fw = null;
		try {
			if (!file.getParentFile().exists())
				file.getParentFile().mkdirs();
			file.createNewFile();
			fw = new FileWriter(file);
			fw.write(header + "\n");
			fw.flush();
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static final void init() {
		newFile(candidateFileName, Candidate.HEADER);

		for (ChannelType channelType : ChannelType.values()) {
			Channel channel = ChannelFactory.getInstance(channelType);
			newFile(channel.getClass().getSimpleName() + ".csv", channel.getHeader());
		}

		newFile(ratingFileName, Rating.HEADER);
	}

	public void insert(Entity obj) {

		String fileName = BASEPATH + obj.getClass().getSimpleName() + ".csv";

		try {
			FileWriter fw = new FileWriter(fileName, true);
			fw.write(obj.toCSV() + "\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
