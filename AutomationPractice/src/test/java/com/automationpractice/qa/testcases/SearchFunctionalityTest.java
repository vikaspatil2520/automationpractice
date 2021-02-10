package com.automationpractice.qa.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.BuyersHomePage;
import com.automationpractice.qa.pages.HomePage;
import com.automationpractice.qa.pages.ProductShoppingActionsPage;
import com.automationpractice.qa.pages.ShoppingCartAdressesPage;
import com.automationpractice.qa.pages.ShoppingCartOrderConfirmPage;
import com.automationpractice.qa.pages.ShoppingCartPaymentPage;
import com.automationpractice.qa.pages.ShoppingCartShippingPage;
import com.automationpractice.qa.pages.ShoppingCartSummeryPage;
import com.automationpractice.qa.pages.SignInPage;

public class SearchFunctionalityTest extends TestBase {

	SignInPage signInPage;
	ProductShoppingActionsPage productShoppingActionsPage;
	BuyersHomePage buyersHomePage;
	Actions actions;
	HomePage homePage;
	ShoppingCartSummeryPage cartSummeryPage;
	ShoppingCartAdressesPage shoppingCartAdressesPage;
	ShoppingCartShippingPage shoppingCartShippingPage;
	ShoppingCartPaymentPage shoppingCartPaymentPage;
	ShoppingCartOrderConfirmPage shoppingCartOrderConfirmPage;

	public SearchFunctionalityTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		login();
		buyersHomePage = new BuyersHomePage(driver);
		cartSummeryPage = new ShoppingCartSummeryPage(driver);
		productShoppingActionsPage = new ProductShoppingActionsPage(driver);
		shoppingCartAdressesPage = new ShoppingCartAdressesPage(driver);
		shoppingCartShippingPage = new ShoppingCartShippingPage(driver);
		shoppingCartPaymentPage = new ShoppingCartPaymentPage(driver);
		shoppingCartOrderConfirmPage = new ShoppingCartOrderConfirmPage(driver);
		actions = new Actions(driver);
	}

	@Test(priority = 1)
	public void searchFunctionalityItemFoundTest() {
		String searchKeyword = new String("Blouse");
		Assert.assertTrue(buyersHomePage.getSearchTextField().isDisplayed());
		buyersHomePage.getSearchTextField().clear();
		buyersHomePage.getSearchTextField().sendKeys(searchKeyword);
		Assert.assertTrue(buyersHomePage.getSearchIcon().isEnabled());
		buyersHomePage.getSearchIcon().click();
		boolean flag = false;

		List<WebElement> productList = buyersHomePage.getListOfProductNames();
		for (WebElement product : productList) {
			if (product.getText().contains(searchKeyword)) {
				flag = true;
				System.out.println("Searching product is available in store");
				break;
			}
		}
		Assert.assertTrue(flag);

	}

	@Test(priority = 2)
	public void searchFunctionalityItemNotFoundTest() {
		String searchKeyword = new String("Napkin");
		Assert.assertTrue(buyersHomePage.getSearchTextField().isDisplayed());
		buyersHomePage.getSearchTextField().clear();
		buyersHomePage.getSearchTextField().sendKeys(searchKeyword);
		Assert.assertTrue(buyersHomePage.getSearchIcon().isEnabled());
		buyersHomePage.getSearchIcon().click();
		boolean flag = false;

		if (flag == false) {
			Assert.assertTrue(buyersHomePage.getNoResultFoundSearchMessage().isDisplayed());
			System.out.println("Searching product is not available in store");
		}

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		buyersHomePage.getSignOutButton().click();
		driver.quit();
	}

}
