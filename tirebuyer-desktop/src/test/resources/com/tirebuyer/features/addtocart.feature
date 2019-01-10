Feature: Launch TireBuyer.com and Create an order

@SmokeTest
Scenario: Add an item to cart and checkout
Given the user is on tirebuyer.com home page
When user clicks 'Tires' tab and user chooses 'Shop by vehicle' section
When user selects year as 2010
And user selects 'Honda' from Select Make section
And user selects 'Accord' from Select Model section
And user selects 'EX 2 Dr. 4 Cyl.' from Select style section
And user enters zip code as 98003 
And user clicks on Shop tires button
And user clicks Shop all tires on the Recommendation page
And user clicks on More details for the product number 2 in Tires Details page
And user clicks on Add to cart in the details page
And user clicks on Deliver to a local installer radio button on the cart page
And user selects installer number 3 from the local installer list
And user clicks on Save and continue button in the Delivery to Installer window.
And user clicks on Continue to checkout button on the cart page
And user clicks on Checkout with PayPal button on the Payment page
And user gives any dummy credentials and clicks on Log in button
Then user should receive an error message
When user clicks on Cancel and return to TireBuyer.com link
Then user should go back to tirebuyer.com

@SmokeTest
Scenario: Add an item to cart and click honda
Given the user is on tirebuyer.com home page
When user clicks 'Wheels' tab and user chooses 'Shop by vehicle' section
When user selects year as 2007
And user selects 'Honda' from Select Make section