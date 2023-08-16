package com.BuyKart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountHomePage {
	//declaration
	@FindBy(name = "name")
	private WebElement nameEdt;
	@FindBy(id = "exampleInputEmail1")
	private WebElement emailEdt;
	@FindBy(name = "contactno")
	private WebElement contactNoEdt;
	@FindBy(name = "update")
	private WebElement updateBtn;
	@FindBy(xpath = "//a[contains(.,'Change Password')]")
	private WebElement changePasswordBtnCollapse;
	@FindBy(name = "cpass")
	private WebElement currentPasswordEdt;
	@FindBy(id = "newpass")
	private WebElement newPasswordEdt;
	@FindBy(id = "cnfpass")
	private WebElement confirmPasswordEdt;
	@FindBy(xpath = "//button[text()='Change ']")
	private WebElement changeBtn;
	@FindBy(xpath = "(//a[@href='my-account.php'])[2]")
	private WebElement myAccountLink;
	@FindBy(linkText = "Shipping / Billing Address")
	private WebElement shipBillAddressLink;
	@FindBy(linkText = "Order History")
	private WebElement orderHistoryLink;
	@FindBy(linkText = "Payment Pending Order")
	private WebElement paymentPendingOrderLink;
	
	//initialization
	public MyAccountHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getNameEdt() {
		return nameEdt;
	}
	public WebElement getEmailEdt() {
		return emailEdt;
	}
	public WebElement getContactNoEdt() {
		return contactNoEdt;
	}
	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	public WebElement getChangePasswordBtnCollapse() {
		return changePasswordBtnCollapse;
	}
	public WebElement getCurrentPasswordEdt() {
		return currentPasswordEdt;
	}
	public WebElement getNewPasswordEdt() {
		return newPasswordEdt;
	}
	public WebElement getConfirmPasswordEdt() {
		return confirmPasswordEdt;
	}
	public WebElement getChangeBtn() {
		return changeBtn;
	}
	public WebElement getMyAccountLink() {
		return myAccountLink;
	}
	public WebElement getShipBillAddressLink() {
		return shipBillAddressLink;
	}
	public WebElement getOrderHistoryLink() {
		return orderHistoryLink;
	}
	public WebElement getPaymentPendingOrderLink() {
		return paymentPendingOrderLink;
	}
	
	//Business Libraries
	public void shippingBillingAddress() {
		shipBillAddressLink.click();
		
	}
	
	
	
}
