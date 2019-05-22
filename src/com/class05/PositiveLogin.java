package com.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*TC 1: Swag Labs Positive login:
Open chrome browser
Go to “https://www.saucedemo.com/”
Enter valid username and valid password and click login
Verify robot icon is displayed
Verify “Products” text is available next to the robot icon*/

public class PositiveLogin {
	public static String userName = "standard_user";
	public static String password = "secret_sauce";
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\users\\fezac\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys(userName);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.cssSelector(".btn_action")).click();
		WebElement robot = driver.findElement(By.cssSelector(".peek"));
		WebElement productTxt = driver.findElement(By.xpath("//div[text()='Products']"));
		String valueProduct = productTxt.getText();
		
		if(robot.isDisplayed() && valueProduct.equals("Products")) {
			System.out.println(userName +" is logged in Test Passed");
		} else {
			System.out.println(userName + " is NOT logged is Test Failed");
		}
		Thread.sleep(3000);
		
		driver.quit();		

	}

}
