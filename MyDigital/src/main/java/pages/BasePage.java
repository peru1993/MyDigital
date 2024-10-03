package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	// Constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public static void SmartWait(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public WebElement locateElement(By by, String elementName) {

		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			SmartWait(2);
			System.out.println("Successfully Located on element: " + elementName);
			return element;

		} catch (Exception e) {
			System.out.println("Error Locating on element: " + elementName + ". Exception: " + e.getMessage());
			return null;
		}
	}

	// Method to click on an element with smart wait
	public void clickElement(By by, String elementName) {

		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
			element.click();
			SmartWait(2);
			System.out.println("Successfully clicked on element: " + elementName);
		} catch (Exception e) {
			System.out.println("Error clicking on element: " + elementName + ". Exception: " + e.getMessage());
		}

	}

	// Method to send keys to an element with smart wait
	public void sendKeysElement(By by, String value, String elementName) {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			element.sendKeys(value);
			SmartWait(2); // Default wait after sending keys
			System.out.println("Successfully sent keys to element: " + elementName + " with value: " + value);
		} catch (Exception e) {
			System.out.println("Error sending keys to element: " + elementName + ". Exception: " + e.getMessage());
		}
	}

	public void textfieldclear(By by, String elementName) {

		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
			element.clear();

			SmartWait(2); // Default wait after sending keys
			System.out.println("Successfully sent keys to element: " + elementName);
		} catch (Exception e) {
			System.out.println("Error sending keys to element: " + elementName + ". Exception: " + e.getMessage());
		}
	}
}
