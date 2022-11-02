package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;

public class BaseClass {

	/*public String baseUrl="https://demo.guru99.com/V4/";
	public String username="mngr446559";
	public String password="bazyhet";
	*/
	
	ReadConfig readconfig = new ReadConfig();
	public String baseUrl=readconfig.getApplicationUrl();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassward();
	
	
	public WebDriver driver;

	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		//WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		//driver= new ChromeDriver();
		
		logger=Logger.getLogger("iNetBanking");
		PropertyConfigurator.configure("Log4j.properties");
	
		logger.info("");
		
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();			
			driver= new ChromeDriver();
			logger.info("Chromedriver Setup Done");
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("FireFoxdriver Setup Done");
		}
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);
		logger.info("trying opening url");
		driver.manage().window().maximize();
		
		
	}
	
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
		logger.info("Quiting Driver Done");
		logger.info("");
	}
	
	
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname +"-"+timestamp+ ".png");
		FileUtils.copyFile(source, target);
		//System.out.println("ScreenShot Taken");
		logger.info("Screenshot Taken");
		
	}
	
	public String randomString()
	{
		String generateString = RandomStringUtils.randomAlphabetic(8);
		return(generateString);
	}
	
	public void skipGoogleAdv()
	{
		driver.navigate().back();
		driver.navigate().forward();
	}
	
}



