package com.class08;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import utils.CommonMethods;

public class MouseOverTest extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "https://www.spicejet.com");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Add-Ons']"))).build().perform();
		driver.findElement(By.xpath("//a[text()='Priority Check-in']")).click();
		
		driver.get("https://www.toolsqa.com/");
		action.moveToElement(driver.findElement(By.xpath("//nav/ul/li[7]/a/span/span[text()='DEMO SITES']"))).build().perform();
		driver.findElement(By.xpath("//nav/ul/li[7]/ul/li[1]/a/span/span")).click();
		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for(String window:windows) {
			if(!window.equalsIgnoreCase(parent)) {
				driver.switchTo().window(window);
				driver.findElement(By.xpath("//a[text()='Menu']")).click();
				action.moveToElement(driver.findElement(By.xpath("//div[text()='Music']"))).build().perform();
				Thread.sleep(2000);
				action.moveToElement(driver.findElement(By.xpath("//div[contains(@id,'ui-id-13')]"))).build().perform();
				Thread.sleep(2000);
				action.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Big Band')]"))).build().perform();
				driver.findElement(By.xpath("//div[contains(text(),'Big Band')]")).click();
				Thread.sleep(2000);
				driver .close();
			}
		}
		driver.switchTo().window(parent);
	
		
		Thread.sleep(2000);
		driver.quit();

	}

}
