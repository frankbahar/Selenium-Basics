package com.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSAlertHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\users\\fezac\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://uitestpractice.com/");
		//click on Switch link & alert button
			driver.findElement(By.linkText("Switch to")).click();
			driver.findElement(By.id("alert")).click();
		Thread.sleep(2000);
		//if we do not handle alert we will get UnhandledAlertException
		//--> unexpected alert open
		//driver.findElement(By.id("confirm")).click();
		//switch focus to the alert window
		Alert alert=driver.switchTo().alert();
		alert.accept();
		//click on confirm button
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(2000);
		
		Alert confirmAlert=driver.switchTo().alert();
		//getting text of an alert
		String alertText=confirmAlert.getText();
		System.out.println("Text of confirm alert="+alertText);
		confirmAlert.dismiss();
		
		driver.findElement(By.id("prompt")).click();
		Thread.sleep(2000);
		Alert propmtAlert=driver.switchTo().alert();
		//getting text of an alert
		System.out.println("Text of prompt alert="+propmtAlert.getText());
		propmtAlert.accept();
		
		Thread.sleep(2000);
		driver.quit();
	}
}
