package com.BuyKart.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.*;

import com.BuyKart.GenericUtility.ExcelUtility;
import com.BuyKart.GenericUtility.JavaUtility;

public class CreateCategoryHomePage {
	
	@FindBy(name = "category")
	private WebElement categoryNameEdt;
	@FindBy(name = "description")
	private WebElement descriptionEdt;
	@FindBy(name ="submit")
	private WebElement submitBtn;
	@FindBy(xpath = "//select[@name='DataTables_Table_0_length']")
	private WebElement showEntriesDD;
	@FindBy(xpath = "//input[@type='text' and @aria-controls='DataTables_Table_0']")
	private WebElement searchEdt;
	
	public CreateCategoryHomePage(WebDriver driver ) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCategoryNameEdt() {
		return categoryNameEdt;
	}

	public WebElement getDescriptionEdt() {
		return descriptionEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getShowEntriesDD() {
		return showEntriesDD;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}
	
	public void createCategory(ExcelUtility eLib, JavaUtility jLib, WebDriver driver, String SheetName, int categoryRowNum, int categoryColNum, int descRowNum, int descColNum) throws Exception {
		
		String CategoryName=eLib.getDataFromExcel(SheetName, categoryRowNum, categoryColNum)+jLib.getRandomNo();
		String description= eLib.getDataFromExcel(SheetName, descRowNum, descColNum);
		
		categoryNameEdt.sendKeys(CategoryName);
		descriptionEdt.sendKeys(description);
		submitBtn.click();
		String succesMsg=driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		if(succesMsg.contains("Well done! Category Created !!")) {
			searchEdt.sendKeys(CategoryName);
			String storedValue=driver.findElement(By.xpath("//tbody[@aria-live='polite']/descendant::td[text()='"+CategoryName+"']")).getText();
			assertEquals(storedValue,CategoryName, "Category not created" );
			System.out.println("Category created successfully");	
		}
		
		
//		if(succesMsg.contains("Category Created")) {
//			searchEdt.sendKeys(CategoryName);
//			String storedValue=driver.findElement(By.xpath("//tbody[@aria-live='polite']/descendant::td[text()='"+CategoryName+"']")).getText();
//			if(storedValue.equals(CategoryName)) {
//				System.out.println("Category created successfully");
//			}
//			else
//				System.out.println("Category not created");
		 
	}

}
