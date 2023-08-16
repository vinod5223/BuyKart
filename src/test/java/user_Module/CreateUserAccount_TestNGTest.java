package user_Module;

import static org.testng.Assert.*;

import java.util.HashMap;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BuyKart.GenericUtility.BaseClass;
import com.BuyKart.ObjectRepository.AdminHomePage;
import com.BuyKart.ObjectRepository.AdminLoginPage;
import com.BuyKart.ObjectRepository.LoginAndSignUpPage;
import com.BuyKart.ObjectRepository.ManageUsersPage;



//@Listeners(com.BuyKart.GenericUtility.ListenerImplementationClass.class)
public class CreateUserAccount_TestNGTest extends BaseClass {

	
	@Test(groups = {"smoke", "regression"})
	public void createUserAccount() throws Throwable {
		String CUST_URL=fLib.readDataFromPropertiesFile("custUrl");
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
		fail();
		ManageUsersPage mup = new ManageUsersPage(driver);
		String emp=mup.searchUser(driver, em);
		assertEquals(emp, em);
		System.out.println("User Created Successfully");
		
//		if(emp.equals(em)) {
//			System.out.println("User Created Successfully");
//		}
	}
}
