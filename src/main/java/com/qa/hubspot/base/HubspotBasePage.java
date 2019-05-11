package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * @author spainaik
 * 
 */
public class HubspotBasePage {
	//Should create references for WebDriver and Properties in base class
	//Create Properties and WebDriver init functions here
	WebDriver driver;
	Properties prop;
	
	/**
	 * @author spainaik
	 * @param Properties reference
	 * @return void
	 * Stores the property FileInputStream in an reference
	 * and updates the Property class reference variable 
	 */
	public Properties initProp() {
		prop = new Properties();
		try {
			FileInputStream Ip = new FileInputStream("C:\\Users\\spainaik\\workspace\\eclipseWS\\"
					+ "SeleniumClass\\POMSeries\\src\\main\\java\\com\\qa\\hubspot\\configuration\\config.properties");
			prop.load(Ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e ){
			e.printStackTrace();
		}
		return prop;
	}

	/**
	 * @author spainaik
	 * @param void
	 * @return WebDriver reference
	 * Initialized the driver reference 
	 * Initialized the driver properties 
	 */
	public WebDriver initDriver(){
		System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		
		return driver;
	}
}
