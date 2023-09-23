package com.lti.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lti.base.TestBase;

public class VehicleInsurance extends TestBase {

	@Test
	public void loginHome() throws InterruptedException
	{
		driver.findElement(By.id(OR.getProperty("motorcylelink"))).click();
		log.debug("Clicked on motorcycle link");
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Enter Vehicle Data");
		Thread.sleep(3000);
		String insuranceType=driver.findElement(By.id(OR.getProperty("insuranceType"))).getText();
		Assert.assertEquals(insuranceType, "Motorcycle Insurance");
		Assert.assertTrue(driver.findElement(By.id(OR.getProperty("insuranceType"))).isDisplayed());
		
	}
}
