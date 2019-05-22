package com.class06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task2 {
	/*
	 * 1: Facebook dropdown verification Open chrome browser Go to
	 * “https://www.facebook.com” Verify: month dd has 12 month options day dd has
	 * 31 day options year dd has 115 year options Select your date of birth Quit
	 * browser
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\users\\fezac\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.facebook.com");

		WebElement monthDD = driver.findElement(By.id("month"));
		Select obj = new Select(monthDD);
		List<WebElement> allOptions = obj.getOptions();
		if (allOptions.size() - 1 == 12) {
			System.out.println(monthDD.getAttribute("aria-label") + " has 12 months Test PASSED");
		} else {
			System.out.println(monthDD.getAttribute("aria-label") + " do not have 12 months Test FAILED");
		}
		obj.selectByVisibleText("Dec");
		Thread.sleep(2000);
		allOptions.clear();
		
		WebElement dayDD = driver.findElement(By.id("day"));
		obj = new Select(dayDD);
		allOptions = obj.getOptions();
		if (allOptions.size() - 1 == 31) {
			System.out.println(dayDD.getAttribute("aria-label") + " has 31 days Test PASSED");
		} else {
			System.out.println(dayDD.getAttribute("aria-label") + " do not have 31 days Test FAILED");
		}
		obj.selectByIndex(10);	
		Thread.sleep(2000);
		allOptions.clear();

		WebElement yearDD = driver.findElement(By.id("year"));
		obj = new Select(yearDD);
		allOptions = obj.getOptions();
		if (allOptions.size() - 1 == 115) {
			System.out.println(dayDD.getAttribute("aria-label") + " has 115 years Test PASSED");
		} else {
			System.out.println(dayDD.getAttribute("aria-label") + " do not have 115 years Test FAILED");
		}
		obj.selectByVisibleText("1974");	
		
		Thread.sleep(2000);
		driver.quit();
	}

}
