package com.class07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import utils.CommonMethods;
/*Task
Ahead to http://uitestpractice.com/Students/Switchto
Get the parent title
Get the parentId
print the parent title and parentId
Click on the open in a new window
Get the child title
Get the childId
print the child title and childId
close the child window*/

public class WindowsDemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome", "http://uitestpractice.com/Students/Switchto");
		String parentTitle = driver.getTitle();
		String parentId= driver.getWindowHandle();
		System.out.println("Parent Title: " + parentTitle + " Parent Id : " + parentId);
		driver.findElement(By.xpath("//a[text()='Opens in a new window']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		Thread.sleep(2000 );
		String childTitle = driver.getTitle();
		String childId = driver.getWindowHandle();
		System.out.println("Child Title : " + childTitle + " Child Id : " + childId);
		driver.close();
		Thread.sleep(3000);
		driver.quit();

	}

}
