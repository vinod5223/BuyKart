package com.BuyKart.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BuyKart.GenericUtility.JavaUtility;

public class TodaysOrdersPage {
	 
		//declaration
		@FindBy(xpath = "//input[@type='text']")
		private WebElement searchEdt;
		
		@FindBy(xpath = "//select[@aria-controls='DataTables_Table_0']")
		private WebElement entriesDD;

		//initialization
		public TodaysOrdersPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		//Utilization
		public WebElement getSearchEdt() {
			return searchEdt;
		}

		public WebElement getEntriesDD() {
			return entriesDD;
		}
		
		
		
		//Business Libraries
		
		public void searchProduct(WebDriver driver, String ProductName, JavaUtility jLib, String Username) {
			searchEdt.sendKeys(ProductName);
			String date = jLib.getSystemDateInFormat("YYYY-MM-dd hh:mm:ss");
			
			 List<WebElement> actualDate=driver.findElements(By.xpath(" contains(text(),'"+date+"')]"));
			 List<WebElement> usernames = driver.findElements(By.xpath("//tbody/tr/td[contains(text(),'"+Username+"')]"));
			 
			 for(int i=0; i<actualDate.size();i++) {
				 String dateu=actualDate.get(i).getText();
				 if(dateu.equals(date)) {
					 String UN=usernames.get(i).getText();
					 if(UN.equals(Username)) {
						 System.out.println("product ordered");
						 break;
					 }			
					}
			 }
			 
			
			
		}
		public void searchProduct(WebDriver driver, String ProductName, String Username) {
			
			searchEdt.sendKeys(ProductName);
			 List<WebElement> usernames = driver.findElements(By.xpath("//tbody/tr/td[contains(text(),'"+Username+"')]"));

			 for(int i=0; i<usernames.size();i++) {
				 
					 String UN=usernames.get(i).getText();
					 if(UN.contains(Username)) {
						 System.out.println("product ordered");
						 break;
					 }		
					 else {
						 System.out.println("product not ordered");
					 }
					}
			 
			
		}
		
		
}
