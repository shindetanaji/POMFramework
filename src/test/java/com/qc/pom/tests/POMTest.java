package com.qc.pom.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qc.pom.pages.DashboardPage;
import com.qc.pom.pages.LoginPage;

public class POMTest extends BaseIntegration {

	@Test(dataProvider = "loginData")
	public void doLogin(String testName, String uName, String uPass) {
		LoginPage login = new LoginPage(driver);
		if (testName.equals("Both are valid")) {
			DashboardPage dash = login.doLoginWithValidData(uName, uPass);
			Assert.assertTrue(dash.verifyHomePageTitle());
			dash.doLogout();
		}else {
			login.doLoginWithInValidData(uName, uPass);
			Assert.assertTrue(login.verifyLoginPageTitle());
		}
	}
}
