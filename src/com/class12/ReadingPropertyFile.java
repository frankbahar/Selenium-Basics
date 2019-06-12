package com.class12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

import utils.CommonMethods;

public class ReadingPropertyFile extends CommonMethods{
	Properties prop;
	
	@Test
	public void readFile() {
		String filePath="src/configs/credentials.properties";
		
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String browser =  prop.getProperty("browser");
		System.out.println(browser);
		String url =  prop.getProperty("url");
		System.out.println(url);
		setUpDriver(browser, url);
		
		quitDriver(); 
	}
}
