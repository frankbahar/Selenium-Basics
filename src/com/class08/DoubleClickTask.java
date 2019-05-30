package com.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.CommonMethods;

public class DoubleClickTask extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "https://www.saucedemo.com");
		WebElement element = driver.findElement(By.cssSelector("#password"));
		Actions action = new Actions(driver);
		element.sendKeys("Selenium@123");
		action.doubleClick(element).build().perform();;
		
		Thread.sleep(2000);
		driver.quit();
	}

}
