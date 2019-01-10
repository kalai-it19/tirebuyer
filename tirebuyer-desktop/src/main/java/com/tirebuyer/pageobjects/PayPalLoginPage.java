package com.tirebuyer.pageobjects;

import org.openqa.selenium.By;

public class PayPalLoginPage {
public static By email = By.id("email");
	
	public static By button_Next = By.id("btnNext");
	
	public static By button_Password = By.id("password");
	
	public static By button_Login = By.id("btnLogin");
	
	public static By link_Cancel = By.id("cancelLink");
	
	public static By login_Error = By.className("notification-critical");
}
