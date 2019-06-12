package com.class12;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class OrangeHRMLoginTestwProperties  extends CommonMethods{
	Properties prop;
	
	@Test
	public void loginTest() {
	String filePath="src/configs/credentials.properties";
		
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String browser =  prop.getProperty("browser");
		System.out.println(browser);
		String url =  prop.getProperty("url");
		System.out.println(url);
		setUpDriver(browser, url);
		String username =  prop.getProperty("username");
		System.out.println(username);
		String password =  prop.getProperty("password");
		System.out.println(password);
		sendText(driver.findElement(By.id("txtUsername")), username);
		sendText(driver.findElement(By.cssSelector("#txtPassword")), password);
		click(driver.findElement(By.cssSelector(".button")));
		String expectedText =  prop.getProperty("expectedText");
		System.out.println(expectedText);
		if(driver.findElement(By.xpath("//h1[text()='Dashboard']")).getText().equals(expectedText)) {
			System.out.println("Text match login successful");
		}else {
			System.out.println("Text do not match login failed");
		}	
		quitDriver(); 
	}

}
