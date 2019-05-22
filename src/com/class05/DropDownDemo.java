package com.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\users\\fezac\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.toolsqa.com/automation-practice-form/");

		WebElement continentDD = driver.findElement(By.id("continents"));
		
		Select obj=new Select(continentDD);
		//select by index
		obj.selectByIndex(3);//Australia
		Thread.sleep(2000);
		//select by visibleText
		obj.selectByVisibleText("North America");
		//get allOptions
		List<WebElement> allOptions=obj.getOptions();
		System.out.println(allOptions.size());
		
		
		Thread.sleep(2000);
		driver.quit();
	}


}
