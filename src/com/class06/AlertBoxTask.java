	package com.class06;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertBoxTask {
	/*
	 * TC 1: JavaScript alert text verification Open chrome browser Go to
	 * “https://www.seleniumeasy.com/test/javascript-alert-box-demo.html” Verify
	 * alert box with text “I am an alert box!” is present confirm box with text
	 * “Press a button!” is present prompt box with text “Please enter your name” is
	 * present Quit browser
	 */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\users\\fezac\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "C:\\users\\fezac\\Selenium\\geckodriver.exe"); WebDriver driver = new
		 * FirefoxDriver();
		 */	driver.manage().timeouts().implicitlyWait(30,
				TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		driver.findElement(By.cssSelector("button[onclick='myAlertFunction()']")).click();
		Alert alert = driver.switchTo().alert();
		String expected = "I am an alert box!";
		if(alert.getText().equalsIgnoreCase(expected)) {
			System.out.println("Alert text is "+ expected + " verfied and Test Passed");
		} else {
			System.out.println("Alert text is "+ alert.getText() + "expected test is " + expected + " did not match Test Failed");
		}
		Thread.sleep(2000);
		alert.accept();
		
		driver.findElement(By.cssSelector("button[onclick='myConfirmFunction()']")).click();
		alert = driver.switchTo().alert();
		expected = "Press a button!";
		if(alert.getText().equalsIgnoreCase(expected)) {
			System.out.println("Alert text is "+ expected + " verfied and Test Passed");
		} else {
			System.out.println("Alert text is "+ alert.getText() + "expected test is " + expected + " did not match Test Failed");
		}
		Thread.sleep(2000);
		alert.accept();
		
		driver.findElement(By.cssSelector("button[onclick='myPromptFunction()']")).click();
		alert = driver.switchTo().alert();
		expected = "Please enter your name";
		if(alert.getText().equalsIgnoreCase(expected)) {
			System.out.println("Alert text is "+ expected + " verfied and Test Passed");
		} else {
			System.out.println("Alert text is "+ alert.getText() + "expected test is " + expected + " did not match Test Failed");
		}
		Thread.sleep(2000);
		alert.sendKeys("Enes Kanter");
		
		Thread.sleep(5000);
		alert.accept();
		
		driver.quit();
		

	}

}
