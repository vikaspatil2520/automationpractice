package com.automationpractice.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpractice.qa.util.Constants;
import com.automationpractice.qa.util.TestUtil;

public class MyWishListsPage  {
	
	private WebDriver driver;

	public MyWishListsPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getWishListName() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("tbody>tr:nth-child(1)>td:nth-child(1)>a"),
				Constants.IMPLICIT_WAIT);
	}
	public WebElement getQuantity() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("tbody>tr:nth-child(1)>td:nth-child(2)"),
				Constants.IMPLICIT_WAIT);
	}
	
	
	public WebElement getDirectLink() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("tbody>tr:nth-child(1)>td:nth-child(5)>a"),
				Constants.IMPLICIT_WAIT);
	}
	public WebElement getDeleteIcon() {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("tbody>tr:nth-child(1)>td:nth-child(6)>a"),
				Constants.IMPLICIT_WAIT);
	}
	
	public WebElement getProductName(int index) {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector(".row.wlp_bought_list>li:nth-child("+index+")>div.row>div>div.product_infos>p#s_title:nth-child(2)"),
				Constants.IMPLICIT_WAIT);
	}
	
	public List<WebElement> getWishListProductNames() {
		return TestUtil.waitForListOfElementPresence(driver, By.cssSelector("#s_title"), Constants.IMPLICIT_WAIT);
	}
	
	
}
