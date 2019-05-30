package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

/*TC 1: Table headers and rows verification

Open chrome browser
Go to “http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx”
Login to the application
Verify customer “Susan McLaren” is present in the table
Click on customer details
Update customers last name
Verify updated customers name is displayed in table
Close browser*/
public class DynamicWebTableTask extends CommonMethods{

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
		String updatedName= "Susan Snow";
		boolean customerFound=false;
		boolean customerUpdated=false;
		for(int i=2;i<=rows.size(); i++) {
			String rowText=driver.findElement(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr[" + i + "]/td[2]")).getText();
			if(rowText.contains(expectedValue)) {
				customerFound=true;
				driver.findElement(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr[" + i + "]/td[13]")).click();	
				sendText(driver.findElement(By.xpath("//input[contains(@id,'txtName')]")),updatedName);
				driver.findElement(By.xpath("//a[contains(@id,'UpdateButton')]")).click();
				List<WebElement> updatedRows = driver.findElements(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr"));
				for(int j=2;i<=rows.size(); i++) {
					String updatedRowText=driver.findElement(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr[" + i + "]/td[2]")).getText();
					if(updatedRowText.contains(updatedName)) {
						customerUpdated=true;
						break;
					}			
				}			
				break;
			}
		}
		if(customerFound && customerUpdated ) {
			System.out.println("Customer " + expectedValue + " found and updated to " + updatedName);
		}else if(customerFound && !customerUpdated) {
			System.out.println("Customer " + expectedValue + " found and could NOT updated to " + updatedName);
		} else {
			System.out.println("Customer " + expectedValue + " could NOT found");
			
		}
		Thread.sleep(2000);
		driver.quit();

	}

}
