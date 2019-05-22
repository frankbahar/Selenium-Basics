package com.class07;

import org.openqa.selenium.By;

import utils.CommonMethods;

/*TC 1: ToolsQA Frame verification
Open chrome browser
Go to “https://www.toolsqa.com/iframe-practice-page/”
Click on “Blogs” link inside first frame
Verify element “Interactions” is present in second frame
Navigate to Home Page
Quit browser*/
public class IFrameTask extends CommonMethods {

	public static void main(String[] args) {
		setUpDriver("chrome", "https://www.toolsqa.com/iframe-practice-page");
		driver.switchTo().frame("IF1");
		driver.findElement(By.xpath("//a[text()='Git Log']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		boolean inter = driver.findElement(By.xpath("//h3[text()='Interactions']")).isDisplayed();
		if (inter) {
			driver.switchTo().defaultContent();
			driver.close();
		}
	}

}
