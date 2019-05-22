package com.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NegativeLogin {
	/*
	 * TC 2: Swag Labs Negative login: Open chrome browser Go to
	 * “https://www.saucedemo.com/” Enter invalid username and password and click
	 * login Verify error message contains: “Username and password do not match any
	 * user in this service”
	 */
	public static String userName = "standard_user1";
	public static String password = "secret_sauce1";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\users\\fezac\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys(userName);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.cssSelector(".btn_action")).click();
		WebElement errorMsg = driver.findElement(By.cssSelector("h3[data-test='error']"));
		String valueErrorMsg = errorMsg.getText();
		
		if(valueErrorMsg.contains("Username and password do not match any user in this service")) {
			System.out.println(userName +" could not logged in Test Passed");
		} else {
			System.out.println(userName + " is logged in Test Failed");
		}
		Thread.sleep(3000);
		
		driver.quit();		

	}

}
