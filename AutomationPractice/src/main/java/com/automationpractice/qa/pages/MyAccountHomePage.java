package com.automationpractice.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpractice.qa.util.Constants;
import com.automationpractice.qa.util.TestUtil;

public class MyAccountHomePage {
	
	private WebDriver driver;

	public MyAccountHomePage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getOrderHistoryAndDetails() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("#center_column > div > div:nth-child(1) > ul > li:nth-child(1) > a > span"),
				Constants.IMPLICIT_WAIT);
	}
	public WebElement getMyCreditSlips() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("#center_column > div > div:nth-child(1) > ul > li:nth-child(2) > a > span"),
				Constants.IMPLICIT_WAIT);
	}
	
	public WebElement getMyAddresses() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("#center_column > div > div:nth-child(1) > ul > li:nth-child(3) > a > span"),
				Constants.IMPLICIT_WAIT);
	}
	
	public WebElement getMyPersonalInformation() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("#center_column > div > div:nth-child(1) > ul > li:nth-child(4) > a > span"),
				Constants.IMPLICIT_WAIT);
	}
	
	public WebElement getMyWishList() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector(".lnk_wishlist>a"),
				Constants.IMPLICIT_WAIT);
	}
}
