package com.BuyKart.GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
/**
 * This method is used to get a random number
 * @author USER
 * @return
 */
	public int getRandomNo() {
		Random r= new Random();
		int random=r.nextInt(1000);
		return random;
		}
	
	
	/**
	 * This method is used to get the Local System Date
	 * @author USER
	 * @return
	 */
	public String getSystemDate() {
		Date d= new Date();
	String date=	d.toString();
	return date;
		}
	
	/**
	 * This method is used to get the data in your prescribed format
	 * @author USER
	 * @param format
	 * @return
	 */
	public String getSystemDateInFormat(String dateFormat) {
	SimpleDateFormat sdf= new SimpleDateFormat(dateFormat);
	Date date= new Date();
String systemdateInFormat = sdf.format(date);
	return systemdateInFormat;
	}
}
