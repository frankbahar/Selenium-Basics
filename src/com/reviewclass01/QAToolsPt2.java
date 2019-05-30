package com.reviewclass01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class QAToolsPt2 extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "https://www.toolsqa.com/automation-practice-form/");
		String expectedTitle="Demo Form for practicing Selenium Automation";
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.equalsIgnoreCase(expectedTitle)) {
			System.out.println("You are in the right place");
		}else {
			System.out.println("You are in the WRONG place");
		}
		driver.findElement(By.name("firstname")).sendKeys("Enes");
		List<WebElement> list = driver.findElements(By.tagName("a"));
		for(WebElement link: list) {
			System.out.println(link.getText());
		}
		Thread.sleep(2000);
		driver.quit();

	}

	private static void sleep(int i) {
		// TODO Auto-generated method stub
		
	}

}
