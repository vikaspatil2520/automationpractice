package com.automationpractice.qa.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.BuyersHomePage;
import com.automationpractice.qa.pages.HomePage;
import com.automationpractice.qa.pages.MyAccountHomePage;
import com.automationpractice.qa.pages.MyWishListsPage;
import com.automationpractice.qa.pages.ProductShoppingActionsPage;
import com.automationpractice.qa.pages.ShoppingCartAdressesPage;
import com.automationpractice.qa.pages.ShoppingCartOrderConfirmPage;
import com.automationpractice.qa.pages.ShoppingCartPaymentPage;
import com.automationpractice.qa.pages.ShoppingCartShippingPage;
import com.automationpractice.qa.pages.ShoppingCartSummeryPage;
import com.automationpractice.qa.pages.SignInPage;

public class WishListFunctionalityTest extends TestBase {
	
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
	MyAccountHomePage myAccountHomePage;
	MyWishListsPage myWishListsPage;
	
	public WishListFunctionalityTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		login();
		
		homePage=new HomePage(driver);
		buyersHomePage = new BuyersHomePage(driver);
		cartSummeryPage = new ShoppingCartSummeryPage(driver);
		productShoppingActionsPage = new ProductShoppingActionsPage(driver);
		shoppingCartAdressesPage=new ShoppingCartAdressesPage(driver);
		shoppingCartShippingPage=new ShoppingCartShippingPage(driver);
		shoppingCartPaymentPage=new ShoppingCartPaymentPage(driver);
		shoppingCartOrderConfirmPage=new ShoppingCartOrderConfirmPage(driver);
		myAccountHomePage=new MyAccountHomePage(driver);
		myWishListsPage=new MyWishListsPage(driver);
		actions = new Actions(driver);
	}
	
	@Test
	public void wishListTest() throws InterruptedException {
		
		List<String> productList=new ArrayList<>();
		
		// first product
		buyersHomePage.getTShirtsBtn().click();

		// test all products are displayed or not
		for (int i = 1; i <= (buyersHomePage.getDressCount().size() - 1); i++) {
			Assert.assertTrue(buyersHomePage.getProductByIndex(i).isDisplayed());
		}
		Thread.sleep(2000);	
		productList.add(buyersHomePage.getProductName(1).getText());
		System.out.println("Product--"+buyersHomePage.getProductName(1).getText());		
		actions.moveToElement(buyersHomePage.getProductContainer(1)).moveToElement(buyersHomePage.getAddToWishListButton(1)).click().build().perform();
		Thread.sleep(2000);
		Assert.assertTrue(buyersHomePage.getAddToWishListOverlay().isDisplayed());
		buyersHomePage.getAddToWishListOverlayCloseIcon().click();
		Thread.sleep(2000);
		
		
		// second product
		productShoppingActionsPage.getHomeIcon().click();
		Assert.assertTrue(buyersHomePage.getDressesBtn().isDisplayed());
		actions.moveToElement(buyersHomePage.getDressesBtn()).build().perform();
		actions.moveToElement(buyersHomePage.getDressesDropDownSummerDressesBtn()).build().perform();
		buyersHomePage.getDressesDropDownSummerDressesBtn().click();
		
		Thread.sleep(2000);
		productList.add(buyersHomePage.getProductName(2).getText());
		System.out.println("Product--"+buyersHomePage.getProductName(2).getText());
		actions.moveToElement(buyersHomePage.getProductContainer(2)).moveToElement(buyersHomePage.getAddToWishListButton(2)).click().build().perform();
		Thread.sleep(2000);
		Assert.assertTrue(buyersHomePage.getAddToWishListOverlay().isDisplayed());
		buyersHomePage.getAddToWishListOverlayCloseIcon().click();
		Thread.sleep(2000);
		
		System.out.println("++"+productList);
		
		Thread.sleep(2000);
		homePage.getMyAccountLink().click();
		Thread.sleep(2000);
		
		myAccountHomePage.getMyWishList().click();
		Thread.sleep(2000);
		System.out.println("WishList page------------");
		System.out.println("wishlistpage:"+myWishListsPage.getWishListName().getText());
		System.out.println("quantity:"+myWishListsPage.getQuantity().getText());
		myWishListsPage.getDirectLink().click();
		Thread.sleep(2000);
		List<String> wishListProducts=new ArrayList<>();
		List<WebElement> wishListProductNames = myWishListsPage.getWishListProductNames();
		for(WebElement element:wishListProductNames) {
			wishListProducts.add(element.getText());
		}		
		System.out.println("wishListProducts--"+wishListProducts);
		Assert.assertEquals(productList, wishListProducts);
		myWishListsPage.getDeleteIcon().click();
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		alert.accept();
		System.out.println("Alert accepted");
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		buyersHomePage.getSignOutButton().click();
		driver.quit();
	}
}
