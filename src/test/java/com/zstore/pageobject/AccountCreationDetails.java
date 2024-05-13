package com.zstore.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationDetails {

	WebDriver ldriver;

	public AccountCreationDetails(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	//gender Radio button
	@FindBy(xpath="//label[@for='id_gender1']")
	WebElement gender;

	//password
	@FindBy(xpath="//input[@id='password']")
	WebElement userpass;

	//#first_name
	@FindBy(xpath="//input[@id='first_name']")
	WebElement fname;

	//#last_name
	@FindBy(xpath="//input[@id='last_name']")
	WebElement lname;

	//address #address2
	@FindBy(xpath="//input[@id='address1']")
	WebElement address;

	//country
	@FindBy(xpath="//select[@id='country']")
	WebElement country;

	//state
	@FindBy(xpath="//input[@id='state']")
	WebElement state;
	//city
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	//zipcode
	@FindBy(xpath="//input[@id='zipcode']")
	WebElement zipcode;
	//mobile_number
	@FindBy(xpath="//input[@id='mobile_number']")
	WebElement mobile_number;
	
	
	
	@FindBy(xpath="/html/body")
	WebElement body;

	////button[normalize-space()='Create Account']
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div/div/form/button")
	WebElement createAcct; 
	
	//Account created://*[@id="form"]/div/div/div/div/form/button
	//////b[normalize-space()='Account Created!']

	@FindBy(xpath="//b[normalize-space()='Account Created!']")
	WebElement accountText;
	
	//////
	
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div/div/a")
	WebElement ContButton;
	
	
	public void selectGender() {
		gender.click();
	}

	public void enterpassword(String pass) {
		userpass.sendKeys(pass);
	}

	public void enterFname(String firsrName) {
		fname.sendKeys(firsrName);
	}
	
	public void enterLname(String lastName) {
		lname.sendKeys(lastName);
	}
	public void enterAddress(String add) {
		address.sendKeys(add);
	}

	public void enterCountry(String countryName) {

		Select obj= new Select(country);
		obj.selectByVisibleText(countryName);
	}
	
public void scrollBy() {
		
		JavascriptExecutor jsExecutor= (JavascriptExecutor)ldriver;
		jsExecutor.executeScript("windowscrollto(0, document.body.scrollHeight)");
	}


	public void enterState(String stateName) {
		state.sendKeys(stateName);
	}
	public void enterCity(String cityName) {
		city.sendKeys(cityName);
	}
	public void enterZipcode(String code) {
		zipcode.sendKeys(code);
		
	}
	
	public void clickBody() {
		body.click();
	}
	
	
	public void enterMobile(String mobileNum) {
		mobile_number.sendKeys(mobileNum);
	}
	public void clickCreateAccount() {
		createAcct.click();
	}
	public String getCreationText() {
		String acctText=accountText.getText();
		System.out.println("accont creation text : "+acctText);
		return acctText;
	}
	public void clickAccount() {
		ContButton.click();
	}

	
}