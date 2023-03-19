package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import library.Browsers;
import library.Constants;
import pages.Home_Page;
import pages.Login_Page;

public class Home_Page_Tests {

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
	public void TCC_0011_0012_0013_0014() {
		Login_Page login = new Login_Page(driver);
		login.loginToSauceDemoSite(Constants.VALID_USER, Constants.VALID_PASSWORD);
		
		Home_Page homePage = new Home_Page(driver);
		homePage.selectItem("Sauce Labs Backpack");
		homePage.selectItem("Sauce Labs Bike Light");
		homePage.cartCount();
		homePage.clickRemoveItemButton();
		homePage.clickFilterButton();
	}
	
	@Test
	public void TCC_0015() {
		Login_Page login = new Login_Page(driver);
		login.loginToSauceDemoSite(Constants.VALID_USER, Constants.VALID_PASSWORD);
		
		Home_Page homePage = new Home_Page(driver);
		
		homePage.compareLinkURL_1();
		homePage.clickTwitterLogo();
		homePage.compareLinkURL_2();
				
		String  expectedSiteTwitterURL = Constants.TWITTER_URL;
		Assert.assertEquals(expectedSiteTwitterURL, driver.getCurrentUrl());
	}
	
	@Test
	public void TCC_0016() {
		Login_Page login = new Login_Page(driver);
		login.loginToSauceDemoSite(Constants.VALID_USER, Constants.VALID_PASSWORD);
		
		Home_Page homePage = new Home_Page(driver);
		
		homePage.compareLinkURL_1();
		homePage.clickFacebookLogo();
		homePage.compareLinkURL_2();		
		
		String  expectedSiteFacebookURL = Constants.FACEBOOK_URL;
		Assert.assertEquals(expectedSiteFacebookURL, driver.getCurrentUrl());
	}
	
	@Test
	public void TCC_0017() {
		Login_Page login = new Login_Page(driver);
		login.loginToSauceDemoSite(Constants.VALID_USER, Constants.VALID_PASSWORD);
		
		Home_Page homePage = new Home_Page(driver);

		homePage.compareLinkURL_1();
		homePage.clickLinkedInLogo();
		homePage.compareLinkURL_2();	
		
		String  expectedSiteLinkedInURL = Constants.LINKEDIN_URL;
		Assert.assertTrue(driver.getCurrentUrl().contains(expectedSiteLinkedInURL));
	}
	
	@Test
	public void TCC_0018() {
		Login_Page login = new Login_Page(driver);
		login.loginToSauceDemoSite(Constants.VALID_USER, Constants.VALID_PASSWORD);
		
		Home_Page homePage = new Home_Page(driver);
		
		String expectedCopyRightText = Constants.COPY_RIGHT;
		Assert.assertEquals(expectedCopyRightText, homePage.copyRightText());
	}
	
	@Test
	public void TC_0023() {
		Login_Page login = new Login_Page(driver);
		login.loginToSauceDemoSite(Constants.VALID_USER, Constants.VALID_PASSWORD);
		
		Home_Page homePage = new Home_Page(driver);
		
		short actualItemsInList = Constants.HOME_PAGE_LIST_COUNT;
		Assert.assertEquals(homePage.countItemsInList(), actualItemsInList);
	}

}
