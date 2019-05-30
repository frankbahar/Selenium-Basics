package com.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonMethods;

public class ExplicitWaitTask2 extends CommonMethods {
	/*
	 * TC 2: Verify element is clickable
	 * 1.Open chrome browser
	 * 2.Go to “https://the-internet.herokuapp.com/”
	 * 3.Click on “Click on the “Dynamic Controls” link
	 * 4.Select checkbox and click Remove
	 * 5.Click on Add button and verify “It's back!” text is displayed
	 * 6.Close the browser
	 */
	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "https://the-internet.herokuapp.com");
		driver.findElement(By.xpath("//a[text()='Dynamic Controls']")).click();
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
	
		driver.findElement(By.xpath("//button[text()='Remove']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String expected = "It's back!";
		WebElement element = driver.findElement(By.xpath("//button[text()='Add']"));
		wait.until(ExpectedConditions.visibilityOf(element));
		boolean flag = element.isDisplayed();
		if (flag) {
			element.click();
			WebElement ele = driver.findElement(By.cssSelector("#message"));
			wait.until(ExpectedConditions.visibilityOf(ele));
			boolean flag1 = ele.isDisplayed();
			if (flag1) {
				String text = ele.getText();
				if (text.equalsIgnoreCase(expected)) {
					System.out.println("Elemenent is displayed and verified : " + expected);
				} else {
					System.out.println("Elemenent is displayed could not verified : actual :" + text + " expected : " + expected);
				}
			} else {
				System.out.println("Element is NOT displayed");
			}
		}
		driver.quit();

	}

}
