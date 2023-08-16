package practice;

import java.sql.Connection;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.BuyKart.GenericUtility.DataBaseUtility;
import com.BuyKart.GenericUtility.ExcelUtility;
import com.BuyKart.GenericUtility.FileUtility;
import com.BuyKart.GenericUtility.JavaUtility;
import com.BuyKart.GenericUtility.WebDriverUtility;
import com.BuyKart.ObjectRepository.AdminHomePage;
import com.BuyKart.ObjectRepository.AdminLoginPage;

public class BaseClassDemo {

	DataBaseUtility dLib= new DataBaseUtility();
	ExcelUtility eLib= new ExcelUtility();
	FileUtility fLib= new FileUtility();
	JavaUtility jLib= new JavaUtility();
	WebDriverUtility wLib= new WebDriverUtility();
	Connection con;
	WebDriver driver;
	
	
	@BeforeSuite
	public void config_BS() throws Throwable {
		dLib.connecToDB();
		System.out.println("connected to DB");
	}
	@BeforeClass
	public void config_BC() throws Throwable {
		String BROWSER=fLib.readDataFromPropertiesFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			 driver= new ChromeDriver();
		}
		else {
			driver= new FirefoxDriver();
		}
		System.out.println("Browser Launched Successfully");
	}
	@BeforeMethod
	public void config_BM() throws Throwable {
		String URL=fLib.readDataFromPropertiesFile("admUrl");
		driver.get(URL);
		AdminLoginPage alp= new AdminLoginPage(driver);
		alp.AdminLogin(fLib);
		System.out.println("Admin Login successful");
	}
	
	@AfterMethod
	public void config_AM() {
		AdminHomePage ahp= new AdminHomePage(driver);
		ahp.adminLogout();
		System.out.println("logout successful");
	}
	
	@AfterClass
	public void config_AC() {
		driver.quit();
		System.out.println("Browser closed succesfully");
	}
	@AfterSuite
	public void config_AS() throws SQLException {
		con.close();
		System.out.println("database connection closed");
	}
	
}

























