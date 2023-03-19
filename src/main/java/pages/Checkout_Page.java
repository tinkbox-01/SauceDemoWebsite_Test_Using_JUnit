package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import library.Constants;

public class Checkout_Page {
	
	WebDriver driver;
	
	public Checkout_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first-name")
	WebElement firstName;
	
	@FindBy(id = "last-name")
	WebElement lastName;
	
	@FindBy(id = "postal-code")
	WebElement postalCode;
	
	@FindBy(id = "continue")
	WebElement continueButton;

	public void enterFirstName() {
		firstName.sendKeys(Constants.FIRST_NAME);
	}
	
	public void enterLastName() {
		lastName.sendKeys(Constants.LAST_NAME);
	}
	
	public void enterPostalCode() {
		postalCode.sendKeys(Constants.POSTAL_CODE);
	}
	
	public void clickContinueButton() {
		continueButton.click();
	}
}
