package user_Module;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.BuyKart.GenericUtility.BaseClass;
import com.BuyKart.ObjectRepository.AdminLoginPage;
import com.BuyKart.ObjectRepository.HomePage;
import com.BuyKart.ObjectRepository.LoginAndSignUpPage;
import com.BuyKart.ObjectRepository.MyAccountHomePage;
import com.BuyKart.ObjectRepository.UpdateBillShipAddressPage;

public class UpdateBillingAndShipping_TestNGTest extends BaseClass{

	@Test(groups = {"smoke","regression"})
	public void UpdateBillingAndShippingTest() throws Throwable {
		String ADMIN_URL= fLib.readDataFromPropertiesFile("admUrl");
		String CUST_URL=fLib.readDataFromPropertiesFile("custUrl");
		String CUST_U_NAME=fLib.readDataFromPropertiesFile("custUsername");
		String CUST_PASSWORD=fLib.readDataFromPropertiesFile("custPassword");
		driver.get(CUST_URL);
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
		driver.get(ADMIN_URL);
		AdminLoginPage alp= new AdminLoginPage(driver);
		alp.AdminLogin(fLib);
	}
}
