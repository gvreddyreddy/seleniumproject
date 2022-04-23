package tests;

import org.testng.annotations.Test;

import globaltest.BaseTest;
import pages.LoginPage;
import pages.UserPage;

public class UserTest extends BaseTest{

	@Test
	public void loginTest() {
		LoginPage loginPage = new LoginPage(getDriver());
		UserPage userPage = new UserPage(getDriver());
		loginPage.login("Admin", "admin123");
		userPage.navigateToMenu();
		userPage.addUser();
	}
}
