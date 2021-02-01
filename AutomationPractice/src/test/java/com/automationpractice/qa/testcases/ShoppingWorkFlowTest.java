package com.automationpractice.qa.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.enums.SelectOption;
import com.automationpractice.qa.model.ProductDetails;
import com.automationpractice.qa.pages.BuyersHomePage;
import com.automationpractice.qa.pages.ShoppingCartSummeryPage;
import com.automationpractice.qa.pages.HomePage;
import com.automationpractice.qa.pages.ProductShoppingActionsPage;
import com.automationpractice.qa.pages.ShoppingCartAdressesPage;
import com.automationpractice.qa.pages.ShoppingCartOrderConfirmPage;
import com.automationpractice.qa.pages.ShoppingCartPaymentPage;
import com.automationpractice.qa.pages.ShoppingCartShippingPage;
import com.automationpractice.qa.pages.SignInPage;
import com.automationpractice.qa.util.Constants;
import com.automationpractice.qa.util.ShoppingUtil;
import com.automationpractice.qa.util.TestUtil;

public class ShoppingWorkFlowTest extends TestBase {
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
	
	public ShoppingWorkFlowTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		login();
		
		buyersHomePage = new BuyersHomePage(driver);
		cartSummeryPage = new ShoppingCartSummeryPage(driver);
		productShoppingActionsPage = new ProductShoppingActionsPage(driver);
		shoppingCartAdressesPage=new ShoppingCartAdressesPage(driver);
		shoppingCartShippingPage=new ShoppingCartShippingPage(driver);
		shoppingCartPaymentPage=new ShoppingCartPaymentPage(driver);
		shoppingCartOrderConfirmPage=new ShoppingCartOrderConfirmPage(driver);
		actions = new Actions(driver);
	}

	@Test(priority = 1)
	public void clothsCategoryTypesDispalyTest() {
		Assert.assertEquals(buyersHomePage.getDressesBtn().isDisplayed(), true);
		actions.moveToElement(buyersHomePage.getDressesBtn()).build().perform();
		Assert.assertTrue(buyersHomePage.getDressesDropDownCasualDressesBtn().isDisplayed());
		Assert.assertTrue(buyersHomePage.getDressesDropDownSummerDressesBtn().isDisplayed());
		Assert.assertTrue(buyersHomePage.getDressesDropDownEveeningDressesBtn().isDisplayed());
	}

	@Test(priority = 2)
	public void selectSingleClothTest() throws InterruptedException {
		Assert.assertTrue(buyersHomePage.getDressesBtn().isDisplayed());
		actions.moveToElement(buyersHomePage.getDressesBtn()).build().perform();
		Assert.assertTrue(buyersHomePage.getDressesDropDownCasualDressesBtn().isDisplayed());
		Assert.assertTrue(buyersHomePage.getDressesDropDownEveeningDressesBtn().isDisplayed());
		Assert.assertTrue(buyersHomePage.getDressesDropDownSummerDressesBtn().isDisplayed());
		actions.moveToElement(buyersHomePage.getDressesDropDownSummerDressesBtn()).build().perform();
		buyersHomePage.getDressesDropDownSummerDressesBtn().click();

		// test all products are displayed or not
		for (int i = 1; i <= (buyersHomePage.getDressCount().size() - 1); i++) {
			Assert.assertTrue(buyersHomePage.getProductByIndex(i).isDisplayed());
		}

		Thread.sleep(1000);
		actions.moveToElement(buyersHomePage.getProductByIndex(1)).build().perform();
		actions.click(buyersHomePage.getProductByIndex(1)).build().perform();

		Thread.sleep(1000);
		System.out.println("++1");

		driver.switchTo().frame(driver.findElement(By.cssSelector(".fancybox-iframe")));

		Assert.assertTrue(productShoppingActionsPage.getQuantityMinusIcon().isDisplayed());
		Assert.assertTrue(productShoppingActionsPage.getQuantityPlusIcon().isDisplayed());
		Assert.assertTrue(productShoppingActionsPage.getAddToCartButton().isDisplayed());
		Assert.assertTrue(productShoppingActionsPage.getSizeDropDown().isEnabled());

		productShoppingActionsPage.setQuantityTextField(10);
		productShoppingActionsPage.getQuantityPlusIcon().click();
		productShoppingActionsPage.getQuantityMinusIcon().click();

		TestUtil.selectDropDownValue(productShoppingActionsPage.getSizeDropDown(), SelectOption.VISIBLETEXT.toString(),
				"M");
		productShoppingActionsPage.getAddToCartButton().click();
		productShoppingActionsPage.getContinueShoppingButton().click();

		productShoppingActionsPage.getHomeIcon().click();

		cartSummeryPage.getCarTabIcon().click();
		String quantity = cartSummeryPage.getTotalProductQuantityMsg().getText().split("\\s+")[0];
		Assert.assertEquals(quantity, "10");
	}


	@Test(priority = 3)
	public void selectMultiplesClothTest() throws InterruptedException {

		// first product--same item Name---size M
		Assert.assertTrue(buyersHomePage.getDressesBtn().isDisplayed());
		actions.moveToElement(buyersHomePage.getDressesBtn()).build().perform();
		Assert.assertTrue(buyersHomePage.getDressesDropDownCasualDressesBtn().isDisplayed());
		Assert.assertTrue(buyersHomePage.getDressesDropDownEveeningDressesBtn().isDisplayed());
		Assert.assertTrue(buyersHomePage.getDressesDropDownSummerDressesBtn().isDisplayed());
		actions.moveToElement(buyersHomePage.getDressesDropDownSummerDressesBtn()).build().perform();
		buyersHomePage.getDressesDropDownSummerDressesBtn().click();

		// test all products are displayed or not
		for (int i = 1; i <= (buyersHomePage.getDressCount().size() - 1); i++) {
			Assert.assertTrue(buyersHomePage.getProductByIndex(i).isDisplayed());
		}

		Thread.sleep(1000);
		actions.moveToElement(buyersHomePage.getProductByIndex(1)).build().perform();
		actions.click(buyersHomePage.getProductByIndex(1)).build().perform();

		Thread.sleep(1000);

		driver.switchTo().frame(driver.findElement(By.cssSelector(".fancybox-iframe")));

		Assert.assertTrue(productShoppingActionsPage.getQuantityMinusIcon().isDisplayed());
		Assert.assertTrue(productShoppingActionsPage.getQuantityPlusIcon().isDisplayed());
		Assert.assertTrue(productShoppingActionsPage.getAddToCartButton().isDisplayed());
		Assert.assertTrue(productShoppingActionsPage.getSizeDropDown().isEnabled());

		productShoppingActionsPage.setQuantityTextField(10);
		productShoppingActionsPage.getQuantityPlusIcon().click();
		productShoppingActionsPage.getQuantityMinusIcon().click();

		TestUtil.selectDropDownValue(productShoppingActionsPage.getSizeDropDown(), SelectOption.VISIBLETEXT.toString(),
				"M");
		productShoppingActionsPage.getAddToCartButton().click();
		productShoppingActionsPage.getContinueShoppingButton().click();

		// second product
		productShoppingActionsPage.getHomeIcon().click();
		Assert.assertTrue(buyersHomePage.getDressesBtn().isDisplayed());
		actions.moveToElement(buyersHomePage.getDressesBtn()).build().perform();
		Assert.assertTrue(buyersHomePage.getDressesDropDownCasualDressesBtn().isDisplayed());
		Assert.assertTrue(buyersHomePage.getDressesDropDownEveeningDressesBtn().isDisplayed());
		Assert.assertTrue(buyersHomePage.getDressesDropDownSummerDressesBtn().isDisplayed());
		actions.moveToElement(buyersHomePage.getDressesDropDownCasualDressesBtn()).build().perform();
		buyersHomePage.getDressesDropDownCasualDressesBtn().click();
		// test all products are displayed or not
		for (int i = 1; i <= (buyersHomePage.getDressCount().size() - 1); i++) {
			Assert.assertTrue(buyersHomePage.getProductByIndex(i).isDisplayed());
		}

		Thread.sleep(1000);
		actions.moveToElement(buyersHomePage.getProductByIndex(1)).build().perform();
		actions.click(buyersHomePage.getProductByIndex(1)).build().perform();

		Thread.sleep(1000);

		driver.switchTo().frame(driver.findElement(By.cssSelector(".fancybox-iframe")));

		Assert.assertTrue(productShoppingActionsPage.getQuantityMinusIcon().isDisplayed());
		Assert.assertTrue(productShoppingActionsPage.getQuantityPlusIcon().isDisplayed());
		Assert.assertTrue(productShoppingActionsPage.getAddToCartButton().isDisplayed());
		Assert.assertTrue(productShoppingActionsPage.getSizeDropDown().isEnabled());

		productShoppingActionsPage.setQuantityTextField(2);
		productShoppingActionsPage.getQuantityPlusIcon().click();
		productShoppingActionsPage.getQuantityMinusIcon().click();

		TestUtil.selectDropDownValue(productShoppingActionsPage.getSizeDropDown(), SelectOption.VISIBLETEXT.toString(),
				"L");
		productShoppingActionsPage.getAddToCartButton().click();
		productShoppingActionsPage.getContinueShoppingButton().click();

		productShoppingActionsPage.getHomeIcon().click();

		cartSummeryPage.getCarTabIcon().click();
		String quantity = cartSummeryPage.getTotalProductQuantityMsg().getText().split("\\s+")[0];
		Assert.assertEquals(quantity, "12");
	}

	@Test(priority = 4)
	public void checkCartProductQuantityAndTotalTest() throws InterruptedException {

		// first product
		buyersHomePage.getTShirtsBtn().click();

		// test all products are displayed or not
		for (int i = 1; i <= (buyersHomePage.getDressCount().size() - 1); i++) {
			Assert.assertTrue(buyersHomePage.getProductByIndex(i).isDisplayed());
		}
		Thread.sleep(2000);
		actions.moveToElement(buyersHomePage.getProductByIndex(1)).build().perform();
		actions.click(buyersHomePage.getProductByIndex(1)).build().perform();
		driver.switchTo().frame(driver.findElement(By.cssSelector(".fancybox-iframe")));
		productShoppingActionsPage.setQuantityTextField(10);
		TestUtil.selectDropDownValue(productShoppingActionsPage.getSizeDropDown(), SelectOption.VISIBLETEXT.toString(),
				"L");
		productShoppingActionsPage.getAddToCartButton().click();
		productShoppingActionsPage.getContinueShoppingButton().click();

		// second product
		productShoppingActionsPage.getHomeIcon().click();
		Assert.assertTrue(buyersHomePage.getDressesBtn().isDisplayed());
		actions.moveToElement(buyersHomePage.getDressesBtn()).build().perform();
		actions.moveToElement(buyersHomePage.getDressesDropDownSummerDressesBtn()).build().perform();
		buyersHomePage.getDressesDropDownSummerDressesBtn().click();
		Thread.sleep(1000);
		actions.moveToElement(buyersHomePage.getProductByIndex(1)).build().perform();
		actions.click(buyersHomePage.getProductByIndex(1)).build().perform();
		Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(By.cssSelector(".fancybox-iframe")));
		productShoppingActionsPage.setQuantityTextField(10);

		TestUtil.selectDropDownValue(productShoppingActionsPage.getSizeDropDown(), SelectOption.VISIBLETEXT.toString(),
				"M");
		productShoppingActionsPage.getAddToCartButton().click();
		productShoppingActionsPage.getContinueShoppingButton().click();

		productShoppingActionsPage.getHomeIcon().click();
		cartSummeryPage.getCarTabIcon().click();
		String quantity = cartSummeryPage.getTotalProductQuantityMsg().getText().split("\\s+")[0];
		System.out.println("quantity==" + quantity);
		Assert.assertEquals(Integer.parseInt(quantity), 20);

		List<ProductDetails> productList = new ArrayList<ProductDetails>();
		for (int i = 1; i <= cartSummeryPage.getNumberOfProductTypesInCart(); i++) {
			ProductDetails product = new ProductDetails();
			product.setUnitiPrice(cartSummeryPage.getUnitPrice(i));
			product.setQuantity(cartSummeryPage.getQuantity(i));
			productList.add(product);
		}

		double totalPrice = ShoppingUtil.getTotalPrice(productList, Constants.SHIPPING_CHARGE, Constants.TAX);
		System.out.println("+++totalPrice" + totalPrice);
		Assert.assertEquals(String.format("%.1f", totalPrice), String.format("%.1f", cartSummeryPage.getTotalPrice()));

	}

	@Test(priority = 5)
	public void PlaceOrderTest() throws InterruptedException {
		        // first product
				buyersHomePage.getTShirtsBtn().click();

				// test all products are displayed or not
				for (int i = 1; i <= (buyersHomePage.getDressCount().size() - 1); i++) {
					Assert.assertTrue(buyersHomePage.getProductByIndex(i).isDisplayed());
				}
				Thread.sleep(2000);
				actions.moveToElement(buyersHomePage.getProductByIndex(1)).build().perform();
				actions.click(buyersHomePage.getProductByIndex(1)).build().perform();
				driver.switchTo().frame(driver.findElement(By.cssSelector(".fancybox-iframe")));
				productShoppingActionsPage.setQuantityTextField(10);
				TestUtil.selectDropDownValue(productShoppingActionsPage.getSizeDropDown(), SelectOption.VISIBLETEXT.toString(),
						"L");
				productShoppingActionsPage.getAddToCartButton().click();
				productShoppingActionsPage.getContinueShoppingButton().click();

				// second product
				productShoppingActionsPage.getHomeIcon().click();
				Assert.assertTrue(buyersHomePage.getDressesBtn().isDisplayed());
				actions.moveToElement(buyersHomePage.getDressesBtn()).build().perform();
				actions.moveToElement(buyersHomePage.getDressesDropDownSummerDressesBtn()).build().perform();
				buyersHomePage.getDressesDropDownSummerDressesBtn().click();
				Thread.sleep(1000);
				actions.moveToElement(buyersHomePage.getProductByIndex(1)).build().perform();
				actions.click(buyersHomePage.getProductByIndex(1)).build().perform();
				Thread.sleep(1000);
				driver.switchTo().frame(driver.findElement(By.cssSelector(".fancybox-iframe")));
				productShoppingActionsPage.setQuantityTextField(10);

				TestUtil.selectDropDownValue(productShoppingActionsPage.getSizeDropDown(), SelectOption.VISIBLETEXT.toString(),
						"M");
				productShoppingActionsPage.getAddToCartButton().click();
				productShoppingActionsPage.getContinueShoppingButton().click();

				productShoppingActionsPage.getHomeIcon().click();
				cartSummeryPage.getCarTabIcon().click();
				String quantity = cartSummeryPage.getTotalProductQuantityMsg().getText().split("\\s+")[0];
				System.out.println("quantity==" + quantity);
				Assert.assertEquals(Integer.parseInt(quantity), 20);

				List<ProductDetails> productList = new ArrayList<ProductDetails>();
				for (int i = 1; i <= cartSummeryPage.getNumberOfProductTypesInCart(); i++) {
					ProductDetails product = new ProductDetails();
					product.setUnitiPrice(cartSummeryPage.getUnitPrice(i));
					product.setQuantity(cartSummeryPage.getQuantity(i));
					productList.add(product);
				}

				double totalPrice = ShoppingUtil.getTotalPrice(productList, Constants.SHIPPING_CHARGE, Constants.TAX);
				System.out.println("+++totalPrice" + totalPrice);
				Assert.assertEquals(String.format("%.1f", totalPrice), String.format("%.1f", cartSummeryPage.getTotalPrice()));
				
				productShoppingActionsPage.getProceedToCheckOutButton().click();
				shoppingCartAdressesPage.getProceedToCheckoutButton().click();
				shoppingCartShippingPage.getTermsOfServiceCheckBox().click();
				shoppingCartShippingPage.getProceedToCheckoutButton().click();
				shoppingCartPaymentPage.getPaymentMethodPayByBankWireButton().click();
				shoppingCartOrderConfirmPage.getConfirmOrderButton().click();
				
				Assert.assertEquals(String.format("%.1f", totalPrice), String.format("%.1f", shoppingCartOrderConfirmPage.getTotalAmount()));
				
	}
	

	@AfterMethod
	public void tearDown() {
		buyersHomePage.getSignOutButton().click();
		driver.quit();
	}
}
