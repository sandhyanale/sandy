package com.crm.comcast.GenericUtils;

import java.util.Random;

import org.testng.annotations.Test;
/**
 * This class has all java related generic methods like getRandomNumber
 * @author Chaitra
 *
 */
public class JavaUtility {
	
	/**
	 * This method will return a random number
	 * @author Chaitra
	 * @return
	 */
	public int getRandomNumber()
	{
		Random random = new Random();
		int ran = random.nextInt(1000);
		return ran;
	}

}
