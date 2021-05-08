package com.banking.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.banking.base.BaseTest;

public class TakeScreenshot extends BaseTest {
	
	public void takeAShot(String methodName) throws IOException {
		String fileName=System.getProperty("user.dir")+"//src//test//resources//screenshots//"+methodName+".png";
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(fileName));
	}

}
