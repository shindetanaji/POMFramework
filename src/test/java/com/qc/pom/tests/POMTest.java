package com.qc.pom.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qc.pom.pages.HomePage;
import com.qc.pom.pages.LoginPage;
import com.qc.pom.pages.RegisterPage;

public class POMTest extends BaseIntegration {

	@Test(dataProvider = "loginData")
	public void doLogin(String testName, String uName, String uPass) {
		LoginPage login = new LoginPage(driver);
		if (testName.equals("Both are valid")) {
			HomePage home = login.loginWithValid(uName, uPass);
			Assert.assertTrue(home.verifyHomePageTitle());
			home.doLogout();
		}else {
			login.loginWithInvalid(uName, uPass);
			Assert.assertTrue(login.verifyLoginPageTitle());
		}
	}
	
	@Test(dataProvider = "registerData")
	public void doRegister(String testName, String uName, String uMobile, String uEmail, String uPass) {
		LoginPage login = new LoginPage(driver);
		if(login.verifyLoginPageTitle()) {
			login.clickOnRegPageLink();
		}
		RegisterPage register = new RegisterPage(driver);
		register.register(uName, uMobile, uEmail, uPass);
		if(testName.equals("All are valid")) {
			Assert.assertTrue(register.handleAlert());
		}else {
			Assert.assertTrue(register.verifyRegisterPage());
		}
	}

}
