package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
	/*
	 * TC 1: Facebook login: Open chrome browser Go to “https://www.facebook.com/”
	 * Enter valid username and valid password and click login User successfully
	 * logged in
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fezac\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
       // driver.get("https://www.facebook.com");
        driver.navigate().to("https://www.facebook.com");
        
        driver.findElement(By.xpath("//a[contains(text(),'Forgot')]")).click();
        driver.navigate().back();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[starts-with(@data-testid,'royal_e')]")).sendKeys("frankbahar07@gmail.com");
        driver.findElement(By.xpath("//input[starts-with(@id,'pass')]")).sendKeys("Syntax2019");
        
     
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[starts-with(@aria-label,'Log')]")).click();
        
        driver.manage().window().wait(2000);
        driver.quit();
    	}
}
