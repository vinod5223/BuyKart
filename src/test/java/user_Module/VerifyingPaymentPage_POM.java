package user_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.BuyKart.GenericUtility.ExcelUtility;
import com.BuyKart.GenericUtility.FileUtility;
import com.BuyKart.GenericUtility.WebDriverUtility;
import com.BuyKart.ObjectRepository.ChosePaymentMethodPage;
import com.BuyKart.ObjectRepository.ElectronicsPage;
import com.BuyKart.ObjectRepository.HomePage;
import com.BuyKart.ObjectRepository.LoginAndSignUpPage;
import com.BuyKart.ObjectRepository.MobilesPage;
import com.BuyKart.ObjectRepository.MyCartPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyingPaymentPage_POM {

	public static void main(String[] args) throws Exception {
		WebDriverUtility wLib= new WebDriverUtility();
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib= new ExcelUtility();
		String BROWSER = fLib.readDataFromPropertiesFile("browser");
		String CUST_URL=fLib.readDataFromPropertiesFile("custUrl");
		String CUST_USERNAME= fLib.readDataFromPropertiesFile("custUsername");
		String CUST_PASSWORD= fLib.readDataFromPropertiesFile("custPassword");
	
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
		lsp.Login(CUST_USERNAME, CUST_PASSWORD);
		HomePage hp= new HomePage(driver);
		hp.home();
		hp.electronics(driver);
		ElectronicsPage ep= new ElectronicsPage(driver);
		ep.mobiles(driver);
		MobilesPage mp= new MobilesPage(driver);
		String product=eLib.getDataFromExcel("ProductToBuy", 0, 0);
		mp.addProductToCart(driver, product, "2", wLib);
		MyCartPage mcp= new MyCartPage(driver);
		mcp.orderProduct();
		ChosePaymentMethodPage cpmp= new ChosePaymentMethodPage(driver);
		cpmp.verifyProductCOD();
		cpmp.verifyProductIB();
		cpmp.verifyProductDC_CC();
	}

}
