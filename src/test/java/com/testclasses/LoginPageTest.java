package com.testclasses;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.pomclasses.LoginPagePom;

public class LoginPageTest extends BaseClass{
	
	@BeforeClass
	
	public void setup() {
		launchWeb();
	}
	@AfterClass
	public void teardown() {}
	
	@Test
	public void pageUrl() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	} 
	
	
	@Test
	public void loginPageTest() {
		LoginPagePom loginPagePom = new LoginPagePom();
		
		Assert.assertEquals(loginPagePom.getUsername(), "Admin");
		Assert.assertEquals(loginPagePom.getPassword(), "admin123");
		
		loginPagePom.login(loginPagePom.getUsername(),loginPagePom.getPassword());
	}

}
