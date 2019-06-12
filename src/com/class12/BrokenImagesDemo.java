package com.class12;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class BrokenImagesDemo extends CommonMethods{
	
	@BeforeMethod
	public void setup() {
		setUpDriver("chrome", "https://the-internet.herokuapp.com");
	}
	
	@Test
	public void brokenImagesVerification() throws Exception {
		List<WebElement> images = driver.findElements(By.tagName("a"));
		System.out.println("Total links : " + images.size());
		boolean hasBrokenLinks = false;
		for(WebElement link:images) {
			URL url = new URL(link.getAttribute("href"));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if(conn.getResponseCode()==200) {
				System.out.println("Link is valid: " + link.getText());
			}else {
				System.out.println("Link is invalid: "+ link.getText());
				hasBrokenLinks=true;
			}
		}
		if(hasBrokenLinks) {
			System.out.println("Has broken links");
		}
		//1. get the list of all the images
		images=driver.findElements(By.tagName("img"));
		System.out.println("Total Images: " + images.size());
		//2.iterate the list
		for(WebElement image : images) {
			String src = image.getAttribute("src");
		}
		
		quitDriver();
	}
	
	@AfterMethod
	public void tearDown() {
		
	}

}
