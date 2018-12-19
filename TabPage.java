package com.ibm.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TabPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
		public TabPage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver,this);
	}
	
	//WebElement for link Catalog
			@FindBy(xpath="//a[contains(text(),'Catalog')]")
			WebElement catalogEle;
			
	//WebElement for link Tabs
			@FindBy(xpath="//a[contains(text(),'Tabs')]")
			WebElement tabsEle;
			
	//WebElement for icon Add New
			@FindBy(xpath="//a[@title='Add New']")
			WebElement addnewEle;
		
	//WebElement for field Tab Name
			@FindBy(xpath="//input[@name='name']")
			WebElement tabnameEle;
			
	//WebElement for field Sort
			@FindBy(xpath="//input[@name='sort']")
			WebElement sortEle;
			
	//WebElement for field Status
			@FindBy(xpath="//select[@name='status']/option[2]")
			WebElement statusEle;
		
	//WebElement for icon Save
			@FindBy(xpath="//button[@title='Save']")
			WebElement saveEle;
			
			public void clickOnLinkCatalog()
			{
				catalogEle.click();
			}
			
			public void clickOnLinkTabs()
			{
				tabsEle.click();
			}
			
			public void clickOnIconAddNew()
			{
				addnewEle.click();
			}
			
			public void enterTabName(String tabname)
			{
				tabnameEle.sendKeys(tabname);
			}
			
			public void enterSortOrder(String sortorder)
			{
				sortEle.sendKeys(sortorder);
			}
			
			public void clickOnStatus()
			{
				statusEle.click();
			}
			
			public void clickOnIconSave()
			{
				saveEle.click();
			}
			
			public void validationOnRecord() throws FileNotFoundException, IOException
			{
				Properties p = new Properties();
				p.load(new FileInputStream("./TestData/magentodata.properties"));
			
				String pagesource = driver.getPageSource();
				//System.out.println(pagesource);
				
				if(pagesource.contains(p.getProperty("tabname"))) {
					System.out.println("The presence of tab name is confirmed on Admin page!");
				}
				else {
					System.out.println("The tab name is not added to this list");
				}
			}

}
