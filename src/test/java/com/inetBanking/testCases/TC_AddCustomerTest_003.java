package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException
	{
		logger.info("Url is Opened");
		
		LoginPage lp= new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		logger.info("Login Button Clicked");
		//Thread.sleep(3000);
		
		//logger.info("Creating ACP object");
		AddCustomerPage addCust = new AddCustomerPage(driver);
		logger.info("Add Customer Page object Created");
		
		addCust.clickAddNewCust();
		logger.info("Add New Customer Link clicked");
		
		Thread.sleep(3000);

		skipGoogleAdv();
			
		addCust.setCustomerName("Devi");
		logger.info("Customer Name Set done");
		addCust.setCustGender("female");
		addCust.setCustDob("01", "01", "1990");
		addCust.setAddress("Lonawala");
		addCust.setCustCity("Pune");
		addCust.setCustState("Maharashtra");
		addCust.setCustPincode("400152");
		addCust.setCustPhoneno("9999999999");
		String email = randomString() + "@gmail.com";
		addCust.setCustemail(email);
		addCust.setCustPassword("xyzw");
		
		addCust.custSubmit();
		logger.info("Add Customer Button Clicked");
		//Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res == true)
		{
			logger.info("Add Customer Test Succcess");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Add Customer Test Failed");
			try {
				captureScreen(driver, "addNewCustomer");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);
		}
	
	}
	
}
