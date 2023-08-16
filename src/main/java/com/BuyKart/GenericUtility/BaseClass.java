package com.BuyKart.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.BuyKart.ObjectRepository.AdminHomePage;
import com.BuyKart.ObjectRepository.AdminLoginPage;

public class BaseClass {
	public DataBaseUtility dLib= new DataBaseUtility();
	public ExcelUtility eLib= new ExcelUtility();
	public FileUtility fLib= new FileUtility();
	public JavaUtility jLib= new JavaUtility();
	public WebDriverUtility wLib= new WebDriverUtility();
	public static WebDriver driver;
	
	
	
	@BeforeSuite(alwaysRun = true)
	public void config_BS() throws Throwable {
		dLib.connecToDB();
		System.out.println("connected to DB");
	}
//	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void config_BC() throws Throwable {
		String BROWSER=fLib.readDataFromPropertiesFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			 driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox")) {
			driver= new FirefoxDriver();
		}
		else
		{
			driver= new EdgeDriver();
		}
		wLib.waitForPageLoad(driver, 10);
		wLib.maximizeWindow(driver);
		System.out.println("Browser Launched Successfully");
	}
	@BeforeMethod(alwaysRun = true)
	public void config_BM() throws Throwable {
		String URL=fLib.readDataFromPropertiesFile("admUrl");
		driver.get(URL);
		AdminLoginPage alp= new AdminLoginPage(driver);
		alp.AdminLogin(fLib);
		System.out.println("Admin Login successful");
	}
	
	@AfterMethod(alwaysRun = true)
	public void config_AM() throws Throwable {
		AdminHomePage ahp= new AdminHomePage(driver);
		ahp.adminLogout();
		System.out.println("logout successful");
	}
	
	@AfterClass(alwaysRun = true)
	public void config_AC() {
		driver.quit();
		System.out.println("Browser closed succesfully");
	}
	@AfterSuite(alwaysRun = true)
	public void config_AS() throws Throwable {
		dLib.closeDB();
		System.out.println("database connection closed");
	}
}
