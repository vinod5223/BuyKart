package com.BuyKart.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageUsersPage {
	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchEdt;
	
	@FindBy(xpath = "//select[@aria-controls='DataTables_Table_0']")
	private WebElement entriesDD;

	public ManageUsersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getEntriesDD() {
		return entriesDD;
	}
	
	
	//Business Libraries
	public String searchUser(WebDriver driver, String email) {
		
		searchEdt.sendKeys(email);
		String emailPresent= driver.findElement(By.xpath("//th[text()='Email ']/ancestor::thead/following-sibling::tbody/descendant::td[text()='"+email+"']")).getText();		
	return emailPresent;	
	}
	
	
}
