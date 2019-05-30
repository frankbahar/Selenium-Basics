package com.class09;

import utils.CommonMethods;

public class DriverTest extends CommonMethods {

	public static void main(String[] args) {
		setUpDriver("chrome", "https://www.google.com");
		driver.quit();

	}

}
