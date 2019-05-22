package com.class06;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownReview {

	public static void main(String[] args) throws InterruptedException {
		//if we do not set property we will get IllegalStateExeception
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\fezac\\Selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.toolsqa.com/automation-practice-form");
		//identify DD with ,<select>
		WebElement countryDD = driver.findElement(By.id("continents"));
		//pass the Select class constructor
		Select select = new Select(countryDD);
		//find how many options is available
		List<WebElement> alllOptions = select.getOptions();
		System.out.println("# of options in Country DD : " + alllOptions.size());
		System.out.println("All options from Country DD using Iterator");
		Iterator<WebElement> it = alllOptions.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getText());
		}
		select.selectByVisibleText("Africa");
		Thread.sleep(2000);
		select.selectByIndex(5);
		//select.deselectByIndex(5) you will get UnsupportedOperationException will occur
		
		//working with MultiSelect
		WebElement commandsDD=driver.findElement(By.id("selenium_commands"));
		Select select1 = new Select(commandsDD);
		List<WebElement> allOptions1 = select1.getOptions();
		System.out.println("# of options ins command DD : " + allOptions1.size());
		System.out.println("All options from Command DD using for loop");
		for(int i=0;i<allOptions1.size();i++) {
			System.out.println(allOptions1.get(i).getText());
		}
		if(select1.isMultiple()) { // checks id DD support multiple options
			Thread.sleep(2000);
			select1.selectByVisibleText("Navigation Commands");
			Thread.sleep(2000);
			select1.selectByIndex(2);
			select1.selectByIndex(3);
			select1.selectByIndex(4);
			Thread.sleep(7000);
		}//Deselecting options from multiple select
		select1.deselectByIndex(3);
		select1.deselectByVisibleText("Navigation Commands");
		Thread.sleep(2000);
		select1.deselectAll();
		Thread.sleep(2000);
		driver.quit();
	}

}
