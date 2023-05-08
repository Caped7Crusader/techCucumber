package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	
	public WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By cartBag = By.xpath("//a[contains(@class,'cart-icon')]");
	By checkoutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	By promoButton = By.xpath("//button[text()='Apply']");
	By placeOrder = By.xpath("//button[text()='Place Order']");
	
	public void CheckoutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(checkoutButton).click();
	}
	
	public boolean VerifyPromoButton() {
		return driver.findElement(promoButton).isDisplayed();
	}
	
	public boolean VerifyPlaceOrderButton() {
		return driver.findElement(placeOrder).isDisplayed();
	}


}
