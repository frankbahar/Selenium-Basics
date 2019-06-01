package com.class11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;


public class CalendarTask extends CommonMethods {
	/*
	 * : Table headers and rows verification 1.Open chrome browser 2.Go to
	 * “https://jqueryui.com/” 3.Click on “Datepicker” 4.Select August 10 of 2019
	 * 5.Verify date “08/10/2019” has been entered succesfully 6.Close browser
	 */ public static void main(String[] args) {
		setUpDriver("chrome", "https://jqueryui.com");
		click(driver.findElement(By.xpath("//a[text()='Datepicker']")));
		String expectedDay= "10";
		String expectedDate = "08/10/2019";
		switchToFrame(0);
		click(driver.findElement(By.cssSelector("#datepicker")));
		while (true) {
			if (driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText().equals("August")) {
				// get all cells
				List<WebElement> cells = driver
						.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
				for (WebElement cell : cells) {
					// get text of each cell
					String cellText = cell.getText();
					if (cellText.equals(expectedDay)) {
						cell.click();
					}
				}
				break;
			} else {
				click(driver.findElement(By.xpath("//span[text()='Next']")));
			}

		}
		String actualDate=driver.findElement(By.cssSelector("#datepicker")).getAttribute("value"); 
		if(actualDate.equals(expectedDate)) {
			System.out.println(expectedDate + " is selected and verified and test PASSED");
		}else {
			System.out.println("Expected date is " + expectedDate + " but actaul date is " + actualDate + " could not verified and test FAILED");
					
		}
		driver.switchTo().defaultContent();

		quitDriver();
	}
}
