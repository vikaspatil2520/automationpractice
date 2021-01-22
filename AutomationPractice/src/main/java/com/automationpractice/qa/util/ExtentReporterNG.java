package com.automationpractice.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.automationpractice.qa.base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNG extends TestBase implements IReporter {
	private ExtentReports extentReport;
	

	
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		
		
		extentReport = new ExtentReports(outputDirectory + File.separator + "Extent.html", true);
		
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}

		extentReport.flush();
		extentReport.close();
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) {
		
	   ExtentTest extentTest;
		
		if (tests.size() > 0) {
			
			for (ITestResult testResult : tests.getAllResults()) {
				extentTest = extentReport.startTest(testResult.getMethod().getMethodName());
				
				extentTest.setStartedTime(getTime(testResult.getStartMillis()));
				extentTest.setEndedTime(getTime(testResult.getEndMillis()));
				
				for (String group : testResult.getMethod().getGroups())
					extentTest.assignCategory(group);
				
				if (testResult.getStatus() == ITestResult.FAILURE) {					
					extentTest.log(LogStatus.FAIL, "TEST CASE IS FAILED: " + testResult.getName());  //to add name in extent report
					extentTest.log(LogStatus.FAIL, "TEST CASE FAIL RESON: " + testResult.getThrowable()); //to add error/exception in extent report
					String screenshotPath;
					try {
						screenshotPath = TestUtil.getScreenshot(driver, testResult.getName());
						extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); 
					} catch (IOException e) {
						e.printStackTrace();
					}
					 //to add screenshot in extent report
					//extentenTest.log(LogStatus.FAIL, extentenTest.addScreencast(screenshotPath));//to add screencast/video in extent report
				}else if (testResult.getStatus() == ITestResult.SKIP) {
					extentTest.log(LogStatus.SKIP, "TEST CASE IS SKIP: " + testResult.getName());
				} else if (testResult.getStatus() == ITestResult.SUCCESS) {
					extentTest.log(LogStatus.PASS, "TEST CASE IS PASS: " + testResult.getName());
				}
				extentReport.endTest(extentTest); //ending test and ends the current test and prepare to create html report				
			}
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}