package com.reviewclass02;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonMethods;

public class TaskWeqas extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		String to = "Dublin, Ireland (DUB)";
		String URL = "https://www.travelocity.com/Flights?SEMCID=TRAVELOCITY-US.MULTILOBF.GOOGLE.GT-c-EN.FLIGHT&&SEMDTL=a1752860948.b138198135423.d1277162028531.e1c.f11t2.g1kwd-28170460.h1e.i1.j19007576.k1.l1g.m1.n1&gclid=EAIaIQobChMI9a7rtPfB4gIVE9VkCh0bagcREAAYAiAAEgI1R_D_BwE&gclsrc=aw.ds";
		setUpDriver("chrome", URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("input[id='flight-origin-flp']"))
				.sendKeys("Alexandria, LA (AEX-Alexandria In");

		driver.findElement(By.cssSelector("input[id='flight-destination-flp']")).sendKeys(to);

		driver.findElement(By.cssSelector("input[id='flight-departing-flp']")).sendKeys("01/31/2020");
		driver.findElement(By.cssSelector("input[id='flight-returning-flp']")).sendKeys("01/31/2020");

		driver.findElement(By.xpath("//button[@data-gcw-change-submit-text='Search']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bold announce-able']")));
		boolean present=driver.findElement(By.cssSelector("div[class='bold announce-able']")).isDisplayed();
		System.out.println("is Element present "+present);
		Thread.sleep(2000);
		driver.quit();
	}
}
