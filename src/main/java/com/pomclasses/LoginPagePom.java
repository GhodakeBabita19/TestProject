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
	private WebElement resetUsernameInput;

	@FindBy(xpath = "//p[text()='Invalid credentials']")
	private WebElement errorMessage;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement resetPasswordButton;

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
	public String getUnvalidUsername() {
		String unvalidUsername = UtilityClass.getWebElementText(usernameText);
		return unvalidUsername.substring(0,8);
	}
	public String getUnvalidPassword() {
		String unvalidPassword = UtilityClass.getWebElementText(passwordText);
		return unvalidPassword.substring(0,8);
	}
	public void unvalidLogin(String unvalidUsername, String unvalidPassword) {
		UtilityClass.setText(usernameInput, unvalidUsername);
		UtilityClass.setText(passwordInput, unvalidPassword);
		UtilityClass.webElementClick(submitButton);
	
	}
	public String getErrorMessage() {
	String message = UtilityClass.getWebElementText(errorMessage);
		return message;
	}
	
	public void forgotPasswordFun(String username) {
		
		UtilityClass.webElementClick(forgotpassword);
		UtilityClass.setText(resetUsernameInput,username);
		UtilityClass.webElementClick(resetPasswordButton);
		
	}
	public String getResetMessage() {
		String resetMessage =UtilityClass.getWebElementText(resetPasswordText);
		return resetMessage;
	}
		
	
	
	
	
}
