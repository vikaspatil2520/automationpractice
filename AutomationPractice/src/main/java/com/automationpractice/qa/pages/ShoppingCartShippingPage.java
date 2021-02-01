package com.automationpractice.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpractice.qa.util.Constants;
import com.automationpractice.qa.util.TestUtil;

public class ShoppingCartShippingPage {
	private WebDriver driver;

	public ShoppingCartShippingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getProceedToCheckoutButton() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("button[name=processCarrier]"), Constants.IMPLICIT_WAIT);
	}
	public WebElement getTermsOfServiceCheckBox() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("input[type=checkbox]"), Constants.IMPLICIT_WAIT);
	}
}
