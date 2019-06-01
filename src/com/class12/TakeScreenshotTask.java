package com.class12;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utils.CommonMethods;

public class TakeScreenshotTask extends CommonMethods {
	/*
	 * TC 1: Upload file and Take Screenshot
	 * 
	 * Navigate to
	 * “http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload”
	 * Upload file Verify file got successfully uploaded and take screenshot
	 */
	static String expected = "File uploaded!";
	
	public static void main(String[] args) {
		setUpDriver("chrome", "http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload");
		sendText(driver.findElement(By.id("gwt-debug-cwFileUpload")), "C:\\Users\\fezac\\Pictures\\clock.JPG");
		click(driver.findElement(By.cssSelector(".gwt-Button")));
		String actual = getAlertText();
		if (actual.equals(expected)) {
			System.out.println("File uploaded successfuly");
		} else {
			System.out.println("File could NOT uploaded");
		}
		acceptAlert();
		takeScreenshot("Passed/FileUpload");
		/*
		 * TakesScreenshot ts = (TakesScreenshot) driver; File upload =
		 * ts.getScreenshotAs(OutputType.FILE); try { FileUtils.copyFile(upload, new
		 * File("screenshots/Passed/FileUpload.png")); } catch (IOException e) {
		 * System.out.println("upload File screenshot could not captured");
		 * e.printStackTrace(); }
		 */	
		quitDriver();
	}

}
