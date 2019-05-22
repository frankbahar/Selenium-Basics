package com.class06;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
	/*
	 * TC 1: Tools QA check all elements Open chrome browser Go to
	 * “https://www.toolsqa.com/automation-practice-form/” Fill out: First Name Last
	 * Name Check that sex radio buttons are enabled and select “Male” Check all
	 * Years of Experience radio buttons are clickable Date Select both checkboxes
	 * for profession Check all Automation Tools checkboxes are clickable and keep
	 * “Selenium WebDriver” option as selected Quit browser
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\users\\fezac\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/automation-practice-form");
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Enes");
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Kanter");

		List<WebElement> sexs = driver.findElements(By.name("sex"));
		String expectedSex = "Male";
		for (WebElement sex : sexs) {
			if (sex.isEnabled()) {
				System.out.println(sex.getAttribute("value") + " is clickable");
			} else {
				System.out.println(sex.getAttribute("value") + " is NOT clickable");
			}
			if (sex.getAttribute("value").equals(expectedSex)) {
				sex.click();
				Thread.sleep(2000);
			}
		}
		List<WebElement> yearsOfExperiences = driver.findElements(By.name("exp"));
		for (WebElement yearsExperience : yearsOfExperiences) {
			if (yearsExperience.isEnabled()) {
				System.out.println(yearsExperience.getAttribute("value") + " is clickable");
				yearsExperience.click();
				Thread.sleep(2000);
			} else {
				System.out.println(yearsExperience.getAttribute("value") + " is NOT clickable");
			}
		}
		ZoneId zonedId = ZoneId.of("America/Montreal");
		LocalDate today = LocalDate.now(zonedId);
		driver.findElement(By.id("datepicker")).sendKeys(today.toString());
		Thread.sleep(2000);

		List<WebElement> professionList = driver.findElements(By.name("profession"));
		for (WebElement profession : professionList) {
			if (profession.isEnabled()) {
				profession.click();
			}
		}
		Thread.sleep(2000);
		
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
