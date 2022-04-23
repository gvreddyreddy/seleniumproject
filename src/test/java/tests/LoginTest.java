package tests;

import org.testng.annotations.Test;

import globaltest.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest{

	
	@Test
	public void loginTest() {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.login("Admin", "admin123");
	}
}
