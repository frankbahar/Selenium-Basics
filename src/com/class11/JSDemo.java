package com.class11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class JSDemo extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		String url="https://www.toolsqa.com/automation-practice-form/";
		setUpDriver("chrome", url);
		Thread.sleep(2000);
		//scroll down to the page
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,550)");//scroll down
		Thread.sleep(2000);
//		js.executeScript("window.scrollBy(0, -400)");// scroll up
//		Thread.sleep(2000);
//		WebElement label=driver.findElement(By.xpath("//label[text()='Automation Tool']"));
//		js.executeScript("arguments[0].scrollIntoView(true);", label);
		
		//click on QTP
		List<WebElement> toolsChbx=driver.findElements(By.name("tool"));
		for (WebElement chbox: toolsChbx) {
			if (chbox.isEnabled()) {
				
				if (chbox.getAttribute("value").equals("QTP")) {
					if (!chbox.isSelected()) {
						chbox.click();
						break;
					}else {
						System.out.println("Checkbox is selected by default");
					}
				}
			}else {
				System.out.println("Checkbox is not enbaled");
			}
		}
		WebElement el=driver.findElement(By.name("submit"));
		js.executeScript("arguments[0].click();", el);
		
		Thread.sleep(7000);
		driver.quit();
	}

}
