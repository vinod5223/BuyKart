package user_Module;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.BuyKart.GenericUtility.ExcelUtility;
import com.BuyKart.GenericUtility.FileUtility;
import com.BuyKart.GenericUtility.JavaUtility;
import com.BuyKart.GenericUtility.WebDriverUtility;
import com.BuyKart.ObjectRepository.AdminHomePage;
import com.BuyKart.ObjectRepository.AdminLoginPage;
import com.BuyKart.ObjectRepository.LoginAndSignUpPage;
import com.BuyKart.ObjectRepository.ManageUsersPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateUserAccount_POM   {


	public static void main(String[] args) throws Exception {
		JavaUtility jLib= new JavaUtility();
		ExcelUtility eLib= new ExcelUtility();
		WebDriverUtility wLib= new WebDriverUtility();
		FileUtility fLib= new FileUtility();
//		fetching the data from properties file
		String BROWSER = fLib.readDataFromPropertiesFile("browser");
		String CUST_URL=fLib.readDataFromPropertiesFile("custUrl");
		WebDriver driver= null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			 driver= new ChromeDriver();
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		driver.get(CUST_URL);	
		int ran=jLib.getRandomNo();
		HashMap<String, String> map = eLib.getMultipleDataFromExcel(driver, "CreateUserAccount", 0, 1);
		LoginAndSignUpPage lsp= new LoginAndSignUpPage(driver);
		String em= lsp.signUp(map, driver, jLib, ran, wLib);
		System.out.println(em);
		String ADMIN_URL= fLib.readDataFromPropertiesFile("admUrl");
		driver.get(ADMIN_URL);
		AdminLoginPage alp= new AdminLoginPage(driver);
		alp.AdminLogin(fLib);
		AdminHomePage ahp= new AdminHomePage(driver);
		ahp.manageUsers();
		ManageUsersPage mup = new ManageUsersPage(driver);
		String emp=mup.searchUser(driver, em);
		if(emp.equals(em)) {
			System.out.println("User Created Succesfully");
		}
		
	}

}
