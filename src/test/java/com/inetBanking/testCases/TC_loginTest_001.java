package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_loginTest_001 extends BaseClass
{

	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		
		logger.info("Url is Opened");
		
		LoginPage lp= new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test Passed");
		}		
		else
		{
			captureScreen(driver, "loginTest");
			logger.info("Login test Failed");
			Assert.assertTrue(false);
			
		}
		
	
	}
	
}
