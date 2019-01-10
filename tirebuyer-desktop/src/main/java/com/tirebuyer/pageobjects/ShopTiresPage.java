package com.tirebuyer.pageobjects;

import org.openqa.selenium.By;

public class ShopTiresPage {
	public static By button_ShopAllTires = By.className("rec-shop-all");
	
	public static By productSelector(Integer productNo) {
		return  By.xpath("//div[@class='list-item-ctn']["+productNo+"]//a[@class='more-details']");
	}

}
