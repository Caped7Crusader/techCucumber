package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.CheckOutPage;
import utils.TestContextSetup;

public class CheckOutPageStepDeifinition {
	
	public CheckOutPage checkoutPage;
	TestContextSetup testContextSetup;
	
	public CheckOutPageStepDeifinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	    this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}
 
	@Then("^User proceeds to checlout and validate (.+) items in checkout page$")
	public void user_proceeds_to_checlout_and_validate_tom_items_in_checkout_page(String str) {
	    checkoutPage.CheckoutItems();
	    //Assertion to extract name form screen and compare with str
	}

	@Then("Verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
		Assert.assertTrue(checkoutPage.VerifyPlaceOrderButton());
	    Assert.assertTrue(checkoutPage.VerifyPromoButton());
	}
}
