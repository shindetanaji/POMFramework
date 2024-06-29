package com.qc.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "password")
	WebElement pass;
	
	@FindBy(id = "submit")
	WebElement signin;
	
	public void enterEmail(String uName) {
		email.clear();
		email.sendKeys(uName);
	}
	
	public void enterPass(String uPass) {
		pass.clear();
		pass.sendKeys(uPass);
	}
	
	public void clickOnSubmit() {
		signin.click();
	}
	
	public HomePage loginWithValid(String uName, String uPass) {
		enterEmail(uName);
		enterPass(uPass);
		clickOnSubmit();
		return new HomePage(driver);
	}
	
	public void loginWithInvalid(String uName, String uPass) {
		enterEmail(uName);
		enterPass(uPass);
		clickOnSubmit();
	}
	
	public boolean verifyLoginPageTitle() {
		String actResult = driver.getTitle();
		return actResult.equals("Queue Codes | Log in");
	}
}
