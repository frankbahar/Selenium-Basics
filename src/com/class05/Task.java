package com.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {
	/*
	 * * Check all Years of Experience radio buttons are clickable
	 * ----------------------------------------------- Check all Automation Tools
	 * checkboxes are clickable and keep “Selenium WebDriver” option as selected
	 */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\users\\fezac\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/automation-practice-form");
		List<WebElement> yearsOfExperiences = driver.findElements(By.name("exp"));
		for(WebElement yearsExperience:yearsOfExperiences) {
			if (yearsExperience.isEnabled()){
				System.out.println(yearsExperience.getAttribute("value") + " is clickable");
				yearsExperience.click();
				Thread.sleep(2000);
			}else {
				System.out.println(yearsExperience.getAttribute("value") + " is NOT clickable");		
			}
		}
	
		List<WebElement> automationTools = driver.findElements(By.name("tool"));
		String valueSelected = "Selenium Webdriver";
		for(WebElement automationTool : automationTools) {
			if (automationTool.isEnabled()){
				System.out.println(automationTool.getAttribute("value") + " is clickable");
				automationTool.click();
				Thread.sleep(2000);
				automationTool.click();
					
			}else {
				System.out.println(automationTool.getAttribute("value") + " is NOT clickable");		
			}
			String value = automationTool.getAttribute("value");
			System.out.println(value);
			if (value.equals(valueSelected)) {
				automationTool.click();
			}
		}
		Thread.sleep(5000);
		driver.quit();
	}
}
