package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\users\\fezac\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Pass')]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[starts-with(@class,'btn_')]")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
