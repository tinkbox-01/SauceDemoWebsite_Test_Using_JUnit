package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import library.Browsers;
import library.Constants;
import pages.Login_Page;

public class Login_Page_Tests {
	
	WebDriver driver;
	
	@Before
	public void before() {
		driver = Browsers.lunchBrowser(Constants.BROWSER);
		driver.get(Constants.LOGIN_PAGE_URL);	
	}
	
	@After
	public void after() {
		driver.quit();
	}
	
	@Test
	public void TC_001() {
		String expectedLoginPageURL = driver.getCurrentUrl();
		String actualLoginPageURL = Constants.LOGIN_PAGE_URL;
		Assert.assertEquals(expectedLoginPageURL, actualLoginPageURL);
	}
	
	@Test
	public void TC_002() {
		String expectedLoginPageTitle = driver.getTitle();
		String actualLoginPageTitle = Constants.LOGIN_PAGE_TITLE;
		Assert.assertEquals(expectedLoginPageTitle, actualLoginPageTitle);
	}
	
	@Test
	public void TC_003() {
		Login_Page login = new Login_Page(driver);
		login.loginToSauceDemoSite(Constants.VALID_USER, Constants.VALID_PASSWORD);	
	}

	@Test
	public void TC_004() {
		Login_Page login = new Login_Page(driver);
		login.loginToSauceDemoSite(Constants.INVALID_USER, Constants.INVALID_PASSWORD);	
	}
	
	@Test
	public void TC_005() {
		Login_Page login = new Login_Page(driver);
		login.loginToSauceDemoSite("", "");	
	}
}
