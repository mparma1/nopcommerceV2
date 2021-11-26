package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nocommerce.utilies.XLUtils;
import com.nopcommerce.pageObject.LoginPage;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
public void loginTest(String user, String pwd)
	{
		
		driver.get(baseURL);
		driver.manage().window().maximize(); 
		logger.info("URL open.....");
				
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(user);
		logger.info("User name clicked...");
		
		lp.setPassword(pwd);
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
			//captureScreen(driver,"loginTest");
			lp.clickLogout();
			Assert.assertTrue(false);
			logger.info("Test case Fail.......");
		}
		
	}
	@DataProvider(name="LoginData")  
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+ "\\src\\test\\java\\com\\nopcommerce\\testData\\LoginData.xlsx";
	int rownum=	XLUtils.getRowCount(path, "Sheet1");
	int colcount=XLUtils.getCellCount(path,"Sheet1",1);
	String logindata[][]=new String [rownum][colcount];
	for(int i=1;i<=rownum;i++)
	{
		for(int j=0;j<colcount;j++)
		{
			logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			
		}
	}
	return logindata;
	}
}
