package com.qc.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "hlogout")
	WebElement logoutBtn;
	
	public boolean verifyHomePageTitle() {
		String actResult = driver.getTitle();
		return actResult.equals("Queue Codes | Dashboard");
	}
	
	public void doLogout() {
		logoutBtn.click();
	}
	
}
