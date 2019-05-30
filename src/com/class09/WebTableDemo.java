package com.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class WebTableDemo extends CommonMethods {

	private static Object expected;

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "https://www.w3schools.com/html/html_tables.asp");

		// *[@id="customers"]/tbody/tr[2]/td[1]
		// *[@id="customers"]/tbody/tr[3]/td[1]
		// *[@id="customers"]/tbody/tr[4]/td[1]
		// *[@id="customers"]/tbody/tr[5]/td[1]
		// *[@id="customers"]/tbody/tr[6]/td[1]
		// *[@id="customers"]/tbody/tr[7]/td[1]
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		System.out.println("Total row # is " + rows.size());

		String beforeXpath = "//*[@id='customers']/tbody/tr[";
		String afterXpath = "]/td[1]";
		String expected = "Island Trading";
		for (int i = 2; i <= 7; i++) {
			String actualXpath = beforeXpath + i + afterXpath;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
			if (element.getText().equals(expected)) {
				System.out.println("Company name : " + element.getText() + " is found at position at " + (i - 1));
				break;
			}
		}
		// *[@id="customers"]/tbody/tr[2]/td[2]
		// *[@id="customers"]/tbody/tr[3]/td[2]
		System.out.println("Customers========================");
		afterXpath = "]/td[2]";
		beforeXpath = "//*[@id='customers']/tbody/tr[";
		expected = "Yoshi Tannamuri";
		for (int i = 2; i <= 7; i++) {
			String actualXpath = beforeXpath + i + afterXpath;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
			if (element.getText().equals(expected)) {
				System.out.println("Contact name : " + element.getText() + " is found at position at " + (i - 1));
				break;
			}
		}
		System.out.println("Country=============================");
		afterXpath = "]/td[3]";
		beforeXpath = "//*[@id='customers']/tbody/tr[";
		expected = "Italy";
		for (int i = 2; i <= 7; i++) {
			String actualXpath = beforeXpath + i + afterXpath;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
			if (element.getText().equals(expected)) {
				System.out.println("Country name : " + element.getText() + " is found at position at " + (i - 1));
				break;
			}
		}
		// handle webtable columns
		// *[@id="customers"]/tbody/tr[1]/th[1]
		// *[@id="customers"]/tbody/tr[1]/th[2]
		// *[@id="customers"]/tbody/tr[1]/th[3]

		String colBeforeXpath = "//*[@id='customers']/tbody/tr[1]/th[";
		String colAfterXpath = "]";
		List<WebElement> cols = driver.findElements(By.xpath(colBeforeXpath.substring(0, colBeforeXpath.length() - 1)));
		int colCount = cols.size();
		System.out.println("Total number of columns are : " + colCount);

		for (int i = 1; i <= colCount; i++) {
			WebElement col = driver.findElement(By.xpath(colBeforeXpath + i + colAfterXpath));
			System.out.println("Column values are: " + col.getText());
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
