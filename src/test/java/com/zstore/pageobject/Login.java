package com.zstore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
WebDriver ldriver;
	
	public Login(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Signup / Login']")
	WebElement signup;
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement userName;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	WebElement ename;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement email;
	
	@FindBy(xpath="//button[normalize-space()='Signup']")
	WebElement singupClick;
	
	public void clickOnsignup() {
		signup.click();
	}
	
	public void singupName(String name) {
		ename.sendKeys(name);
	}
	
	public void singupEmail(String username) {
		email.sendKeys(username);
	}

	public void clickOnSignup() {
		singupClick.click();
	}



}
