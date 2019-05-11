package com.qa.hubspot.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.HubspotBasePage;

public class LoginPage extends HubspotBasePage{
	
	WebDriver driver;
	
	
	@FindBy(id="username")
	WebElement login;
	
	@FindBy(id="password")
	WebElement passwd;
	
	@FindBy(id="loginBtn")
	WebElement loginBtn;
	
	@FindBy(linkText="Sign up")
	WebElement signUp;
	
	public LoginPage(WebDriver driver){
	//public LoginPage(){
		this.driver=driver;
		PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, this);
	}
	
	//sush
	/*public WebDriver loginPageInit(){
		driver=initDriver();//sush
		PageFactory.initElements(driver, this);
		return driver;
	}*/
	
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifySignUpLink(){
		return signUp.isDisplayed();
	}
	
	public void doLogin(String un, String pw){
		login.sendKeys(un);
		passwd.sendKeys(pw);
		loginBtn.click();
	}
}
