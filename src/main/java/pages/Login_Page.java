package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	WebDriver driver;
	
	public Login_Page (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	public void enterUserName(String user) {
		username.sendKeys(user);
	}
	
	public void enterPassword(String pword) {
		password.sendKeys(pword);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void loginToSauceDemoSite(String user, String pword) {
		username.sendKeys(user);
		password.sendKeys(pword);
		loginButton.click();
	}

}
