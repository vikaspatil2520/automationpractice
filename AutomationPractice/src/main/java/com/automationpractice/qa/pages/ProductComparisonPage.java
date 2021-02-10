package com.automationpractice.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpractice.qa.util.Constants;
import com.automationpractice.qa.util.TestUtil;

public class ProductComparisonPage {
	
	private WebDriver driver;

	public ProductComparisonPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getNavigationPath() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("span.navigation_page"),
				Constants.IMPLICIT_WAIT);
	}
	
	public WebElement getRemoveIcon(int index) {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("tbody>tr:nth-child(1)>td:nth-child("+(++index)+")>div[class=remove]>a"),
				Constants.IMPLICIT_WAIT);
	}
	
	public String getProductName(int index) {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("tbody>tr:nth-child(1)>td:nth-child("+(++index)+")>h5>a"),
				Constants.IMPLICIT_WAIT).getText();
				}
	
	public String getProductPrice(int index) {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("tbody>tr:nth-child(1)>td:nth-child("+(++index)+")>.prices-container>span"),
				Constants.IMPLICIT_WAIT).getText().trim().substring(1);
	}
	
	public WebElement getAddToCartButton(int index) {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("tbody>tr:nth-child(1)>td:nth-child("+(++index)+")>.comparison_product_infos>div>div>a:nth-child(1)"),
				Constants.IMPLICIT_WAIT);
	}
	public WebElement getViewButton(int index) {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("tbody>tr:nth-child(1)>td:nth-child("+(++index)+")>.comparison_product_infos>div>div>a:nth-child(2)"),
				Constants.IMPLICIT_WAIT);
	}
	
	/*public WebElement getMoreThanThreeProductsComparisonErrorMsg() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector(".fancybox-error"),
				Constants.IMPLICIT_WAIT);
	}
	public WebElement getMoreThanThreeProductsComparisonErrorMsgCloseButton() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector(".fancybox-item.fancybox-close"),
				Constants.IMPLICIT_WAIT);
	}*/
}
