package com.automationpractice.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.qa.base.TestBase;

public class TestPageTest extends TestBase{

	
	public TestPageTest() {
		super();
	}
	
	@Test(priority=1)
	public void successTest() {
		initialization();
		Assert.assertTrue(true);
		driver.quit();
	}
	
	@Test(priority=2)
	public void failTest() {
		initialization();
		Assert.assertTrue(false);
		driver.quit();
	}
}
