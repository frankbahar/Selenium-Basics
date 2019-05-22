package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
	/*
	 * TC 2: Mercury Tours Registration: Open chrome browser Go to
	 * “http://newtours.demoaut.com/” Click on Register Link Fill out all required
	 * info Click Submit User successfully registered (Create 2 scripts using
	 * different locators)
	 */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fezac\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com");
        
	
        driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
        driver.findElement(By.xpath("//input[contains(@name,'first')]")).sendKeys("Enes");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Kanter");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("201 456 33 45");
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("eneskanter@gmail.com");
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("21 main st.");
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Portaland");
        driver.findElement(By.xpath("//input[@name='state']")).sendKeys("OR");
        driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("87345"); 
        driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys("eneskanter@gmail.com");
        driver.findElement(By.xpath("//input[contains(@name,'pass')]")).sendKeys("Syntax2019");
        driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("Syntax2019");
        driver.findElement(By.xpath("//input[@type='image']")).click();
        
        Thread.sleep(3000);
        
        driver.quit();
        
	}

}
