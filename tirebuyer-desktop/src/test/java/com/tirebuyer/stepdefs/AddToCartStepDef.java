package com.tirebuyer.stepdefs;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tirebuyer.pageobjects.CartAndDeliveryPage;
import com.tirebuyer.pageobjects.HomePage;
import com.tirebuyer.pageobjects.PayPalLoginPage;
import com.tirebuyer.pageobjects.PaymentPage;
import com.tirebuyer.pageobjects.ShopTiresPage;
import com.tirebuyer.pageobjects.TireDetailsPage;
import com.tirebuyer.util.WebDriverUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToCartStepDef {

	WebDriver driver = CommonStepDefs.driver;

	public void clearAds() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(HomePage.adSelector));
			
			driver.findElement(HomePage.adSelector).click();
		} catch (Exception e) {
		}

		try {
			Thread.sleep(5000);
			
			driver.findElement(HomePage.close_flyInAd).click();
			WebDriverUtil.clickAsJavascript(driver, HomePage.close_flyInAd);
		} catch (Exception e) {
		}
	}

	@Given("the user is on tirebuyer.com home page")
	public void the_user_is_on_tirebuyer_com_home_page() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get("https://www.tirebuyer.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		clearAds();
	}

	@When("user clicks {string} tab and user chooses {string} section")
	public void user_clicks_tab_and_user_chooses_section(String tab, String shopBy) {
		driver.findElement(HomePage.getTabSelector(tab)).click();
		driver.findElement(HomePage.getShopBySelector(tab, shopBy)).click();
	}

	@When("user selects year as {int}")
	public void user_selects_year_as(Integer year) throws InterruptedException {
		WebDriverUtil.clickAsJavascript(driver, HomePage.launchYearSelector);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(HomePage.getYearSelector(year)));
		driver.findElement(HomePage.getYearSelector(year)).click();
	}

	@When("user selects {string} from Select Make section")
	public void user_selects_from_Select_Make_section(String make) {
		driver.findElement(HomePage.getMakeSelector(make)).click();
	}

	@When("user selects {string} from Select Model section")
	public void user_selects_from_Select_Model_section(String model) {
		driver.findElement(HomePage.getModelSelector(model)).click();
	}

	@When("user selects {string} from Select style section")
	public void user_selects_from_Select_style_section(String style) {
		driver.findElement(HomePage.getStyleSelector(style)).click();

	}

	@When("user enters zip code as {int}")
	public void user_enters_zip_code_as(Integer zipCode) {
		driver.findElement(HomePage.getZipCodeSelector(zipCode)).sendKeys(zipCode.toString());
	}

	@When("user clicks on Shop tires button")
	public void user_clicks_on_Shop_tires_button() {
		driver.findElement(HomePage.button_ShopTires).click();
	}

	@When("user clicks Shop all tires on the Recommendation page")
	public void user_clicks_Shop_all_tires_on_the_Recommendation_page() {		
		clearAds();
		
		try {			
			driver.findElement(ShopTiresPage.button_ShopAllTires).click();
		} catch (NoSuchElementException e) {
			// Ignore
		}
	}

	@When("user clicks on More details for the product number {int} in Tires Details page")
	public void user_clicks_on_More_details_for_the_product_number_in_Tires_Details_page(Integer productNo) {
		clearAds();		
		WebDriverUtil.scrollBy(driver, 0, 400);
		driver.findElement(ShopTiresPage.productSelector(productNo)).click();
	}

	@When("user clicks on Add to cart in the details page")
	public void user_clicks_on_Add_to_cart_in_the_details_page() {		
		WebDriverUtil.scrollBy(driver, 0, 500);
		driver.findElement(TireDetailsPage.button_AddToCart).click();
	}

	@When("user clicks on Deliver to a local installer radio button on the cart page")
	public void user_clicks_on_Deliver_to_a_local_installer_radio_button_on_the_cart_page() {
		driver.findElement(CartAndDeliveryPage.deliveryMethodInstaller).click();
	}

	@When("user selects installer number {int} from the local installer list")
	public void user_selects_installer_number_from_the_local_installer_list(Integer itemNo) {
		driver.findElement(CartAndDeliveryPage.installerItemSelector(itemNo)).click();
	}

	@When("user clicks on Save and continue button in the Delivery to Installer window.")
	public void user_clicks_on_Save_and_continue_button_in_the_Delivery_to_Installer_window() {
		driver.findElement(CartAndDeliveryPage.button_SaveAndContinue).click();
	}

	@When("user clicks on Continue to checkout button on the cart page")
	public void user_clicks_on_Continue_to_checkout_button_on_the_cart_page() throws InterruptedException {		
		WebDriverUtil.scrollBy(driver, 0, 500);
		Thread.sleep(5000);
		driver.findElement(CartAndDeliveryPage.button_ContinueToCheckout).click();
	}

	@When("user clicks on Checkout with PayPal button on the Payment page")
	public void user_clicks_on_Checkout_with_PayPal_button_on_the_Payment_page() {
		driver.findElement(PaymentPage.button_PaypalExpress).click();
	}

	@When("user gives any dummy credentials and clicks on Log in button")
	public void user_gives_any_dummy_credentials_and_clicks_on_Login_button() throws InterruptedException {
		
		Thread.sleep(5000);
		
		WebDriverUtil.flipWindow(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(PayPalLoginPage.email));

		driver.findElement(PayPalLoginPage.email).sendKeys("abc@gmail.com");
		driver.findElement(PayPalLoginPage.button_Next).click();
		driver.findElement(PayPalLoginPage.button_Password).sendKeys("12345");
		driver.findElement(PayPalLoginPage.button_Login).click();
	}

	@Then("user should receive an error message")
	public void user_should_receive_an_error_message() {
		driver.findElement(PayPalLoginPage.login_Error);
	}

	@When("user clicks on Cancel and return to TireBuyer.com link")
	public void user_clicks_on_Cancel_and_return_to_TireBuyer_com_link() {
		driver.findElement(PayPalLoginPage.link_Cancel).click();
		WebDriverUtil.flipWindow(driver);
	}

	@Then("user should go back to tirebuyer.com")
	public void user_should_go_back_to_tirebuyer_com() {
		assertTrue(driver.getCurrentUrl().contains("tirebuyer.com"));
	}

}
