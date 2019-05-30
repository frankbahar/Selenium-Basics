package com.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class DropDownTest extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		String url = "https://www.toolsqa.com/automation-practice-form/";
		setUpDriver("chrome", url);
		WebElement countriesDD = driver.findElement(By.cssSelector("#continents"));
		selectValueFromDD(countriesDD, "Australia");
		
		Thread.sleep(2000);
		driver.quit();
	}

}
