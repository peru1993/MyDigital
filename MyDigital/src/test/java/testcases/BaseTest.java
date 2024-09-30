package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import constants.FrameworkConstants;
import pages.BasePage;
import utilities.ConfigReader;

public class BaseTest {
	protected WebDriver driver;
	public Logger logger;   //log4j
	
	@BeforeMethod
	void setUp() {
		logger = LogManager.getLogger(this.getClass());
		
		String strBrowser = ConfigReader.getPropertyFromKey("browser");
		System.out.println("'" + strBrowser + "' browser selected for test.");

		String url = ConfigReader.getPropertyFromKey("baseurl");
		System.out.println("Application under test : '" + url + "'.");

		switch (strBrowser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Unsupported browser type mentioned in the config.properties file.");
			System.out.println("Chrome browser selected for test as default.");
			driver = new ChromeDriver();
			break;
		}

		System.out.println("'" + strBrowser + "' browser initialized.");
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.getImplicitWaitTime()));
		driver.get(url);
		System.out.println("Navigated to url '" + url + "'.");
	}

	@AfterMethod
	void tearDown() {
		BasePage.SmartWait(3);
		driver.quit();
	}
	
	public static void printMethodName() {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		System.out.println("Executing method: " + methodName);
	}
}
