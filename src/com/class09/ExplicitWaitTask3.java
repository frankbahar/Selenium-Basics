package com.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonMethods;

public class ExplicitWaitTask3 extends CommonMethods {
	/*
	 * 1 Open chrome browser 
	 * 2.Go to “https://the-internet.herokuapp.com/” 
	 * 3.Click on the “Dynamic Controls” link 
	 * 4.Click on enable button 
	 * 5.Enter “Hello” and verify text is entered successfully 
	 * 6.Close the browser
	 */
	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "https://the-internet.herokuapp.com");
		driver.findElement(By.xpath("//a[text()='Dynamic Controls']")).click();
		driver.findElement(By.xpath("//button[.='Enable']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		String expected = "It's enabled!";
		
	//	wait.until(ExpectedConditions.visibilityOf(element));
		WebElement msg = driver.findElement(By.xpath("//p[@id='message']"));
		wait.until(ExpectedConditions.textToBePresentInElement(msg,expected));
	//	WebElement element = driver.findElement(By.xpath("//p[@id='message']"));
		WebElement element = driver.findElement(By.xpath("//input[@type='text']"));
		
		boolean flag = element.isEnabled();
		if (flag) {
			expected = "Hello";
			element.sendKeys(expected);
			
			String text = element.getAttribute("value");
			if (text.equalsIgnoreCase(expected)) {
				System.out.println("Elemenent is enabled and " + expected + " is entered successfuly");
			} else {
				System.out.println("Elemenent is enabled but " + expected + " could not entered successfuly");
			}
		} else {
			System.out.println("Element is NOT enabled");
		}

		driver.quit();

	}

}
