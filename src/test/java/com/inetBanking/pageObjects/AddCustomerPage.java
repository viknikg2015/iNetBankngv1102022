package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage 
{
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//@FindBy(xpath = "//a[normalize-space()='New Customer']")
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/ul[1]/li[2]/a[1]")
	@CacheLookup
	public
	WebElement linkAddNewCustomer;
	
	@FindBy(xpath= "//input[@name='name']")
	@CacheLookup
	WebElement txtCustomerName;
	
	//WebElement txtCustomerName= ldriver.findElement(By.xpath("//input[@name='name']"));
	
	//@FindBy(how = How.NAME, using="rad1")
	@FindBy(xpath = "//input[@value='m']")
	@CacheLookup
	WebElement rdGenderm;
	
	@FindBy(xpath = "//input[@value='f']")
	@CacheLookup
	WebElement rdGenderf;
	
	@FindBy(name= "dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(name= "addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(name= "city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(name= "state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(name= "pinno")
	@CacheLookup
	WebElement txtpincode;
	
	@FindBy(name= "telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy(name= "emailid")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy(name= "password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath = "//input[@name='sub']")
	@CacheLookup
	WebElement btnsubmit;
	
	@FindBy(xpath = "//input[@name='res']")
	@CacheLookup
	WebElement btnreset;
	
	
	public void clickAddNewCust()
	{
		linkAddNewCustomer.click();
	}
	
	public void setCustomerName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	
	public void setCustGender(String cgender)
	{
		if(cgender == "male")
		{
			rdGenderm.click();
		}else
		{
			rdGenderf.click();
		}
	}
	
	public void setCustDob(String dd, String mn, String yr)
	{
		txtdob.sendKeys(dd);
		txtdob.sendKeys(mn);
		txtdob.sendKeys(yr);
	}
	
	public void setAddress(String caddr)
	{
		txtaddress.sendKeys(caddr);
	}
	
	public void setCustCity(String ccity)
	{
		txtcity.sendKeys(ccity);
	}
	
	public void setCustState(String cstate)
	{
		txtstate.sendKeys(cstate);
	}
	
	public void setCustPincode(String cpin)
	{
		txtpincode.sendKeys(cpin);
	}
	
	public void setCustPhoneno(String cphoneno)
	{
		txttelephoneno.sendKeys(cphoneno);
	}
	
	public void setCustemail(String cemail)
	{
		txtemailid.sendKeys(cemail);
	}
	
	public void setCustPassword(String cpwd)
	{
		txtpassword.sendKeys(cpwd);
	}
	
	public void custSubmit()
	{
		btnsubmit.click();
	}
	
	
	
	
	
	
	
}
