package com.inetBanking.testCases;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TestTest2 extends BaseClass
{
	//public static Logger logger;
	
	@Test
	public void Test() throws InterruptedException
	{
		
	/*logger=Logger.getLogger("iNetBanking");
	PropertyConfigurator.configure("Log4j.properties");
		*/
	/*WebDriverManager.chromedriver().setup();
	logger.info("Chrome setup start");
	WebDriver driver = new ChromeDriver();
	logger.info("Chrome setup ok");
	*/
	
	logger.info("Creating Loginpage object");
	LoginPage lp= new LoginPage(driver);
	
	lp.setUserName(username);
	logger.info("Entered Username");
	lp.setPassword(password);
	logger.info("Entered Password");
	
	lp.clickSubmit();
	logger.info("Login Button Clicked");
	/*AddCustomerPage addCust = new AddCustomerPage(driver);
	logger.info("Created ADDCust Object");

	driver.get("https://demo.guru99.com/V4/manager/Managerhomepage.php");
	
	
	//WebElement btnlogout = driver.findElement(By.cssSelector("a[href='addcustomerpage.php']"));
	addCust.linkAddNewCustomer.click();
	*/
	//btnlogout.click();
	
	/*logger.info("Creating AddCust Object");
	AddCust2 Ac = new AddCust2(driver);
	logger.info("AddCust Object Created");
	*/
	//driver.get(Ac.Urll);
	//logger.info("Url Opened");
	//Ac.btnlogout.click();
	
	//Ac.linkAddNewCustomer.click();
	
	logger.info("Creating ACP object");
	AddCustomerPage addCust = new AddCustomerPage(driver);
	logger.info("ACP object Created");
	
	logger.info("clicking add new cust link");
	addCust.clickAddNewCust();
	logger.info("ADNewCust clicked");

	Thread.sleep(3000);

	driver.navigate().back();
	driver.navigate().forward();
	
	/*logger.info("Refreshing Page");
	driver.navigate().refresh();
	logger.info("Refresh Page Done");
	
	logger.info("Refreshing Page2");
	driver.navigate().refresh();
	logger.info("Refresh Page Done2");
	
	try {
	logger.info("Finding Google Add Iframe");
	WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
	logger.info("G ADv iframe Found");
	driver.switchTo().frame(frame1);
	logger.info("Switeched to gad iframe");
	WebElement frame2 = driver.findElement(By.id("ad_iframe"));
	logger.info("ad iframe found");
	driver.switchTo().frame(frame2);
	logger.info("switched to frame 2");
    driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
    logger.info("dismiss buton clicked");
    driver.switchTo().defaultContent();
    logger.info("switched to default content");
    Thread.sleep(5000);
	}catch(NoSuchElementException e) {}
	*/
	
	/*
	logger.info("Refreshing Page");
	driver.navigate().refresh();
	logger.info("Refresh Page Done");
	
	logger.info("Refreshing Page2");
	driver.navigate().refresh();
	logger.info("Refresh Page Done2");
	*/
	logger.info("Seting Customer Name");
	addCust.setCustomerName("vikas");
	logger.info("Customer Name Set done");
	
	}
}
