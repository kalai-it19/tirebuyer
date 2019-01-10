package com.tirebuyer.pageobjects;

import org.openqa.selenium.By;

public class CartAndDeliveryPage {
	public static By deliveryMethodInstaller = By
			.xpath("//div[@class='delivery-method delivery-method-installer ']//div[@class=\"delivery-radio\"]");

	public static By button_SaveAndContinue = By.id("InstallerSubmit");
	
	public static By button_ContinueToCheckout = By.className("continue-to-checkout");
	
	public static By installerItemSelector(Integer itemNo) {
		return By.xpath("//div[@id='InstallerList']//div[@data-installer-index='"+(itemNo.intValue() -1)+"']//div[@class='selector-radio']");
	}
}
