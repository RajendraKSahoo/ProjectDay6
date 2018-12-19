package com.ibm.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ibm.utilities.PropertiesFileHandler;

public class UserPage 
{

//	@Test
	public void verifytab() throws IOException, InterruptedException
	{
		
		String file="./TestData/magentodata.properties";
		
		PropertiesFileHandler propFileHandler = new PropertiesFileHandler();
		HashMap<String, String> data= propFileHandler.getPropertiesAsMap(file);
		
		String userurl = data.get("userurl");
				
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(userurl);
		
		Properties p = new Properties();
		p.load(new FileInputStream("./TestData/magentodata.properties"));
		
		String pagesource = driver.getPageSource();
		if(pagesource.contains(p.getProperty("tabname")))
		{
			System.out.println("The presence of tab name is confirmed on User page!");
		}
		else {
			System.out.println("The tab name doesn't exist on User page");
		}
		
				
	}

}
