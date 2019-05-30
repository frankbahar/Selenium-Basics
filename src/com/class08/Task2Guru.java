package com.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.CommonMethods;

public class Task2Guru extends CommonMethods {
	/*
	 * Task Two Ahead to http://demo.guru99.com/test/drag_drop.html Click on the
	 * Actions Handle the drag and drop Close the browser
	 */

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "http://demo.guru99.com/test/drag_drop.html");
		
		WebElement src= driver.findElement(By.xpath("//a[text()=' BANK ']"));
		WebElement target = driver.findElement(By.cssSelector("#bank>li"));
		
		Actions action = new Actions(driver);
		action.clickAndHold(src);
		action.moveToElement(target);
		action.release(src);
		action.build().perform();
		
		Thread.sleep(5000);
		driver.quit();

	}

}
