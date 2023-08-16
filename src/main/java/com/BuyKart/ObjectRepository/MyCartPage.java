package com.BuyKart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BuyKart.GenericUtility.WebDriverUtility;

public class MyCartPage {
	
	@FindBy(linkText = "Continue Shopping")
	private WebElement continueShopping;
	
	@FindBy(xpath = "//input[@value='Update shopping cart']")
	private WebElement updateShoppingCart;
	
	@FindBy(name = "ordersubmit")
	private WebElement proceedCheckout;

	public MyCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContinueShopping() {
		return continueShopping;
	}

	public WebElement getUpdateShoppingCart() {
		return updateShoppingCart;
	}

	public WebElement getProductCheckout() {
		return proceedCheckout;
	}
	
	
	//Business Libraries
	public void orderProduct() {
		proceedCheckout.click();
	}
	public void orderProduct(WebDriverUtility wLib, WebDriver driver) {
		updateShoppingCart.click();
		wLib.acceptAlertPopUp(driver);
		proceedCheckout.click();
	}
	
	
	
	
}

//a[text()='Redmi Note 4 (Gold, 32 GB)  (With 3 GB RAM)']/ancestor::tr/td/input