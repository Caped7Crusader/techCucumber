Feature: Search and place orders

@OffersPage
Scenario Outline: Search Experience for porduct search in both home and offers page

Given User is on GreenCart Landing page
When User searched with Shortname <Name> and extracted acutual name of the product
Then User seached for same Shortname <Name> in Offers page to chek if product exits
And Validate Offer page product name matched with Landing page product name

Examples:
	|Name|
	|Tom |
	|Beet|