package com.zstore.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.zstore.pageobject.RegisterUserAccount;
import com.zstore.pageobject.indexPage;
import com.zstore.utilities.ReadExcelFile;

import junit.framework.Assert;

public class TC_LoginTestDataDriven extends BaseClass {

	@Test(dataProvider="LoginDataProvider")
	public void loginVerify(String userName, String pasword,  String expectedUsername) throws InterruptedException, IOException {

		indexPage ip=new indexPage(driver);
		Logger.info("*************click for signup*******************");
		ip.clickOnsignup();

		Logger.info("*************Enter Login  details to Verify user account*******************");
		RegisterUserAccount regAcct=new RegisterUserAccount(driver);

		Logger.info("*************Enter Username *******************");
		regAcct.enterUsername(userName);

		Logger.info("*************Enter Password*******************");
		regAcct.enterPassword(pasword);

		Logger.info("*************Click Login Button*******************");
		regAcct.clickLogin();
		Thread.sleep(2000);

		String loginText=regAcct.getLoginText();
		if(loginText.contains(expectedUsername)) {

			Logger.info("*************Verify Login Passed*******************");
			Assert.assertTrue(true);
			Logger.info("*************Click Logout Button*******************");
			regAcct.clickLogOut();
			Thread.sleep(1000);


		}else {

			Logger.info("*************Verify Login Failed*******************");
			captureScreenShot(driver, "LoginTest");
			Assert.assertTrue(false);
			}
		}
		/*
		 * Thread.sleep(2000);
		 * Logger.info("*************Click Logout Button*******************");
		 * regAcct.clickLogOut();
		 */
		@DataProvider(name = "LoginDataProvider")
		public String[][] LoginDataProvider()
		{
			//System.out.println(System.getProperty("user.dir"));
			String fileName = System.getProperty("user.dir") + "\\TestData\\storeTestData.xlsx";


			int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
			int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
		

			String data[][]=new String[ttlRows-1][ttlColumns];

			for(int i=1;i<ttlRows;i++)//rows =1,2
			{
				for(int j=0;j<ttlColumns;j++)//col=0, 1,2
				{

					data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
				}

			}
			return data;
		}

	}