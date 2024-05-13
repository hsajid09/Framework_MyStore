package com.zstore.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.zstore.pageobject.RegisterUserAccount;
import com.zstore.pageobject.SearchResultPage;
import com.zstore.pageobject.indexPage;

import junit.framework.Assert;

public class TC_AddProduct extends BaseClass{
	
	@Test
	public void verifySearchProduct() throws InterruptedException, IOException {
		
		String searchKey="T-Shirts";
		String confirmationtoCart="Add";
		indexPage ip=new indexPage(driver);
		SearchResultPage srpage= new SearchResultPage(driver);
		
		
		Logger.info("*************click for signup*******************");
		ip.clickOnsignup();

		Logger.info("************Enter Login  details to Verify user account*****************");
		RegisterUserAccount regAcct=new RegisterUserAccount(driver);

		Logger.info("*************Enter Username *******************");
		regAcct.enterUsername("dave002@yahoo.com");

		Logger.info("*************Enter Password*******************");
		regAcct.enterPassword("Test@1234");

		Logger.info("*************Click Login Button*******************");
		regAcct.clickLogin();
		Thread.sleep(1000);
		
		Logger.info("*************click on product*******************");
		srpage.productSelect();
		Thread.sleep(5000);
		Logger.info("*************enter product ***T-Shirt*******************");
		srpage.clickProduct(searchKey);
		Thread.sleep(2000);
		Logger.info("*************Verify Product if it is T_Shirt*******************");
		
		if(srpage.getProductText().contains(searchKey)) {
			
			Logger.info("*************confirm search product*******************");
			Assert.assertTrue(true);
			Thread.sleep(3000);
		}else {
			
			Logger.info("*************Not confirm search product*******************");
			captureScreenShot(driver, "TC_AddProduct");
			Assert.assertTrue(false);
			Thread.sleep(3000);
		}
			
		
		srpage.clickViewProduct();
		Logger.info("*************add to cart*******************");
		
		
		/*
		  if (srpage.getconfirmToAdd().contains(confirmationtoCart)){
		  Logger.info("*************Verify select product cart*******************");
		  Assert.assertTrue(true); Thread.sleep(3000);
		  
		  }else {
		  
		  Logger.info("*************not Verify select product cart*******************"
		  ); captureScreenShot(driver, "TC_AddProduct"); Assert.assertTrue(false);
		  Thread.sleep(3000); }
		 */
		
		
		  Logger.info("*************contentLabel text*********************");
		  srpage.getcontentLabel();
		  Thread.sleep(3000);
	
		  
	}
}
