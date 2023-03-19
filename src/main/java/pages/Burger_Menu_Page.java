package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Burger_Menu_Page {

	WebDriver driver;
	
	public Burger_Menu_Page (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="react-burger-menu-btn")
	WebElement burgerMenuButton;
	
	@FindBy(id="inventory_sidebar_link")
	WebElement allItemsButton;
	
	@FindBy(id="logout_sidebar_link")
	WebElement logoutButton;
	
	@FindBy(id="about_sidebar_link")
	WebElement aboutButton;
	
	@FindBy(id="reset_sidebar_link")
	WebElement resetAppStateButton;
	
	public void clickOnBurgerMenuButton() {
		burgerMenuButton.click();
	}
	
	public void clickOnAllItemsButton() {
		allItemsButton.click();
	}
		public void clickOnLogoutButton() {
		logoutButton.click();
	}
	
	public void clickOnAboutButton() {
		aboutButton.click();
	}
	
	public void clickOnResetAppButton() {
		resetAppStateButton.click();
	}
}
