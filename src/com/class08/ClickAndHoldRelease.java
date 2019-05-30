package com.class08;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.CommonMethods;

public class ClickAndHoldRelease extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "https://jqueryui.com/droppable");
		driver.switchTo().frame(0);
		WebElement src = driver.findElement(By.cssSelector("#draggable"));
		WebElement target = driver.findElement(By.cssSelector("#droppable"));
		Actions action = new Actions(driver);
		action.clickAndHold(src);
		action.moveToElement(target);
		action.release(src);
		action.build().perform();
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}
