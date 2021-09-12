package com.crm.comcast.GenericUtils;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class XMLFileUtility {
	
	public String readDataFromXml(String node) throws DocumentException
	{
		//Read the file from location
		File inputfile = new File(IPathConstatnts.XMLPATH);
		
		//read the xml file from input
		SAXReader reader = new SAXReader();
		Document doc = reader.read(inputfile);
		
		//navigate to a particular node to get the value
		String value = doc.selectSingleNode("//commonData/"+node).getText();
		return value;
		
	}

}
