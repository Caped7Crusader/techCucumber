 package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
	public WebDriver driver;
	private By searchBar = By.xpath("//input[@type='search']");
	private By offersPageLink = By.linkText("Top Deals");
	private By offerPageProductText = By.xpath("//tbody/tr/td[1]");
	
	public OfferPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchItem(String name) {
		driver.findElement(searchBar).sendKeys(name);
	}
	
	public void getToOffersPage() {
		driver.findElement(offersPageLink).click();
	}
	
	public String getProductName() throws InterruptedException {
		Thread.sleep(5);
		return driver.findElement(offerPageProductText).getText().split("-")[0].trim();
	}

}
