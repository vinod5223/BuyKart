package user_Module;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.BuyKart.GenericUtility.FileUtility;
import com.BuyKart.GenericUtility.WebDriverUtility;
import com.BuyKart.ObjectRepository.ElectronicsPage;
import com.BuyKart.ObjectRepository.HomePage;
import com.BuyKart.ObjectRepository.LoginAndSignUpPage;
import com.BuyKart.ObjectRepository.MobilesPage;
import com.BuyKart.ObjectRepository.WishListPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddProductToWishlist_POM {

	public static void main(String[] args) throws Throwable {
		//fetching the data from properties file
				WebDriverUtility wLib= new WebDriverUtility();
				FileUtility fLib= new FileUtility();
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
				//login to the application
				driver.get(CUST_URL);
				wLib.waitForPageLoad(driver, 10);
				wLib.maximizeWindow(driver);	
				LoginAndSignUpPage lsp= new LoginAndSignUpPage(driver);
				lsp.Login(BROWSER, CUST_URL);
				HomePage hp= new HomePage(driver);
				hp.home();
				hp.electronics(driver);
				ElectronicsPage ep= new ElectronicsPage(driver);
				ep.mobiles(driver);
				MobilesPage mp= new MobilesPage(driver);
				String product="Apple iPhone 6 (Silver, 16 GB)";
				//adding the Product to Wish list
				mp.addToWishlist(driver, product);
				WishListPage wp= new WishListPage(driver);
				wp.WishlistAddedConfirmation(product, driver);
	}

}


