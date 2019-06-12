package com.class12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

/*
 * TC - 12356 - search flight verification
 * Step 1:navigate to URL
 * Step 2: enter details
 * Step 3: verify search is successful
 */
public class FlightSearch extends CommonMethods {
	static String browser = "chrome";

	static String url = "https://www.aa.com/homePage.do";

	@BeforeMethod
	public void setup() {
		setUpDriver(browser, url);
	}

	@Test
	public void searchFlight() throws InterruptedException {
		// enter to and from
		sendText(driver.findElement(By.name("originAirport")), "DCA");
		sendText(driver.findElement(By.name("destinationAirport")), "NYC");
		// click on calendar icon
		click(driver.findElement(By.xpath("//input[@id='aa-leavingOn']/following-sibling::button")));
		// grab element that holds month @ year
		WebElement depMonth = driver.findElement(By.xpath("//div[contains(@class,'ui-corner-left')]/div"));
		while (!depMonth.getText().contains("October")) {
			click(driver.findElement(By.xpath("//a[@title='Next']")));
			Thread.sleep(2000);
			// if we wont performm this action will get
			// staleElementRefenceException: stale element reference: element is not
			// attached to DOM
			depMonth = driver.findElement(By.xpath("//div[contains(@class,'ui-corner-left')]/div"));
		}
		// capturing all cell and then loop and search for specific date
		List<WebElement> depCells = driver
				.findElements(By.xpath("//div[contains(@class,'group-first')]/table/tbody/tr/td"));
		for (WebElement cell : depCells) {
			if (cell.getText().equals("18")) {
				click(cell);
				break;
			}
		}

		click(driver.findElement(By.xpath("//input[@id='aa-returningFrom']/following-sibling::button")));
		// select arrival December 24 and verify you find successful search
		while (true) {
			WebElement arrMonth = driver.findElement(By.xpath("//div[contains(@class,'ui-corner-left')]/div"));
			if (arrMonth.getText().contains("December")) {
				break;
			}
			click(driver.findElement(By.xpath("//a[@title='Next']")));
		}
		List<WebElement> arrCells = driver
				.findElements(By.xpath("//div[contains(@class,'group-first')]/table/tbody/tr/td"));
		for (WebElement cell : arrCells) {
			if (cell.getText().equals("24")) {
				click(cell);
				break;
			}
		}
		Thread.sleep(2000);
//		click(driver.findElement(By.xpath("//*[@id=\"flightSearchForm.button.reSubmit\"]")));
//		Actions action = new Actions(driver);
	//	action.click(driver.findElement(By.xpath("//*[@id=\"flightSearchForm.button.reSubmit\"]"))).perform();
		jsClick(driver.findElement(By.xpath("//*[@id=\"flightSearchForm.button.reSubmit\"]")));
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#aa-pageTitle")));
		WebElement ele = driver.findElement(By.cssSelector("#aa-pageTitle"));
		if (ele.isDisplayed()) {
			if (ele.getText().contains("Choose flights")) {
				System.out.println("Flight found test passed");
			} else {
				System.out.println("Flight cound not find test failed");
			}
		} else {
			System.out.println("Element did not displayed");
		}
	}

	@AfterMethod
	public void tearDown() {
		quitDriver();
	}
}
