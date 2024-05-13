package com.zstore.testcases;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.zstore.pageobject.AccountCreationDetails;
import com.zstore.pageobject.Login;
import com.zstore.pageobject.RegisterUserAccount;
import com.zstore.pageobject.indexPage;

import junit.framework.Assert;

public class TC_MyAccountPageTest extends BaseClass {

	@Test
	public void verifyRegistrationLogin() throws InterruptedException, IOException {
		
		
		indexPage ip=new indexPage(driver);
		Logger.info("*************click for signup*******************");
		ip.clickOnsignup();
		Thread.sleep(1000);
		
		Login login=new Login(driver);
		Logger.info("*************Enter user name*******************");
		login.singupName("Landen Haris");
		Logger.info("*************Enter email address*******************");
		int randomEmail=new Random().nextInt(10000);
		login.singupEmail("dondon"+randomEmail +"@yahoo.com");
		login.clickOnSignup();
		
		Logger.info("*************Enter user details to create user account**********");
		
		AccountCreationDetails acctdetails=new AccountCreationDetails(driver);
		
		acctdetails.selectGender();
		
		Logger.info("*************Enter Password*******************");
		acctdetails.enterpassword("Test@1234");
		
		Logger.info("*************Enter first name*******************");
		acctdetails.enterFname("Landen");
		
		Logger.info("*************Enter last name*******************");
		acctdetails.enterLname("Haris");
		
		Logger.info("*************Enter Address*******************");
		acctdetails.enterAddress(" 5866 120 street");
		
		
		Logger.info("*************Enter Country*******************");
		acctdetails.enterCountry("United States");
	
		Logger.info("*************Enter State*******************");
		acctdetails.enterState("Texas");
		
		
		acctdetails.clickBody();
		Thread.sleep(3000);
		
		Logger.info("*************Enter City*******************");
		acctdetails.enterCity("Dallas");
		 
		
		Logger.info("*************window scroll by *******************");
		
		
		
		Thread.sleep(2000);
		Logger.info("*************Enter Zip code*******************");
		acctdetails.enterZipcode("785422");
		
		
		
		Logger.info("*************Enter Cell number*******************");
		acctdetails.enterMobile("0197523654587");
		
		
		
		Logger.info("*************Click create account Button*******************");
		acctdetails.clickCreateAccount();
		
		
		
		String acctCreatedText=acctdetails.getCreationText();
		if(acctCreatedText.equals("ACCOUNT CREATED!")) {
			
			Logger.info("*************TC_MyAccountPageTest Passed*******************");
			Assert.assertTrue(true);
			
		}else {
			Logger.info("*************TC_MyAccountPageTest Passed*******************");
			captureScreenShot(driver, "MyAccountPage");
			Assert.assertTrue(false);
		}

		acctdetails.clickAccount();
		Thread.sleep(1000);
		
	}

}
