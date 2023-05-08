Feature: Place orders

@PlaceOrder
Scenario Outline: Search and add product and proceed to checkout

Given User is on GreenCart Landing page
When User searched with Shortname <Name> and extracted acutual name of the product
And Added "3" items of the selected product to cart
Then User proceeds to checlout and validate <Name> items in checkout page
And Verify user has ability to enter promo code and place the order

Examples:
	|Name|
	|Tom |
	