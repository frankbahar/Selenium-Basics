package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParaBankDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fezac\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/register.htm");
		driver.findElement(By.id("customer.firstName")).sendKeys("Enes");
		driver.findElement(By.name("customer.lastName")).sendKeys("Kanter");
		driver.findElement(By.id("customer.address.street")).sendKeys("312 Main Street");
		driver.findElement(By.name("customer.address.city")).sendKeys("Portland");
		driver.findElement(By.id("customer.address.state")).sendKeys("OR");
		driver.findElement(By.name("customer.address.zipCode")).sendKeys("77982");
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("314 456 7798");
		driver.findElement(By.name("customer.ssn")).sendKeys("123-45-6789");
		driver.findElement(By.name("customer.username")).sendKeys("Eneskanter");
		driver.findElement(By.id("customer.password")).sendKeys("12345678");
		driver.findElement(By.name("repeatedPassword")).sendKeys("12345678");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("table.form2:nth-child(1) tbody:nth-child(1) tr:nth-child(13) td:nth-child(2)>input.button")).click();
		

	}

}
