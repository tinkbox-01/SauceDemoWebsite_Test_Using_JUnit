package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import library.Browsers;
import library.Constants;
import pages.Cart_Page;
import pages.Home_Page;
import pages.Login_Page;

public class Cart_Page_Tests {

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
	public void TC_0019_0021() {
		Login_Page login = new Login_Page(driver);
		login.loginToSauceDemoSite(Constants.VALID_USER, Constants.VALID_PASSWORD);	
		
		Home_Page homePage = new Home_Page(driver);
		homePage.selectItem("Sauce Labs Backpack");
		homePage.selectItem("Sauce Labs Bike Light");	
		homePage.clickShoppingCartLink();
		
		Cart_Page cart = new Cart_Page(driver);
//		cart.countItemsInList();
		
		int acctualItemsInList = Constants.CART_PAGE_LIST_COUNT;
		Assert.assertEquals(cart.countItemsInList(), acctualItemsInList);
	}
	
	@Test
	public void TC_0020() throws InterruptedException {
		Login_Page login = new Login_Page(driver);
		login.loginToSauceDemoSite(Constants.VALID_USER, Constants.VALID_PASSWORD);	
		
		Home_Page homePage = new Home_Page(driver);
		homePage.clickShoppingCartLink();
		
		Cart_Page cart = new Cart_Page(driver);
		cart.clickOnContinueShoppingButton();	
	}

	@Test
	public void TC_0022() throws InterruptedException {
		Login_Page login = new Login_Page(driver);
		login.loginToSauceDemoSite(Constants.VALID_USER, Constants.VALID_PASSWORD);	

		Home_Page homePage = new Home_Page(driver);
		homePage.clickShoppingCartLink();
		
		Cart_Page cart = new Cart_Page(driver);
		cart.clickCheckoutButton();	
	}

}
