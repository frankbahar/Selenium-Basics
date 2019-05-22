package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWorld {

	public static void main(String[] args) {
		
		  System.setProperty("webdriver.chrome.driver",
		  "C:\\Users\\fezac\\Selenium\\chromedriver.exe"); 
		  WebDriver driver = new ChromeDriver(); 
		  driver.get("https://www.google.com/");
		  driver.manage().window().maximize();
		  driver.get("https://www.facebook.com");
		  driver.get("https://www.amazon.com");
		  driver.quit();
		
		  System.setProperty("webdriver.gecko.driver",
		  "C:\\Users\\fezac\\Selenium\\geckodriver.exe");
		  WebDriver driver1 = new FirefoxDriver(); 
		  driver1.get("https://www.google.com/");
		  driver1.manage().window().maximize();
		 

	}

}
