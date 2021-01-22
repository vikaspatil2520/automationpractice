package com.automationpractice.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpractice.qa.util.Constants;
import com.automationpractice.qa.util.TestUtil;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSignInButton() {
		return TestUtil.waitToBeClickable(driver, By.linkText("Sign in"), Constants.IMPLICIT_WAIT);
	}

	public WebElement getContactUsButton() {
		return TestUtil.waitToBeClickable(driver, By.linkText("Contact us"), Constants.IMPLICIT_WAIT);
	}
	
	public WebElement getLogo() {
		return TestUtil.waitToBeClickable(driver, By.cssSelector(".logo.img-responsive"), Constants.IMPLICIT_WAIT);
	}
	
	public WebElement getFooterContainer() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector(".footer-container"), Constants.IMPLICIT_WAIT);
	}
	
	public WebElement getSlider() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector("#homeslider > li:nth-child(2) > a > img"), Constants.IMPLICIT_WAIT);
	}
}
