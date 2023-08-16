package com.BuyKart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	//declaration
	@FindBy(xpath = "//img[@src='images/user.png']")
	private WebElement adminIconDdImg;
	@FindBy(xpath = "//a[text()='Change Password']")
	private WebElement changePasswordLink;
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement adminLogoutLink;
	@FindBy(name = "password")
	private WebElement currentPasswordEdt;
	@FindBy(name = "newpassword")
	private WebElement newPasswordEdt;
	@FindBy(name = "confirmpassword")
	private WebElement confirmPasswordEdt;
	@FindBy(name = "submit")
	private WebElement submitBtn;
	@FindBys({@FindBy(xpath = "//a[contains(.,'Order Management')]"), @FindBy(xpath = "//a[@href='#togglePages']")})
	private WebElement orderMgtDropDown;
	
	@FindBy(xpath = "//a[@href='todays-orders.php']")
	private WebElement todaysOrdersLink;
	
	@FindBy(xpath = "//a[@href='pending-orders.php']")
	private WebElement pendingOrdersLink;
	
	@FindBy(xpath = "//a[@href='delivered-orders.php']")
	private WebElement deliveredOrdersLink;
		
	
	@FindBy(xpath = "//a[@href='category.php']")
	private WebElement createCategoryLink;
	
	@FindBy(xpath = "//a[@href='manage-users.php']")
	private WebElement manageUsersLink;

	

	//initialization
	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	//utilization
	public WebElement getTodaysOrdersLink() {
		return todaysOrdersLink;
	}


	public WebElement getPendingOrdersLink() {
		return pendingOrdersLink;
	}

	public WebElement getManageUsersLink() {
		return manageUsersLink;
	}
	

	public WebElement getDeliveredOrdersLink() {
		return deliveredOrdersLink;
	}

	public WebElement getAdminIconDdImg() {
		return adminIconDdImg;
	}


	public WebElement getChangePasswordLink() {
		return changePasswordLink;
	}


	public WebElement getAdminLogoutLink() {
		return adminLogoutLink;
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


	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	
	public WebElement getOrderMgtDropDown() {
		return orderMgtDropDown;
	}


	public WebElement getCreateCategoryLink() {
		return createCategoryLink;
	}
	
	
	
	
	//business libraries
	public void createCategory() {
		createCategoryLink.click();
	}
	
	public void orderManagement() {
		orderMgtDropDown.click();
	}
	
	public void pendingOrdersList() {
		pendingOrdersLink.click();
	}
	
	public void todaysOrdersList() {
		todaysOrdersLink.click();
	}
	public void deliveredOrderList() {
		deliveredOrdersLink.click();
	}
	
	public void manageUsers() {
		manageUsersLink.click();
	}
	public void adminLogout() {
		adminIconDdImg.click();
		adminLogoutLink.click();
	}
}
























