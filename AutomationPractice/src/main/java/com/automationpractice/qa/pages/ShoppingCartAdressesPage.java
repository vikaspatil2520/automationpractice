package com.automationpractice.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpractice.qa.util.Constants;
import com.automationpractice.qa.util.TestUtil;

public class ShoppingCartAdressesPage {
	
	private WebDriver driver;

	public ShoppingCartAdressesPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getProceedToCheckoutButton() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("button[name=processAddress]"), Constants.IMPLICIT_WAIT);
	}

}
