package com.tirebuyer.runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tirebuyer.pageobjects.HomePage;

public class SimpleRunner {

	static {
		// TODO: Read from a config file
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\E329222\\Desktop\\VS2017\\Selenium\\chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.tirebuyer.com");
		driver.manage().window().maximize();
		// Alert alert = driver.switchTo().alert();
		// alert.dismiss();
		// HomePage homePage = PageFactory.initElements(driver, HomePage.class);

		/*
		 * try { WebDriverWait wait = new WebDriverWait(driver, 20);
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id(
		 * "monetate_lightbox_content"))).click(); } catch (Exception e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		driver.findElement(HomePage.adSelector).click();

		WebElement element1 = driver.findElement(HomePage.launchYearSelector);
		JavascriptExecutor executor = ((JavascriptExecutor) driver);
		executor.executeScript("arguments[0].click();", element1);
		
		Thread.sleep(5000);
		
		// driver.switchTo().window("CDwindow-B1D4A68280BCFC9F03BCCA69EE9230C0");
		driver.findElement(HomePage.getYearSelector(2010)).click();
		/*
		 * String MainWindow=driver.getWindowHandle();
		 * System.out.println("window"+MainWindow);
		 */
		driver.findElement(By.className("at_fitment_make_Honda")).click();
		driver.findElement(By.className("at_fitment_model_Accord")).click();
		driver.findElement(By.xpath("//div[contains(@class,'fitment-panel-style')]/tr[1]/td[1]")).click();
		driver.findElement(By.className("at_fitment_zipcode")).sendKeys("98003");
		driver.findElement(By.className("at_shop_tires")).click();
		driver.findElement(By.className("rec-shop-all")).click();

	}

}
