package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart_Page {

	WebDriver driver;
	
	public Cart_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=("//a[@id='item_4_title_link']/../../../../../div/div/div/div[2]/a/div"))
	List <WebElement> itemList;
	
	@FindBy(id="continue-shopping")
	WebElement continueShoppingButton;
	
	@FindBy(id="remove-sauce-labs-backpack")
	WebElement removeItemButton;
	
	@FindBy(id="checkout")
	WebElement checkoutButton;
	
	@FindBy(xpath="//div[@id='shopping_cart_container']/a")
	WebElement clickCartLink;
	
	public int countItemsInList() {
		int items = itemList.size();
		return items;
	}
	
	public void clickOnContinueShoppingButton() {
		continueShoppingButton.click();
	}
	
	public void clickRemoveItemButton() {
		removeItemButton.click();
	}
	
	public void clickCheckoutButton() {
		checkoutButton.click();
	}
	
	public void clickShoppingCartLink() {
		clickCartLink.click();
	}
	

}
