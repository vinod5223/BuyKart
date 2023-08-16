package com.BuyKart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BuyKart.GenericUtility.FileUtility;

public class AdminLoginPage {
	
	@FindBy(id = "inputEmail")
	private WebElement usernameEdt;
	@FindBy(id = "inputPassword")
	private WebElement passwordEdt;
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginBtn;
	
	
	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getUsernameEdt() {
		return usernameEdt;
	}


	public WebElement getPasswordEdt() {
		return passwordEdt;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void AdminLogin(FileUtility fLib) throws Exception {
		usernameEdt.sendKeys(fLib.readDataFromPropertiesFile("admUsername"));
		passwordEdt.sendKeys(fLib.readDataFromPropertiesFile("admPassword"));
		loginBtn.click();
	}
	
	
	
	
	
}
