package com.banking.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.base.BaseTest;

public class LoginTest extends BaseTest {
	
	
	@Test
	public void loginAsBankManager() {
		
		driver.findElement(By.xpath(OR.getProperty("txtusername"))).sendKeys(config.getProperty("username"));
		log.info("username is entered");
		driver.findElement(By.xpath(OR.getProperty("txtpassword"))).sendKeys(config.getProperty("password"));
		log.info("password is entered");
		driver.findElement(By.xpath(OR.getProperty("loginBtn"))).click();
		log.info("login button is clicked");
		Assert.assertEquals(driver.findElement(By.xpath(OR.getProperty("loginvalidation"))).getText(), "Welcome To Manager's Page of Guru99 Bank");
		
	}

}
