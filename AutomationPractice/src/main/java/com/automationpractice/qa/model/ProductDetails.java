package com.automationpractice.qa.model;

public class ProductDetails {
	
	private String productUrl;
	private String productDescription;
	private String availability;
	private Double unitiPrice;
	private Integer quantity;
	private Double TotalOfSingleProduct;

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Double getUnitiPrice() {
		return unitiPrice;
	}

	public void setUnitiPrice(Double unitiPrice) {
		this.unitiPrice = unitiPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalOfSingleProduct() {
		return TotalOfSingleProduct;
	}

	public void setTotalOfSingleProduct(Double totalOfSingleProduct) {
		TotalOfSingleProduct = totalOfSingleProduct;
	}

}
