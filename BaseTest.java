package com.ibm.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.ibm.pages.AdminPage;
import com.ibm.pages.BannerPage;
import com.ibm.pages.CouponPage;
import com.ibm.pages.LoginPage;
import com.ibm.pages.ProductPage;
import com.ibm.pages.ReturnPage;
import com.ibm.pages.ShippingPage;
import com.ibm.pages.TabPage;
import com.ibm.pages.UserPage;
import com.ibm.utilities.PropertiesFileHandler;

import junit.framework.Assert;

public class BaseTest {
	
//	@Test
	public void Day1Testcase() throws IOException, InterruptedException
	{
		
		String file="./TestData/magentodata.properties";
		
		PropertiesFileHandler propFileHandler = new PropertiesFileHandler();
		HashMap<String, String> data= propFileHandler.getPropertiesAsMap(file);
		
		String url = data.get("url");
		String email = data.get("email");
		String password = data.get("password");
		String expectedTitle = data.get("expectedtitle");
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(url);
		
		LoginPage login = new LoginPage(driver);
		login.enterEmailAddress(email);
		login.enterPassword(password);
		login.clickOnLogin();
		
		AdminPage apage=new AdminPage(driver, wait);
		String actualTitle=apage.getCurrentTitle();
				
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Test Passed");
			propFileHandler.setKeyAndValue(file, "TestResult", "Test Passed");
		}
		else
		{
			System.out.println("Test failed");
			propFileHandler.setKeyAndValue(file, "TestResult", "Test Failed");
		}
		
		BannerPage bpage=new BannerPage(driver, wait);
		bpage.addBanner();
		
		apage.clickOnLogOut();

		driver.close();
	
	}
	
//	@Test
	public void Day2Testcase() throws IOException, InterruptedException
	{
		
		String file="./TestData/magentodata.properties";
		
		PropertiesFileHandler propFileHandler = new PropertiesFileHandler();
		HashMap<String, String> data= propFileHandler.getPropertiesAsMap(file);
		
		String url = data.get("url");
		String email = data.get("email");
		String password = data.get("password");
		String couponname = data.get("couponname");
		String code = data.get("code");
		String discount = data.get("discount");
		String amount = data.get("amount");
		String startdate = data.get("startdate");
		String enddate = data.get("enddate");
		String usespercoupon = data.get("usespercoupon");
		String usespercustomer = data.get("usespercustomer");
		//String expectedcouponmessage = data.get("expectedcouponmessage");
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(url);
		
		LoginPage login = new LoginPage(driver);
		login.enterEmailAddress(email);
		login.enterPassword(password);
		login.clickOnLogin();
		
		AdminPage apage=new AdminPage(driver, wait);
		CouponPage coupon = new CouponPage(driver, wait);
		coupon.clickOnLinkMarketing();
		coupon.clickOnLinkCoupons();
		coupon.clickOnIconAddNew();
		coupon.enterCode(code);
		coupon.clickOnType();
		coupon.enterDiscount(discount);
		coupon.enterAmount(amount);
		coupon.enterStartDate(startdate);
		coupon.enterEndDate(enddate);
		coupon.enterUsesPerCoupon(usespercoupon);
		coupon.enterUsesPerCustomer(usespercustomer);
		coupon.clickOnStatus();
		coupon.enterCouponName(couponname);
		coupon.clickOnIconSave();
		Thread.sleep(2000);
		coupon.validationOnRecord();
		
		apage.clickOnLogOut();

		driver.close();
		
	}
	
//	@Test
	public void Day3Testcase() throws IOException, InterruptedException
	{
		
		String file="./TestData/magentodata.properties";
		
		PropertiesFileHandler propFileHandler = new PropertiesFileHandler();
		HashMap<String, String> data= propFileHandler.getPropertiesAsMap(file);
		
		String url = data.get("url");
		String email = data.get("email");
		String password = data.get("password");
		String productname = data.get("productname");
		String metatitle = data.get("metatitle");
		String model = data.get("model");
		String gst = data.get("gst");
		String price = data.get("price");
		String specialdiscount = data.get("specialdiscount");
		//String discountprice = data.get("discountprice");
		String imagepath = data.get("imagepath");
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(url);
		
		LoginPage login = new LoginPage(driver);
		login.enterEmailAddress(email);
		login.enterPassword(password);
		login.clickOnLogin();
		
		AdminPage apage=new AdminPage(driver, wait);
		ProductPage pp = new ProductPage(driver, wait);
		pp.clickLinkCatalog();
		pp.clickOnLinkProducts();
		pp.clickOnIconAddNew();
		pp.enterMetaTitle(metatitle);
		pp.enterProductName(productname);
		pp.clickOnTabData();
		pp.enterModel(model);
		pp.enterGST(gst);
		pp.enterPrice(price);
		pp.enterSplDiscount(specialdiscount);
		//pp.enterDiscountPrice(discountprice);
		pp.clickOnTabLink();
		pp.selectFromTabs();
		pp.selectCategories();
		pp.clickOnTabImage();
		pp.enterImage(imagepath);
		pp.clickOnIconSave();
		Thread.sleep(2000);
		pp.validationOnRecord();
		
		apage.clickOnLogOut();

		driver.close();
		
	}
	
