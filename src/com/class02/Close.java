package com.class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Close {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fezac\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://cnn.com");
		String title = driver.getTitle();
		driver.get("http://ebay.com");
		driver.get("http://paypal.com");
		Thread.sleep(2000);
		System.out.println(title);
		driver.close();
		Thread.sleep(2000);
		driver.get("http://yahoo.com");
		Thread.sleep(2000);
		driver.quit();
		/*
		 * driver.get("http://amazon.com"); driver.quit();
		 */

	}

}
