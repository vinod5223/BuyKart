package user_Module;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.BuyKart.GenericUtility.ExcelUtility;
import com.BuyKart.GenericUtility.FileUtility;
import com.BuyKart.GenericUtility.JavaUtility;
import com.BuyKart.GenericUtility.WebDriverUtility;
import com.BuyKart.ObjectRepository.HomePage;
import com.BuyKart.ObjectRepository.LoginAndSignUpPage;
import com.BuyKart.ObjectRepository.MyAccountHomePage;
import com.BuyKart.ObjectRepository.UpdateBillShipAddressPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateBillingAndShipping_POM {

	public static void main(String[] args) throws Exception {
		WebDriverUtility wLib= new WebDriverUtility();
		FileUtility fLib= new FileUtility();	
//		fetching the data from properties file	
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
		String BROWSER = fLib.readDataFromPropertiesFile("browser");
		String CUST_URL=fLib.readDataFromPropertiesFile("custUrl");
		String CUST_U_NAME=fLib.readDataFromPropertiesFile("custUsername");
		String CUST_PASSWORD=fLib.readDataFromPropertiesFile("custPassword");		
		WebDriver driver= null;	
		if(BROWSER.equalsIgnoreCase("chrome")) {	
			 driver= new ChromeDriver();
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		//login to the application
		driver.get(CUST_URL);
		wLib.waitForPageLoad(driver, 10);
		wLib.maximizeWindow(driver);	
		LoginAndSignUpPage lsp= new LoginAndSignUpPage(driver);
		//Logging into the application
		lsp.Login(CUST_U_NAME, CUST_PASSWORD);
		//My account 
		HomePage hp= new HomePage(driver);
		hp.myAccount();
		//billing & shipping address
		MyAccountHomePage mhp= new MyAccountHomePage(driver);
		mhp.shippingBillingAddress();
		UpdateBillShipAddressPage ubsap= new UpdateBillShipAddressPage(driver);
		HashMap<String, String> map1 = eLib.getMultipleDataFromExcel(driver, "Bill_Ship", 0,1);
		ubsap.updateBillingAddress(map1, driver, jLib, wLib);
		ubsap.shippingAddressAccordion();
		HashMap<String, String> map = eLib.getMultipleDataFromExcel(driver, "Bill_Ship", 3,4);
		ubsap.updateShippingAddress(map, driver, jLib, wLib);
		driver.close();
	}

}
