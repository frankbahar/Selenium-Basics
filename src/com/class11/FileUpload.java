package com.class11;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utils.CommonMethods;

public class FileUpload extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "https://the-internet.herokuapp.com");
		click(driver.findElement(By.xpath("//a[text()='File Upload']")));
		driver.findElement(By.cssSelector("#file-upload")).sendKeys("C:\\Users\\fezac\\Pictures\\clock.JPG");
		Thread.sleep(2000);
		click(driver.findElement(By.cssSelector("#file-submit")));
		
		boolean isDisplayed = driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).isDisplayed();
		if(isDisplayed) {
			System.out.println("File upload successfully");
		}else {
			System.out.println("File could not uploaded successfuly");
		}
		//steps to take screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File pic = ts.getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(pic, new File("screenshots/TheInternet/FileUpload.png"));
		}catch(IOException e) {
			System.out.println("Screenshot was not captured");
		}
		quitDriver();

	}

}
