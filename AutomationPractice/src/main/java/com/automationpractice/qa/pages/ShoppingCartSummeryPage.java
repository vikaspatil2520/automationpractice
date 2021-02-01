package com.automationpractice.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpractice.qa.util.Constants;
import com.automationpractice.qa.util.TestUtil;

public class ShoppingCartSummeryPage {

	private WebDriver driver;

	public ShoppingCartSummeryPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCarTabIcon() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector(".shopping_cart>a"), Constants.IMPLICIT_WAIT);
	}

	public WebElement getTotalProductQuantityMsg() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector("#summary_products_quantity"),
				Constants.IMPLICIT_WAIT);
	}

	public WebElement getProductDescription(int number) {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("tbody>tr:nth-child(" + number + ")>.cart_description>p>a"), Constants.IMPLICIT_WAIT);
	}

	public double getUnitPrice(int number) {

		return Double.parseDouble(
				driver.findElement(By.cssSelector("tbody>tr:nth-child(" + number + ")>td>.price> span.price")).getText()
						.substring(1));

	}

	public int getQuantity(int number) {

		return Integer.parseInt(driver
				.findElement(By.cssSelector("tbody>tr:nth-child(" + number + ")>td:nth-child(5)>input:nth-child(2)"))
				.getAttribute("value"));

	}

	public WebElement getTotalOfSingleProduct(int number) {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("tbody>tr:nth-child(" + number + ")>td:nth-child(6)>span"), Constants.IMPLICIT_WAIT);
	}

	public WebElement getDeleteIcon(int number) {
		return TestUtil.waitForElementPresence(driver,
				By.cssSelector("tbody>tr:nth-child(" + number + ")>td:nth-child(7)>div>a"), Constants.IMPLICIT_WAIT);
	}

	public WebElement getTotalProdcutsCostBeforeShippingChargeAndTax() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector("#total_product"), Constants.IMPLICIT_WAIT);
	}

	public WebElement getTotalShippingCharges() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector("#total_shipping"), Constants.IMPLICIT_WAIT);
	}

	public WebElement getTotalPriceWithoutTax() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector("#total_price_without_tax"),
				Constants.IMPLICIT_WAIT);
	}

	public WebElement getTotalTax() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector("#total_tax"), Constants.IMPLICIT_WAIT);
	}

	public double getTotalPrice() {

		return Double.parseDouble(driver.findElement(By.cssSelector("#total_price")).getText().substring(1));
	}

	public int getNumberOfProductTypesInCart() {
		return driver.findElements(By.cssSelector("tbody>tr")).size();
	}
	public WebElement getProceedToCheckoutButton() {
		return TestUtil.waitForElementPresence(driver, By.cssSelector("a[title='Proceed to checkout']"),
				Constants.IMPLICIT_WAIT);
	}
}
