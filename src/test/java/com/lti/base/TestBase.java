package com.lti.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.lti.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties OR=new Properties();
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger("devpinoyLogger");
	public ExtentReports reo=ExtentManager.getInstance();
	public static ExtentTest test;
	
	@BeforeTest
	public void setup() throws IOException
	{
		if (driver==null)
		{
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			config.load(fis);
			
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);
			
			if(config.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				driver= new ChromeDriver();
				log.debug("Chrome Driver Initiated");
			}
			else if(config.getProperty("browser").equalsIgnoreCase("firefox"))
			{
				driver=new FirefoxDriver();
				log.debug("firefox Driver Initiated");
			}
			
			driver.get(config.getProperty("testurl"));
			driver.manage().window().maximize();
			log.debug("browser invoked");
		}
		
	}
	
	@AfterTest
	public void teardown()
	{
		if(driver!=null)
		{
		driver.quit();
		driver=null;
		}
		
	}

}
