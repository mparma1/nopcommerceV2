package com.nopcommerce.testCases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObject.LoginPage;



public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException {
		
	    driver.get(baseURL);
		driver.manage().window().maximize(); 
		logger.info("URL open.....");
				
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("User name clicked...");
		
		lp.setPassword(password);
		logger.info("Password entered..");
		
		lp.clickLogin();
		logger.info("Login is clicked");
		//Thread.sleep(2000);
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			lp.clickLogout();
			Assert.assertTrue(true);
			logger.info("Test case Pass");
			
		} else
		{
			captureScreen(driver,"loginTest");
			lp.clickLogout();
			Assert.assertTrue(false);
			logger.info("Test case Fail.......");
			
		}

	}
}
