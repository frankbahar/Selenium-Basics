package com.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonMethods;

public class ExplicitWait extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "http://uitestpractice.com");
		driver.findElement(By.xpath("//a[text()='AjaxCall']")).click();
		driver.findElement(By.xpath("//a[contains(.,'This is a Ajax')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
	
		//wait.until(ExpectedConditions.textToBePresentInElement(element, " Linux"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ContactUs")));
		WebElement element = driver.findElement(By.cssSelector(".ContactUs"));
		boolean flag = element.isDisplayed();
		if(flag) {
			String text = element.getText();
			System.out.println(text);
		}else {
			System.out.println("Element is NOT displayed");
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
