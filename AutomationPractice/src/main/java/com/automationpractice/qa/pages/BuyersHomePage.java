package com.automationpractice.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpractice.qa.util.Constants;
import com.automationpractice.qa.util.TestUtil;

public class BuyersHomePage {

	private WebDriver driver;

	public BuyersHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSignOutButton() {
		return TestUtil.waitToBeClickable(driver, By.linkText("Sign out"), Constants.IMPLICIT_WAIT);
	}
	
	public WebElement getWomenBtn() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a"),
				Constants.IMPLICIT_WAIT);
	}

	public WebElement getDressesBtn() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a"),
				Constants.IMPLICIT_WAIT);
	}

	public WebElement getTShirtsBtn() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector("#block_top_menu > ul > li:nth-child(3) > a"),
				Constants.IMPLICIT_WAIT);
	}
	
	public WebElement getWomenDropDownTShirtsBtn() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("#block_top_menu > ul > li:nth-child(1) > ul > li:nth-child(1) > ul > li:nth-child(1)>a"),
				Constants.IMPLICIT_WAIT);
	}
	public WebElement getWomenDropDownBlousesBtn() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("#block_top_menu > ul > li:nth-child(1) > ul > li:nth-child(1) > ul > li:nth-child(2)>a"),
				Constants.IMPLICIT_WAIT);
	}
	
	
	
	public WebElement getDressesDropDownCasualDressesBtn() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child(1) > a"),
				Constants.IMPLICIT_WAIT);
	}

	public WebElement getDressesDropDownEveeningDressesBtn() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child(2) > a"),
				Constants.IMPLICIT_WAIT);
	}

	public WebElement getDressesDropDownSummerDressesBtn() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child(3) > a"),
				Constants.IMPLICIT_WAIT);
	}

	// 1
	public WebElement getCasulDressProduct(int itemNumber) {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector(".product_list.grid.row>li:nth-child(" + itemNumber + ")>div>div:nth-child(1)"),
				Constants.IMPLICIT_WAIT);
	}

	// 1
	public WebElement getEveningDressProduct(int itemNumber) {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector(".product_list.grid.row>li:nth-child(" + itemNumber + ")>div>div:nth-child(1)"),
				Constants.IMPLICIT_WAIT);
	}

	// between 1 to 3
	public WebElement getSummerDressProduct(int itemNumber) {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector(".product_list.grid.row>li:nth-child(" + itemNumber + ")>div>div:nth-child(1)"),
				Constants.IMPLICIT_WAIT);
	}

	public WebElement getProductCategory(String category) {
		return TestUtil.waitForElementPresence(driver,By.linkText(category),Constants.IMPLICIT_WAIT);
	}
	public WebElement getProductByIndex(int itemNumber) {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector(".product_list.grid.row>li:nth-child(" + itemNumber + ")>div>div:nth-child(1)"),
				Constants.IMPLICIT_WAIT);
	}
	public List<WebElement> getDressCount() {
		//return driver.findElements(By.cssSelector(".product_list.grid.row>li>div"));		
		return TestUtil.waitForListOfElementPresence(driver, By.cssSelector(".product_list.grid.row>li>div"), Constants.IMPLICIT_WAIT);
	}
}
