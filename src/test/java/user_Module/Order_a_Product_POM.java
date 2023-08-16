package user_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.BuyKart.GenericUtility.ExcelUtility;
import com.BuyKart.GenericUtility.FileUtility;
import com.BuyKart.GenericUtility.JavaUtility;
import com.BuyKart.GenericUtility.WebDriverUtility;
import com.BuyKart.ObjectRepository.AdminHomePage;
import com.BuyKart.ObjectRepository.AdminLoginPage;
import com.BuyKart.ObjectRepository.ChosePaymentMethodPage;
import com.BuyKart.ObjectRepository.ElectronicsPage;
import com.BuyKart.ObjectRepository.HomePage;
import com.BuyKart.ObjectRepository.LoginAndSignUpPage;
import com.BuyKart.ObjectRepository.MobilesPage;
import com.BuyKart.ObjectRepository.MyCartPage;

import com.BuyKart.ObjectRepository.TodaysOrdersPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Order_a_Product_POM {

	public static void main(String[] args) throws Throwable {
		WebDriverUtility wLib= new WebDriverUtility();
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
		String BROWSER = fLib.readDataFromPropertiesFile("browser");
		String CUST_URL=fLib.readDataFromPropertiesFile("custUrl");
		String USERNAME= fLib.readDataFromPropertiesFile("custUsername");
		String PASSWORD= fLib.readDataFromPropertiesFile("custPassword");
		String ADMIN_URL= fLib.readDataFromPropertiesFile("admUrl");
	
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
		lsp.Login(USERNAME, PASSWORD);
		HomePage hp= new HomePage(driver);
		hp.home();
		hp.electronics(driver);
		ElectronicsPage ep= new ElectronicsPage(driver);
		ep.mobiles(driver);
		MobilesPage mp= new MobilesPage(driver);
		String product=eLib.getDataFromExcel("ProductToBuy", 0, 0);
		mp.addProductToCart(driver, product, "2", wLib);
		hp.myCart();
		MyCartPage mcp= new MyCartPage(driver);
		mcp.orderProduct();
		ChosePaymentMethodPage cpmp= new ChosePaymentMethodPage(driver);
		cpmp.buyProductCOD();
		hp.logout();
		driver.get(ADMIN_URL);
		AdminLoginPage alp= new AdminLoginPage(driver);
		alp.AdminLogin(fLib);
		AdminHomePage ahp= new AdminHomePage(driver);
		ahp.orderManagement();
		ahp.todaysOrdersList();
		TodaysOrdersPage top= new TodaysOrdersPage(driver);
		top.searchProduct(driver, product, USERNAME);
	
	}

}
