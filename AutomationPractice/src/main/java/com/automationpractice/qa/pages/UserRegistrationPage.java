package com.automationpractice.qa.pages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.qa.base.TestBase;

public class UserRegistrationPage extends TestBase {

	@FindBy(linkText="Sign in")
	WebElement signInLink;
	
	@FindBy(css="input#email_create")
	WebElement emailAddressInputText;
	
	@FindBy(css="button#SubmitCreate > span")
	WebElement createAccountButton;
	
	@FindBy(css="#create_account_error>ol>li")
	WebElement invlaidEmailAddressErroeMsg;
	
	
	public UserRegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public CreateAccountPage createRegistration(String emailId) {
		signInLink.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// already created account's email id can't accept.So we can create dynamic email id
		emailAddressInputText.sendKeys(getModifiedEmail(emailId));
		createAccountButton.click();
		return new CreateAccountPage();
	}
	
	public String verifyInvalidEmailErrorMsg(String email) {
		signInLink.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		emailAddressInputText.sendKeys(email);
		createAccountButton.click();
		return invlaidEmailAddressErroeMsg.getText();
	}
	
	private String getModifiedEmail(String email) {
		Random random=new Random();
        Integer number=random.nextInt(99);
        String num=number.toString();
        
        String split_first = email.substring(0,email.indexOf("@"));
        String split_second = email.substring(email.indexOf("@")+1);    
        
        return split_first+num+"@"+split_second;
	}
}
