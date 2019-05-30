package com.class07;

import utils.CommonMethods;

public class Test extends CommonMethods {
	public static void main(String[] args) throws InterruptedException {
		setUpDriver("ie", "https://www.google.com/");
		Thread.sleep(3000);
		driver.close();
	}
}
