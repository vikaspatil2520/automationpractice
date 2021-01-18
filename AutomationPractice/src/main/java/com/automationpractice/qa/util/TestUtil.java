package com.automationpractice.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.automationpractice.qa.base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestUtil extends TestBase{
	
	public static ExtentReports extentReports;
	public static ExtentTest extentenTest;

	
	public static void takeScreenshotAtEndOfTest() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

		try {
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {			
			e.printStackTrace();
		}
	
	}
	
	public static String getScreenshot(WebDriver driver, String screeshotName) throws IOException {
		String date = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourecFile = screenshot.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedScreenshots/" + screeshotName + date + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(sourecFile, finalDestination);
		return destination;
	}
	
	public static void setExtentReprot() {
		
	}
	
	public static void testResultReportWrite(ITestResult testResult) {
		
		
	}
}
