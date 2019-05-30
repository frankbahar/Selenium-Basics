package com.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonMethods;

public class ExplicitWaitTask1 extends CommonMethods{
	/*
	 * TC 1: Verify element is present Open chrome browser Go to
	 * “https://the-internet.herokuapp.com/” Click on “Click on the “Dynamic
	 * Loading” link Click on “Example 1...” and click on “Start” Verify element
	 * with text “Hello World!” is displayed Close the browser
	 */
	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "https://the-internet.herokuapp.com");
		driver.findElement(By.xpath("//a[text()='Dynamic Loading']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Example 1: ')]")).click();
		driver.findElement(By.xpath("//button[contains(.,'Start')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String expected = "Hello World!";
		WebElement element = driver.findElement(By.xpath("//div[@id='finish']"));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		boolean flag = element.isDisplayed();
		if(flag) {
			String text = element.getText();
			if(text.equalsIgnoreCase(expected)) {
				System.out.println("Elemenent is displayed and verified : " + expected);
			}else {
				System.out.println("Elemenent is displayed could not verified : " + expected);
			}
		}else {
			System.out.println("Element is NOT displayed");
		}
		
		driver.quit();

	}

}
