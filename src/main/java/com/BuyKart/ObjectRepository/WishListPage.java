package com.BuyKart.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
	
	
	
	public WishListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void WishlistAddedConfirmation(String product, WebDriver driver) {
		List<WebElement> WishListProducts=driver.findElements(By.xpath("//div[@class='product-name']"));
		for(int i=WishListProducts.size()-1; i<WishListProducts.size();i++) {
			String presentProduct=WishListProducts.get(i).getText();
			if(product.equalsIgnoreCase(presentProduct)) {
				System.out.println("Product added");
				break;
			}
		}
	}
}
