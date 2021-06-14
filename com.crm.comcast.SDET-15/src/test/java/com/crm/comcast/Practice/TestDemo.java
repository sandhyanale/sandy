package com.crm.comcast.Practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;
import com.crm.comcast.objectRepository.HomePage;



public class TestDemo {

	static int count=1;
	
	@Test(retryAnalyzer = com.crm.comcast.GenericUtils.RetryAnalyzer.class)
	public void dryRun() {
		System.out.println(count++);
		Assert.assertTrue(false);
	}
}
