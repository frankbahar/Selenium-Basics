package com.reviewclass01;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class ToolasQATask extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome" , "https://www.toolsqa.com/automation-practice-form/");
		List<WebElement> list = driver.findElements(By.cssSelector("input[id^='exp-']"));
		int i =0;
		for(WebElement ele : list) {
			i++;
			if(ele.isEnabled()) {
				ele.click();
				Thread.sleep(2000);
				if(i==4) {
					break;
				}
			}
		}
		/*
		 * list = driver.findElements(By.xpath("//input[@name='exp']"));
		 * Iterator<WebElement> it = list.iterator(); while(it.hasNext()) { WebElement
		 * ele= it.next(); if(ele.isEnabled()) { ele.click(); Thread.sleep(2000); } }
		 */
		String expected="Female";
		list = driver.findElements(By.cssSelector("input[name='sex']"));
		for(WebElement ele:list) {
			if(ele.getAttribute("value").equalsIgnoreCase(expected)) {
				ele.click();
			}
		}
		Thread.sleep(2000);
		
		expected="Selenium";
		list = driver.findElements(By.xpath("//input[starts-with(@id,'tool')]"));
		for(WebElement ele:list) {
			if(ele.getAttribute("value").startsWith(expected)) {
				ele.click();
			}
		}
		Thread.sleep(3000);
		driver.quit();
	}
}
