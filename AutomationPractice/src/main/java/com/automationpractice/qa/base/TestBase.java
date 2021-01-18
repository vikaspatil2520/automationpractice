package com.automationpractice.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.automationpractice.qa.util.Constants;
import com.automationpractice.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	public static Logger log;
	public static EventFiringWebDriver eventFiringWebDriver;
	public static WebEventListener webEventListener;
	
	public TestBase() {
		prop=new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\automationpractice\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	
	}
	
	public static void initialization() {
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("Chrome")) {
			System.out.println("Chrome Browser selected");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();			
		}
		
		eventFiringWebDriver=new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		webEventListener=new WebEventListener();
		eventFiringWebDriver.register(webEventListener);
		driver=eventFiringWebDriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT,TimeUnit.SECONDS);		
		driver.get(prop.getProperty("url"));
	}
}
