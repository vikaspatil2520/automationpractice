package com.automationpractice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.enums.SelectOption;
import com.automationpractice.qa.util.TestUtil;

public class CreateAccountPage extends TestBase {

	@FindBy(css = "input#id_gender1")
	WebElement radioMr;

	@FindBy(css = "input#id_gender2")
	WebElement radioMrs;

	@FindBy(css = "input#customer_firstname")
	WebElement firstNameElement;

	@FindBy(css = "input[id=customer_lastname]")
	WebElement lastNameElement;

	@FindBy(css = "input[id=email]")
	WebElement emailElement;

	@FindBy(css = "input[id=passwd]")
	WebElement passwordElement;

	@FindBy(css = "input[id=firstname]")
	WebElement addFirstNameElement;

	@FindBy(css = "input[id=lastname]")
	WebElement addLastNameElement;

	@FindBy(css = "input[id=company]")
	WebElement companyElement;

	@FindBy(css = "input[id=address1]")
	WebElement addressElement;

	@FindBy(css = "input[id=city]")
	WebElement cityElement;

	@FindBy(css = "select[id=id_state]")
	WebElement stateElement;

	@FindBy(css = "input[name=postcode]")
	WebElement zipCodeElement;

	@FindBy(css = "select[name=id_country]")
	WebElement countryElement;

	@FindBy(css = "input[id=phone_mobile]")
	WebElement mobilePhoneElement;

	@FindBy(css = "input[id=alias]")
	WebElement aliasAddresElement;

	@FindBy(css = "#submitAccount > span")
	WebElement registerBtn;

	@FindBy(css = "#center_column>div>p")
	WebElement mandatoryFieldErrorMsg;

	public CreateAccountPage() {
		PageFactory.initElements(driver, this);
	}

	public AccountCreationSucessPage createAccount(String title, String firstName, String lastName, String email,
			String password, String dob, String company, String address, String city, String state, String zipCode,
			String country, String mobile, String assigneeAddress) {

		if (title.equalsIgnoreCase("Mr.")) {
			radioMr.click();
		} else if (title.equalsIgnoreCase("Mrs.")) {
			radioMrs.click();
		}
		firstNameElement.sendKeys(firstName);
		lastNameElement.sendKeys(lastName);

		passwordElement.sendKeys(password);

		addFirstNameElement.clear();
		addFirstNameElement.sendKeys(firstName);
		addLastNameElement.clear();
		addLastNameElement.sendKeys(lastName);
		companyElement.sendKeys(company);
		addressElement.sendKeys(address);
		cityElement.sendKeys(city);

		TestUtil.selectDropDownValue(stateElement, SelectOption.VISIBLETEXT.toString(), state);

		zipCodeElement.sendKeys(zipCode);
		mobilePhoneElement.sendKeys(mobile);
		aliasAddresElement.clear();
		aliasAddresElement.sendKeys(assigneeAddress);
		registerBtn.click();
		return new AccountCreationSucessPage();
	}

	public String getErrorMsgForMandatoryFields() {
		registerBtn.click();
		return mandatoryFieldErrorMsg.getText();
	}
}
