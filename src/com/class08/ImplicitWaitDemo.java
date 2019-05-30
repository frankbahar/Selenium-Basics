package com.class08;
import java.util.concurrent.TimeUnit;

import utils.*;
public class ImplicitWaitDemo extends CommonMethods {

	public static void main(String[] args) {
		setUpDriver("chrome", "https://www.ebay.com");
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.quit();
	}

}
