package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import globalpagefactory.BasePage;
import util.Util;

public class UserPage extends BasePage{

	@FindBy(id = "systemUser_userType")
	public WebElement userRoleDrpDwn;
	
	@FindBy(id = "systemUser_employeeName_empName")
	public WebElement empNameTxtBx;
	
	@FindBy(id = "systemUser_userName")
	public WebElement userNameTxtBx;
	
	@FindBy(id = "systemUser_status")
	public WebElement statusDrpDwn;
	
	@FindBy(id = "systemUser_password")
	public WebElement pwdTxtBx;
	
	@FindBy(id = "systemUser_confirmPassword")
	public WebElement confirmPwdTxtBx;
	
	@FindBy(id = "btnSave")
	public WebElement saveBtn;
	
	@FindBy(id = "btnAdd")
	public WebElement addBtn;
	
	public void navigateToMenu() {
		getActions().moveToElement(getDriver().findElement(By.linkText("Admin"))).build().perform();
		getActions().moveToElement(getDriver().findElement(By.linkText("User Management"))).build().perform();
		getActions().moveToElement(getDriver().findElement(By.linkText("Users"))).click().build().perform();
	}
	
	public void addUser() {
		clickOnButton(addBtn, TEN);
		waitFor(ExpectedConditions.visibilityOf(userRoleDrpDwn), TEN);
		selectByVisibleText(userRoleDrpDwn, "Admin", TEN);
	  	enterText(empNameTxtBx, "Admin A", TEN);
	  	String userName = "User" + Util.randomNumeric(3);
	  	enterText(userNameTxtBx, userName , TEN);
	  	selectByVisibleText(statusDrpDwn, "Enabled", TEN);
	  	String pwd = Util.randomAlphanumeric(10);
	  	enterText(pwdTxtBx, pwd, TEN);
	  	enterText(confirmPwdTxtBx, pwd, TEN);
	  	clickOnButton(saveBtn, TEN);
	  	
	  	WebElement ele = getDriver().findElement(By.xpath("//a[text()='" + userName +"']"));
	  	Assert.assertEquals(true, isWebElementPresent(ele, TEN), "User Added SuccessFully");
	}
	
	public UserPage(WebDriver driver) {
		super(driver);
	}
}
