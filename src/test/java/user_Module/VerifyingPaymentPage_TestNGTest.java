package user_Module;

import org.testng.annotations.Test;

import com.BuyKart.GenericUtility.BaseClass;
import com.BuyKart.ObjectRepository.AdminLoginPage;
import com.BuyKart.ObjectRepository.ChosePaymentMethodPage;
import com.BuyKart.ObjectRepository.ElectronicsPage;
import com.BuyKart.ObjectRepository.HomePage;
import com.BuyKart.ObjectRepository.LoginAndSignUpPage;
import com.BuyKart.ObjectRepository.MobilesPage;
import com.BuyKart.ObjectRepository.MyCartPage;

public class VerifyingPaymentPage_TestNGTest extends BaseClass {

	@Test(groups = "smoke")
	public void verifyingPaymentPage() throws Throwable {
		String CUST_URL=fLib.readDataFromPropertiesFile("custUrl");
		String CUST_USERNAME= fLib.readDataFromPropertiesFile("custUsername");
		String CUST_PASSWORD= fLib.readDataFromPropertiesFile("custPassword");
		String ADMIN_URL= fLib.readDataFromPropertiesFile("admUrl");
		driver.get(CUST_URL);
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
		driver.get(ADMIN_URL);
		AdminLoginPage alp= new AdminLoginPage(driver);
		alp.AdminLogin(fLib);
	}
}
