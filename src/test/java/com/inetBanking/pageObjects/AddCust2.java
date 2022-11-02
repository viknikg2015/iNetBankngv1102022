package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCust2 
{
	WebDriver ldriver;
	
	//public String Urll = "https://demo.guru99.com/V4/manager/Managerhomepage.php";
	
	public AddCust2(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	//WebElement btnlogout = ldriver.findElement(By.cssSelector("a[href='addcustomerpage.php']"));
	
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/ul[1]/li[2]/a[1]")
	@CacheLookup
	public
	WebElement linkAddNewCustomer;
	
	
}
