package com.class07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import utils.CommonMethods;

public class WindowsHomework extends CommonMethods{
	/*
	 * ToolsQA Windows verification Open chrome browser Go to
	 * “https://the-internet.herokuapp.com/” Click on “Multiple Windows” link Click
	 * on “Elemental Selenium” Verify title of second window is “Elemental Selenium:
	 * Receive a Free, Weekly Tip on Using Selenium like a Pro” Close second window
	 * Click on “Click Here” link Verify title if newly open window is “New Window”
	 * Close second window Verify title of second window is “The Internet” Quit
	 * browser NOTE: Selenium execution could be too fast, please use Thread.sleep
	 */
	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "https://the-internet.herokuapp.com");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Elemental Selenium")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		String expected = "Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro";
		driver.switchTo().window(child);
		String title = driver.getTitle();
		if(title.equalsIgnoreCase(expected)) {
			System.out.println("Title is " + title + " and verified");
		}else {
			System.out.println("Title is " + title + " Expected " + expected + " could not verified");
		}
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(parent);
		driver.findElement(By.linkText("Click Here")).click();
		windows = driver.getWindowHandles();
		it = windows.iterator();
		parent = it.next();
		child = it.next();
		expected = "New Window";
		driver.switchTo().window(child);
		title = driver.getTitle();
		if(title.equalsIgnoreCase(expected)) {
			System.out.println("Title is " + title + " and verified");
		}else {
			System.out.println("Title is " + title + " Expected " + expected + " could not verified");
		}
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(parent);
		title = driver.getTitle();
		expected = "The Internet";
		if(title.equalsIgnoreCase(expected)) {
			System.out.println("Title is " + title + " and verified");
		}else {
			System.out.println("Title is " + title + " Expected " + expected + " could not verified");
		}
		Thread.sleep(2000);
		driver.quit();

	}

}
