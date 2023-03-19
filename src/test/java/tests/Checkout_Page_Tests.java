package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import library.Browsers;
import library.Constants;
import pages.Cart_Page;
import pages.Checkout_Page;
import pages.Home_Page;
import pages.Login_Page;

public class Checkout_Page_Tests {

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
	public void TC_0023_0024() {
		Login_Page login = new Login_Page(driver);
		login.loginToSauceDemoSite(Constants.VALID_USER, Constants.VALID_PASSWORD);	
		
		Home_Page homePage = new Home_Page(driver);
		homePage.selectItem("Sauce Labs Backpack");
		homePage.selectItem("Sauce Labs Bike Light");	
		homePage.clickShoppingCartLink();
		
		Cart_Page cart = new Cart_Page(driver);
		cart.clickCheckoutButton();	
		
		Checkout_Page checkout = new Checkout_Page(driver);
		checkout.enterFirstName();
		checkout.enterLastName();
		checkout.enterPostalCode();
		checkout.clickContinueButton();
	}
}
