package com.class08;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.CommonMethods;

public class Task2GuruRightClick extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "http://demo.guru99.com/test/simple_context_menu.html");
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'right')]"));
		Actions action = new Actions(driver);
		action.contextClick(ele).build().perform();
		Thread.sleep(2000);
	
		driver.navigate().refresh();
		ele = driver.findElement(By.xpath("//button[contains(text(),'Double')]"));
		action.doubleClick(ele).build().perform();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		String expected = "You double clicked me.. Thank You..";
		String actual = alert.getText();
		if(actual.equalsIgnoreCase(expected)) {
			System.out.println("Text is " + actual + " verified and Test passed");
		}else {
			System.out.println("Actual Text is " + actual + " and expected text is " + expected + " did NOT verified and Test failed");
		}
		Thread.sleep(2000);
		alert.accept();
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		driver.quit();

	}

}
