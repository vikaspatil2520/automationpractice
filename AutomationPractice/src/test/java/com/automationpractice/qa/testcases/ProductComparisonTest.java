package com.automationpractice.qa.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.model.ProductDetails;
import com.automationpractice.qa.pages.BuyersHomePage;
import com.automationpractice.qa.pages.HomePage;
import com.automationpractice.qa.pages.ProductShoppingActionsPage;
import com.automationpractice.qa.pages.ShoppingCartAdressesPage;
import com.automationpractice.qa.pages.ShoppingCartOrderConfirmPage;
import com.automationpractice.qa.pages.ShoppingCartPaymentPage;
import com.automationpractice.qa.pages.ShoppingCartShippingPage;
import com.automationpractice.qa.pages.ShoppingCartSummeryPage;
import com.automationpractice.qa.pages.SignInPage;

public class ProductComparisonTest extends TestBase {

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

	public ProductComparisonTest() {
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

	@Test
	public void productComparisonTest() throws InterruptedException {
		Integer noOfProductsForCompareCount = 0;
		
		List<ProductDetails> productList=new ArrayList<ProductDetails>();

		// first product
		actions.moveToElement(buyersHomePage.getDressesBtn())
				.moveToElement(buyersHomePage.getDressesDropDownSummerDressesBtn()).build().perform();
		buyersHomePage.getDressesDropDownSummerDressesBtn().click();		
		Thread.sleep(2000);
		ProductDetails product1=new ProductDetails();
		product1.setProductName(buyersHomePage.getProductName(1).getText());
		product1.setUnitiPrice(Double.valueOf(buyersHomePage.getProductPrice(1)));
		productList.add(product1);
		
		actions.moveToElement(buyersHomePage.getProductContainer(2))
				.moveToElement(buyersHomePage.getAddToCompareButton(2)).click().build().perform();
		noOfProductsForCompareCount++;
		driver.navigate().refresh();
		Assert.assertEquals(noOfProductsForCompareCount,
				Integer.valueOf(buyersHomePage.getCompareButtonToatlCompareValue()));

		// second  product
		buyersHomePage.getTShirtsBtn().click();	
		Thread.sleep(2000);
		ProductDetails product2=new ProductDetails();
		product2.setProductName(buyersHomePage.getProductName(1).getText());
		product2.setUnitiPrice(Double.valueOf(buyersHomePage.getProductPrice(1)));
		productList.add(product2);		
		actions.moveToElement(buyersHomePage.getProductContainer(1))
				.moveToElement(buyersHomePage.getAddToCompareButton(1)).click().build().perform();
		noOfProductsForCompareCount++;
		driver.navigate().refresh();
		Assert.assertEquals(noOfProductsForCompareCount,
				Integer.valueOf(buyersHomePage.getCompareButtonToatlCompareValue()));
		
		// third product
		actions.moveToElement(buyersHomePage.getWomenBtn())
				.moveToElement(buyersHomePage.getWomenDropDownBlousesBtn()).build().perform();
		buyersHomePage.getWomenDropDownBlousesBtn().click();		
		Thread.sleep(2000);
		ProductDetails product3=new ProductDetails();
		product3.setProductName(buyersHomePage.getProductName(1).getText());
		product3.setUnitiPrice(Double.valueOf(buyersHomePage.getProductPrice(1)));
		productList.add(product3);
		actions.moveToElement(buyersHomePage.getProductContainer(1))
				.moveToElement(buyersHomePage.getAddToCompareButton(1)).click().build().perform();
		noOfProductsForCompareCount++;
		driver.navigate().refresh();
		Assert.assertEquals(noOfProductsForCompareCount,
				Integer.valueOf(buyersHomePage.getCompareButtonToatlCompareValue()));
		
		//fourth product
		actions.moveToElement(buyersHomePage.getDressesBtn())
		.moveToElement(buyersHomePage.getDressesDropDownCasualDressesBtn()).build().perform();
        buyersHomePage.getDressesDropDownCasualDressesBtn().click();
        Thread.sleep(1000);
        Assert.assertTrue(buyersHomePage.getMoreThanThreeProductsComparisonErrorMsg().isDisplayed());
        buyersHomePage.getMoreThanThreeProductsComparisonErrorMsgCloseButton().click();
        
        //click on compare button
        buyersHomePage.getCompareButton().click();
        
        System.out.println("productList--"+productList);
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		// buyersHomePage.getSignOutButton().click();
		// driver.quit();
	}
}
