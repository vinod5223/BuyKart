package user_Module;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import com.BuyKart.GenericUtility.BaseClass;
import com.BuyKart.ObjectRepository.AdminLoginPage;
import com.BuyKart.ObjectRepository.ElectronicsPage;
import com.BuyKart.ObjectRepository.HomePage;
import com.BuyKart.ObjectRepository.LoginAndSignUpPage;
import com.BuyKart.ObjectRepository.MobilesPage;
import com.BuyKart.ObjectRepository.WishListPage;

public class AddProductToWishlist_TestNGTest extends BaseClass {

	@Test(groups = "regression", retryAnalyzer = com.BuyKart.GenericUtility.RetryImplementationClass.class)
	public void addProduct() throws Throwable {
		
		String CUST_URL=fLib.readDataFromPropertiesFile("custUrl");
		
		driver.get(CUST_URL);	
		LoginAndSignUpPage lsp= new LoginAndSignUpPage(driver);
		String USERNAME= fLib.readDataFromPropertiesFile("custUsername");
		String PASSWORD= fLib.readDataFromPropertiesFile("custPassword");
		lsp.Login(USERNAME,PASSWORD );
		HomePage hp= new HomePage(driver);
		hp.home();
		fail();
		hp.electronics(driver);
		ElectronicsPage ep= new ElectronicsPage(driver);
		ep.mobiles(driver);
		MobilesPage mp= new MobilesPage(driver);
		String product=eLib.getDataFromExcel("ProductToBuy", 0, 0);
		//adding the Product to Wish list
		mp.addToWishlist(driver, product);
		WishListPage wp= new WishListPage(driver);
		wp.WishlistAddedConfirmation(product, driver);
		hp.logout();
		String ADM_URL= fLib.readDataFromPropertiesFile("admUrl");
		driver.get(ADM_URL);
		AdminLoginPage alp= new AdminLoginPage(driver);
		alp.AdminLogin(fLib);
	}
}
