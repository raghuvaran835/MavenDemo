package com.util.property;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	public String getDataFromProperty(String key) throws IOException
	{
		Properties prop=new Properties();
		File f=new File("C:\\Users\\raghuvr\\Documents\\Eclipse_Workspace\\MavenDemo\\src\\test\\resources\\config.properties");
		FileReader fr=new FileReader(f);
		prop.load(fr);
		
		return prop.getProperty(key);
	}

}
