package com.automationpractice.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpractice.qa.util.Constants;
import com.automationpractice.qa.util.TestUtil;

public class ProductShoppingActionsPage {
	private WebDriver driver;

	public ProductShoppingActionsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getQuantityTextField() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector("#quantity_wanted"), Constants.IMPLICIT_WAIT);
	}

	public WebElement getQuantityMinusIcon() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector(".icon-minus"), Constants.IMPLICIT_WAIT);
	}

	public WebElement getQuantityPlusIcon() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector(".icon-plus"), Constants.IMPLICIT_WAIT);
	}

	public WebElement getSizeDropDown() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector("#group_1"), Constants.IMPLICIT_WAIT);
	}

	public List<WebElement> getListOfAvailbleColor() {
		return TestUtil.waitForListOfElementPresence(driver, By.cssSelector("#color_to_pick_list>li>a"),
				Constants.IMPLICIT_WAIT);
	}
	
	public WebElement getAddToCartButton() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector("#add_to_cart > button > span"), Constants.IMPLICIT_WAIT);
	}
	public WebElement getProceedToCheckOutButton() {
		return TestUtil.waitForElementPresence(driver, By.linkText("Proceed to checkout"), Constants.IMPLICIT_WAIT);
	}
	
	public WebElement getHomeIcon() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector(".icon-home"), Constants.IMPLICIT_WAIT);
	}
	
	public WebElement getContinueShoppingButton() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector("span[title='Continue shopping']>span>i"),Constants.IMPLICIT_WAIT);
	}
	
	public void setQuantityTextField(Integer count) {
		WebElement quantity = this.getQuantityTextField();
		quantity.clear();
		quantity.sendKeys(count.toString());
	}
	
	
}
