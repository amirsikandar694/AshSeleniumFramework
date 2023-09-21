package com.lti.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.lti.base.TestBase;

public class VehicleInsurance extends TestBase {

	@Test
	public void loginHome()
	{
		driver.findElement(By.id(OR.getProperty("motorcylelink"))).click();
		log.debug("Clicked on motorcycle link");
	}
}
