package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	
	/*@FindBy(xpath="//input[@name='uid']")
	@CacheLookup
	WebElement txtUserName;
	*/
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;	
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;	
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;
	/*
	WebElement txtUserName= ldriver.findElement(By.xpath("//input[@name='uid']"));
	//WebElement txtPassword= ldriver.findElement(By.xpath("//input[@name='password']"));
	WebElement btnLogin= ldriver.findElement(By.xpath("//input[@name='btnLogin']"));
	*/
	
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
	}

	public void clickLogout()
	{
		lnkLogout.click();
	}

}
