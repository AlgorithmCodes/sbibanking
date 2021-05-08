package com.banking.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.banking.utilities.Reporting;
import com.banking.utilities.TakeScreenshot;

public class CustomeListener extends Reporting implements ITestListener{
	TakeScreenshot ts;
	
	
	public void onTestStart(ITestResult result) {
		getReport();
		
		
		
		ts=new TakeScreenshot();  
		
	}

	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		test.pass("PASS");

		
		 try {
				ts.takeAShot(result.getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String screenshotpath=System.getProperty("user.dir")+"//src/test/resources//screenshots//"+result.getName()+".png";
			test.addScreenCaptureFromPath(screenshotpath);	
		
	}

	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		test.fail("FAIL");
		
		  try {
			ts.takeAShot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			String screenshotpath=System.getProperty("user.dir")+"//src/test/resources//screenshots//"+result.getName()+".png";
			test.addScreenCaptureFromPath(screenshotpath);
			
		
	}

	public void onTestSkipped(ITestResult result) {
		  
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		  
		
	}

	public void onStart(ITestContext context) {
		  
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();  
		
	}

}
