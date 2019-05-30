package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class DynamicTable  extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2ftestcomplete11%2fWebOrders%2fDefault.aspx");
		//log in the application
		sendText(driver.findElement(By.cssSelector("input[id$='username']")),"tester");
		sendText(driver.findElement(By.cssSelector("input[id*='password']")),"test");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		//get number of rows and columns
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr"));
		List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr[1]/th"));
		//click on the checkbox net to Susan McLarenSusan McLaren
		String expectedValue = "Susan McLaren";
		boolean valueFound=false;
		for(int i=2;i<=rows.size(); i++) {
			String rowText=driver.findElement(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr[" + i + "]/td[2]")).getText();
			if(rowText.contains(expectedValue)) {
				driver.findElement(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr[" + i + "]/td[1]")).click();
				break;
			}
		}
		
		Thread.sleep(2000);
		driver.quit();
	}

}
