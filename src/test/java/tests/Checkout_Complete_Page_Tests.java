package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import library.Browsers;
import library.Constants;
import pages.Cart_Page;
import pages.Checkout_Complete_Page;
import pages.Checkout_Page;
import pages.Checkout_Page_Two;
import pages.Home_Page;
import pages.Login_Page;

public class Checkout_Complete_Page_Tests {
	
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
	public void TC_0033_0034() {
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
		
		Checkout_Page_Two checkout2 = new Checkout_Page_Two(driver);
		checkout2.clickFinishButton();
		
		Checkout_Complete_Page checkoutComplete = new Checkout_Complete_Page(driver);
//		checkoutComplete.getthankYouMessage();
		
		String expectedThankYouMessage = Constants.THANK_YOU_MESSAGE;
		Assert.assertEquals(expectedThankYouMessage, checkoutComplete.getthankYouMessage());
		
		String expectedPonyExpressImage = Constants.SRC_ATTRIBUTE_PONY_EXPRESS_IMAGE;	
		Assert.assertEquals(expectedPonyExpressImage, checkoutComplete.getponyExpressImageSource());
		
		checkoutComplete.clickBackHomeButton();
	}
}
