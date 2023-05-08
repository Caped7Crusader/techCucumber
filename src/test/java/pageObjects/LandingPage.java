package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	By searchBar = By.xpath("//input[@type='search']");
	By productText = By.xpath("//h4[@class='product-name']");
	By incriment = By.xpath("//div/a[@class='increment']");
	By addToCart = By.xpath("//button[text()='ADD TO CART']");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitle() {
		
		String title = driver.getTitle();
		return title;
	}
	public void searchItem(String name) {
		driver.findElement(searchBar).sendKeys(name);
	}
	
	public String getProductName() {
		return driver.findElement(productText).getText().split("-")[0].trim();
	}
	
	public void incrementQuantity(int quantity) {
		int i = quantity - 1;
		while(i<0) {
			driver.findElement(incriment).click();
			i--;
		}
	}
	
	public void addToCart() {
		driver.findElement(addToCart).click();
	}

}
