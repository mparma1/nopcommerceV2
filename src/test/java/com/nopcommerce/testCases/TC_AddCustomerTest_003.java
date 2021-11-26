package com.nopcommerce.testCases;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nopcommerce.pageObject.AddcustomerPage;
import com.nopcommerce.pageObject.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass
{
@Test
public void addNewCustomer() throws IOException, InterruptedException
{
	driver.get(baseURL);
	AddcustomerPage addcust=new AddcustomerPage(driver);
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(username);
	logger.info("User name is provid");
	
	lp.setPassword(password);
	logger.info("Password is provided");
	
	lp.clickLogin();
	
	logger.info("Provide customer details");
	
	//AddcustomerPage addcust=new AddcustomerPage(driver);
	
	addcust.clickOnCustomerMenu();
	logger.info("Click on customer");
	Thread.sleep(1000);
	addcust.clickOnCustomerMenuIteam();
	logger.info("click on menu iteam");
	addcust.clickOnAddNew();
	//Thread.sleep(2000);
	logger.info("click on addNew");
	String email=randomestring () + "@gmail.com";
	
	addcust.setEmail(email);
	logger.info("Email entered");
	addcust.setPassword("test123");
	
	addcust.setFirstName("Mayur");
	addcust.setLastName("SSSFFGGHH");
	logger.info("last name entered");
	addcust.setGender("Male");
	
	addcust.setDob("7/05/1985");
	logger.info("Dob entered");
	
	addcust.setCompanyName("xyz.pvt.ltd");
	logger.info("Company name entered");
	
	addcust.setNewsLatter("Your store name");
	logger.info("News letter selected");
	
	addcust.setCustomerRoles("Vendors");
	logger.info("customer role selected");
	
	addcust.setManagerOfVendor("Vendor 1");
	logger.info("Vendder entered");
	
	addcust.setAdmineComment("hi...hello");
	
	addcust.clickOnSave();
logger.info("Click on save");
	logger.info("Validation start....");
	String str=driver.findElement(By.tagName("body")).getText();
	
	if(str.contains("The new customer has been added successfully"))
	{
		Assert.assertTrue(true);
		logger.info("Test case passed....");
		
	}
	else
	{
		captureScreen(driver,"addNewCustomer");
		logger.info("Test case fail");
		Assert.assertTrue(false);
	}
	
}
	

	



	

}
