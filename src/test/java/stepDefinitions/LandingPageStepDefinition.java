package stepDefinitions;



import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	
	TestContextSetup testContextSetup;
	
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		Assert.assertEquals("GreenKart - veg and fruits kart", landingPage.getTitle());
	   
	}
	@When("^User searched with Shortname (.+) and extracted acutual name of the product$")
	public void user_searched_with_shortname_and_extracted_acutual_name_of_the_product(String shortName) throws InterruptedException {
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
//		LandingPage landingPage = new LandingPage(testContextSetup.driver);
//		testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		landingPage.searchItem(shortName);
//		testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
//	    Thread.sleep(10);
		testContextSetup.productName = landingPage.getProductName();
//	    testContextSetup.productName = testContextSetup.driver.findElement(By.xpath("//h4[text()='Tomato - 1 Kg']")).getText().split("-")[0].trim();
		System.out.println(shortName);
	    System.out.println(testContextSetup.productName +" is extrated from Landing page");
	}

	@When("Added {string} items of the selected product to cart")
	public void added_items_of_the_selected_product_to_cart(String str) {
	    LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
	    landingPage.incrementQuantity(Integer.parseInt(str));
	    landingPage.addToCart();
	    System.out.println("incrmented and added to cart");
	    
	}



}
