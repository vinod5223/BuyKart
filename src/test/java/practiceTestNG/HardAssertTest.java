package practiceTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertTest {
	
	@Test
	public void hardAssertTest() {
		System.out.println("1");
		System.out.println("2");
		Assert.assertEquals("A","A");
		System.out.println("3");
	}
	
	@Test
	public void hardAssertTest1() {
		System.out.println("1");
		System.out.println("2");
		Assert.assertEquals("a","b");// a is actually what i got in the testScript and b is what iam expecting to be in the script
		Assert.fail();
		System.out.println("3");
		
	}
}
