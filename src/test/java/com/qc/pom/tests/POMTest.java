package com.qc.pom.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qc.pom.pages.HomePage;
import com.qc.pom.pages.LoginPage;

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

}
