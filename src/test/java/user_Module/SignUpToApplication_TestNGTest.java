package user_Module;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.BuyKart.GenericUtility.BaseClass;
import com.BuyKart.ObjectRepository.AdminLoginPage;
import com.BuyKart.ObjectRepository.LoginAndSignUpPage;

public class SignUpToApplication_TestNGTest extends BaseClass{

	@Test(groups = "smoke")
	public void signUpToApplicationTest() throws Throwable {
		String CUST_URL=fLib.readDataFromPropertiesFile("custUrl");
		driver.get(CUST_URL);	
		HashMap<String, String> map = eLib.getMultipleDataFromExcel(driver, "CreateUserAccount", 0, 1);
		LoginAndSignUpPage lsp= new LoginAndSignUpPage(driver);
		int ran=jLib.getRandomNo();
		lsp.signUp(map, driver, jLib, ran, wLib);
		System.out.println("done");
		String ADMIN_URL=fLib.readDataFromPropertiesFile("admUrl");
		driver.get(ADMIN_URL);
		AdminLoginPage alp= new AdminLoginPage(driver);
		alp.AdminLogin(fLib);
	}
}
