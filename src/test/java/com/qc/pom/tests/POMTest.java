package com.qc.pom.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qc.pom.pages.DashboardPage;
import com.qc.pom.pages.LoginPage;
import com.qc.pom.pages.RegisterPage;

public class POMTest extends BaseIntegration {

	@Test(dataProvider = "loginData")
	public void doLogin(String testName, String uName, String uPass) {
		LoginPage login = new LoginPage(driver);
		if (testName.equals("Both are valid")) {
			DashboardPage dash = login.doLoginWithValidData(uName, uPass);
			Assert.assertTrue(dash.verifyHomePageTitle());
			dash.doLogout();
		} else {
			login.doLoginWithInValidData(uName, uPass);
			Assert.assertTrue(login.verifyLoginPageTitle());
		}
	}

	@Test(dataProvider = "registerData")
	public void doRegister(String testName, String uName, String uMobile, String uEmail, String uPass) {
		if (driver.getTitle().equals("Queue Codes | Log in")) {
			LoginPage login = new LoginPage(driver);
			login.clickOnRegisterLink();
		}
		RegisterPage register = new RegisterPage(driver);
		register.doRegisterWithData(uName, uMobile, uEmail, uPass);
		if (testName.equals("All are valid")) {
			Assert.assertTrue(register.handleAlert());
		} else {
			Assert.assertTrue(register.verifyRegisterPageTitle());	
		}
	}
}
