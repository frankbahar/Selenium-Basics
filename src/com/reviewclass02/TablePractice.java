package com.reviewclass02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class TablePractice extends CommonMethods{

	public static void main(String[] args) {
		setUpDriver("chrome", "https://the-internet.herokuapp.com/tables");
		List<WebElement> rows  = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println("Tables row count : " + rows.size());
		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		String expected="Doe";
		boolean isNameFound=true;
		for(int i=1; i<=rows.size(); i++) {
			String actual = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td[1]")).getText();
			System.out.println(actual);
			if(actual.equals(expected)) {
				isNameFound=true;
				driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td[6]")).click();
			}	
		}
		if(!isNameFound) {
			System.out.println("Could not find the name");
		}
		quitDriver();
	}

}
