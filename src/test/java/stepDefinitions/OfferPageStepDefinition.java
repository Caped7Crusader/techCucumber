package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.OfferPage;

import utils.TestContextSetup;

public class OfferPageStepDefinition {
	public TestContextSetup testContextSetup;
//	public PageObjectManager pageObjectManager;

	public OfferPageStepDefinition(TestContextSetup textContextSetup) {
		this.testContextSetup = textContextSetup;
	}
	
	@Then("^User seached for same Shortname (.+) in Offers page to chek if product exits$")
	public void user_seached_for_same_shortname_in_offers_page_to_chek_if_product_exits(String shortName ) throws InterruptedException {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		pageObjectManager = new PageObjectManager(testContextSetup.driver);
		OfferPage offerPage =  testContextSetup.pageObjectManager.getOfferPage();
//	 	OfferPage offerPage = new OfferPage(testContextSetup.driver);
		offerPage.getToOffersPage();
//		testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		testContextSetup.genericUtils.switchToChildWindow();
//	    String parentWindow = testContextSetup.driver.getWindowHandle();
//	    Set<String> allWindows = testContextSetup.driver.getWindowHandles();
//	    for(String childWindow : allWindows) {
//		    if(!parentWindow.equalsIgnoreCase(childWindow))
//		    	testContextSetup.driver.switchTo().window(childWindow);
//	   }
		offerPage.searchItem(shortName);
//	    testContextSetup.driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortName);
	    testContextSetup.offerPageProductName = offerPage.getProductName();
//	    String offerProductName = testContextSetup.driver.findElement(By.xpath("//tbody/tr/td[1]")).getText().split("-")[0].trim();
	    System.out.println(testContextSetup.offerPageProductName +" is extrated from Offer page");
	}
	@And("Validate Offer page product name matched with Landing page product name")
	public void validate_offer_page_product_name_matched_with_landing_page_product_name() {
		
		System.out.println(testContextSetup.productName +'\n' +testContextSetup.offerPageProductName);
	    Assert.assertEquals(testContextSetup.offerPageProductName, testContextSetup.productName);
	}

}
