package practiceTestNG;

import org.testng.annotations.Test;

import com.BuyKart.GenericUtility.BaseClass;

public class TestNG_CreateCategoryTest extends BaseClass{
	
	@Test
	public void createCategory() {
		System.out.println("--Category Created--");
	}
	@Test(groups = "smoke")
	public void editCategory() {
		System.out.println("--Category edited--");
	}
}
