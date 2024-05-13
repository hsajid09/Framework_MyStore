package com.zstore.testcases;


	import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.*;

import com.zstore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;


	public class BaseClass{
		
		
		ReadConfig readconfig= new ReadConfig();
		String url=readconfig.getBaseUrl();
		String browser=readconfig.getBrowser();
		public static WebDriver driver;
		public static Logger Logger;
		
		
		@BeforeClass
		public void setup() {
			
			switch(browser.toLowerCase()) {
			case "chrome":
				
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				break;
				
			case "firefox":
				
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
				break;
				
			case "edge":
				
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				driver.manage().window().maximize();
				break;
				
			default:
				driver=null;
				break;
			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			Logger=LogManager.getLogger("MyzStore");
			driver.get(url);
			Logger.info("************url launched********************");
		
		
		}
		
		@AfterClass
		public void tearDown() {
			
			driver.close();
			driver.quit();
		}
		
		public void captureScreenShot(WebDriver driver, String testName) throws IOException {
			
			TakesScreenshot screenshot= ((TakesScreenshot)driver);
			File src=screenshot.getScreenshotAs(OutputType.FILE);
			File dest=new File(System.getProperty("user.dir") +"\\Screenshots\\" + testName+".png");
			FileUtils.copyFile(src, dest);
			
			
		}
		

}
