package com.class06;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonDepartmentListVerification {
	/*
	 * Amazon Department List Verification Open chrome browser Go to
	 * “http://amazon.com/” Verify how many department options available. Print each
	 * department Select Computers Quit browser
	 */
	public static void main(String[] args) throws InterruptedException {

		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "C:\\users\\fezac\\Selenium\\geckodriver.exe"); WebDriver driver = new
		 * FirefoxDriver(); driver.manage().timeouts().implicitlyWait(30,
		 * TimeUnit.SECONDS);
		 */

		System.setProperty("webdriver.chrome.driver", "C:\\users\\fezac\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		WebElement departmentDD = driver.findElement(By.id("searchDropdownBox"));
		Select select = new Select(departmentDD);
		List<WebElement> departmentOptions = select.getOptions();
		System.out.println("Amazon has " + departmentOptions.size() + " departments");

		for (WebElement department : departmentOptions) {
			System.out.println(department.getText());
		}

		select.selectByVisibleText("Computers");

		Thread.sleep(3000);
		driver.quit();

	}

}
