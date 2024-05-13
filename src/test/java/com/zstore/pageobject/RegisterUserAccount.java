package com.zstore.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterUserAccount {

	WebDriver ldriver;
	public RegisterUserAccount(WebDriver rdriver) {

		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//input[@data-qa='login-email']
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement userName;

	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;

	//
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement login;

	// //[10]//a[1]
	@FindBy(xpath="//li[10]//a[1]")
	WebElement loginText;

	//*[@id="header"]/div/div/div/div[2]/div/ul/li[4]/a
	//a[normalize-space()='Logout']
	//*[@class='fa fa-lock']
	
	@FindBy(xpath="//*[@class='fa fa-lock']")
	WebElement logOut;

	public void enterUsername(String username) {
		userName.sendKeys(username);

	}
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public String getLoginText() {
		
		String login=loginText.getText();
		System.out.println("Login accont verification text : "+login);
		return login;

	}
	public void clickLogOut() {
		logOut.click();
	}
}
