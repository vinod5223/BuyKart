package com.BuyKart.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
@FindBy(linkText = "My Account")
private WebElement myAccountLink;

@FindBy(linkText = "Wishlist")
private WebElement wishListLink;

@FindBy(linkText = "My Cart")
private WebElement myCartLink;

@FindBy(xpath = "//a[@href='logout.php']")
private WebElement logoutLink;

@FindBy(xpath="//span[text()='Track Order']")
private WebElement trackOrder;

@FindBy(className = "search-field")
private WebElement searchBarField;

@FindBy(className="search-button")
private WebElement searchButton;

@FindBy(xpath = "//div[@class='basket']")
private WebElement cartIcon;

@FindBy(xpath = "//a[text()='Home']")
private WebElement HomeLink;

//@FindBy(xpath="//a[text()=' Electronics']")
//private WebElement electronicsLink;
//
//@FindBy(xpath = "//a[text()=' Fashion']")
//private WebElement fashionLink;


public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getMyAccountLink() {
	return myAccountLink;
}

public WebElement getWishListLink() {
	return wishListLink;
}

public WebElement getMyCartLink() {
	return myCartLink;
}

public WebElement getLogoutLink() {
	return logoutLink;
}

public WebElement getTrackOrder() {
	return trackOrder;
}

public WebElement getSearchBarField() {
	return searchBarField;
}

public WebElement getSearchButton() {
	return searchButton;
}

public WebElement getCartIcon() {
	return cartIcon;
}

public WebElement getHomeLink() {
	return HomeLink;
}
//
//public WebElement getElectronicsLink() {
//	return electronicsLink;
//}
//
//public WebElement getFashionLink() {
//	return fashionLink;
//}

//Business Libraries

public void home() {
	HomeLink.click();
}

public void myAccount() {
	myAccountLink.click();
}

public void wishList() {
	wishListLink.click();
}
public void myCart() {
	myCartLink.click();
	
}
public void electronics(WebDriver driver) {
	driver.findElement(By.xpath("//div[.=' Categories']/following-sibling::nav/descendant::a[@href='category.php?cid=4']")).click();
}
public void fashion(WebDriver driver)
{
	driver.findElement(By.xpath("//div[.=' Categories']/following-sibling::nav/descendant::a[@href='category.php?cid=14']")).click();
}
public void logout() {
	getLogoutLink().click();
}
}
















