package com.class05;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonLinks {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\users\\fezac\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println(links.size());
		int count = 0;
		Iterator<WebElement> it = links.iterator();
		while (it.hasNext()) {
			String linkTest = it.next().getText();
			if (!linkTest.isEmpty()) {
				System.out.println(linkTest);
				count++;
			}
		}
		System.out.println("Total number on links with text " + count);
		driver.quit();
	}

}
