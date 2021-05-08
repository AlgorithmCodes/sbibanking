package com.banking.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.base.BaseTest;
import com.banking.utilities.ReadExcelData;

public class AddNewCustomerTest extends BaseTest {

	@Test(dataProvider = "getData")
	public void addCustomer(String customername, String gender, String dob, String address, String city, String state,
			String pin, String mobilenumber, String email, String password) throws InterruptedException {

		LoginTest lt = new LoginTest();
		lt.loginAsBankManager();

		driver.findElement(By.xpath(OR.getProperty("addnewcustomer"))).click();
		log.info("add new customer button is clicked");
		driver.findElement(By.xpath(OR.getProperty("customername"))).sendKeys(customername);
		log.info("customername is entered");
		clickRadioButton(OR.getProperty("gender"), "value", gender);
		log.info("gender is clicked");
		enterDOB(dob, OR.getProperty("dob"));
		log.info("dob is entered");

		driver.findElement(By.xpath(OR.getProperty("address"))).sendKeys(address);
		log.info("address is entered");

		driver.findElement(By.xpath(OR.getProperty("city"))).sendKeys(city);

		log.info("city is entered");
		driver.findElement(By.xpath(OR.getProperty("state"))).sendKeys(state);

		log.info("state is entered");
		driver.findElement(By.xpath(OR.getProperty("pin"))).sendKeys(pin);

		log.info("pin is entered");
		driver.findElement(By.xpath(OR.getProperty("mobilenumber"))).sendKeys(mobilenumber);

		log.info("mobilenumber is entered");
		driver.findElement(By.xpath(OR.getProperty("email"))).sendKeys(email);

		log.info("email is entered");
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys(password);
		log.info("password is entered");
		
		
		//driver.findElement(By.xpath(OR.getProperty("submit"))).click();

		//log.info("submit button is clicked");
		
		
		//Assert.assertEquals(driver.findElement(By.xpath(OR.getProperty("addcustomersuccess"))).getText(), "Customer Registered Successfully!!!");
		//Thread.sleep(10000);
	}

	@DataProvider
	public String[][] getData() throws IOException {
		String filePath="B:\\finalProjects\\Hybrid_Data_Keyword_driven_framework\\src\\test\\resources\\excel\\customer.xlsx";
		ReadExcelData red=new ReadExcelData(filePath, "regData");
		int rowCount=red.getRowCount();
		System.out.println(rowCount);
		int colCount=red.getColCount();
		System.out.println(colCount);
		String[][] data=new String[rowCount][colCount];
		
		for (int i = 1; i <=rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				data[i-1][j]=red.getCellData(i, j);
			}
		}
		return data;

	}

	public static void clickRadioButton(String locator, String attribute, String desiredValue) {

		List<WebElement> list = driver.findElements(By.xpath(locator));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAttribute(attribute).equals(desiredValue)) {
				list.get(i).click();
			}
		}

	}

	public static void enterDOB(String dob, String locator) {
		String date = dob;
		String day = date.substring(0,2);
		String month = date.substring(2,4);
		String year =date.substring(4,8);
		driver.findElement(By.xpath(locator)).sendKeys(day);
		driver.findElement(By.xpath(locator)).sendKeys(month);
		driver.findElement(By.xpath(locator)).sendKeys(year);

	}

}
