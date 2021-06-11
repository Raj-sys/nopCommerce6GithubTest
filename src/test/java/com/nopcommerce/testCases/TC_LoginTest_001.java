package com.nopcommerce.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);
			
		LoginPage lp = new LoginPage(driver);
		driver.findElement(By.id("Email")).clear();
		lp.setUserName(username);
		logger.info("User provided"); //logger msg
		
		driver.findElement(By.id("Password")).clear();
		lp.setPassword(password);
		logger.info("Password provided");//logger msg
		
		lp.clickLogin();
		logger.info("Login in Clicked");//logger msg
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			Thread.sleep(5000);
			lp.clickLogout();
			Assert.assertTrue(true);
			logger.info("Login Passed");//logger msg
			
		} else {
			captureScreen(driver,"loginTest");
			logger.info("Login Failed");//logger msg
			Assert.assertTrue(false);
			
			
		}

	}

	
}
