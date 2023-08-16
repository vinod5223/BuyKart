package admin_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.BuyKart.GenericUtility.ExcelUtility;
import com.BuyKart.GenericUtility.FileUtility;
import com.BuyKart.GenericUtility.JavaUtility;
import com.BuyKart.GenericUtility.WebDriverUtility;
import com.BuyKart.ObjectRepository.AdminHomePage;
import com.BuyKart.ObjectRepository.AdminLoginPage;
import com.BuyKart.ObjectRepository.CreateCategoryHomePage;

public class CreateACategory_POM {

	public static void main(String[] args) throws Exception {
		JavaUtility jLib= new JavaUtility();
		ExcelUtility eLib= new ExcelUtility();
		FileUtility fLib= new FileUtility();
		WebDriverUtility wLib= new WebDriverUtility();
		//fetching the data from properties file
		String BROWSER=fLib.readDataFromPropertiesFile("browser");
		String ADMIN_URL=fLib.readDataFromPropertiesFile("admUrl");	
		WebDriver driver= null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			 driver= new ChromeDriver();
		}
		else {
			driver= new FirefoxDriver();
		}
		//login to the application		
		driver.get(ADMIN_URL);
		wLib.waitForPageLoad(driver, 10);
		wLib.maximizeWindow(driver);
		AdminLoginPage alp= new AdminLoginPage(driver);
		alp.AdminLogin(fLib);
		AdminHomePage ahp= new AdminHomePage(driver);
		ahp.createCategory();
		//creating a category
		CreateCategoryHomePage cchp= new CreateCategoryHomePage(driver);
		cchp.createCategory(eLib, jLib, driver, "Categories", 1, 0, 1, 1);
	}
}
