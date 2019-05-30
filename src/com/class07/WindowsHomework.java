
package com.class07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import utils.CommonMethods;

public class WindowsHomework extends CommonMethods {
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
		String parent = driver.getWindowHandle();
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Elemental Selenium")).click();
		Set<String> windows = driver.getWindowHandles();
		for (String child : windows) {
			if (!child.equals(parent)) {
				String expected = "Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro";
				driver.switchTo().window(child);
				String title = driver.getTitle();
				if (title.equalsIgnoreCase(expected)) {
					System.out.println("Title is " + title + " and verified");
				} else {
					System.out.println("Title is " + title + " Expected " + expected + " could not verified");
				}
				Thread.sleep(2000);
				driver.close();
				driver.switchTo().window(parent);
			}
		}
		driver.findElement(By.linkText("Click Here")).click();
		Thread.sleep(3000);
		windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			String child = it.next();
			String expected = "New Window";
			if (!child.equals(parent)) {
				driver.switchTo().window(child);
				String title = driver.getTitle();
				if (title.equalsIgnoreCase(expected)) {
					System.out.println("Title is " + title + " and verified");
				} else {
					System.out.println("Title is " + title + " Expected " + expected + " could not verified");
				}
				Thread.sleep(2000);
				driver.close();
				driver.switchTo().window(parent);
			}
		}
		String title = driver.getTitle();
		String expected = "The Internet";
		if (title.equalsIgnoreCase(expected)) {
			System.out.println("Title is " + title + " and verified");
		} else {
			System.out.println("Title is " + title + " Expected " + expected + " could not verified");
		}
		Thread.sleep(2000);
		driver.quit();

	}

}
