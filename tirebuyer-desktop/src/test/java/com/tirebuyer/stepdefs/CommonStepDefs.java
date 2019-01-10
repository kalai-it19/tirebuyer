package com.tirebuyer.stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CommonStepDefs {

	static {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\E329222\\Desktop\\VS2017\\Selenium\\chromedriver.exe");
	}
	
	public static WebDriver driver = null;

	@Before
	public void beforeScenario() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@After
	public void afterScenario() {
		driver.close();
	}

}
