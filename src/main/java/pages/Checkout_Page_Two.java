package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_Page_Two {

	WebDriver driver;
	
	public Checkout_Page_Two(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//a[@id='item_4_title_link']/../../../../../div/div/div/div[2]/a/div"))
	List <WebElement> lists;
	
	@FindBy(xpath=("//div[@id='checkout_summary_container']/div/div[2]/div[2]"))
	WebElement paymentCardDetails;
	
	@FindBy(xpath=("//div[@id='checkout_summary_container']/div/div[2]/div[4]"))
	WebElement shippingDetails;
	
	@FindBy(xpath=("//div[@id='checkout_summary_container']/div/div[2]/div[6]"))
	WebElement totalItemPayment;
	
	@FindBy(xpath=("//div[@id='checkout_summary_container']/div/div[2]/div[7]"))
	WebElement taxTotalPayement;
	
	@FindBy(xpath=("//div[@id='checkout_summary_container']/div/div[2]/div[8]"))
	WebElement totalPayments;
	
	@FindBy(id = "finish")
	WebElement finishButton;
	
	@FindBy(id = "cancel")
	WebElement cancelButton;
	
	public int countItemsInList() {
		int itemList = lists.size();
		return itemList;
	}
	
	public String getPaymentCardDetails() {
		String cardDetails = paymentCardDetails.getText();
		return cardDetails;
	}
	
	public String getShippingDetails() {
		String shippingDets = shippingDetails.getText();
		return shippingDets;
	}
	
	public String getTotalItemPayment() {
		String totalItemPay = totalItemPayment.getText();
		return totalItemPay;
	}
	
	public String getTaxTotalPayement() {
		String taxTotal = taxTotalPayement.getText();
		return taxTotal;
	}
	
	public String getTotalPayments() {
		String totalPay = totalPayments.getText();
		return totalPay;
	}
	
	public void clickFinishButton() {
		finishButton.click();
	}
	
	public void clickCancelButton() {
		cancelButton.click();
	}
}
