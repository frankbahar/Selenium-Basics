package com.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonMethods;

public class ExplicitWaitDemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "http:\\www.facebook.com");
		clickOn(driver.findElement(By.cssSelector("#loginbutton")),20);
		driver.navigate().back();
		clickOn(driver.findElement(By.xpath("//a[text()='Create a Page']")),10);
		Thread.sleep(2000);
		driver.quit();

	}

	public static void clickOn(WebElement locator, int timeout) {
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
}
