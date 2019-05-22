package com.class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverCommands {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fezac\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("google")) {
			System.out.println("This is the right title");
		} else {
			System.out.println("sorry this is not the title");
		}

		driver.get("http://facebook.com");
		String title1 = driver.getTitle();
		System.out.println(title1);
		if (title1.equalsIgnoreCase("Facebook - Log In or Sign Up")) {
			System.out.println("This is the right title");
		} else {
			System.out.println("sorry this is not the title");
		}

		driver.quit();
	}

}
