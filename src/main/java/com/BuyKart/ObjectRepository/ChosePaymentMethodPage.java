package com.BuyKart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

public class ChosePaymentMethodPage {
	
	//declaration
	@FindBy(xpath = "//input[@value='COD']")
	private WebElement COD_radioBtn;
	
	@FindBy(xpath = "//input[@value='Internet Banking']")
	private WebElement IB_ratioBtn;
	
	@FindBy(xpath = "//input[@value='Debit / Credit card']")
	private WebElement D_C_Card_radioBtn;
	
	@FindBy(name  = "submit")
	private WebElement submitBtn;

	//initialization
	public ChosePaymentMethodPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCOD_radioBtn() {
		return COD_radioBtn;
	}

	public WebElement getIB_ratioBtn() {
		return IB_ratioBtn;
	}

	public WebElement getD_C_Card_radioBtn() {
		return D_C_Card_radioBtn;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//Business Libraries
	
	public void verifyProductCOD() {
		
String textPresent= COD_radioBtn.getAttribute("value");

	assertEquals(textPresent,"COD", "COD Not verified" );
	System.out.println("COD Verified");
//		if(textPresent.equalsIgnoreCase("COD")) {
//			System.out.println("COD Verified");
//		}
//		else {
//			System.out.println("COD Not verified");
//		}
	}
	
	public void verifyProductIB() {
		
String textPresent= IB_ratioBtn.getAttribute("value");

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(textPresent.contains("gg"), "IB Not verified");
		
//		assertTrue(textPresent.contains("Internet Banking"), "IB Not verified");
		System.out.println("Internet Banking Verified");
		
//		if(textPresent.contains("Internet Banking")) {
//			System.out.println("Internet Banking Verified");
//		}
//		else {
//			System.out.println("IB Not verified");
//		}
		sa.assertAll();
	}
	
	public void verifyProductDC_CC() {
		
String textPresent= D_C_Card_radioBtn.getAttribute("value");
		if(textPresent.contains(" Debit / Credit card")) {
			System.out.println(" Debit / Credit card Verified");
		}
		else {
			System.out.println("DC/CC Not verified");
		}
	}
	
	
	public void buyProductCOD() {
		COD_radioBtn.click();
		submitBtn.click();
	}
	public void buyProductIB() {
		IB_ratioBtn.click();
		submitBtn.click();
	}
	public void buyProductDC_Card() {
		D_C_Card_radioBtn.click();
		submitBtn.click();
	}
	
	
}


