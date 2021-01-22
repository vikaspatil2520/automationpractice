package com.automationpractice.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.SignInPage;

public class LoginFormTest extends TestBase {
	
	SignInPage signInPage;
	
	public LoginFormTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		signInPage = new SignInPage(driver);
	
	}
	
	@Test(priority = 1)
	public void loginPageElementDispalyTest() {
		signInPage.getSignInLink().click();
		Assert.assertTrue(signInPage.getSignInEmailField().isDisplayed());
		Assert.assertTrue(signInPage.getSignInPasswordField().isDisplayed());
		Assert.assertTrue(signInPage.getSignInSubmitBtn().isEnabled());
	}
	
	@Test(priority = 2)
	public void invalidCredentialsTest() {
		// username: dip@gmail.com
		// password: dip@123
		signInPage.getSignInLink().click();
		signInPage.setEmailField("dip@gmail.com");
		signInPage.setPasswordField("dip@12345");
		signInPage.getSignInSubmitBtn().click();
		Assert.assertTrue(signInPage.getAuthenticationFailedError().isDisplayed());		
		
		signInPage.setEmailField("dip@gmail.com");
		signInPage.setPasswordField("123");
		signInPage.getSignInSubmitBtn().click();
		Assert.assertTrue(signInPage.getInvalidPasswordError().isDisplayed());	
		
		signInPage.getSignInEmailField().clear();
		signInPage.getSignInPasswordField().clear();
		signInPage.getSignInSubmitBtn().click();
		Assert.assertTrue(signInPage.getEmailRequiredError().isDisplayed());
		
		signInPage.setEmailField("dip@gmail.com");
		signInPage.getSignInPasswordField().clear();
		signInPage.getSignInSubmitBtn().click();
		Assert.assertTrue(signInPage.getPasswordRequiredError().isDisplayed());	
		
		signInPage.setEmailField("dip@gmail");
		signInPage.getSignInSubmitBtn().click();
		Assert.assertTrue(signInPage.getEmailInvalidError().isDisplayed());	
		
	}
	
	@Test(priority = 3)
	public void invalidEmaiIdTest() {
		// username: dip@gmail.com
		// password: dip@123
		signInPage.getSignInLink().click();
		signInPage.setEmailField("dip@gmail");
		signInPage.getSignInPasswordField().click();
		Assert.assertTrue(signInPage.getEmailHighlightedRed().isDisplayed());		
		
		signInPage.setEmailField("dip");
		signInPage.getSignInPasswordField().click();
		Assert.assertTrue(signInPage.getEmailHighlightedRed().isDisplayed());	
		
		signInPage.setEmailField("dip@gmail.com");
		signInPage.getSignInPasswordField().click();
		Assert.assertTrue(signInPage.getEmailHighlightedGreen().isDisplayed());
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
