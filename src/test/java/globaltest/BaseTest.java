package globaltest;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@BeforeMethod
	public void createDriver(ITestContext testContext) {
		Map<String, String> testParameters = testContext.getCurrentXmlTest().getAllParameters();
		String browserName = testParameters.get("browserName");
		if ("chrome".equalsIgnoreCase(browserName)) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if ("firefox".equalsIgnoreCase(browserName)) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if ("ie".equalsIgnoreCase(browserName)) {
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}

	protected WebDriver getDriver() {
		return driver;
	}

	public void wait(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void closeDriver() {
		if (null != driver) {
			driver.close();
			driver.quit();
		}
	}
}
