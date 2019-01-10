package com.tirebuyer.util;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverUtil {

		public static void clickAsJavascript(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		JavascriptExecutor executor = ((JavascriptExecutor) driver);
		executor.executeScript("arguments[0].click();", element);
	}

	public static void scrollBy(WebDriver driver, int x, int y) {
		JavascriptExecutor executor = ((JavascriptExecutor) driver);
		executor.executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	public static void flipWindow(WebDriver driver) {
		String current = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		while (iterator.hasNext()) {
			String target = iterator.next();
			if (!current.equals(target)) {
				driver.switchTo().window(target);
			}
		}
	}
}
