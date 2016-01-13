package it.synclab.hrpm.factory;

import java.io.File;

public class FileNameFactory {
	public static final String BASEPATH = "hr" + File.separator;
	
	public static String getFileName(Class clazz) {
		return BASEPATH + clazz.getSimpleName() + ".csv";
	}
}
