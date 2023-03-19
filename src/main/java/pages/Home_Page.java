package pages;

import java.util.List;

import javax.swing.text.html.CSS;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import library.Constants;

public class Home_Page {

	WebDriver driver;
	
	public Home_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='shopping_cart_container']/a/span")
	WebElement countOfCart;
	
	@FindBy(id="remove-sauce-labs-backpack")
	WebElement removeItemButton;
	
	@FindBy(xpath="//select[@data-test='product_sort_container']")
	WebElement filter;
	
	@FindBy(xpath="//div[@id='page_wrapper']/footer/ul/li[1]")
	WebElement twitter;

	@FindBy(xpath="//div[@id='page_wrapper']/footer/ul/li[2]")
	WebElement facebook;

	@FindBy(xpath="//div[@id='page_wrapper']/footer/ul/li[3]")
	WebElement linkedin;
	
	@FindBy(xpath="//div[@id='page_wrapper']/footer/div")
	WebElement copyRight;
	
	@FindBy(xpath=("//a[@id='item_4_title_link']/div/../../../../../../div/div/div[2]/div/a/div"))
	List <WebElement> itemList;
	
	@FindBy(xpath="//div[@id='shopping_cart_container']/a")
	WebElement clickCartLink;
	
	@FindBy(css="//div[@id='organization_guest_contextual-sign-in']/div/section/button/icon")
	WebElement cancelLinkedInButton;
	
	@FindBy(id="email-or-phone")
	WebElement linkedInEmail;
	
	@FindBy(id="password")
	WebElement linkedInPassword;
	
	
	public void cartCount() {
		countOfCart.getText();
	}
	
	public void clickRemoveItemButton() {
		removeItemButton.click();
	}
	
	public void clickFilterButton() {
		filter.click();
	}
	
	public void clickTwitterLogo() { 
		twitter.click();
	}
	
	public void clickFacebookLogo() { 
		facebook.click();
	}
	
	public void clickLinkedInLogo() {
		linkedin.click();
	}
	
	public String copyRightText() {
		String copy = copyRight.getText();
		return copy;
	}
	
	public short countItemsInList() {
		short items = (short) itemList.size();
		return items;
	}
	
	public void clickShoppingCartLink() {
		clickCartLink.click();
	}
	
	public void clickCancelLinkenInButton() {
		cancelLinkedInButton.click();
	}
	
	public void compareLinkURL_1() {
	driver.getWindowHandle();
	assert driver.getWindowHandles().size() == 1;
	}
	
	public void compareLinkURL_2() {
	WebDriverWait wait = new WebDriverWait(driver,5);
	wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	
	for (String windowHandle : driver.getWindowHandles()) {
		if(!driver.getWindowHandle().contentEquals(windowHandle)) {
			driver.switchTo().window(windowHandle);
	    break;
	   	}
	}
	}
	
	public void selectItem(String itemName) {
		List<WebElement> items = driver.findElements(By.xpath("//a[@id='item_4_title_link']/div/../../../../../../div/div/div[2]/div/a/div"));
		List<WebElement> addToCartButton = driver.findElements(By.xpath("//a[@id='item_4_title_link']/div/../../../../../../div/div/div[2]/div[2]/button"));
		
		for(int i=0; i<items.size(); i++) {
			String text = items.get(i).getText();
			if(text.equalsIgnoreCase(itemName)) {
				addToCartButton.get(i).click();
			}
		}		
	}
}
