package com.qc.pom.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "name")
	WebElement rName;
	
	@FindBy(id = "mobile")
	WebElement rMobile;
	
	@FindBy(id = "email")
	WebElement rEmail;
	
	@FindBy(id = "password")
	WebElement rPass;
	
	@FindBy(className = "btn-flat")
	WebElement rSubmitBtn;
	
	public void enterName(String uName) {
		rName.clear();
		rName.sendKeys(uName);
	}
	
	public void enterMobile(String uMobile) {
		rMobile.clear();
		rMobile.sendKeys(uMobile);
	}
	
	public void enterEmail(String uEmail) {
		rEmail.clear();
		rEmail.sendKeys(uEmail);
	}
	
	public void enterPass(String uPass) {
		rPass.clear();
		rPass.sendKeys(uPass);
	}
	
	public void clickOnSubmit() {
		rSubmitBtn.click();
	}
	
	public boolean handleAlert() {
		Alert alt = driver.switchTo().alert();
		String actResult = alt.getText();
		alt.accept();
		return actResult.equals("User registered successfully.");
	}
	
	public boolean verifyRegisterPageTitle() {
		String actResult = driver.getTitle();
		String expResult = "Queue Codes | Registration Page";
		return actResult.equals(expResult); 
	}
	
	public void doRegisterWithData(String uName, String uMobile, String uEmail, String uPass) {
		enterName(uName);
		enterMobile(uMobile);
		enterEmail(uEmail);
		enterPass(uPass);
		clickOnSubmit();
	}
}
