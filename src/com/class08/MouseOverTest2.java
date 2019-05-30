package com.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.CommonMethods;

public class MouseOverTest2 extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		setUpDriver("chrome", "http://seleniumpractise.blogspot.com/2016/08/how-to-perform-mouse-hover-in-selenium.html");
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.cssSelector("button.dropbtn"));
		action.moveToElement(ele).build().perform();
		Thread.sleep(2000);
		List<WebElement> links = driver.findElements(By.xpath("//div[@class='dropdown-content']/a"));
		int total_count = links.size();
		for(int i=0;i<total_count;i++) {
			WebElement elem = links.get(i);
			String text = elem.getAttribute("innerHTML");
			boolean status = elem.isEnabled();
			System.out.println("Links name is " + text + " and link status is " + status);
			if(text.equals("Appium")) {
				elem.click();
				break;
			}
		}
		Thread.sleep(2000);
		driver.quit();
		
	}

}
