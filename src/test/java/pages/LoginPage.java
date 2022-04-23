package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import globalpagefactory.BasePage;

public class LoginPage extends BasePage{

	@FindBy(id = "txtUsername")
	public WebElement userNameTxtBx;
	
	@FindBy(id = "txtPassword")
	public WebElement passwordTxtBx;
	
	@FindBy(id = "btnLogin")
	public WebElement loginBtn;
	
	@FindBy(id = "welcome")
	public WebElement welcomeLink;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void login(String userName, String pwd) {
		getDriver().get("https://opensource-demo.orangehrmlive.com/");
		enterText(userNameTxtBx, userName, 10);
		enterText(passwordTxtBx, pwd, 10);
		clickOnButton(loginBtn, 10);
		Assert.assertEquals(true, isWebElementPresent(welcomeLink, 10));
	}
}
