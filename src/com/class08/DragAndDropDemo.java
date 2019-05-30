package com.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import utils.CommonMethods;

public class DragAndDropDemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		setUpDriver("chrome", "http://jqueryui.com/droppable");
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.xpath("//*[@id='draggable']")))
				.moveToElement(driver.findElement(By.xpath("//*[@id='droppable']"))).release().build().perform();

		driver.get("https://demoqa.com");
		driver.findElement(By.xpath("//a[text()='Droppable']")).click();
		action.clickAndHold(driver.findElement(By.xpath("//*[@id='draggable']")))
				.moveToElement(driver.findElement(By.xpath("//*[@id='droppable']"))).release().build().perform();

		Thread.sleep(2000);
		driver.quit();

	}

}
