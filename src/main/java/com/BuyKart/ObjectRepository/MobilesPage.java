package com.BuyKart.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BuyKart.GenericUtility.WebDriverUtility;

public class MobilesPage {
	//declaration
	@FindBy(xpath = "//input[@value='1']")
	private WebElement quantity;
	
	@FindBy(xpath = "//a[text()=' ADD TO CART']")
	private WebElement addToCart;
	
	@FindBy(xpath = "//i[@class='fa fa-heart']")
	private WebElement addToWishList;
	
	//initialization
	public MobilesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//utilization
	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}

	public WebElement getAddToWishList() {
		return addToWishList;
	}
	
	//business libraries
	
	public void addProductToCart(WebDriver driver, String ProdName, String  Quantity, WebDriverUtility wLib) {
		driver.findElement(By.xpath("//a[text()='"+ProdName+"']")).click();
		quantity.sendKeys(Quantity);
		addToCart.click();	
		try{
			wLib.acceptAlertPopUp(driver);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void addProductToCart(WebDriver driver, String ProdName, WebDriverUtility wLib) {
		driver.findElement(By.xpath("//a[text()='"+ProdName+"']")).click();
		addToCart.click();	
		try{
			wLib.acceptAlertPopUp(driver);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void addToWishlist( WebDriver driver,  String ProdName) {
		driver.findElement(By.xpath("//a[text()='"+ProdName+"']")).click();
		addToWishList.click();
	}
	
}
