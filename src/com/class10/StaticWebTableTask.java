package com.class10;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class StaticWebTableTask extends CommonMethods {
	/*
	 * TC 1: Table headers and rows verification
	 * 
	 * Open chrome browser Go to “https://the-internet.herokuapp.com/” Click on
	 * “Click on the “Sortable Data Tables” link Verify tables consist of 4 rows and
	 * 6 columns Print name of all column headers Print data of all rows
	 */
	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "https://the-internet.herokuapp.com");
		driver.findElement(By.xpath("//a[text()='Sortable Data Tables']")).click();
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println("Table has rows count is : " + rows.size());
		System.out.println("-----------------------Rows data---------------- ");
		for (WebElement row : rows) {
			System.out.println(row.getText());
		}
		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		System.out.println("Table column count is " + cols.size());
		System.out.println("------------Column Data------------------");
		Iterator<WebElement> it = cols.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().getText());
		}

		// how to print value cell by cell
		// 1. loop thru all rows
		// 2 loop thr all cols
		// 3 driver
		
		//1 way
		for (int i = 1; i <= rows.size(); i++) {
			for (int j = 1; j <= cols.size(); j++) {
				String cellText = driver
						.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
				System.out.println(cellText);
			}
		}
		// 2nd way 
		List<WebElement> cells = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td"));
		for(WebElement cell : cells) {
			System.out.println(cell.getText());
		}
		
		Thread.sleep(2000);
		driver.quit();

	}

}
