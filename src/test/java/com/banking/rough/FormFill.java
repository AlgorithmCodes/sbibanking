package com.banking.rough;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormFill {
	
	public static WebDriver driver;
	
public static void clickMultiChoice(String locator,String attribute,String desiredValue) {
		
		List<WebElement> list=driver.findElements(By.xpath(locator));
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getAttribute(attribute).equals(desiredValue)) {
				list.get(i).click();
				break;
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		driver=new ChromeDriver();
		
	
	driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
	
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("hello");
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("hello");
	clickMultiChoice("//input[contains(@id,'sex')]","value","Female");
	
	
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
	
	}

}
