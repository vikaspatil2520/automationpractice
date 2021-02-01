package com.automationpractice.qa.util;

import java.util.List;

import com.automationpractice.qa.model.ProductDetails;

public class ShoppingUtil {
	
	public static double getTotalPrice(List<ProductDetails> productList,Double shippingCharges,Double tax) {
		double totalOfSingleProduct=0;
		double totalPrice=0;
		for(ProductDetails product:productList) {
			totalOfSingleProduct=product.getQuantity()*product.getUnitiPrice();
			totalPrice=totalPrice+totalOfSingleProduct;
		}
		totalPrice=totalPrice+shippingCharges+tax;
	
		return totalPrice;
	}
}
