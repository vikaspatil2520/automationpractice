package com.automationpractice.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpractice.qa.util.TestUtil;

public class SignInPage {

	private WebDriver driver;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSignInLink() {
		return TestUtil.waitForElementPresence(driver, By.linkText("Sign in"), 30);
	}

	public WebElement getSignInEmailField() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector("input#email"), 30);
	}

	public WebElement getSignInPasswordField() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector("input#passwd"), 30);
	}

	public WebElement getSignInSubmitBtn() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector("#SubmitLogin > span"), 30);
	}

	public void setEmailField(String mail) {
		WebElement email = this.getSignInEmailField();
		email.clear();
		email.sendKeys(mail);
	}

	public void setPasswordField(String pass) {
		WebElement password = this.getSignInPasswordField();
		password.clear();
		password.sendKeys(pass);
	}

	public WebElement getEmailRequiredError() {
		return TestUtil.waitForElementPresence(driver, By.xpath("//li[contains(text(),'An email address required.')]"),30);
	}

	public WebElement getEmailInvalidError() {
		return TestUtil.waitForElementPresence(driver, By.xpath("//li[contains(text(),'Invalid email address.')]"), 30);
	}

	public WebElement getAuthenticationFailedError() {
		return TestUtil.waitForElementPresence(driver, By.xpath("//li[contains(text(),'Authentication failed.')]"), 30);
	}

	public WebElement getPasswordRequiredError() {
		return TestUtil.waitForElementPresence(driver, By.xpath("//li[contains(text(),'Password is required.')]"), 30);
	}

	public WebElement getInvalidPasswordError() {
		return TestUtil.waitForElementPresence(driver, By.xpath("//li[contains(text(), 'Invalid password')]"), 30);
	}

	
	public String getErrorMessage() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector("#center_column > div.alert.alert-danger > ol > li:first-of-type"), 30).getText();
	}
	
        /****** HIGHLIGHTED ERRORS ******/
	
	public WebElement getEmailHighlightedGreen() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector(".form-group.form-ok>input"), 30);
	}
	public WebElement getEmailHighlightedRed() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector(".form-group.form-error>input"), 30);
	}
}
