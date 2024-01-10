package com.qc.pom.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.qc.pom.utils.TestUtils;

public class BaseIntegration {

	WebDriver driver;
	TestUtils test = new TestUtils();
	Properties prop;
	
	@BeforeSuite
	public void doSetup() throws IOException {
		prop = test.readProp();
		if(prop.getProperty("browser").equals("chrome")) {
			driver = new ChromeDriver();
		}else if(prop.getProperty("browser").equals("edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("siteURL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@DataProvider
	public Object[][] loginData() throws IOException{
		return test.readExcelData("Sheet1"); 
	}
	
	@DataProvider
	public Object[][] registerData() throws IOException{
		return test.readExcelData("Sheet2");
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
