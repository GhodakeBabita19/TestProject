package com.pomclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
import com.utility.UtilityClass;

public class LoginPagePom extends BaseClass {
	
	public LoginPagePom(){
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//p[text()='Username : Admin']")
	private WebElement usernameText;

	@FindBy(xpath = "//p[text()='Password : admin123']")
	private WebElement passwordText;

	@FindBy(xpath = "//div/input[@name='username']")
	private WebElement usernameInput;

	@FindBy(xpath = "//div/input[@name='password']")
	private WebElement passwordInput;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;

	@FindBy(xpath = "//div[@class='orangehrm-login-forgot']//child::p")
	private WebElement forgotpassword;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement resetPasswordusernameInput;

	@FindBy(xpath = "//p[text()='Invalid credentials']")
	private WebElement errorMessage;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement resetPasswordsubmitButton;

	@FindBy(xpath = "//h6[text()='Reset Password link sent successfully']")
	private WebElement resetPasswordText;

   
	public String getUsername() {
		String username = UtilityClass.getWebElementText(usernameText);
		return username.substring(11);
	}
	public String getPassword() {
		String password = UtilityClass.getWebElementText(passwordText);
		return password.substring(11);
	}
	public void login(String username,String password) {
		UtilityClass.setText(usernameInput, username);
		UtilityClass.setText(passwordInput, password);
		UtilityClass.webElementClick(submitButton);
	}
	
	
	
}
