package com.automationpractice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.qa.base.TestBase;

public class AccountCreationSucessPage extends TestBase {
	
	@FindBy(css="p[class=info-account]")
	WebElement accountCreationSucessMsgElement;
	
	public AccountCreationSucessPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getAccountCreationSucessMsg() {
		return accountCreationSucessMsgElement.getText();
	}
}
