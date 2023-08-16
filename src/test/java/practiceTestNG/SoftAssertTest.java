package practiceTestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

	@Test
	public void softAssertTest() {
		System.out.println("1");
		System.out.println("2");
		SoftAssert sa= new SoftAssert();
		sa.assertEquals("a", "b", "mismatch");
		System.out.println("3");
		
	}
	@Test
	public void softAssertTest1() {
		System.out.println("1");
		System.out.println("2");
		SoftAssert sa= new SoftAssert();
		sa.assertEquals("a", "a", "mismatch");
		System.out.println("3");
		sa.assertTrue(true);
//		sa.assertTrue(false);
		sa.assertTrue(false, "pailed");
		sa.assertAll();
		System.out.println("ayyoo");
		sa.assertAll();

	}

}
