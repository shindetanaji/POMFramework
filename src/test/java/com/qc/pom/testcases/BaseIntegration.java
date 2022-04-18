package com.qc.pom.testcases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import com.qc.pom.utils.TestUtils;


public class BaseIntegration {

	TestUtils test = new TestUtils();
	Properties prop;
	WebDriver driver;
	WebElement email, pass, submit, logout, regLink, rName, rEmail, rMobile, rPassword, logLink;
	SoftAssert sa = new SoftAssert();
	String expResult, actResult, name, mobile, email_id, password;

	@BeforeSuite
	public void doSetup() throws IOException {
		prop = test.readPropData();
		if (prop.getProperty("browser").equals("chrome")) {
			System.setProperty(prop.getProperty("webDriverKey"), prop.getProperty("webDriverValue"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		driver.get(prop.getProperty("siteURL"));
	}
	
	@DataProvider
	public Object[][] readLoginData() throws IOException{
		return test.readExcelData("Sheet1");
	}
	
	@DataProvider
	public Object[][] readRegisterData() throws IOException{
		return test.readExcelData("registerSheet");
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
		sa.assertAll();
	}
}
