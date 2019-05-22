package com.class06;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectAndDeselectValues {
	/*
	 * Select and Deselect values Open chrome browser Go to
	 * “http://uitestpractice.com/” Click on “Select” tab Verify how many options
	 * available in the first drop down and then select “United states of America”
	 * Verify how many options available in the second drop down and then select
	 * all. Deselect China from the second drop down Quit browser
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\users\\fezac\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://uitestpractice.com/");
		driver.findElement(By.xpath("//a[text()='Select']")).click();
		WebElement firstDD = driver.findElement(By.id("countriesSingle"));
		Select select = new Select(firstDD);
		System.out.println("First DD has " + select.getOptions().size() + " options available");
		select.selectByVisibleText("United states of America");
		Thread.sleep(2000);
		WebElement secondDD = driver.findElement(By.id("countriesMultiple"));
		Select select1 = new Select(secondDD);
		List<WebElement> options2 = select1.getOptions();
		
		System.out.println("Second DD has " + select1.getOptions().size() + " options available");
		if(select1.isMultiple()) {
			for(int i=0; i <select1.getOptions().size();i++) {
				select1.selectByIndex(i);
			}
			select1.deselectAll();
			Thread.sleep(2000);
			//another way
			for(WebElement option:options2) {
				option.click();
			}
			
		}
		Thread.sleep(3000);
		select1.deselectByVisibleText("China");
		Thread.sleep(3000);
		
		driver.quit();
	}

}
