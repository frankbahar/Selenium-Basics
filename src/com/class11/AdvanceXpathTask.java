package com.class11;

import org.openqa.selenium.By;

import utils.CommonMethods;

public class AdvanceXpathTask extends CommonMethods{

	public static void main(String[] args) {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com");
		sendText(driver.findElement(By.xpath("//parent::div[@id='divUsername']/span/preceding-sibling::input")), "Admin");
		sendText(driver.findElement(By.xpath("//following-sibling::span[text()='Password']/parent::div/child::input")),"admin123");	
		click(driver.findElement(By.xpath("//parent::div[@id='divLoginButton']/input")));
		
		quitDriver();
	}

}
