package com.class08;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import utils.CommonMethods;

public class TakeScreenShotDemo extends CommonMethods {

	public static void main(String[] args) throws IOException, InterruptedException {
		setUpDriver("chrome", "https://www.google.com");
		
		Thread.sleep(2000);
		//take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//now copy the screenshot to desired location using copy file //method
	
		FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\src\\com\\class08\\googlescreenshot.png"));
		
		driver.quit();

	}

}
