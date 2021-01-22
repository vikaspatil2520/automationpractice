package com.automationpractice.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.pages.AccountCreationSucessPage;
import com.automationpractice.qa.pages.CreateAccountPage;
import com.automationpractice.qa.pages.UserRegistrationPage;
import com.automationpractice.qa.util.Constants;
import com.automationpractice.qa.util.Message;
import com.automationpractice.qa.util.TestUtil;
//using PageFactory method
public class CreateAccountPageTest extends TestBase {
	CreateAccountPage createAccountPage;
	UserRegistrationPage userRegistrationPage;
	AccountCreationSucessPage accountCreationSucessPage;

	String sheetName = "CreateAccount";

	public CreateAccountPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		userRegistrationPage = new UserRegistrationPage();
	}

	@DataProvider
	public Object[][] getAutoPracticeTestData() {
		Object[][] testData = TestUtil.getTestData(sheetName);
		return testData;
	}

	@Test(priority = 1, dataProvider = "getAutoPracticeTestData")
	public void createAccountTest(String title, String firstName, String lastName, String email, String password,
			String dob, String company, String address, String city, String state, String zipCode, String country,
			String mobile, String assigneeAddress) {

		createAccountPage = userRegistrationPage.createRegistration(email);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		accountCreationSucessPage = createAccountPage.createAccount(title, firstName, lastName, email, password, dob,
				company, address, city, state, zipCode, country, mobile, assigneeAddress);
		Assert.assertEquals(accountCreationSucessPage.getAccountCreationSucessMsg().trim(),
				Message.accountCreationSucessMeaage);
	}

	@Test(priority = 2)
	public void invalidEmailErrorMsgTest() {
		String emailErrorMsg = userRegistrationPage.verifyInvalidEmailErrorMsg(Constants.INVALID_EMAIL_ID);
		Assert.assertEquals(emailErrorMsg.trim(), Message.InvalidEmailErrorMsg);
	}

	@Test(priority = 3, dataProvider = "getAutoPracticeTestData")
	public void verifyErrorMsgForMandatoryFields(String title, String firstName, String lastName, String email,
			String password, String dob, String company, String address, String city, String state, String zipCode,
			String country, String mobile, String assigneeAddress) {
		createAccountPage = userRegistrationPage.createRegistration(email);
		Assert.assertEquals(createAccountPage.getErrorMsgForMandatoryFields(),
				Message.accountCreationMandatoryFieldsErrorMsg);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
