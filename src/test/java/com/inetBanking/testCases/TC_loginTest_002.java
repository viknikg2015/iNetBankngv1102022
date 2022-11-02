package com.inetBanking.testCases;

import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_loginTest_002 extends BaseClass 
{	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws IOException 
	{
		logger.info("Url is Opened");
			
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Username Entered");
		lp.setPassword(pwd);
		logger.info("Password Entered");
		lp.clickSubmit();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(isAlertPresent()==true)
		{
			//logger.info("Trying to get screenhot");
			//captureScreen(driver, "loginDDT");
			//logger.info("Trying Accepting Alert");
			driver.switchTo().alert().accept(); //closeAlert
			//logger.info("Alert Accepted");
			
			//captureScreen(driver, "loginDDT");
			//logger.info("Alert Accepted");
			driver.switchTo().defaultContent();
			
			logger.info("Trying to get screenhot");
			captureScreen(driver, "loginDDT");
			logger.warn("login Failed");
			Assert.assertTrue(false);
		}
		else
		{
			logger.info("Login Passed");
			Assert.assertTrue(true);
			lp.clickLogout();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	
	public boolean isAlertPresent() throws IOException
	{
		try
		{
			driver.switchTo().alert();
			//logger.info("Trying to get screenhot");
			//captureScreen(driver, "loginDDT");
			logger.info("Alert Is Present");
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		logger.info("into getdata ");
		
	String path = System.getProperty("user.dir") + ("/src/test/java/com/inetBanking/testData/LoginData.xlsx");
	//logger.info("Excel File Path Set Done");
	int rownum = XLUtils.getRowCount(path, "sheet1");
	//logger.info("Row count of sheet  set to rownum");
	int colcount = XLUtils.getCellCount(path, "sheet1", 0);
	//logger.info("Column count of sheet  set on colcount");
	
	String logindata[][] = new String [rownum][colcount];
	//logger.info("logindata variable created");
	
	for(int i=1; i<=rownum; i++)
	{
		for(int j=0; j<colcount; j++)
		{
			logindata[i-1][j] = XLUtils.getCellData(path, "sheet1", i, j);			
		}
		
	}
	logger.info("Returned logindata array");
	return logindata;
	}
	
}
