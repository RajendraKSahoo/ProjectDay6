package com.ibm.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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
			@FindBy(xpath="//select[@name='status']")
			WebElement statusddEle;
		
	//WebElement for icon Save
			@FindBy(xpath="//button[@title='Save']")
			WebElement saveEle;
			
	//This is a method to click on link Catalog on Admin page
			public void clickOnLinkCatalog()
			{
				catalogEle.click();
			}
	//This is a method to click on link Tabs under Catalog on Admin page		
			public void clickOnLinkTabs()
			{
				tabsEle.click();
			}
	//This is a method to click on icon Add New on Tabs List of Admin page		
			public void clickOnIconAddNew()
			{
				addnewEle.click();
			}
	//This is a method to enter value on field Tab Name using properties file
			public void enterTabName(String tabname)
			{
				tabnameEle.sendKeys(tabname);
			}
	//This is a method to enter value on field Sort Order using properties file		
			public void enterSortOrder(String sortorder)
			{
				sortEle.sendKeys(sortorder);
			}
	//This is a method to select value on field Status		
			public void selectStatus()
			{
				statusddEle.click();
				Select statusEle = new Select(statusddEle);
				statusEle.selectByVisibleText("Enabled");
			}
	//This is a method to click on icon Save		
			public void clickOnIconSave()
			{
				saveEle.click();
			}
	//This is a method to validate that record is inserted into the list
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
