package com.tesco.gmail.smoke;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tesco.gmail.datareader.DataReader;
import com.tesco.gmail.objectreader.ObjectReader;
import com.tesco.gmail.utility.Utility;

public class GmailSmoke {
	Logger logger=LogManager.getLogger(GmailSmoke.class);
	WebDriver gs;ObjectReader o;DataReader e;
	@BeforeTest
	public void setUP() {
		o=new ObjectReader();
		e=new DataReader();
		System.setProperty("webdriver.chrome.driver", o.chromePath());
		gs=new ChromeDriver();
		gs.manage().window().maximize();	
	}
	@Test
	public void baseURL() {
		Utility.wait_Statement(3000);
		gs.get(o.baseURL());
	}
	@Test(dependsOnMethods="baseURL")
	public void loginintoAccount() {
		Utility.wait_Statement(4000);
		gs.findElement(By.xpath(o.loginbutton())).click();                   
		Utility.wait_Statement(1000);
		gs.findElement(By.xpath(o.email())).sendKeys(e.userName());
		Utility.wait_Statement(1000);
		gs.findElement(By.xpath(o.password())).sendKeys(e.userPassword());
		Utility.wait_Statement(1000);
		Utility.screenShots(gs, "Credentials of the User");
		gs.findElement(By.xpath(o.next())).click();
	}
	@Test(dependsOnMethods="loginintoAccount")
	public void verifyLoginURL(){
		Utility.wait_Statement(2000);
		String actualURL=o.loginURL();
		String expectedURL=gs.getCurrentUrl();
		if(actualURL.equals(expectedURL)){
			logger.debug("Pass    UserLoggedintoAccount              ===>" + gs.getCurrentUrl());
		}else{
			logger.error("Fail    UsenotrLoggedintoAccount           ===>" + gs.getCurrentUrl());
		}
	}
	@Test(dependsOnMethods="verifyLoginURL")
	public void logOut(){
		Utility.wait_Statement(5000);
		Utility.screenShots(gs, "Login Page of the User");
		gs.findElement(By.xpath(o.profilebutton())).click();
		Utility.wait_Statement(1000);
		gs.findElement(By.xpath(o.logout())).click();
		Utility.wait_Statement(1000);
		gs.findElement(By.xpath(o.logout1())).click();
	}
	@AfterMethod
	public void tearDown(ITestResult fail) {
	if(ITestResult.FAILURE==fail.getStatus()) {
		Utility.screenShots(gs, fail.getName());
	}
	}
	@AfterTest
	public void closeBrowser(){
		Utility.wait_Statement(2000);
		gs.close();
	}
}
