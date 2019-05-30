package utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {

	public static WebDriver driver;

	public static void setUpDriver(String browser, String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "src/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "src/drivers/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("browser given is wrong");
		}
		driver.get(url);

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * @author Frank Bahar This method will click the element specified
	 * @param Select element
	 */
	public static void click(WebElement element) {
		element.click();
	}

	/**
	 * @author Frank Bahar This method will select a specified value from a drop
	 *         down by text
	 * @param Select element, String text
	 */
	public static void selectValueFromDD(WebElement element, String text) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		boolean isElementSelected = false;
		for (WebElement option : options) {
			String optionText = option.getText();
			if (optionText.equals(text)) {
				select.selectByVisibleText(text);
				System.out.println("Option with text " + text + " is selected");
				isElementSelected = true;
				break;
			}
		}
		if (!isElementSelected) {
			System.out.println("Option with text " + text + " is not available");
		}
	}

	/**
	 * @author fezac This method will select a specified value from a drop down by
	 *         index
	 * @param Select element, String text
	 */
	public static void selectValueFromDD(WebElement element, int index) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		if (options.size() > index) {
			select.selectByIndex(index);
		} else {
			System.out.println("Invalid index has been passed");
		}
	}

	public static void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	/**
	 * @author fezac Method will accept alert
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present ");
		}
	}

	/**
	 * @author fezac Method will dismiss alert
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present ");
		}
	}

	/**
	 * @author fezac Method will get text of an alert
	 * @throws NoAlertPresentException if alert is not present
	 * @return String text
	 */
	public static String getAlertText() {
		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present ");
			return null;
		}
	}

	/**
	 * @author fezac Method will switch control to the specified frame by using Id
	 *         or name
	 * @param Id or Name
	 * @throws NoAlertPresentException if frame is not present
	 */
	public static void switchToFrame(String idOrName) {
		try {
			driver.switchTo().frame(idOrName);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame was not present");
		}
	}

	/**
	 * @author fezac Method will switch control to the specified frame by using
	 *         WebElement
	 * @param WebElement
	 * @throws NoAlertPresentException if frame is not present
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame was not present");
		}
	}

	/**
	 * @author fezac Method will switch control to the specified frame by index
	 * @param int index
	 * @throws NoAlertPresentException if frame is not present
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame was not present");
		}
	}

	/**
	 * @author Frank Bahar This method will select a specified value from a drop
	 *         down by text
	 * @param Select List<WebElement>, String text
	 */
	public static void selectValueFromRadioButton(List<WebElement> options, String text) {
		boolean isElementSelected = false;
		for (WebElement option : options) {
			if (option.isEnabled()) {
				String value = option.getAttribute("value");
				if (value.equals(text)) {
					option.click();
					isElementSelected=true;
					break;
				}
			}
		}
		if(!isElementSelected) {
			System.out.println("Option with text " + text + " is not available");	
		}
	}

	/**
	 * @author Frank Bahar This method will select a specified values from a
	 *         checkbox
	 * @param Select <List<WebElement>, List<String> text
	 */
	public static void selectValueFromCheckbox(List<WebElement> options, List<String> texts) {
		boolean isElementSelected=false;
		for (String text : texts) {
			for (WebElement option : options) {
				if (option.isEnabled()) {
					String value = option.getAttribute("value");
					if (value.equals(text)) {
						option.click(); 
						isElementSelected=true;
					}
				}
			}
		}
		if(!isElementSelected) {
			System.out.println("No option is available with any text requested could not select");	
		}
	}

	public static void quitDriver() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("Could not sleep ");
		}
		driver.quit();
	}
}