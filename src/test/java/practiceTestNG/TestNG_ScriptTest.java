package practiceTestNG;

import org.testng.annotations.Test;

public class TestNG_ScriptTest  {
	@Test
	public void createCategory() {
		System.out.println("--Category Created--");
	}
	@Test
	public void createSubCategory() {
		System.out.println("--Sub category created--");
	}
}
