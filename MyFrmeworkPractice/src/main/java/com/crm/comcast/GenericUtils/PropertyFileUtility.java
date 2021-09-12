package com.crm.comcast.GenericUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
	
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream file = new FileInputStream(IPathConstatnts.PROPERTYPATH);
		Properties prop = new Properties();
		prop.load(file); 
		String value=prop.getProperty(key);
		return value;	
	}


}
