package practiceTestNG;

import org.testng.annotations.Test;

import com.BuyKart.GenericUtility.BaseClass;

public class TestNG_CreateProductTest extends BaseClass {
	
	
	@Test
	public void createProduct() {
		System.out.println("--Product Created--");
	}
	@Test(groups = {"smoke", "regression"})
	public void editProduct() {
		System.out.println("--Product Edited--");
	}
}
