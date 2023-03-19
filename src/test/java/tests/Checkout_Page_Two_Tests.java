package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import library.Browsers;
import library.Constants;
import pages.Cart_Page;
import pages.Checkout_Page;
import pages.Checkout_Page_Two;
import pages.Home_Page;
import pages.Login_Page;

public class Checkout_Page_Two_Tests {

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
	public void TC_0026_0027_0028_0029_0030_0031() {
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
		
		int actualCountItemsList = Constants.CART_PAGE_LIST_COUNT;
		Assert.assertEquals(checkout2.countItemsInList(), actualCountItemsList);
		
		String expectedPaymentCardDetails = Constants.PAYMENT_CARD_DETAILS;
		Assert.assertEquals(expectedPaymentCardDetails, checkout2.getPaymentCardDetails());
		
		String expectedShippingDetails = Constants.SHIPPING_INFORMATION;
		Assert.assertEquals(expectedShippingDetails, checkout2.getShippingDetails());
		
		String expectedTotalItemPayment = Constants.TOTAL_ITEM_PAYMENT;
		Assert.assertEquals(expectedTotalItemPayment, checkout2.getTotalItemPayment());
		
		String expectedTaxTotalPayement = Constants.TOTAL_TAX_PAYMENT;
		Assert.assertEquals(expectedTaxTotalPayement, checkout2.getTaxTotalPayement());
		
		String expectedTotalPayements = Constants.TOTAL_PAYMENT;
		Assert.assertEquals(expectedTotalPayements, checkout2.getTotalPayments());
		
		checkout2.clickFinishButton();
	}
	
	@Test
	public void TC_0032() {
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
		
		checkout2.clickCancelButton();
		
	}
}
