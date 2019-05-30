package com.class11;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class WebTableTask2 extends CommonMethods {
	/*
	 * TC 1: Table headers and rows verification
	 * 1.Open browser and go to “http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx”
	 * 2.Login to the application
	 * 3.Create an Order
	 * 4.Verify order of that person is displayed in the table “List of All Orders”
	 * 5.Click on edit of that specific order
	 * 6.Verify each order details
	 * 7.Update street address
	 * 8.Verify in the table that street has been updated
	 * 9.Close browser
	 */	
	public static void main(String[] args) {
		setUpDriver("chrome", "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		sendText(driver.findElement(By.cssSelector("input[id$='username']")),"Tester");
		sendText(driver.findElement(By.cssSelector("input[id*='password']")),"test");
		click(driver.findElement(By.cssSelector("input[value='Login']")));
		click(driver.findElement(By.xpath("//a[text()='Order']")));
		//Order Information
		String product="FamilyAlbum";
		String quantity="3";
		String discount="0";
		String name="Enes Kanter";
		String street = "12 Main St.";
		String city = "Portland";
		String state="OR";
		String zip = "89776";
		String cardType="MasterCard";
		String cardNum="12345";
		String expDate="02/22";
		//entering the order
		selectValueFromDD(driver.findElement(By.xpath("//select[contains(@id,'ddlProduct')]")), product);
		String unitPrice=driver.findElement(By.cssSelector("input[id$='txtUnitPrice']")).getAttribute("value");
		sendText(driver.findElement(By.cssSelector("input[id*='txtQuantity']")),quantity);
		sendText(driver.findElement(By.cssSelector("input[id*='txtDiscount']")),discount);
		click(driver.findElement(By.cssSelector("input[type='submit']")));
		String total=driver.findElement(By.cssSelector("input[id*='txtTotal']")).getAttribute("value");
		sendText(driver.findElement(By.cssSelector("input[id*='txtName']")),name);
		sendText(driver.findElement(By.cssSelector("input[id*='TextBox2']")),street);
		sendText(driver.findElement(By.cssSelector("input[id*='TextBox3']")),city);
		sendText(driver.findElement(By.cssSelector("input[id*='TextBox4']")),state);
		sendText(driver.findElement(By.cssSelector("input[id*='TextBox5']")),zip);
		selectValueFromRadioButton(driver.findElements(By.cssSelector("input[type='radio']")), cardType);
		sendText(driver.findElement(By.cssSelector("input[id*='TextBox6']")),cardNum);
		sendText(driver.findElement(By.cssSelector("input[id$='TextBox1']")),expDate);
		click(driver.findElement(By.cssSelector("a[id$='InsertButton']")));
		click(driver.findElement(By.xpath("//a[text()='View all orders']")));
		//verifying order entered and available in list of all orders page
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr"));
		List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr[1]/th"));
		boolean orderFound=false;
		boolean orderUpdated=false;
		String updatedStreet="13 Updated St.";
		for(int i=2;i<=rows.size(); i++) {
			String rowText=driver.findElement(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr[" + i + "]/td[2]")).getText();
			if(rowText.contains(name)) {
				orderFound=true;
				driver.findElement(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr[" + i + "]/td[13]")).click();
				if(!driver.findElement(By.xpath("//option[@value='"+product+"']")).isSelected()) {
					System.out.println("Product ordered does NOT match ; " + product);
					break;
				}
				String actualQuantity=driver.findElement(By.cssSelector("input[id*='txtQuantity']")).getAttribute("value"); 
				if(!actualQuantity.equals(quantity)) {
					System.out.println("Product ordered quantity is " + quantity + " but in order " + actualQuantity + " does NOT match");
					break;
				}
				String actualUnitPrice=driver.findElement(By.cssSelector("input[id$='txtUnitPrice']")).getAttribute("value");
				if(!actualUnitPrice.equals(unitPrice)) {
					System.out.println("Product Unit price is " + unitPrice + " but in order " + actualUnitPrice + " does NOT match");
					break;
				}
				String actualDiscount=driver.findElement(By.cssSelector("input[id*='txtDiscount']")).getAttribute("value");
				if(!actualDiscount.equals(discount)) {
					System.out.println("Product Discount is " + discount + " but in order " + actualDiscount + " does NOT match");
					break;
				}
				String actualName=driver.findElement(By.cssSelector("input[id*='txtName']")).getAttribute("value");
				if(!actualName.equals(name)) {
					System.out.println("Name is " + name + " but in order " + actualName + " does NOT match");
					break;
				}
				String actualStreet=driver.findElement(By.cssSelector("input[id*='TextBox2']")).getAttribute("value");
				if(!actualStreet.equals(street)) {
					System.out.println("Street is " + street + " but in order " + actualStreet + " does NOT match");
					break;
				}
				String actualCity=driver.findElement(By.cssSelector("input[id*='TextBox3']")).getAttribute("value");
				if(!actualCity.equals(city)) {
					System.out.println("City is " + city + " but in order " + actualCity + " does NOT match");
					break;
				}
				String actualState=driver.findElement(By.cssSelector("input[id*='TextBox4']")).getAttribute("value");
				if(!actualState.equals(state)) {
					System.out.println("State is " + state + " but in order " + actualState + " does NOT match");
					break;
				}
				String actualZip=driver.findElement(By.cssSelector("input[id*='TextBox5']")).getAttribute("value");
				if(!actualZip.equals(zip)) {
					System.out.println("Postal Code is " + zip + " but in order " + actualZip + " does NOT match");
					break;
				}
				if(!driver.findElement(By.xpath("//input[@value='"+cardType+"']")).isSelected()) {
					System.out.println("Card type doe NOT match ; " + cardType);
					break;
				}
				String actualCardNum=driver.findElement(By.cssSelector("input[id*='TextBox6']")).getAttribute("value");
				if(!actualCardNum.equals(cardNum)) {
					System.out.println("Card Number is " + cardNum + " but in order " + actualCardNum + " does NOT match");
					break;
				}
				String actualExpDate=driver.findElement(By.cssSelector("input[id$='TextBox1']")).getAttribute("value");
				if(!actualExpDate.equals(expDate)) {
					System.out.println("Expiration Date is " + expDate + " but in order " + actualExpDate + " does NOT match");
					break;
				}
					
				sendText(driver.findElement(By.cssSelector("input[id*='TextBox2']")),updatedStreet);
				driver.findElement(By.xpath("//a[contains(@id,'UpdateButton')]")).click();
				List<WebElement> updatedRows = driver.findElements(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr"));
				for(int j=2;i<=rows.size(); i++) {
					String updatedRowText=driver.findElement(By.xpath("//table[contains(@id,'orderGrid')]/tbody/tr[" + i + "]/td[6]")).getText();
					if(updatedRowText.contains(updatedStreet)) {
						orderUpdated=true;
						break;
					}			
				}			
				break;
			}
		}
		if(orderFound && orderUpdated ) {
			System.out.println("Customer Street is " + street + " found and updated to " + updatedStreet);
		}else if(orderFound && !orderUpdated) {
			System.out.println("Customer " + street + " found and could NOT updated to " + updatedStreet);
		} else {
			System.out.println("Customer " + street + " could NOT found");
			
		}
	
		quitDriver();	
	}
}
