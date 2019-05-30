package com.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.CommonMethods;

public class ContexClickRightClick extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome","https://www.saucedemo.com/");
		WebElement element = driver.findElement(By.cssSelector("#user-name"));
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
		
		Thread.sleep(2000);
		driver.quit();
	}

}