//	@Test
	public void Day4Testcase() throws IOException, InterruptedException
	{
		
		String file="./TestData/magentodata.properties";
		
		PropertiesFileHandler propFileHandler = new PropertiesFileHandler();
		HashMap<String, String> data= propFileHandler.getPropertiesAsMap(file);
		
		String url = data.get("url");
		String email = data.get("email");
		String password = data.get("password");
		String returnactionname = data.get("returnactionname");
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(url);
		
		LoginPage login = new LoginPage(driver);
		login.enterEmailAddress(email);
		login.enterPassword(password);
		login.clickOnLogin();
		
		AdminPage apage=new AdminPage(driver, wait);
		ReturnPage rp = new ReturnPage(driver, wait);
		rp.clickOnLinkSystem();
		rp.clickOnLinkReturns();
		Thread.sleep(2000);
		rp.clickOnLinkRetActions();
		rp.clickOnAction();
		rp.clickOnEdit();
		rp.enterReturnActionName(returnactionname);
		rp.clickOnIconSave();
		rp.validationOnRecord();
		
		apage.clickOnLogOut();

		driver.close();
		
	}
	
//	@Test
	public void Day5Testcase() throws IOException, InterruptedException
	{
		
		String file="./TestData/magentodata.properties";
		
		PropertiesFileHandler propFileHandler = new PropertiesFileHandler();
		HashMap<String, String> data= propFileHandler.getPropertiesAsMap(file);
		
		String url = data.get("url");
		String email = data.get("email");
		String password = data.get("password");
		String expectedpincodemessage = data.get("expectedpincodemessage");
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(url);
		
		LoginPage login = new LoginPage(driver);
		login.enterEmailAddress(email);
		login.enterPassword(password);
		login.clickOnLogin();
		
		AdminPage apage=new AdminPage(driver, wait);
		ShippingPage sp = new ShippingPage(driver, wait);
		sp.clickOnLinkSystem();
		sp.clickOnLinkShipping();
		sp.clickOnLinkShippingPincode();
		sp.clickOnAction();
		sp.clickOnEdit();
		sp.clearPincode();
		sp.clickOnIconSave();
		sp.getHeaderMessage();
		String actualpincodemessage = sp.validationOnMisingField();
		Assert.assertEquals(expectedpincodemessage, actualpincodemessage);
		
		apage.clickOnLogOut();

		driver.close();
	}
	
	@Test
	public void Day6Testcase() throws IOException, InterruptedException
	{
		
		String file="./TestData/magentodata.properties";
		
		PropertiesFileHandler propFileHandler = new PropertiesFileHandler();
		HashMap<String, String> data= propFileHandler.getPropertiesAsMap(file);
		
		String url = data.get("url");
		String email = data.get("email");
		String password = data.get("password");
		String tabname = data.get("tabname");
		String sortorder = data.get("sortorder");
				
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(url);
		
		LoginPage login = new LoginPage(driver);
		login.enterEmailAddress(email);
		login.enterPassword(password);
		login.clickOnLogin();
		
		AdminPage apage=new AdminPage(driver, wait);
		TabPage tp = new TabPage(driver, wait);
		tp.clickOnLinkCatalog();
		tp.clickOnLinkTabs();
		tp.clickOnIconAddNew();
		tp.enterTabName(tabname);
		tp.enterSortOrder(sortorder);
		tp.clickOnStatus();
		tp.clickOnIconSave();
		tp.validationOnRecord();
		
		UserPage up = new UserPage ();
		up.verifytab();
		
//		apage.clickOnLogOut();

//		driver.close();
		
		
				
//		driver.close();
		
	}
	
	/*public void login() throws IOException, InterruptedException
	{
		String file="./TestData/magentodata.properties";
		
		PropertiesFileHandler propFileHandler = new PropertiesFileHandler();
		HashMap<String, String> data= propFileHandler.getPropertiesAsMap(file);
		
		String url = data.get("url");
		String email = data.get("email");
		String password = data.get("password");
		String expectedTitle = data.get("expectedtitle");
		String couponname = data.get("couponname");
		String code = data.get("code");
		String discount = data.get("discount");
		String amount = data.get("amount");
		String startdate = data.get("startdate");
		String enddate = data.get("enddate");
		String usespercoupon = data.get("usespercoupon");
		String usespercustomer = data.get("usespercustomer");
		String expectedcouponmessage = data.get("expectedcouponmessage");
		String productname = data.get("productname");
		String metatitle = data.get("metatitle");
		String model = data.get("model");
		String gst = data.get("gst");
		String price = data.get("price");
		String specialdiscount = data.get("specialdiscount");
		String discountprice = data.get("discountprice");
		String imagepath = data.get("imagepath");
		String returnactionname = data.get("returnactionname");
		String expectedpincodemessage = data.get("expectedpincodemessage");
		//String tabname = data.get("tabname");
		//String sortorder = data.get("sortorder");
						
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(url);
		
		LoginPage login = new LoginPage(driver);
		login.enterEmailAddress(email);
		login.enterPassword(password);
		login.clickOnLogin();*/
		
		/*AdminPage apage=new AdminPage(driver, wait);
		String actualTitle=apage.getCurrentTitle();
				
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Test Passed");
			propFileHandler.setKeyAndValue(file, "TestResult", "Test Passed");
		}
		else
		{
			System.out.println("Test failed");
			propFileHandler.setKeyAndValue(file, "TestResult", "Test Failed");
		}*/
		
		
		/*BannerPage bpage=new BannerPage(driver, wait);
		bpage.addBanner();*/
		
		/*CouponPage coupon = new CouponPage(driver);
		coupon.clickOnLinkMarketing();
		coupon.clickOnLinkCoupons();
		coupon.clickOnIconAddNew();
		coupon.enterCode(code);
		coupon.clickOnType();
		coupon.enterDiscount(discount);
		coupon.enterAmount(amount);
		coupon.enterStartDate(startdate);
		coupon.enterEndDate(enddate);
		coupon.enterUsesPerCoupon(usespercoupon);
		coupon.enterUsesPerCustomer(usespercustomer);
		coupon.clickOnStatus();
		coupon.enterCouponName(couponname);
		coupon.clickOnIconSave();
		Thread.sleep(5000);
		coupon.validationOnRecord();*/
		
		/*ProductPage pp = new ProductPage(driver, wait);
		pp.clickLinkCatalog();
		pp.clickOnLinkProducts();
		pp.clickOnIconAddNew();
		pp.enterMetaTitle(metatitle);
		pp.enterProductName(productname);
		pp.clickOnTabData();
		pp.enterModel(model);
		pp.enterGST(gst);
		pp.enterPrice(price);
		pp.enterSplDiscount(specialdiscount);
		//pp.enterDiscountPrice(discountprice);
		pp.clickOnTabLink();
		pp.selectFromTabs();
		pp.selectCategories();
		pp.clickOnTabImage();
		pp.enterImage(imagepath);
		pp.clickOnIconSave();
		Thread.sleep(5000);
		pp.validationOnRecord();*/
		
		/*ReturnPage rp = new ReturnPage(driver, wait);
		rp.clickOnLinkSystem();
		rp.clickOnLinkReturns();
		Thread.sleep(2000);
		rp.clickOnLinkRetActions();
		rp.clickOnAction();
		rp.clickOnEdit();
		rp.enterReturnActionName(returnactionname);
		rp.clickOnIconSave();
		Thread.sleep(2000);
		rp.validationOnRecord();*/
		
		/*ShippingPage sp = new ShippingPage(driver, wait);
		sp.clickOnLinkSystem();
		sp.clickOnLinkShipping();
		sp.clickOnLinkShippingPincode();
		sp.clickOnAction();
		sp.clickOnEdit();
		sp.clearPincode();
		sp.clickOnIconSave();
		sp.getHeaderMessage();
		String actualpincodemessage = sp.validationOnMisingField();
		Assert.assertEquals(expectedpincodemessage, actualpincodemessage);*/
		
		/*TabPage tp = new TabPage(driver, wait);
		tp.clickOnLinkCatalog();
		tp.clickOnLinkTabs();
		tp.clickOnIconAddNew();
		tp.enterTabName(tabname);
		tp.enterSortOrder(sortorder);
		tp.clickOnStatus();
		tp.clickOnIconSave();*/
		
//		apage.clickOnLogOut();

//		driver.close();
	
	//excel data using dataprovider
	//run and check	
	//sends data in excel one by one
    /*@Test(dataProvider = "data")
    public void testcase2(String user, String pwd){
    		System.out.println(user);
    		System.out.println(pwd);
    }

    @DataProvider(name="data")
    public Object[][] data() throws IOException {
        return ExcelUtil.DataTable("./TestData/TestData.xlsx","LoginData");
    }*/


}
