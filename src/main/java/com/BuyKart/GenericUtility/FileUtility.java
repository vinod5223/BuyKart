package com.BuyKart.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	/**
	 * This method is used to read the value present in the properties file
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String readDataFromPropertiesFile(String key) throws Exception {
		FileInputStream fis= new FileInputStream(IPathConstants.filePath);
		Properties pObj= new Properties();
		pObj.load(fis);
		
String value=	pObj.getProperty(key);
		return value;
	}
}
 