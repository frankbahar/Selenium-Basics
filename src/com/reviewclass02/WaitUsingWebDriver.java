package com.reviewclass02;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonMethods;

public class WaitUsingWebDriver extends CommonMethods{

	public static void main(String[] args) {
		setUpDriver("chrome", "https://www.travelocity.com");
		click(driver.findElement(By.id("tab-flight-tab-hp")));
		sendText(driver.findElement(By.id("flight-origin-hp-flight")), "New York (NYC-All Airports)");
		sendText(driver.findElement(By.id("flight-destination-hp-flight")), "Istanbul, Turkey (IST-All Airports)");
		sendText(driver.findElement(By.cssSelector("#flight-departing-hp-flight")), "06/20/2019");
		sendText(driver.findElement(By.cssSelector("#flight-returning-hp-flight")), "07/20/2019");
		click(driver.findElement(By.xpath("//button[@data-gcw-change-submit-text='Search']")));
		driver.findElement(By.cssSelector("div[class='bold announce-able']")).isDisplayed();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("div[class='bold announce-able']")));
		quitDriver();
		
	}

}
