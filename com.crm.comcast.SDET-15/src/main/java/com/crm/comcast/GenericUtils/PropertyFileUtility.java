package com.crm.comcast.GenericUtils;


import java.io.FileInputStream;
import java.util.Properties;
/**
 * This class will read the data from property file
 * @author Chaitra
 *
 */

public class PropertyFileUtility {
	
    /**
     * This method will read data from property file
     * @author Chaitra
     * @param key
     * @return
     * @throws Throwable
     */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream file = new FileInputStream(IPathConstants.PROPERTYFILEPATH);
		Properties prop = new Properties();
		prop.load(file);
		String value=prop.getProperty(key);
		return value;	
	}

}
