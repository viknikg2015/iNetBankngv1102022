package com.inetBanking.utilities; 

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	
     public ExtentSparkReporter htmlReporter;
	 public ExtentReports extent;
	 public ExtentTest logger;
	 
	  
	 public void onStart(ITestContext testContext)
	 {
		 String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 String repname= "test-Report-" + timestamp + ".html";
		 
		 
		 //htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/myReport.html");//specify location of the report
		 htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/" + repname);//specify location of the report
		 
		 try {
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	 }
	  
	  extent=new ExtentReports();
	  
	  extent.attachReporter(htmlReporter);
	  extent.setSystemInfo("Host name","localhost");
	  extent.setSystemInfo("Environemnt","QA");
	  extent.setSystemInfo("user","vikas");
	  
	  htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
	  htmlReporter.config().setReportName("Functional Testing"); // name of the report
	  //htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
	  htmlReporter.config().setTheme(Theme.DARK);
	 }
	 
	 public void onTestSuccess(ITestResult tr)
	 {
	  logger=extent.createTest(tr.getName()); // create new entry in the report
	  logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
	 }
	 
	 public void onTestFailure(ITestResult tr)
	 {
	  logger=extent.createTest(tr.getName()); // create new entry in the report
	  logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
	  
	  String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	  
	  String screenshotPath = System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+"-"+timestamp+".png";

	  /*File f = new File(screenshotPath);
	  
	  if(f.exists())
	  {
		  logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
	  }*/
	  
	  /*try {
		   logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
		  } catch (IOException e) {
		    e.printStackTrace();
		  } 
	   */
	  
	  logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath)); 
	 }
	 
	 public void onTestSkipped(ITestResult tr)
	 {
	  logger=extent.createTest(tr.getName()); // create new entry in the report
	  logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	 }
	 
	 public void onFinish(ITestContext testContext)
	 {
	  extent.flush();
	 }
	
}
