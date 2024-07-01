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
	
	@FindBy(className = "btn-primary")
	WebElement registerBtn;
	
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
	
	public void clickOnRegister() {
		registerBtn.click();
	}
	
	public void register(String uName, String uMobile, String uEmail, String uPass) {
		enterName(uName);
		enterMobile(uMobile);
		enterEmail(uEmail);
		enterPass(uPass);
		clickOnRegister();
	}
	
	public boolean handleAlert() {
		Alert alt = driver.switchTo().alert();
		String altText = alt.getText();
		alt.accept();
		return altText.equals("User registered successfully.");
	}
	
	public boolean verifyRegisterPage() {
		String actResult = driver.getTitle();
		return actResult.equals("Queue Codes | Registration Page");
	}
}
