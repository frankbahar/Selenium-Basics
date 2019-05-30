package com.reviewclass01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.CommonMethods;

public class FacebookTask extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "https://www.facebook.com/");
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Enes");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Kanter");
		
		driver.findElement(By.cssSelector("#u_0_h")).sendKeys("201 435 4556");
		driver.findElement(By.cssSelector("input[data-type='password']")).sendKeys("Selenium@123");
		WebElement ele = driver.findElement(By.cssSelector("#month"));
		Select select = new Select(ele);
		select.selectByVisibleText("May");
		ele = driver.findElement(By.cssSelector("#day"));
		select = new Select(ele);
		select.selectByVisibleText("21");
		ele = driver.findElement(By.cssSelector("#year"));
		select = new Select(ele);
		select.selectByVisibleText("2001");
		
		Thread.sleep(2000);
		driver.quit();
		

	}

}
