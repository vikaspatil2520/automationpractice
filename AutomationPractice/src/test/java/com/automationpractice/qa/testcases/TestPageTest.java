package com.automationpractice.qa.testcases;

import org.testng.annotations.Test;

import com.automationpractice.qa.base.TestBase;

public class TestPageTest extends TestBase{

	public TestPageTest() {
		super();
	}
	
	@Test
	public void propFileTest() {
		initialization();
		driver.quit();
	}
}
