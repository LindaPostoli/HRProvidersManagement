package it.synclab.hrpm.bootstrap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import it.synclab.hrpm.enumeration.ChannelType;
import it.synclab.hrpm.factory.ChannelFactory;
import it.synclab.hrpm.factory.FileNameFactory;
import it.synclab.hrpm.model.Candidate;
import it.synclab.hrpm.model.Channel;
import it.synclab.hrpm.model.Entity;
import it.synclab.hrpm.model.Rating;

public class FileManager {

	private static void newFile(String fileName, String header) {
		File file = new File(fileName);
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
		newFile(FileNameFactory.getFileName(Candidate.class), Candidate.HEADER);

		for (ChannelType channelType : ChannelType.values()) {
			Channel channel = ChannelFactory.getInstance(channelType);
			newFile(FileNameFactory.getFileName(channel.getClass()), channel.getHeader());
		}

		newFile(FileNameFactory.getFileName(Rating.class), Rating.HEADER);
	}

	public void insert(Entity obj) {
		String fileName = FileNameFactory.getFileName(obj.getClass());

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

/*
 * TO CHANGE
 * 
 * public static void delete(Entity obj) throws IOException {
 * 
 * String fileName = FileNameFactory.BASEPATH + obj.getClass().getSimpleName() +
 * ".csv"; BufferedReader br = new BufferedReader(new FileReader(fileName));
 * FileWriter writer = new FileWriter(fileName); String line = ""; String key =
 * ((Candidate) obj).getKey(); if (obj instanceof Candidate) { while ((line =
 * br.readLine()) != null) { if ((line.split(";")[0]).equals(key)) //
 * entity.equals(obj) writer.write("");
 * 
 * }
 * 
 * } }
 * 
 * 
 * 
 * 
 * public static void update(Entity obj) throws IOException {
 * 
 * String fileName = FileNameFactory.BASEPATH + obj.getClass().getSimpleName() +
 * ".csv"; BufferedReader br = new BufferedReader(new FileReader(fileName));
 * FileWriter writer = new FileWriter(fileName);
 * 
 * }
 * 
 * }
 */