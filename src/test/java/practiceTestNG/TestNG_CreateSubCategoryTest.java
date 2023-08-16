package practiceTestNG;

import org.testng.annotations.Test;

import com.BuyKart.GenericUtility.BaseClass;

public class TestNG_CreateSubCategoryTest extends BaseClass {
	@Test
	public void createSubCategory() {
		System.out.println("--Created User--");
	}

	@Test
	public void editSubCategory() {
		System.out.println("--Edited User");
}
} 