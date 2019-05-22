package com.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class Iframedemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "http://uitestpractice.com/Students/Switchto");
		// way-1
		// driver.switchTo().frame("iframe_a");
		// way-2
		// WebElement ele = driver.findElement(By.xpath("//iframe[@name='iframe_a']"));
		// driver.switchTo().frame(ele);
		// way-3
		driver.switchTo().frame(0);

		driver.findElement(By.id("name")).sendKeys("Enes");
		driver.switchTo().defaultContent();
		boolean switchDisplayed = driver.findElement(By.xpath("//h2[text()='SwitchTo']")).isDisplayed();

		Thread.sleep(2000);
		if (switchDisplayed) {
			driver.quit();
		}
	}

}
