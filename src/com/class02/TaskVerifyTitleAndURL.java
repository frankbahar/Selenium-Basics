package com.class02;

/*TC 1: Amazon Page Title Verification:
Open chrome browser
Go to “https://www.amazon.com/”
Verify Title “Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more” is displayed

TC 2: Syntax Page URL Verification:
Open chrome browser
Navigate to “https://www.syntaxtechs.com/”
Navigate to “https://www.google.com/”
Navigate back to Syntax Technologies Page
Refresh current page
Verify url contains “Syntax”*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskVerifyTitleAndURL {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fezac\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		String title = driver.getTitle();
		System.out.println(title);
		String expected = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		if(title.equalsIgnoreCase(expected)) {
			System.out.println("Title is correct");
		}else {
			System.out.println("Title is not correct");
		}
		driver.navigate().to("https://www.syntaxtechs.com/");
		Thread.sleep(1000);
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		String url = driver.getCurrentUrl();
		if(url.toUpperCase().contains("SYNTAX")) {
			System.out.println("Url contains Syntax");
		}else {
			System.out.println("Url does not contain Syntax");
		}
		
		driver.quit();
	}

}
