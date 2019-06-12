package com.class12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.CommonMethods;

public class BrokenImagesExample extends CommonMethods {

	// *TC 1: OrangeHRM Title Validation
	// TC 2: OrangeHRM Successful Login
	// https://opensource-demo.orangehrmlive.com/
	// Please make sure to use the following: annotations:
	// @BeforeMethod
	// @AfterMethod
	// @Test
	@BeforeMethod
	public void setUp() {

		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com");
	}

	@Test(priority = 0)
	public void checkLogo() throws Throwable {
		String title = driver.getTitle();
		String expctedTitle = "OrangeHRM";
		Assert.assertEquals(title, expctedTitle);
		System.out.println("after hard assert");
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void logo() throws Throwable {
		SoftAssert soft = new SoftAssert();

		try {
			WebElement logo = driver.findElement(By.xpath("//img[contains(@src,'logo.pngwwr')]"));

			soft.assertTrue(logo.isDisplayed());
		} catch (Exception e) {
			// handle exception
		}
		soft.assertAll();
		System.out.println("after soft assert");
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void logIn() throws Throwable {
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		sendText(driver.findElement(By.xpath("//input[@id='txtPassword']")), "admin123");
		driver.findElement(By.cssSelector("input.button")).click();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
