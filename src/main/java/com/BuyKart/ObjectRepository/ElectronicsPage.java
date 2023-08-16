package com.BuyKart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectronicsPage {

	@FindBy(xpath = "//a[contains(.,'Mobiles')]")
	private WebElement mobiles;

	@FindBy(xpath = "//a[@href='sub-category.php?scid=2']")
	private WebElement television;
	

	//initialization
	public ElectronicsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getMobiles() {
		return mobiles;
	}

	public WebElement getTelevision() {
		return television;
	}

	
	//Business Libraries
	public void television(WebDriver driver) {
		television.click();
		
	}
	
	public void mobiles(WebDriver driver) {
		mobiles.click();
	}
	
	
	
}
