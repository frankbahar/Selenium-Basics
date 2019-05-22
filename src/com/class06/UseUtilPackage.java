package com.class06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import utils.CommonMethods;

public class UseUtilPackage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\users\\fezac\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("http://uitestpractice.com/");
		driver.findElement(By.linkText("Select")).click();
		// working with Single DD
		WebElement countriesDD = driver.findElement(By.id("countriesSingle"));

		CommonMethods.selectValueFromDD(countriesDD, "United states of America");

		// working with muplitple DD
		WebElement multDD = driver.findElement(By.cssSelector("select#countriesMultiple"));
		Select select = new Select(multDD);
		List<WebElement> optionList = select.getOptions();
		int ddSize = optionList.size();
		System.out.println("# of options in multiple countries dd=" + ddSize);
		// check if we can select multiple options
		if (select.isMultiple()) {
			for (int i = 0; i < ddSize; i++) {
				select.selectByIndex(i);
				Thread.sleep(1000);
			}
			// another way
			for (WebElement option : optionList) {
				option.click();
				Thread.sleep(1000);
			}
		}

		Thread.sleep(2000);
		driver.quit();
	}
}
