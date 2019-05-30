package com.class11;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

/*TC 1: Users Application Form Fill1.Open chrome browser
 * 2.Go to “http://uitestpractice.com/”
 * 3.Click on “Forms” link
 * 4.Fill out the entire form
 * 5.Close the browser
 * MUST USE Functions: 
*/
public class WebTableTask1 extends CommonMethods {

	public static void main(String[] args) {
		setUpDriver("chrome", "http://uitestpractice.com");
		click(driver.findElement(By.xpath("//a[text()='Form']")));
		sendText(driver.findElement(By.cssSelector("#firstname")), "Enes");
		sendText(driver.findElement(By.cssSelector("#lastname")), "Kanter");
		click(driver.findElement(By.xpath("//div[3]/label[3]/input")));
		List<String> selectValues = new ArrayList<>();
		selectValues.add("read");
		selectValues.add("cricket");	
		selectValueFromCheckbox(driver.findElements(By.xpath("//input[@type='checkbox']")), selectValues);
		selectValueFromDD(driver.findElement(By.cssSelector("#sel1")), "Canada");
		sendText(driver.findElement(By.cssSelector("#datepicker")),"05/10/1980");
		sendText(driver.findElement(By.cssSelector("#phonenumber")),"201 345 4556");
		sendText(driver.findElement(By.cssSelector("#username")),"eneskanter");
		sendText(driver.findElement(By.cssSelector("#email")),"eneskanter@gmail.com");
		sendText(driver.findElement(By.cssSelector("#comment")),"Happy Ramadan");
		sendText(driver.findElement(By.cssSelector("#pwd")),"enes@123");
					
		quitDriver();
	}

}
