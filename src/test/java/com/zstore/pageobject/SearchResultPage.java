package com.zstore.pageobject;

import java.util.List;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	WebDriver ldriver;

	public SearchResultPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//a[normalize-space()='Signup / Login']")
	WebElement signup;

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

	//Ptoduct
	@FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
	WebElement productSelection;

	//i[@class='fa fa-search']

	// search product
	@FindBy(xpath="//input[@id='search_product']")
	WebElement searchProduct;

	//search product click

	@FindBy(xpath="//i[@class='fa fa-search']") 
	WebElement enterSearch;

	@FindBy(xpath="//div[@class='productinfo text-center']//p[contains(text(),'Premium Polo T-Shirts')]")
	WebElement productName;
	
	//view product
	@FindBy(xpath="//div[5]//div[1]//div[1]//div[2]//div[1]//a[1]")
	WebElement ViewProduct;

	//quantity of product

	@FindBy(xpath="//input[@id='quantity'] ")
	WebElement quantityOfProduct;

	//input[@id='quantity']
	

	@FindBy(xpath="//div[@class='modal-content']//div[2]")
	WebElement confirmAddToCart;
	/*
	@FindBy(xpath="//h4[@class='modal-title w-100']")
	WebElement confirmAddToCart;
*/
	@FindBy(xpath="//div[@class='modal-content']//div")
	List<WebElement> contentOfAddLabel;





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
	public void productSelect() {
		productSelection.click();
	}
	public void clickProduct(String product) {
		searchProduct.sendKeys(product);
	}
	public void clickSearch() {
		enterSearch.click();
	}


	public void clickViewProduct() 
	{
		try {

			if (ViewProduct.isDisplayed() && ViewProduct.isEnabled()) {
				ViewProduct.click();
			} else {
				System.out.println("Element is not interactable");
			}
		} catch (ElementNotInteractableException e) {
			System.out.println("Element is not interactable: " + e.getMessage());
		}

	}

	public String getProductText() {
		
		String productText=productName.getText();
		System.out.println("product is selected : "+productText);
		return productText;
	}


	public String getconfirmToAdd() {
		String cart=confirmAddToCart.getText();
		System.out.println("confirm to cart : " +cart);

		return cart;
	}


	public String getcontentLabel() {

		int addtionCount=contentOfAddLabel.size(); 
		System.out.println(addtionCount);
		String cartLabel = " "; 
		for(WebElement label:contentOfAddLabel) {

			cartLabel=label.getText();
			System.out.println(cartLabel);
			//return cartLabel;
		}
		return cartLabel;





	}



}
