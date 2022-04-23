package globalpagefactory;

import java.time.Duration;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import exception.FailedActionException;

public class BasePage {

	protected static final int TEN = 10;
	private WebDriver driver;
	private Actions actions;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	protected Actions getActions() {
		return actions;
	}
	
	public void enterText(WebElement element, String text, long timeout) {
		try {
			if (isNotEmpty(text)) {
				waitFor(ExpectedConditions.visibilityOf(element), timeout);
				element.clear();
				element.sendKeys(text);
			} else {
				System.out.println("Given value is empty please check");
			}
		} catch (Exception ex) {
			System.out.println("Unable to enter the text : " + element);
			throw new FailedActionException("Error occured while entering text: " + ex.getMessage());
		}
	}
	
	/**
	 * click on button for both types button and submit
	 * 
	 * @return
	 */
	public void clickOnButton(WebElement element, long timeout) {
		try {
			waitFor(ExpectedConditions.visibilityOf(element), timeout);
			element.click();
		} catch (Exception ex) {
			System.out.println("Failed to click on button : " + element);
			throw new FailedActionException("Error occured while clicking on button: " + ex.getMessage());
		}
	}
	
	protected WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * Returns true if the value not empty.
	 * 
	 * @param value
	 * @return boolean
	 */
	public boolean isNotEmpty(String value) {
		if (StringUtils.isNotBlank(value)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Wait for condition using the fluent driver
	 * 
	 * @param waitCondition
	 */
	public void waitFor(ExpectedCondition<?> waitCondition, long timeout) {
			new WebDriverWait(driver, Duration.ofSeconds(timeout)).pollingEvery(Duration.ofMillis(600)).until(waitCondition);
	}
	
	/**
	 * Verifies element present or not
	 * 
	 * @param element
	 * @return
	 */
	public boolean isWebElementPresent(WebElement element, long timeout) {
		boolean isPresent = false;
		try {
			waitFor(ExpectedConditions.visibilityOf(element), timeout);
			if (element.isDisplayed()) {
				isPresent = true;
			}
		} catch (Exception ex) {
			System.out.println("Element is not present: " + element);
			isPresent = false;
		}
		return isPresent;
	}
	
	/**
	 * Selects a dropdown value by visible text
	 * 
	 * @param dropDownElement
	 * @param visibleText
	 */
	public void selectByVisibleText(WebElement dropDownElement, String visibleText, long timeout) {
		try {
			if (isNotEmpty(visibleText)) {
				waitFor(ExpectedConditions.visibilityOf(dropDownElement), timeout);
				new Select(dropDownElement).selectByVisibleText(visibleText);
			} else {
				System.out.println("Given value is empty please check");
			}
		} catch (Exception ex) {
			System.out.println("Unable to select the value from dropdown: " + dropDownElement);
			throw new FailedActionException("Error occured while selecting value from dropdown " + ex.getMessage());
		}
	}

	/**
	 * Selects a dropdown value by value *
	 * 
	 * @param dropDownElement
	 * @param value
	 */
	public void selectByValue(WebElement dropDownElement, String value, long timeout) {
		try {
			if (isNotEmpty(value)) {
				waitFor(ExpectedConditions.visibilityOf(dropDownElement), timeout);
				new Select(dropDownElement).selectByValue(value);
			} else {
				System.out.println("Given value is empty please check");
			}
		} catch (Exception ex) {
			System.out.println("Unable to select the value from dropdown: " + dropDownElement);
			throw new FailedActionException("Error occured while selecting value from dropdown " + ex.getMessage());
		}
	}

	/**
	 * Selects a dropdown value by index *
	 * 
	 * @param dropDownElement
	 * @param value
	 */
	public void selectByIndex(WebElement dropDownElement, int index, long timeout) {
		try {
			waitFor(ExpectedConditions.visibilityOf(dropDownElement), timeout);
			new Select(dropDownElement).selectByIndex(index);
		} catch (Exception ex) {
			System.out.println("Unable to select the value from dropdown: " + dropDownElement);
			throw new FailedActionException("Error occured while selecting value from dropdown " + ex.getMessage());
		}
	}
}
