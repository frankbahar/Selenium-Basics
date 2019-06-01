package com.class12;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;

import utils.CommonMethods;

public class JavaScriptExecuterConcept extends CommonMethods {

	@BeforeClass
	public void setup() {
		setUpDriver("chrome", "https://www.saucedemo.com");
	}

	@Test
	public void javaScriptTest() throws IOException, InterruptedException {
		WebElement loginBtn = driver.findElement(By.cssSelector(".btn_action"));
		
		flash(loginBtn); // highlight the element
		drawBorder(loginBtn); // draw a border
		// take screenshot and store as file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("src/com/class12/googlescreenshot.png"));
		// generate alert
		 //generateAlert("There is an issue with Login button on Login Page");
		 //driver.switchTo().alert().accept();
		sendText(driver.findElement(By.id("user-name")), "standard_user");
		sendText(driver.findElement(By.id("password")), "secret_sauce");
		//click on any element by using JS executor
		clickElementByJS(loginBtn);
		//refresh page 
		//1 using selenium
		driver.navigate().refresh();
		//2.using JS executor
		refreshBrowserByJS();
		//get the title of the page by JS
		System.out.println("Title is " + getTitleByJS());
		//get the page text (which not method in Selenium
		System.out.println("Inner text is : "+ getPageInnerText());
		// scroll page down
		scrollPageDown();
		Thread.sleep(2000);
		WebElement cart = driver.findElement(By.cssSelector("#shopping_cart_container > a > svg > path"));
		 scrollIntoView(cart);
		Thread.sleep(2000);
	}

	public static void flash(WebElement element) {
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 3; i++) {
			changeColor("rgb(0,200,0)", element);
			changeColor(bgcolor, element);
		}
	}

	public static void changeColor(String color, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}

	public static void drawBorder(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid black'", element);
	}

	public static void generateAlert(String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}
	
	public static void clickElementByJS(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
			try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}

	public static void refreshBrowserByJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}
	
	public static String getTitleByJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static String getPageInnerText() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String text = js.executeScript("return document.documentElement.innerText;").toString();
		return text;
	}
	
	public static void scrollPageDown() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	@AfterClass
	public void tearDown() {
		quitDriver();
	}

}
