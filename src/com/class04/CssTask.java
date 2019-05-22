package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssTask {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fezac\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com");  
	
        driver.findElement(By.cssSelector("a[href*='mercuryregister.php']")).click();
        driver.findElement(By.cssSelector("input[name^='first']")).sendKeys("Enes");
        driver.findElement(By.cssSelector("input[name*='astN']")).sendKeys("Kanter");
        driver.findElement(By.cssSelector("input[name$='ne']")).sendKeys("201 456 33 45");
        driver.findElement(By.cssSelector("#userName")).sendKeys("eneskanter@gmail.com");
        driver.findElement(By.cssSelector("input[name$='ss1']")).sendKeys("21 main st.");
        driver.findElement(By.cssSelector("input[name*='it']")).sendKeys("Portaland");
        driver.findElement(By.cssSelector("input[name^='sta']")).sendKeys("OR");
        driver.findElement(By.cssSelector("input[name^='postal']")).sendKeys("87345"); 
        driver.findElement(By.cssSelector("#email")).sendKeys("eneskanter@gmail.com");
        driver.findElement(By.cssSelector("input[name*='pass']")).sendKeys("Syntax2019");
        driver.findElement(By.cssSelector("input[name$='rmPassword']")).sendKeys("Syntax2019");
        driver.findElement(By.cssSelector("input[type$='mage']")).click();
        
        Thread.sleep(3000);
        
        driver.quit();

	}

}
