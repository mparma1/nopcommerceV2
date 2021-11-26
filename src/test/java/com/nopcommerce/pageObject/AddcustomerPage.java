package com.nopcommerce.pageObject;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage {

	public WebDriver ldriver;
	public AddcustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	//follow old/this approch only one you have to use
	By lnkCustomer_menu=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a");
	By lnkCustomer_menuitem=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a");
	By btnAddnew=By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
	
	By txtEmail=By.xpath("/html/body/div[3]/div[1]/form/section/div/div/nop-cards/nop-card/div/div[2]/div[1]/div[2]/input");
	By txtPassword=By.id("Password");
	
	By txtFirstname=By.id("FirstName");
	By txtLastname=By.id("LastName");
	
	By rdMaleGender=By.id("Gender_Male");
	By rdFemaleGender=By.id("Gender_Female");
	
	By txtDob=By.xpath("//*[@id=\"DateOfBirth\"]");
	
	By txtCompanyName=By.xpath("//*[@id=\"Company\"]");
	
	By txtNewsletter=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div/div");
	By listYourStory=By.xpath("//*[@id=\"SelectedNewsletterSubscriptionStoreIds_listbox\"]/li[1]");
	By listTestStory2=By.xpath("//*[@id=\"SelectedNewsletterSubscriptionStoreIds_taglist\"]/li/span[1]");
	
	By txtCustomerRole=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
	By listIteamAdministrator=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]");
	By listIteamForumModular=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[2]");
	By listIteamGuest=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]");
	By listIteamRegister=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[4]");
	By listIteamVender=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[5]");
	
	
	By drpmgrVendor=By.xpath("//*[@id=\"VendorId\"]");
	By txtAdminComment=By.xpath("//*[@id=\"AdminComment\"]");
	
	By btnSubmit=By.xpath("/html/body/div[3]/div[1]/form/div[1]/div/button[1]");

	public void clickOnCustomerMenu()
	{
		ldriver.findElement(lnkCustomer_menu).click();
		
	}
	public void clickOnCustomerMenuIteam()
	{
		ldriver.findElement(lnkCustomer_menuitem).click();
	}
	public void clickOnAddNew()
	{
		ldriver.findElement(btnAddnew).click();
		}
	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	public void setPassword(String pwd)
	{
		ldriver.findElement(txtPassword).sendKeys(pwd);;
	}
	public void setFirstName(String name)
	{
		ldriver.findElement(txtFirstname).sendKeys(name);
	}
	public void setLastName(String lname)
	{
		ldriver.findElement(txtLastname).sendKeys(lname);;
	}
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdMaleGender).click();
		}else if(gender.equals("Female"))
		{
			ldriver.findElement(rdFemaleGender).click();
			
			}
		else
		{
			ldriver.findElement(rdMaleGender).click();
		}
	}
	public void setDob(String dob)
	{
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	public void setCompanyName(String Cname)
	{
		ldriver.findElement(txtCompanyName).sendKeys(Cname);
	}
	public void setNewsLatter(String role)
	{
		ldriver.findElement(txtNewsletter).click();
		ldriver.findElement(By.xpath("//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div/div")).click();
		WebElement listiteam1;
		switch(role)
		{
		case "Your store name" :
			listiteam1=ldriver.findElement(listYourStory);break;
		case "Test store 2" :
			listiteam1=ldriver.findElement(listTestStory2);break;
		default:
			listiteam1=ldriver.findElement(listYourStory);
		}
		//listiteam1.click();
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listiteam1);

		}
	
	public void setCustomerRoles(String role1) 
	{
		//ldriver.findElement(By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div]")).click();
	
		ldriver.findElement(txtCustomerRole).click();
					
		WebElement listitem;
		
		switch(role1)
		{
		case "Administrators":
				listitem=ldriver.findElement(listIteamAdministrator); break;
		case "Guests":
				listitem=ldriver.findElement(listIteamGuest); break;
		case "Registered":
			listitem=ldriver.findElement(listIteamRegister); break;
		case "Vendors":
			listitem=ldriver.findElement(listIteamVender); break;
		case "Forum Moderators" :
			listitem=ldriver.findElement(listIteamForumModular);break;
		default:
			listitem=ldriver.findElement(listIteamVender);
		}
					
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listitem);
		
}
	public void setManagerOfVendor(String value)
	{
		Select drp=new Select(ldriver.findElement(drpmgrVendor));
		drp.selectByVisibleText(value);
		
	}
	public void setAdmineComment(String comment)
	{
		ldriver.findElement(txtAdminComment).sendKeys(comment);
	}
	public void clickOnSave()
	{
		ldriver.findElement(btnSubmit).click();
	}
}










































