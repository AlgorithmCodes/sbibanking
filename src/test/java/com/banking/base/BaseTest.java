package com.banking.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	public static WebDriver driver;
	public static FileInputStream configFis;
	public static FileInputStream orFis;
	public static Properties OR=new Properties();
	public static Properties config=new Properties();
	public static Logger log;
	
	
	@BeforeClass
	public void setup() throws IOException{
		
			configFis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			orFis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			OR.load(orFis);
			config.load(configFis);
			log=Logger.getLogger("onlineBanking");
			PropertyConfigurator.configure("log4j.properties");
			
		if(config.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
			driver=new ChromeDriver();
			log.info("driver is loaded succesfully!");
		}
		
		driver.get(config.getProperty("baseURL"));
		log.info("URL is loaded succesfully!");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		log.info("driver is closed succesfully!");
	}
	
	

}
