package com.android.anjan.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Application_Properties {
	File file = null;
	FileInputStream fileInputStream = null;
	Properties props = null;
	String devicePropertyPath = null;

	public String getElelment(String elementPath) throws IOException {
		try {
			file = new File("./src/or.properties");
			fileInputStream = new FileInputStream(file);
			props = new Properties();
			props.load(fileInputStream);
			devicePropertyPath = props.getProperty(elementPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return devicePropertyPath;
	}

}
