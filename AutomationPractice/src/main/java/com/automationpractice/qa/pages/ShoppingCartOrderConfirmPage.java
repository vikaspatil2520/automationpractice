package com.automationpractice.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpractice.qa.util.Constants;
import com.automationpractice.qa.util.TestUtil;

public class ShoppingCartOrderConfirmPage {
	private WebDriver driver;

	public ShoppingCartOrderConfirmPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getConfirmOrderButton() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("#cart_navigation > button > span"), Constants.IMPLICIT_WAIT);
	}
	
	public double getTotalAmount() {
		 return Double.parseDouble(driver.findElement(By.cssSelector(".price > strong")).getText().substring(1));
	}
}
