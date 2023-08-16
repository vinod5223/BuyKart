package com.BuyKart.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.*;

import com.BuyKart.GenericUtility.JavaUtility;
import com.BuyKart.GenericUtility.WebDriverUtility;

public class LoginAndSignUpPage {
	
	//declaration
	@FindBy(name="email")
	private  WebElement emailAddressEdt; 
	
	@FindBy(id="exampleInputPassword1")
	private WebElement passwordEdt;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement loginBtn;
	
	@FindBy(name="fullname")
	private WebElement fullNameCreateEdt;
	
	@FindBy(id="email")
	private WebElement emailCreateEdt;
	
	@FindBy(id="contactno")
	private WebElement contactNoEdt;
	
	@FindBy(id="password")
	private WebElement passwordCreateEdt;
	
	@FindBy(name="confirmpassword")
	private WebElement confirmPasswordCreateEdt;
	
	@FindBy(xpath = "//button[text()='Sign Up']")
	private WebElement signUpbtn;
	
	
	//initialization
	public LoginAndSignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getEmailAddressEdt() {
		return emailAddressEdt;
	}

	public WebElement getFullNameCreateEdt() {
		return fullNameCreateEdt;
	}
	public WebElement getEmailCreateEdt() {
		return emailCreateEdt;
	}
	public WebElement getContactNoEdt() {
		return contactNoEdt;
	}
	public WebElement getPasswordCreateEdt() {
		return passwordCreateEdt;
	}
	public WebElement getConfirmPasswordCreateEdt() {
		return confirmPasswordCreateEdt;
	}
	public WebElement getSignUpbtn() {
		return signUpbtn;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}	
	//Business Libraries
	public void Login(String USERNAME, String PASSWORD) {
		getEmailAddressEdt().sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	 
	
	public String signUp(HashMap<String, String> map ,WebDriver driver, JavaUtility jLib, int random, WebDriverUtility wLib) {
		String em=null; 
		String expEmKey="emailid";
		String expPass="password";
		String pass=null;
		
		for(Entry<String, String> set:map.entrySet()) {
			if(set.getKey().equalsIgnoreCase(expEmKey)) {
			em= random+set.getValue();
			driver.findElement(By.name(set.getKey())).sendKeys(em);
			}
			else if(set.getKey().equalsIgnoreCase(expPass)) {
				pass= set.getValue();
				driver.findElement(By.id(set.getKey())).sendKeys(pass);
				}
			else {
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
				 }	
		}
		signUpbtn.click();
		String created=wLib.alertPopGetText(driver);
		
		assertEquals(created, "You are successfully register");
		System.out.println("user signed up successfully");
		wLib.acceptAlertPopUp(driver);
		emailAddressEdt.sendKeys(em);
		passwordEdt.sendKeys(pass);
		loginBtn.click();
		
	
//		if(created.equalsIgnoreCase("You are successfully register")) {
//			System.out.println("user signed up successfully");
//			wLib.acceptAlertPopUp(driver);
//			emailAddressEdt.sendKeys(em);
//			passwordEdt.sendKeys(pass);
//			loginBtn.click();		
//		}
//		else {
//			System.out.println("User not created");
//		}
		
	return em;
	}

}



