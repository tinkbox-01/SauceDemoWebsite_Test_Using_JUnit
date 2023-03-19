package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import library.Browsers;
import library.Constants;
import pages.Burger_Menu_Page;
import pages.Login_Page;

public class Burger_Menu_Page_Tests {

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
	public void TC_006_007() {
		Login_Page login = new Login_Page(driver);
		login.loginToSauceDemoSite(Constants.VALID_USER, Constants.VALID_PASSWORD);	
		
		Burger_Menu_Page burgerMenu = new Burger_Menu_Page(driver);
		burgerMenu.clickOnBurgerMenuButton();

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		burgerMenu.clickOnLogoutButton();
	}
	
	
	@Test
	public void TC_008_009_0010() {
		Login_Page login = new Login_Page(driver);
		login.loginToSauceDemoSite(Constants.VALID_USER, Constants.VALID_PASSWORD);	
		
		Burger_Menu_Page burgerMenu = new Burger_Menu_Page(driver);
		burgerMenu.clickOnBurgerMenuButton();
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		burgerMenu.clickOnAllItemsButton();
		burgerMenu.clickOnResetAppButton();
		burgerMenu.clickOnAboutButton();
	}
}
