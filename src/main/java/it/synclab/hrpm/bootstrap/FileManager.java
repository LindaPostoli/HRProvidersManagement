package it.synclab.hrpm.bootstrap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import it.synclab.hrpm.enumeration.ChannelType;
import it.synclab.hrpm.enumeration.ConnectionCriteria;
import it.synclab.hrpm.exception.KeyNotFoundException;
import it.synclab.hrpm.factory.ChannelFactory;
import it.synclab.hrpm.factory.FileNameFactory;
import it.synclab.hrpm.factory.ParserManagerFactory;
import it.synclab.hrpm.model.Candidate;
import it.synclab.hrpm.model.Channel;
import it.synclab.hrpm.model.Entity;
import it.synclab.hrpm.model.Rating;
import it.synclab.hrpm.parser.*;

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

	public void delete(Entity obj) throws FileNotFoundException, IOException, ClassNotFoundException {
		final String nameFileSorg = FileNameFactory.BASEPATH + obj.getClass().getSimpleName() + ".csv";
		final String nameFileDest = FileNameFactory.BASEPATH + obj.getClass().getSimpleName() + "Copy.csv";

		BufferedReader readerSorg = new BufferedReader(new FileReader(nameFileSorg));
		File fileDest = new File(nameFileDest);
		FileWriter writerDest = new FileWriter(fileDest);

		ParserManager parserManager = ParserManagerFactory.getInstance(obj.getClass().getSimpleName());

		String line = "";
		line = readerSorg.readLine();
		while ((line = readerSorg.readLine()) != null) {
			try {
				if (!(parserManager.parse(line).equals(obj)))
					writerDest.write(line + "\n");
			} catch (KeyNotFoundException e) {
				e.toString();
			}
		}
		writerDest.close();

		BufferedReader readerDest = new BufferedReader(new FileReader(fileDest));
		FileWriter writerSorg = new FileWriter(nameFileSorg);
		writerSorg.write(Rating.HEADER + "\n");

		while ((line = readerDest.readLine()) != null)
			writerSorg.write(line + "\n");

		readerSorg.close();
		readerDest.close();
		writerSorg.close();

		fileDest.delete();
	}

	public void update(Entity obj) throws IOException, KeyNotFoundException {
		final String nameFileSorg = FileNameFactory.BASEPATH + obj.getClass().getSimpleName() + ".csv";
		final String nameFileDest = FileNameFactory.BASEPATH + obj.getClass().getSimpleName() + "Copy.csv";

		BufferedReader readerSorg = new BufferedReader(new FileReader(nameFileSorg));
		File fileDest = new File(nameFileDest);
		FileWriter writerDest = new FileWriter(fileDest);

		ParserManager parserManager = ParserManagerFactory.getInstance(obj.getClass().getSimpleName());
		String line = "";
		line = readerSorg.readLine();
		while ((line = readerSorg.readLine()) != null) {
			try {
				if (!(parserManager.parse(line).equals(obj)))
					writerDest.write(line + "\n");

			} catch (KeyNotFoundException e) {
				e.toString();
			}
		}
		writerDest.write(obj.toCSV() + "\n");
		writerDest.flush();
		writerDest.close();

		BufferedReader readerDest = new BufferedReader(new FileReader(fileDest));
		FileWriter writerSorg = new FileWriter(nameFileSorg);
		writerSorg.write(Rating.HEADER + "\n");

		while ((line = readerDest.readLine()) != null)
			writerSorg.write(line + "\n");

		readerSorg.close();
		readerDest.close();
		writerSorg.close();
		fileDest.delete();
	}
}
