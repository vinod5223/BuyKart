package com.BuyKart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveredOrdersPage {
	
	//declaration
	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchEdt;
	
	@FindBy(xpath = "//select[@aria-controls='DataTables_Table_0']")
	private WebElement entriesDD;

	//initialization
	public DeliveredOrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getEntriesDD() {
		return entriesDD;
	}
	
	//business libraries
	public void searchProduct(String ProductName) {
		searchEdt.sendKeys(ProductName);
		
	}
	
	
}
