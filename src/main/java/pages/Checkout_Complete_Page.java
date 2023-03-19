package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_Complete_Page {

	WebDriver driver;
	
	public Checkout_Complete_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='checkout_complete_container']/h2")
	WebElement thankYouMessage;
	
	@FindBy(xpath = "//img[@alt='Pony Express']")
	WebElement ponyExpressImage;
	
	@FindBy(id="back-to-products")
	WebElement backHomeButton;
	
	public String getthankYouMessage() {
		String thankYouMsg = thankYouMessage.getText();
		return thankYouMsg;
	}
	
	public String getponyExpressImageSource() {
		String ponyImage = ponyExpressImage.getAttribute("src");
		return ponyImage;
	}
	
	public void clickBackHomeButton() {
		backHomeButton.click();
	}
}
