package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.HubspotBasePage;
import com.qa.hubspot.commons.Constants;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.CommonUtil;

public class LoginTest {
	HubspotBasePage basepage;
	WebDriver driver;
	Properties prop;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp(){
		basepage = new HubspotBasePage();
		driver = basepage.initDriver();
		prop = basepage.initProp();
		driver.get(prop.getProperty("url"));
		CommonUtil.mediumWait();
		loginPage = new LoginPage(driver);
		
		
		//Sush
		/*loginPage = new LoginPage();
		driver = loginPage.loginPageInit();
		prop=loginPage.initProp();
		driver.get(prop.getProperty("url"));
		CommonUtil.mediumWait();*/
	}
	
	@Test(priority=1,enabled=true)
	public void verifyLoginPageTitleTest(){
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login Page Title is " + title);
		Assert.assertEquals(title,Constants.LOGINPAGE_TITLE,"Login Page Title is not correct");
	}
	
	@Test(priority=2,enabled=false)
	public void verifySignUpLink(){
		Assert.assertTrue(loginPage.verifySignUpLink(),"SignUp Link is not available");
	}
	
	@Test(priority=3,enabled=false)
	public void loginTest(){
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
