package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbsoluteXpath {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\users\\fezac\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.toolsqa.com/automation-practice-form");
		driver.findElement(By.xpath(
		"html/body/div/div[5]/div/div/div/div/div/div/div/div[2]/div/form/fieldset/div[8]/input[@name='firstname']")).sendKeys("Enes");
		Thread.sleep(2000);
		
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.xpath("html/body/div/div/div/div/form/input[@type='text']")).sendKeys("standard_user");
		driver.findElement(By.xpath("html/body/div/div/div/div/form/input[@data-test='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("html/body/div/div/div/div/form/input[@class='btn_action']")).click();
		Thread.sleep(2000);
		
		
		driver.quit();
		
		
	}

}
