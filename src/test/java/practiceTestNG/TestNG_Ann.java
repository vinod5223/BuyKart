package practiceTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestNG_Ann {

	@BeforeSuite
	public void config_BS() {
		System.out.println("--Connected to DB--");
	}
	@BeforeClass
	public void config_BC() {
		System.out.println("--Browser Launched--");
	}
	@BeforeMethod
	public void config_BM() {
		System.out.println("--Login to the application--");
	}
	
	@AfterMethod
	public void config_AM() {
		System.out.println("--Logout from the application--");
	}
	@AfterClass
	public void config_AC() {
		System.out.println("--browser closed--");
	}
	@AfterSuite
	public void config_AS() {
		System.out.println("--DB connection closed--");
	}
}
