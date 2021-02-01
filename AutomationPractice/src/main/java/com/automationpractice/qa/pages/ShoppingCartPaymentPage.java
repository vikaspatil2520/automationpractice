package com.automationpractice.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpractice.qa.util.Constants;
import com.automationpractice.qa.util.TestUtil;

public class ShoppingCartPaymentPage {
	private WebDriver driver;

	public ShoppingCartPaymentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getPaymentMethodPayByBankWireButton() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector(".bankwire"), Constants.IMPLICIT_WAIT);
	}
	public WebElement getPaymentMethodPayByCheckireButton() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector(".cheque"), Constants.IMPLICIT_WAIT);
	}
}
