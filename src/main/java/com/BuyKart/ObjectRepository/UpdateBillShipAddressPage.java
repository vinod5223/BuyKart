package com.BuyKart.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.BuyKart.GenericUtility.JavaUtility;
import com.BuyKart.GenericUtility.WebDriverUtility;

public class UpdateBillShipAddressPage {
	//Declaration
	@FindBy(name = "billingaddress")
	private WebElement billingAddressEdt;
	@FindBy(id  = "bilingstate")
	private WebElement billingStateEdt;
	@FindBy(id = "billingcity")
	private WebElement billingCityEdt;
	@FindBy(id = "billingpincode")
	private WebElement billingPinCodeEdt;
	@FindBy(name = "update")
	private WebElement billUpdateBtn;
	@FindBy(xpath = "//a[contains(.,'Shipping Address')]")
	private WebElement shippingAddressAccordion;
	@FindBy(name = "shippingaddress")
	private WebElement ShipAddressEdt;
	@FindBy(id  = "shippingstate")
	private WebElement ShippingStateEdt;
	@FindBy(name = "shippingcity")
	private WebElement shippingCityEdt;
	@FindBy(id = "shippingpincode")
	private WebElement shippingPinCodeEdt;
	@FindBy(name = "shipupdate")
	private WebElement shipUdateBtn;
	
	
	//initialization
	public UpdateBillShipAddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getBillingAddressEdt() {
		return billingAddressEdt;
	}

	public WebElement getBillingStateEdt() {
		return billingStateEdt;
	}

	public WebElement getBillingCityEdt() {
		return billingCityEdt;
	}

	public WebElement getBillingPinCodeEdt() {
		return billingPinCodeEdt;
	}

	public WebElement getBillUpdateBtn() {
		return billUpdateBtn;
	}

	public WebElement getShippingAddressAccordion() {
		return shippingAddressAccordion;
	}

	public WebElement getShipAddressEdt() {
		return ShipAddressEdt;
	}

	public WebElement getShippingStateEdt() {
		return ShippingStateEdt;
	}

	public WebElement getShippingCityEdt() {
		return shippingCityEdt;
	}

	public WebElement getShippingPinCodeEdt() {
		return shippingPinCodeEdt;
	}

	public WebElement getShipUdateBtn() {
		return shipUdateBtn;
	}
	
	//Business Libraries
	public void updateBillingAddress(HashMap<String, String> map, WebDriver driver,  JavaUtility jLib, WebDriverUtility wLib) {
		for(Entry<String, String> set:map.entrySet()) {
			if(set.getKey().equalsIgnoreCase("billingaddress"))
			{
				WebElement ele= driver.findElement(By.name(set.getKey()));	
				ele.clear();
				ele.sendKeys(set.getValue()+jLib.getRandomNo());
			}
			else
			{
				WebElement ele= driver.findElement(By.name(set.getKey()));
				ele.clear();
				ele.sendKeys(set.getValue());
			}
		}
		billUpdateBtn.click();
		wLib.acceptAlertPopUp(driver);
	}
	
	public void shippingAddressAccordion() {
		shippingAddressAccordion.click();
	}
	
	
	public void updateShippingAddress(HashMap<String, String> map, WebDriver driver, JavaUtility jLib, WebDriverUtility wLib) {
		for(Entry<String, String> set:map.entrySet()) {

			if(set.getKey().equalsIgnoreCase("shippingaddress"))
			{
				WebElement ele= driver.findElement(By.name(set.getKey()));	
				ele.clear();
				ele.sendKeys(set.getValue()+jLib.getRandomNo());
			}
			else
			{
				WebElement ele= driver.findElement(By.name(set.getKey()));
				ele.clear();
				ele.sendKeys(set.getValue());
			}
		}
		shipUdateBtn.click();
		wLib.acceptAlertPopUp(driver);
	}
}
