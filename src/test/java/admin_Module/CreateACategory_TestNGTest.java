package admin_Module;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BuyKart.GenericUtility.BaseClass;
import com.BuyKart.ObjectRepository.AdminHomePage;
import com.BuyKart.ObjectRepository.CreateCategoryHomePage;

@Listeners(com.BuyKart.GenericUtility.ListenerImplementationClass.class)
public class CreateACategory_TestNGTest extends BaseClass {
	@Test
	public void createCategory() throws Exception {
		AdminHomePage ahp= new AdminHomePage(driver);	
		ahp.createCategory();
//		Assert.fail();
//		creating a category
		CreateCategoryHomePage cchp= new CreateCategoryHomePage(driver);
		
		cchp.createCategory(eLib, jLib, driver, "Categories", 1, 0, 1, 1);
	}
}
