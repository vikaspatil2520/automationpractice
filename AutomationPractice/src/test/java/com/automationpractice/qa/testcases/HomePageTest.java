package com.automationpractice.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.HomePage;

public class HomePageTest extends TestBase {
	HomePage homePage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage(driver);
	}

	@Test(priority = 1)
	public void homePageElementDispalyTest() throws InterruptedException {
		Thread.sleep(30000);
		Assert.assertTrue(homePage.getContactUsButton().isDisplayed());
		Assert.assertTrue(homePage.getSignInButton().isDisplayed());
		Assert.assertTrue(homePage.getLogo().isDisplayed());
		Assert.assertTrue(homePage.getFooterContainer().isDisplayed());
		Assert.assertTrue(homePage.getSlider().isDisplayed());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
