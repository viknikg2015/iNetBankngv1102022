package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		File src= new File("./Configuration/config.properties"); 
	
		try {
			
			FileInputStream fis= new FileInputStream(src);
			pro = new Properties();
			pro.load(fis); 
		}
		catch(Exception e)
		{
			System.out.println("Exception is" + e.getMessage());
		}
	
	}
	
	public String getApplicationUrl()
	{
		String url= pro.getProperty("baseUrl");
		return url;
	}

	
	public String getUsername()
	{
		String username= pro.getProperty("username");
		return username;
	}

	public String getPassward()
	{
		String password= pro.getProperty("password");
		return password;
	}

	
	
	
	
	
}
